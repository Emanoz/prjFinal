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
public class ProdutoExportacao extends Produto{

    public ProdutoExportacao(String destino, int codigo, String nome, Categoria categoria, double preco, int moeda, double imposto) {
        super(codigo, nome, categoria, preco, moeda, imposto);
        this.destino = destino;
    }
    
    private String destino;

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "ProdutoExportacao{" + "destino=" + destino + ", descricao=" + getNome() + ", categoria=" + getCategoria().getDescricao() 
                + ", preco=" + getPreco() + ", moeda=" + getMoeda() + ", imposto=" + getImposto() + '}';
    }
}
