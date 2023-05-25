package br.edu.sistemapedidos.utilidade;

import java.util.Optional;
import java.util.Scanner;

import br.edu.sistemapedidos.basedados.BancoDados;
import br.edu.sistemapedidos.entidade.Caderno;
import br.edu.sistemapedidos.entidade.Cupom;
import br.edu.sistemapedidos.entidade.Livro;
import br.edu.sistemapedidos.entidade.Pedido;
import br.edu.sistemapedidos.entidade.Produto;
import br.edu.sistemapedidos.entidade.constantes.Genero;
import br.edu.sistemapedidos.entidade.constantes.Materias;
import br.edu.sistemapedidos.negocio.ProdutoNegocio;


public class LeitoraDados {
	
	private static Scanner scanner;
	
	
	static {
		scanner = new Scanner(System.in);
	}

	
	public static String lerDado() {
		
		String texto = scanner.nextLine();
		
		return texto;
	}


	public static Livro lerLivro() {

		System.out.println("Cadastrando livro...");
		Livro livro = new Livro();

		System.out.println("Digite o nome");
		String nome = lerDado();
		livro.setNome(nome);

		System.out.println("Digite o gênero: DRAMA, SUSPENSE, ROMANCE");
		String genero = lerDado();
		livro.setGenero(Genero.valueOf(genero.toUpperCase()));
		//metodo valueOf é fornecido por toda Enum criada, é usado para obter uma instância da enumeração com base no nome fornecido como argumento.

		System.out.println("Digite o preço(padrão 0.0)");
		String preco = lerDado();
		livro.setPreco(Double.parseDouble(preco));
		//converte de string para double a variavel preço e seta em setPreço.
		
		return livro;
	}


	public static Caderno lerCaderno() {

		System.out.println("Cadastrando caderno...");
		Caderno caderno = new Caderno();

		System.out.println("Digite a quantidade de matérias: M2, M5, M10");
		String materias = lerDado();
		caderno.setTipo(Materias.valueOf(materias.toUpperCase()));

		System.out.println("Digite o preço(padrão 0.0)");
		String preco = lerDado();
		caderno.setPreco(Double.parseDouble(preco));

		return caderno;
	}


	public static Pedido lerPedido(BancoDados banco) {

		ProdutoNegocio produtoNegocio = new ProdutoNegocio(banco);

		System.out.println("Cadastrando pedido...");
		Pedido pedido = new Pedido();

		String opcao = "s";
		do {

			System.out.println("Digite o código do produto(livro/Caderno)");
			String codigo = lerDado();

			Optional<Produto> resultado = produtoNegocio.consultar(codigo);
			if (resultado.isPresent()) {

				Produto produto = resultado.get();

				System.out.println("Digite a quantidade");
				String quantidade = lerDado();
				produto.setQuantidade(Integer.parseInt(quantidade));

				pedido.getProdutos().add(produto);
			} else {
				System.out.println("Produto inexistente. Escolha um produto válido");
			}

			System.out.println("Deseja selecionar mais um produto? s/n");
			opcao = lerDado();
		} while("s".equals(opcao));

		return pedido;
	}


	public static Optional<Cupom> lerCupom(BancoDados banco) {

		System.out.println("Caso queira utilizar algum cupom escolha entre: CUPOM2, CUPOM5, CUPOM7. Se não desejar, deixe em branco.");

		String desconto = lerDado();

		for (Cupom cupom: banco.getCupons()) {
			if (cupom.getCodigo().equalsIgnoreCase(desconto)) {
				return Optional.of(cupom);
			}
		}

		return Optional.empty();
	}
}
