/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author emanu
 */
public class Pedido {

    public Pedido(long numero, Date data, int status, ArrayList<ItemPedido> itens) {
        this.numero = numero;
        this.data = data;
        this.status = status;
        this.itens = itens;
    }
    
    private long numero;
    private Date data;
    private ArrayList<ItemPedido> itens = new ArrayList<>();
    private Cliente cliente = null;
    private int status;

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ItemPedido item) {
        this.itens.add(item);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        if(status == 0)
            return "Finalizado";
        else
            return "Aberto";
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public double totalPedido(){
        double total = 0;
        for(ItemPedido item : itens){
            total += item.totalItem();
        }
        return total;
    }
    
    public double totalImposto(){
        double total = 0;
        for(ItemPedido item : itens){
            total += item.getProduto().getImposto() * item.getQuantidade();
        }
        return total;
    }
    
    public void mostrarItens(){
        System.out.println("Numero: " + numero + "\nData: " + data + "\nPedidos: [");
        for(ItemPedido item : itens)
            System.out.println("\n" + item.toString() + "]");
    }
}
