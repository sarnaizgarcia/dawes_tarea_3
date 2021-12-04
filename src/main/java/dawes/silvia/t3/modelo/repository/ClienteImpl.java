package dawes.silvia.t3.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dawes.silvia.t3.modelo.beans.Cliente;

@Repository
public class ClienteImpl implements ClienteInt {
	
	private List<Cliente> listaClientes;
	
	public ClienteImpl() {
		listaClientes = new ArrayList<Cliente>();
		cargarDatos();
	}

	@Override
	public int insertarCliente(Cliente cliente) {
		if (listaClientes.contains(cliente))
			return 0;
		else
			return listaClientes.add(cliente) ? 1 : 0;
	}
	
	private void cargarDatos() {
		Cliente cliente1 = new Cliente("11111111A", "Domicilio1", new BigDecimal(500000), "Cliente1", 50);
		Cliente cliente2 = new Cliente("22222222B", "Domicilio2", new BigDecimal(1000000), "Cliente2", 800);
		Cliente cliente3 = new Cliente("33333333C", "Domicilio3", new BigDecimal(750000), "Cliente3", 200);
		Cliente cliente4 = new Cliente("44444444D", "Domicilio4", new BigDecimal(800000), "Cliente4", 300);
		Cliente cliente5 = new Cliente("55555555E", "Domicilio5", new BigDecimal(300000), "Cliente5", 500);
		Cliente cliente6 = new Cliente("66666666F", "Domicilio6", new BigDecimal(1500000), "Cliente6", 100);
		
		listaClientes.add(cliente1);
		listaClientes.add(cliente2);
		listaClientes.add(cliente3);
		listaClientes.add(cliente4);
		listaClientes.add(cliente5);
		listaClientes.add(cliente6);
	}

	@Override
	public Cliente buscarPorCif(String cifCliente) {
		Cliente cliente = listaClientes.stream()
				.filter(ele -> ele.getCif().equals(cifCliente))
				.findAny()
				.orElse(null);
		
		return cliente;
	}

	@Override
	public List<Cliente> buscarTodos() {
		return listaClientes;
	}

}
