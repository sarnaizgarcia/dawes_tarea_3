package dawes.silvia.t3.modelo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import dawes.silvia.t3.modelo.beans.Cliente;

@Repository
public interface ClienteInt {
	
	int insertarCliente(Cliente cliente);
	Cliente buscarPorCif(String cifCliente);
	List<Cliente> buscarTodos();
}
