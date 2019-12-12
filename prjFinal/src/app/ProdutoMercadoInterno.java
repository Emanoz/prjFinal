/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author emanu
 */
public class ProdutoMercadoInterno extends Produto{

    public ProdutoMercadoInterno(boolean incentivo, int codigo, String nome, Categoria categoria, double preco, int moeda, double imposto) {
        super(codigo, nome, categoria, preco, moeda, imposto);
        this.incentivo = incentivo;
    }
    
    private boolean incentivo;

    public boolean isIncentivo() {
        return incentivo;
    }

    public void setIncentivo(boolean incentivo) {
        this.incentivo = incentivo;
    }

    @Override
    public String toString() {
        return "Ha incentivo?: " + incentivo + "\nDescricao: " + getNome() + "\nCategoria: " + getCategoria().getDescricao() 
                + "\nPreco: " + getPreco() + "\nMoeda: " + getMoeda() + "\nImposto: " + getImposto() + "\n";
    }
}
