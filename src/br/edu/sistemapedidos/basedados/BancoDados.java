package br.edu.sistemapedidos.basedados;

import java.util.ArrayList;
import java.util.List;

import br.edu.sistemapedidos.entidade.Cliente;
import br.edu.sistemapedidos.entidade.Cupom;
import br.edu.sistemapedidos.entidade.Pedido;
import br.edu.sistemapedidos.entidade.Produto;

public class BancoDados {
	
	private List<Produto> produtos;
    private List<Pedido> pedidos;
    private List<Cupom> cupons;
    private Cliente cliente;

    
    public BancoDados() {

        this.produtos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.cliente = new Cliente();

        this.cupons = new ArrayList<>();
        cupons.add(new Cupom("CUPOM2", 2));
        cupons.add(new Cupom("CUPOM5", 5));
        cupons.add(new Cupom("CUPOM7", 7));
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public Cupom[] getCupons() {
        return cupons.toArray(new Cupom[cupons.size()]);
    }

    public Pedido[] getPedidos() {
        return pedidos.toArray(new Pedido[pedidos.size()]);
    }

    public Produto[] getProdutos() {
        return produtos.toArray(new Produto[produtos.size()]);
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int posicao) {
        produtos.remove(posicao);
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removerPedido(int posicao) {
        pedidos.remove(posicao);
    }
}
