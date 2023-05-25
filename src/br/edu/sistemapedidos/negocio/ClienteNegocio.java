package br.edu.sistemapedidos.negocio;

import java.util.Optional;

import br.edu.sistemapedidos.basedados.BancoDados;
import br.edu.sistemapedidos.entidade.Cliente;

public class ClienteNegocio {
	
	private BancoDados bancoDados;

    public ClienteNegocio(BancoDados banco) {
        this.bancoDados = banco;
    }


    public Optional<Cliente> consultar(String cpf) {

        if (bancoDados.getCliente().getCpf().equals(cpf)) {
            return Optional.of(bancoDados.getCliente());
        } else {
            return Optional.empty();
        }
    }
}
