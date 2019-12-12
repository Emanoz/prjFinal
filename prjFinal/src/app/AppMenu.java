/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Lorraine
 */
public class AppMenu {
         public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int op = 0, opInterno = 0, codCli = 0, codProd = 0, codPedido = 0, codCat = 0, codItem = 0;
        ArrayList<Cliente> cliList = new ArrayList<>();
        ArrayList<Produto> prodList = new ArrayList<>();
        ArrayList<Pedido> pedList = new ArrayList<>();
        ArrayList<Categoria> catList = new ArrayList<>();
        Cliente c = null;
        Produto p = null;
        Categoria cat = null;
        Pedido ped = null;
        
        do{
            System.out.println("1.Cliente\n2.Produto\n3.Categoria\n4.Criar pedidos para um cliente\n5.Listar pedidos de um cliente\n6"
                    + ".Dar baixa de um pedido\n7.Sai\n");
            op = s.nextInt();
            switch(op){
                case 1: System.out.println("\n\n1.Cadastrar\n2.Atualizar\n3.Remover\n4.Pesquisar\n5.Listar todos");
                        opInterno = s.nextInt();
                        switch(opInterno){
                            case 1: System.out.println("Informe o nome, endereco, telefone e o limite de saldo do cliente: ");
                                    cliList.add(new Cliente(++codCli, s.next(), s.next(), s.next(), s.nextDouble()));
                                    break;
                            case 2: System.out.println("Informe o nome do cliente:");
                                    c = searchCliente(s.next(), cliList);
                                    if(c != null){
                                        System.out.println("Informe o nome, endereco, telefone e o limite de saldo do cliente:");
                                        c.setNome(s.next());
                                        c.setEndereco(s.next());
                                        c.setTelefone(s.next());
                                        c.setLimite(s.nextDouble());
                                    }else
                                        System.out.println("O cliente não foi encontrado");
                                    break;
                            case 3: System.out.println("Informe o nome do cliente:");
                                    c = searchCliente(s.next(), cliList);
                                    if(cliList.remove(c))
                                        System.out.println("Cliente removido com sucesso!");
                                    else
                                        System.out.println("Cliente nao foi removido com sucesso!");
                                    break;
                            case 4: System.out.println("Informe o nome do cliente:");
                                    c = searchCliente(s.next(), cliList);
                                    if(c != null){
                                        System.out.println("\n------------------------\n" + c.toString());
                                    }else
                                        System.out.println("O cliente nao foi encontrado");
                                    break;
                            case 5: if(cliList.size() != 0){
                                        for(Cliente cli : cliList)
                                        System.out.println("\n-------------------------\n" + cli.toString());
                                    }else
                                        System.out.println("Nao ha clientes cadastrados");
                                    break;
                    }
                    break;
                case 2: System.out.println("\n\n1.Cadastrar\n2.Atualizar\n3.Remover\n4.Pesquisar\n5.Listar todos");
                        opInterno = s.nextInt();
                        switch(opInterno){
                            case 1: System.out.println("Este produto vai ser exportado? <1.SIM/2.NAO>");
                                    int opp = s.nextInt();
                                    if(opp == 1){
                                        System.out.println("Informe o destino, descricao, categoria, preco, o valor da moeda e o imposto do produto: ");
                                        prodList.add(new ProdutoExportacao(s.next(), ++codProd, s.next(), searchcategoria(s.next(), catList), s.nextDouble(), s.nextInt(), s.nextDouble()));
                                    }
                                    else{
                                        System.out.println("informe se ha incentivo, descricao, categoria, preco, o valor da moeda e o imposto do produto: ");
                                        prodList.add(new ProdutoMercadoInterno(s.nextBoolean(), ++codProd, s.next(), searchcategoria(s.next(), catList), s.nextDouble(), s.nextInt(), s.nextDouble()));
                                    }
                                    break;
                            case 2: System.out.println("Informe a descricao do produto:");
                                    p = searchProduto(s.next(), prodList);
                                    if(p != null){
                                        if(p instanceof ProdutoExportacao){
                                            System.out.println("Informe o destino, descricao, categoria, preco, o valor da moeda e o imposto do produto:");
                                            ((ProdutoExportacao) p).setDestino(s.next());
                                        } else{
                                            System.out.println("Informe se ha incentivo, descricao, categoria, preco, o valor da moeda e o imposto do produto:");
                                            ((ProdutoMercadoInterno) p).setIncentivo(s.nextBoolean());
                                        }
                                        p.setNome(s.next());
                                        p.setCategoria(searchcategoria(s.next(), catList));
                                        p.setPreco(s.nextDouble());
                                        p.setMoeda(s.nextInt());
                                        p.setImposto(s.nextDouble());
                                    }else
                                        System.out.println("O produto não foi encontrado");
                                    break;
                            case 3: System.out.println("Informe a descricao do produto:");
                                    p = searchProduto(s.next(), prodList);
                                    if(prodList.remove(p))
                                        System.out.println("Produto removido com sucesso!");
                                    else
                                        System.out.println("Produto nao foi removido com sucesso!");
                                    break;
                            case 4: System.out.println("Informe a descricao do produto:");
                                    p = searchProduto(s.next(), prodList);
                                    if(p != null){
                                        System.out.println("\n------------------------\n" + p.toString());
                                    }else
                                        System.out.println("O produto nao foi encontrado");
                                    break;
                            case 5: if(prodList.size() != 0){
                                        for(Produto prod : prodList)
                                            System.out.println("\n-------------------------\n" + prod.toString());
                                    }else
                                        System.out.println("Nao ha produtos cadastrados");
                                    break;
                    }
                    break;
                case 3: System.out.println("\n\n1.Cadastrar\n2.Atualizar\n3.Remover\n4.Pesquisar\n5.Listar todos");
                        opInterno = s.nextInt();
                        switch(opInterno){
                            case 1: System.out.println("Informe a descricao: ");
                                    catList.add(new Categoria(s.next()));
                                    break;
                            case 2: System.out.println("Informe a descricao da categoria:");
                                    cat = searchcategoria(s.next(), catList);
                                    if(cat != null){
                                        System.out.println("Informe a descricao da categoria:");
                                        cat.setDescricao(s.next());
                                    }else
                                        System.out.println("A categoria não foi encontrado");
                                    break;
                            case 3: System.out.println("Informe a descricao da categoria:");
                                    cat = searchcategoria(s.next(), catList);
                                    if(catList.remove(cat))
                                        System.out.println("Categoria removida com sucesso!");
                                    else
                                        System.out.println("Categoria nao foi removida com sucesso!");
                                    break;
                            case 4: System.out.println("Informe a descricao da categoria:");
                                    cat = searchcategoria(s.next(), catList);
                                    if(cat != null){
                                        System.out.println("\n------------------------\n" + cat.toString());
                                    }else
                                        System.out.println("A categoria nao foi encontrada");
                                    break;
                            case 5: if(catList.size() != 0){
                                        for(Categoria ca : catList)
                                            System.out.println("\n-------------------------\n" + ca.toString());
                                    }else
                                        System.out.println("Nao ha categorias cadastradas");
                                    break;
                    }   
                    break;
                case 4: ArrayList<ItemPedido> itens = new ArrayList<>();
                        System.out.println("Informe o nome do cliente em que o pedido estara associado: ");
                        c = searchCliente(s.next(), cliList);
                        if(c != null){
                            System.out.println("Listagem dos produtos disponiveis:\n");
                            for(Produto prod : prodList)
                                System.out.println(prod.toString());
                            System.out.println("\nInforme os produtos que serao adicionados e suas quantidades:\n");
                            String oppp = "";
                            do{
                                Produto prod = searchProduto(s.next(), prodList);
                                if(prod != null)
                                    itens.add(new ItemPedido(++codItem, s.nextInt(), prod));
                                else
                                    System.out.println("Este produto nao esta disponivel");
                                System.out.println("Deseja adicionar mais algum produto? <S/N>");
                                oppp = s.next();
                            }while(oppp.equals("s") || oppp.equals("S"));
                            ped = new Pedido(++codPedido, null, 1, itens);
                            if(ped.totalPedido() <= c.getLimite()){
                                c.setPedidos(ped);
                                ped.setCliente(c);
                                c.setLimite(c.getLimite() - ped.totalPedido());
                            }else
                                System.out.println("O limite do saldo deste cliente foi extrapolado! O pedido sera cancelado");
                                
                        } else
                            System.out.println("Cliente nao encontrado");
                    break;
                case 5: System.out.println("Informe o nome do cliente: ");
                        c = searchCliente(s.next(), cliList);
                        if(c != null){
                            for(Pedido pedido : c.getPedidos()){
                                System.out.println("\n------------------------\n");
                                pedido.mostrarItens();
                            }
                                
                        }else
                            System.out.println("O cliente nao foi encontrado");
                    break;
                case 6: System.out.println("Informe o nome do cliente em que o pedido sera finalizado: ");
                        c = searchCliente(s.next(), cliList);
                        if(c != null){
                            if(c.getPedidos().size() > 0){
                                for(Pedido pedido : c.getPedidos()){
                                    System.out.println("\n------------------------\n");
                                    pedido.mostrarItens();
                                }
                                System.out.println("Informe o numero do pedido que sera finalizado: ");
                                ped = searchPedido(s.nextInt(), c.getPedidos());
                                if(ped != null){
                                    ped.setStatus(0);
                                    c.setLimite(c.getLimite() + ped.totalPedido());
                                    c.getPedidos().remove(ped);
                                }else
                                    System.out.println("Este pedido nao existe");
                            }else
                                System.out.println("Este cliente nao possui pedidos abertos");
                        }else
                            System.out.println("Este cliente nao foi encontrado");
                    break;
                default:
                    System.out.println("Opção inexistente, insira um valor valido.");
                    break;
            }
            
        } while(op != 7);
        
    }
    
    public static Cliente searchCliente(String nome, ArrayList<Cliente> list){
        for(Cliente c : list){
            if(c.getNome().equals(nome))
                return c;
        }
        return null;
    }
    
    public static Pedido searchPedido(int cod, ArrayList<Pedido> list){
        for(Pedido p : list){
            if(p.getNumero() == cod)
                return p;
        }
        return null;
    }
    
    public static Categoria searchcategoria(String descricao, ArrayList<Categoria> list){
        for(Categoria p : list){
            if(p.getDescricao().equals(descricao))
                return p;
        }
        return null;
    }
    
    public static Produto searchProduto(String descricao, ArrayList<Produto> list){
        for(Produto p : list){
            if(p.getNome().equals(descricao))
                return p;
        }
        return null;
    }
}
