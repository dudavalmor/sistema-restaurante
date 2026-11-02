package org.example.app;

import org.example.cardapio.*;
import org.example.financeiro.Caixa;
import org.example.pedido.GerenciadorPedidos;
import org.example.pedido.Pedido;
import org.example.financeiro.Transacao;

import java.util.Collection;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) {

        MenuConsole menu = new MenuConsole();
        GerenciadorPedidos gerenciador  = new GerenciadorPedidos();
        RestauranteFacade facade = new RestauranteFacade(gerenciador);
        Caixa caixa = Caixa.getInstancia();

        boolean executando = true;

        while (executando){

            int opcao = menu.exibirMenu();
            switch (opcao){
                case 1:
                    menu.exibirMensagem("Registrar pedido");
                    Pedido pedido = facade.criarPedido(menu.lerNomeCliente());

                    String continuar = "S";

                    while (continuar.equalsIgnoreCase("S")){

                        menu.exibirCardapio();
                        int opcaoCardapio = menu.lerOpcao();

                        Lanche lancheEscolhido = facade.selecionarLanche(opcaoCardapio);

                        if(lancheEscolhido == null){
                            menu.exibirMensagem("Opção inválida. Tente novamente");
                            continue;
                        } else {
                            ItemCardapio itemFinal = lancheEscolhido;

                            if(menu.removerQueijo()){
                                lancheEscolhido.setQueijo(false);
                            }

                            if(menu.removerAlface()){
                                lancheEscolhido.setAlface(false);
                            }

                            if (menu.removerTomate()){
                                lancheEscolhido.setTomate(false);
                            }

                            if (menu.removerCebola()){
                                lancheEscolhido.setCebola(false);
                            }

                            String cheddar = menu.desejaCheddar();
                            if(cheddar.equalsIgnoreCase("S")){
                                itemFinal = new ComCheddar(itemFinal);
                            }

                            String baconExtra = menu.desejaBaconExtra();
                            if(baconExtra.equalsIgnoreCase("S")){
                                itemFinal = new ComBaconExtra(itemFinal);
                            }

                            pedido.adicionarItem(itemFinal);
                            menu.exibirMensagem("Lanche adicionado com sucesso!");
                        }

                        continuar = menu.desejaAdicionarItem();
                    }

                    menu.exibirMensagem("Pedido de número " + pedido.getNumero() + " criado com sucesso\n");
                    break;
                case 2:
                    menu.exibirPedidos(facade.getPedidos());
                    break;
                case 3:
                    menu.exibirMensagem("Fechamento do dia");

                    double totalPedidos = facade.calcularTotalDoDia();
                    menu.exibirFechamentoDia(totalPedidos);

                    double faturamento = caixa.calcularFaturamento();
                    double gorjetas = caixa.calcularTotalGorjetas();
                    double fechamento = caixa.fecharCaixa();

                    menu.exibirMensagem("===== RELATÓRIO FINANCEIRO =====");
                    menu.exibirMensagem("Faturamento dos pedidos pagos: R$ " + faturamento);
                    menu.exibirMensagem("Total Gorjetas: R$ " + gorjetas);
                    menu.exibirMensagem("Total do caixa: R$ " + fechamento);

                    HashSet<String> combinacoes = facade.obterCombinacoesDiferentes();
                    menu.exibirCombinacoes(combinacoes);

                    HashSet<String> lanchesBase = facade.obterLanchesBaseDiferentes();
                    menu.exibirMensagem("Quantidade de lanches base diferentes: " + lanchesBase.size());
                    menu.exibirMensagem("Lanches base vendidos: " + lanchesBase);

                    executando = false;
                    break;
                case 4:
                    int numPedido = menu.lerNumeroPedido();
                    Pedido pedidoEncontrado = facade.buscarPedido(numPedido);

                    if(pedidoEncontrado == null){
                        menu.exibirMensagem("Pedido não foi encontrado");
                    } else {
                        menu.exibirMensagem("Pedido encontrado!");
                        menu.exibirPedido(pedidoEncontrado);
                        int opcaoModificacao = menu.exibirMenuModificacao();

                        switch (opcaoModificacao){
                            case 1:
                                menu.exibirMensagem("Adicionar lanche");
                                menu.exibirCardapio();

                                int opcaoCardapio = menu.lerOpcao();

                                Lanche novoLanche = facade.selecionarLanche(opcaoCardapio);

                                if(novoLanche == null){
                                    menu.exibirMensagem("Opção inválida!");
                                } else {
                                    if(menu.removerQueijo()){
                                        novoLanche.setQueijo(false);
                                    }

                                    if(menu.removerAlface()){
                                        novoLanche.setAlface(false);
                                    }

                                    if (menu.removerTomate()){
                                        novoLanche.setTomate(false);
                                    }

                                    if (menu.removerCebola()){
                                        novoLanche.setCebola(false);
                                    }

                                    ItemCardapio itemFinal = novoLanche;

                                    String cheddar = menu.desejaCheddar();
                                    if(cheddar.equalsIgnoreCase("S")){
                                        itemFinal = new ComCheddar(itemFinal);
                                    }

                                    String baconExtra = menu.desejaBaconExtra();
                                    if(baconExtra.equalsIgnoreCase("S")){
                                        itemFinal = new ComBaconExtra(itemFinal);
                                    }

                                    pedidoEncontrado.adicionarItem(itemFinal);
                                    menu.exibirMensagem("Lanche adicionado com sucesso!");

                                    menu.exibirPedido(pedidoEncontrado);
                                }

                                break;
                            case 2:
                                menu.exibirMensagem("Remover lanche");

                                if (pedidoEncontrado.getItens().isEmpty()) {
                                    menu.exibirMensagem("Este pedido nao possui lanches");
                                } else {
                                    menu.exibirItensPedido(pedidoEncontrado);

                                    int numeroEscolhido = menu.lerIndiceItem(pedidoEncontrado);
                                    int indice = numeroEscolhido - 1;

                                    pedidoEncontrado.removerItem(indice);

                                    menu.exibirMensagem("Lanche removido com sucesso!");
                                    menu.exibirPedido(pedidoEncontrado);
                                }
                                break;
                            case 3:
                                menu.exibirMensagem("Cancelar pedido");
                                facade.cancelarPedido(pedidoEncontrado.getNumero());
                                menu.exibirMensagem("Pedido cancelado com sucesso!");
                                break;
                            case 0:
                                menu.exibirMensagem("Voltar");
                                break;
                            default:
                                menu.exibirMensagem("Opção inválida");
                                break;
                        }
                    }
                    break;
                case 5:
                    menu.exibirMensagem("Registrar pagamento");

                    int numeroPedido = menu.lerNumeroPedido();
                    Pedido pedidoPagamento = facade.buscarPedido(numeroPedido);

                    if(pedidoPagamento == null){
                        menu.exibirMensagem("Pedido não encontrado");
                    } else if(pedidoPagamento.isPago()){
                        menu.exibirMensagem("Esse pedido já foi pago.");
                    } else {
                        double valor = pedidoPagamento.calcularTotal();
                        double gorjeta = menu.lerGorjeta();

                        Transacao transacao = new Transacao(pedidoPagamento.getNumero(), valor, gorjeta);
                        caixa.registrarTransacao(transacao);
                        pedidoPagamento.setPago(true);

                        menu.exibirMensagem("Pagamento registrado com sucesso!");
                        menu.exibirMensagem("Valor do lanche: R$ " + valor);
                        menu.exibirMensagem("Gorjeta: R$ " + gorjeta);
                        menu.exibirMensagem("Total pago: R$ " + (valor + gorjeta));
                    }

                    break;
                case 0:
                    executando = false;
                    menu.exibirMensagem("Encerrando sistema..");
                    break;
                default:
                    menu.exibirMensagem("Opção inválida");
                    break;
            }
        }
    }


}