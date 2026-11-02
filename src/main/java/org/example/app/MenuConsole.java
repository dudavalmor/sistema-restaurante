package org.example.app;

import org.example.cardapio.ItemCardapio;
import org.example.cardapio.Lanche;
import org.example.pedido.Pedido;

import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsole {
    private Scanner sc = new Scanner(System.in);
    public int exibirMenu() {

        while (true){
            System.out.println("===== SISTEMA RESTAURANTE =====");
            System.out.println("1 - Registrar pedido");
            System.out.println("2 - Listar pedidos");
            System.out.println("3 - Fechar restaurante");
            System.out.println("4 - Modificar pedido");
            System.out.println("5 - Registrar pagamento");
            System.out.println("0 - Sair");
            System.out.println("===============================");
            System.out.println("Digite a opção desejada: ");

            try{
                int opcao = sc.nextInt();
                sc.nextLine();

                if(opcao >= 0 && opcao <= 5){
                    return opcao;
                }

                System.out.println("Opção inválida! Escolha uma opção de 0 a 5");
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Entrada inválida. Digite um número");
            }
        }
    }

    public void exibirCardapio(){
        System.out.println("===== CARDÁPIO =====");
        System.out.println("1 - X-Burger - R$ 16,00");
        System.out.println("2 - X-Salada - R$ 18,00");
        System.out.println("3 - X-Bacon - R$ 22,00");
    }

    public String lerNomeCliente(){
        System.out.println("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        return nome;
    }

    public int lerOpcao(){

        while (true){
            System.out.println("Digite a opcao desejada: ");

            try{
                int opcao = sc.nextInt();
                sc.nextLine();

                if(opcao >= 1 && opcao <= 3){
                    return opcao;
                }

                System.out.println("Opção inválida! Escolha uma opção de 1 a 3.");
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Entrada inválida! Digite um número.");
            }
        }
    }

    public String desejaAdicionarItem(){
        System.out.println("Deseja adicionar mais algum item? (S/N) ");
        String continuar = sc.nextLine();
        return continuar;
    }

    public void exibirMensagem(String mensagem){
        System.out.println(mensagem);
    }

    public void exibirPedidos(Collection<Pedido> pedidos){

        if(pedidos.isEmpty()){
            exibirMensagem("Não há nenhum pedido.");
            return;
        }

        for(Pedido p : pedidos){
            System.out.println();
            System.out.println("Pedido: " + p.getNumero());
            System.out.println("Cliente: " + p.getNomeCliente());

            for (ItemCardapio item : p.getItens()){
                System.out.println("Lanche: " + item.getDescricao());
                System.out.println("Preço: R$ " + item.getPreco());
            }

            System.out.println("-------------------------------");
            System.out.println("Total do pedido: R$ " + p.calcularTotal());
            System.out.println("-------------------------------");
        }
    }

    public void exibirPedido(Pedido pedido){
        System.out.println("Pedido: " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getNomeCliente());
        for(ItemCardapio item : pedido.getItens()){
            System.out.println("Lanche: " + item.getDescricao());
            System.out.println("Preço: R$ " + item.getPreco());
        }

        System.out.println("Total: R$ " + pedido.calcularTotal());
    }

    public void exibirFechamentoDia(double total){
        System.out.println("===== FECHAMENTO DO DIA =====");
        System.out.println("Total arrecadado: R$ " + total);
    }

    public String desejaCheddar(){
        System.out.println("Deseja adicionar cheddar por R$ 4,00? (S/N) ");
        String cheddar = sc.nextLine();
        return cheddar;
    }

    public String desejaBaconExtra(){
        System.out.println("Deseja adicionar bacon extra por R$ 6,00? (S/N) ");
        String baconExtra = sc.nextLine();
        return baconExtra;
    }

    public boolean removerQueijo(){
        exibirMensagem("Deseja retirar o queijo? (S/N) ");
        String resposta = sc.nextLine();
        return resposta.equalsIgnoreCase("S");
    }

    public boolean removerAlface(){
        exibirMensagem("Deseja retirar a alface? (S/N) ");
        String resposta = sc.nextLine();
        return resposta.equalsIgnoreCase("S");
    }

    public boolean removerTomate(){
        exibirMensagem("Deseja retirar o tomate? (S/N) ");
        String resposta = sc.nextLine();
        return resposta.equalsIgnoreCase("S");
    }

    public boolean removerCebola(){
        exibirMensagem("Deseja remover a cebola? (S/N) ");
        String resposta = sc.nextLine();
        return resposta.equalsIgnoreCase("S");
    }

    public int lerNumeroPedido(){

        while (true){
            System.out.println("Digite o número do pedido: ");
            try{
                int numeroPedido = sc.nextInt();
                sc.nextLine();

                if(numeroPedido > 0){
                    return numeroPedido;
                }
                System.out.println("O número do pedido deve ser maior que zero!");
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Entrada inválida! Digite um número.");
            }
        }
    }

    public int exibirMenuModificacao(){

        while (true){
            System.out.println("===== MODIFICAR PEDIDO =====");
            System.out.println("1 - Adicionar lanche");
            System.out.println("2 - Remover lanche");
            System.out.println("3 - Cancelar pedido");
            System.out.println("0 - Voltar");
            System.out.println("Digite a opção desejada:");

            try{
                int opcao = sc.nextInt();
                sc.nextLine();

                if(opcao >= 0 && opcao <= 3){
                    return opcao;
                }
                System.out.println("Opção inválida! Escolha uma opção de 0 a 3.");
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Entrada inválida! Digite um número.");
            }
        }
    }

    public int lerIndiceItem(Pedido pedido){

        while (true){
            System.out.println("Digite o número do lanche que deseja remover: ");

            try{
                int opcao = sc.nextInt();
                sc.nextLine();

                if(opcao >= 1 && opcao <= pedido.getItens().size()){
                    return opcao;
                }

                System.out.println("Número inválido! Escolha um número entre 1 e " + pedido.getItens().size());
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Entrada inválida! Digite um número.");
            }
        }
    }

    public void exibirItensPedido(Pedido pedido){
        System.out.println("===== LANCHES DO PEDIDO =====");
        for (int i = 0; i < pedido.getItens().size(); i++) {
            System.out.println((i+1) + " - " + pedido.getItens().get(i).getDescricao());
        }
    }

    public void exibirCombinacoes(HashSet<String> combinacoes){
        System.out.println("===== COMBINAÇÕES DO DIA =====");
        System.out.println("Quantidade de combinações diferentes: " + combinacoes.size());

        for(String combinacao : combinacoes){
            System.out.println("- " + combinacao);
        }
    }

    public double lerGorjeta(){
        System.out.println("Informe o valor da gorjeta: ");
        return sc.nextDouble();
    }

}
