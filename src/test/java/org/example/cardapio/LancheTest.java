package org.example.cardapio;

import org.example.cardapio.ComCheddar;
import org.example.cardapio.ItemCardapio;
import org.example.cardapio.Lanche;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LancheTest {

    @Test
    void deveRejeitarPrecoNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Lanche("X-Burger", -5.0)
        );
    }

    @Test
    void deveAdicionarPrecoDoCheddar() {
        Lanche lanche = new Lanche("X-Burger", 16.0);

        ItemCardapio comCheddar = new ComCheddar(lanche);

        assertEquals(20.0, comCheddar.getPreco(), 0.001);
    }
}