package org.example.financeiro;

public class Transacao {

    private int numeroPedido;
    private double valor;
    private double gorjeta;

    public Transacao(int numeroPedido, double valor, double gorjeta) {

        if(numeroPedido <= 0){
            throw new IllegalArgumentException("Número do pedido inválido");
        }

        if(valor < 0){
            throw new IllegalArgumentException("O valor não pode ser negativo");
        }

        if(gorjeta < 0){
            throw new IllegalArgumentException("A gorjeta não pode ser negativa");
        }

        this.numeroPedido = numeroPedido;
        this.valor = valor;
        this.gorjeta = gorjeta;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public double getValor() {
        return valor;
    }

    public double getGorjeta() {
        return gorjeta;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Transacao outra = (Transacao) obj;
        return numeroPedido == outra.numeroPedido;
    }
}
