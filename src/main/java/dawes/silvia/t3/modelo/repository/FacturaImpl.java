package dawes.silvia.t3.modelo.repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dawes.silvia.t3.modelo.beans.Factura;

@Repository
public class FacturaImpl implements FacturaInt {
	
	private List<Factura> listaFacturas;
	
	public FacturaImpl() throws ParseException {
		listaFacturas = new ArrayList<Factura>();
		cargarDatos();
	}

	@Override
	public int insertarFactura(Factura factura) {
		if (listaFacturas.contains(factura))
			return 0;
		else
		return listaFacturas.add(factura) ? 1 : 0;
	}

	@Override
	public Factura buscarFacturaPorId(String idFactura) {
		Factura factura = listaFacturas.stream()
				.filter(ele -> ele.getIdFactura().equals(idFactura))
				.findAny()
				.orElse(null);
		
		return factura;
	}
	
	private void cargarDatos() throws ParseException {
		ProyectoInt iProyecto = new ProyectoImpl();
		
		Factura factura1 = new Factura("F2021-01", "Factura 1", iProyecto.buscarPorId("Proy1"));
		Factura factura2 = new Factura("F2021-02", "Factura 2", iProyecto.buscarPorId("Proy2"));
		Factura factura3 = new Factura("F2021-03", "Factura 3", iProyecto.buscarPorId("Proy3"));
				
		listaFacturas.add(factura1);
		listaFacturas.add(factura2);
		listaFacturas.add(factura3);
	}

}
