package org.example.pedido;

import org.example.cardapio.LancheFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class deveFiltrarCombinacoesRepetidas {

    @Test
    void deveFiltrarCombinacoesRepetidas(){
        GerenciadorPedidos gerenciador = new GerenciadorPedidos();
        Pedido pedido1 = gerenciador.criarPedido("João");
        Pedido pedido2 = gerenciador.criarPedido("Eduarda");

        pedido1.adicionarItem(LancheFactory.xBacon());
        pedido2.adicionarItem(LancheFactory.xBacon());

        assertEquals(1, gerenciador.obterCombinacoesDiferentes().size());
    }
}
