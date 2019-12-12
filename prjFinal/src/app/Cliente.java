/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;

/**
 *
 * @author emanu
 */
public class Cliente {

    public Cliente(int codigo, String nome, String endereco, String telefone, double limite) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.limite = limite;
    }
    public Cliente(){
        
    }
    
    private int codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private double limite;
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos.add(pedidos);
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + "\nNome: " + nome + "\nEndereco: " + endereco + "\nTelefone: " + telefone + "\nLimite: " + limite + "\n";
    }
}
