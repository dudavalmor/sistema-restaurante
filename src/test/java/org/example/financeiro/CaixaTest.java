package org.example.financeiro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CaixaTest {

    @Test
    void deveCalcularFechamentoDoCaixa(){

        Caixa caixa = Caixa.getInstancia();
        double fechamentoAntes = caixa.fecharCaixa();
        Transacao transacao = new Transacao(999, 20.0, 5.0);
        caixa.registrarTransacao(transacao);
        double fechamentoDepois = caixa.fecharCaixa();
        assertEquals(fechamentoAntes + 25.0, fechamentoDepois, 0.001);

    }

}
