package org.example.financeiro;

import java.util.HashSet;

public class Caixa {

    private static Caixa instancia;
    private HashSet<Transacao> transacoes = new HashSet<>();

    private Caixa(){}

    public static Caixa getInstancia() {

        if(instancia == null){
            instancia = new Caixa();
        }
        return instancia;
    }

    public void registrarTransacao(Transacao transacao){

        if (transacao != null){
            transacoes.add(transacao);
        }
    }

    public double calcularFaturamento(){
        double total = 0;

        for(Transacao transacao : transacoes){
            total += transacao.getValor();
        }
        return total;
    }

    public double calcularTotalGorjetas(){
        double total = 0;

        for (Transacao transacao : transacoes){
            total += transacao.getGorjeta();
        }
        return total;
    }

    public double fecharCaixa(){
        return calcularFaturamento() + calcularTotalGorjetas();
    }

}
