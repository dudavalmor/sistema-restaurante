package org.example.pedido;

import org.example.cardapio.ItemCardapio;

import java.util.ArrayList;

public class Pedido {

    private int numero;
    private String nomeCliente;
    private ArrayList<ItemCardapio> itens = new ArrayList<>();
    private boolean pago = false;

    public Pedido(int numero, String nomeCliente) {
        this.numero = numero;
        setNomeCliente(nomeCliente);
    }

    public void setNomeCliente(String nomeCliente) {
        if(nomeCliente == null || nomeCliente.trim().isEmpty()){
            throw new IllegalArgumentException("Nome inválido");
        } else {
            this.nomeCliente = nomeCliente;
        }
    }

    public int getNumero() {
        return numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public ArrayList<ItemCardapio> getItens() {
        return itens;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public void adicionarItem(ItemCardapio item){
        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo");
        }
        itens.add(item);
    }

    public double calcularTotal(){
        double total = 0;
        for (int i = 0; i < itens.size(); i++) {
            total += itens.get(i).getPreco();
        }
        return total;
    }

    public void removerItem(int indice){
        if(indice >= 0 && indice < itens.size()){
            itens.remove(indice);
        }
    }
}
