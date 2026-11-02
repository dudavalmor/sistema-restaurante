package org.example.app;

import org.example.cardapio.Lanche;
import org.example.cardapio.LancheFactory;
import org.example.pedido.GerenciadorPedidos;
import org.example.pedido.Pedido;

import java.util.Collection;
import java.util.HashSet;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciadorPedidos;

    public RestauranteFacade(GerenciadorPedidos gerenciadorPedidos) {
        this.gerenciadorPedidos = gerenciadorPedidos;
    }

    public Pedido criarPedido(String nomeCliente){
        return gerenciadorPedidos.criarPedido(nomeCliente);
    }

    public Pedido buscarPedido(int numero){
        return gerenciadorPedidos.buscarPedido(numero);
    }

    public Collection<Pedido> getPedidos(){
        return gerenciadorPedidos.getPedidos();
    }

    public double calcularTotalDoDia(){
        return gerenciadorPedidos.calcularTotalDoDia();
    }

    public Lanche selecionarLanche(int opcao){
        switch (opcao){
            case 1:
                return LancheFactory.xBurger();
            case 2:
                return LancheFactory.xSalada();
            case 3:
                return LancheFactory.xBacon();
            default:
                return null;
        }
    }

    public void cancelarPedido(int numero){
        gerenciadorPedidos.cancelarPedido(numero);
    }

    public HashSet<String> obterCombinacoesDiferentes(){
        return gerenciadorPedidos.obterCombinacoesDiferentes();
    }

    public HashSet<String> obterLanchesBaseDiferentes(){
        return gerenciadorPedidos.obterLanchesBaseDiferentes();
    }
}
