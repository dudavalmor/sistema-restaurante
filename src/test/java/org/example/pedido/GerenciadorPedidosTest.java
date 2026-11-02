package org.example.pedido;

import org.junit.jupiter.api.Test;
import org.example.cardapio.LancheFactory;

import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorPedidosTest {

    @Test
    void deveCancelarPedido(){

        GerenciadorPedidos gerenciador = new GerenciadorPedidos();
        Pedido pedido = gerenciador.criarPedido("João");
        gerenciador.cancelarPedido(pedido.getNumero());
        assertNull(gerenciador.buscarPedido(pedido.getNumero()));
    }

    @Test
    void deveFiltrarCombinacoesRepetidas() {

        GerenciadorPedidos gerenciador = new GerenciadorPedidos();

        Pedido pedido1 = gerenciador.criarPedido("João");
        Pedido pedido2 = gerenciador.criarPedido("Maria");

        pedido1.adicionarItem(LancheFactory.xBacon());
        pedido2.adicionarItem(LancheFactory.xBacon());

        assertEquals(1, gerenciador.obterCombinacoesDiferentes().size());
    }

}
