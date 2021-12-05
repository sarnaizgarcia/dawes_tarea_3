package dawes.silvia.t3.modelo.repository;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dawes.silvia.t3.modelo.beans.ProyectoConProducto;

@Repository
public class ProyectoConProductoImpl implements ProyectoConProductoInt {

	List<ProyectoConProducto> listaProyectoConProducto;
	
	public ProyectoConProductoImpl() throws ParseException {
		listaProyectoConProducto = new ArrayList<ProyectoConProducto>();
		cargarDatos();
	}
	
	@Override
	public int insertarProyectoConProducto(ProyectoConProducto proyectoConProducto) {
		if (listaProyectoConProducto.contains(proyectoConProducto))
			return 0;
		else
			return listaProyectoConProducto.add(proyectoConProducto) ? 1 : 0;
	}

	@Override
	public ProyectoConProducto buscarProyectoConProducto(int idProyectoConProducto) {
		ProyectoConProducto proyectoConProducto = listaProyectoConProducto.stream()
				.filter(ele -> ele.getProducto().getIdProducto() == idProyectoConProducto)
				.findAny()
				.orElse(null);

		return proyectoConProducto;
	}

	@Override
	public List<ProyectoConProducto> buscarPorProyecto(String idProyecto) {
		List<ProyectoConProducto> productosEnProyecto = new ArrayList<ProyectoConProducto>();
		listaProyectoConProducto.forEach(ele -> {
			if (ele.getProyecto().getIdProyecto().equals(idProyecto))
				productosEnProyecto.add(ele);
		});
		
		return productosEnProyecto;
	}
	
	private void cargarDatos() throws ParseException {
		ProyectoInt iProyecto = new ProyectoImpl();
		ProductoInt iProducto = new ProductoImpl();
		
		
		ProyectoConProducto proConProd1 = new ProyectoConProducto(1,
				15, new BigDecimal(40), iProducto.buscarPorId(1), 
				iProyecto.buscarPorId("Proy1"));
		ProyectoConProducto proConProd2 = new ProyectoConProducto(2,
				15, new BigDecimal(40), iProducto.buscarPorId(2), 
				iProyecto.buscarPorId("Proy1"));
		ProyectoConProducto proConProd3 = new ProyectoConProducto(3,
				15, new BigDecimal(40), iProducto.buscarPorId(3), 
				iProyecto.buscarPorId("Proy1"));
		ProyectoConProducto proConProd4 = new ProyectoConProducto(4,
				15, new BigDecimal(40), iProducto.buscarPorId(4), 
				iProyecto.buscarPorId("Proy1"));
		ProyectoConProducto proConProd5 = new ProyectoConProducto(5,
				15, new BigDecimal(40), iProducto.buscarPorId(5), 
				iProyecto.buscarPorId("Proy1"));
		
		ProyectoConProducto proConProd6 = new ProyectoConProducto(6,
				15, new BigDecimal(40), iProducto.buscarPorId(1), 
				iProyecto.buscarPorId("Proy2"));
		ProyectoConProducto proConProd7 = new ProyectoConProducto(7,
				15, new BigDecimal(40), iProducto.buscarPorId(2), 
				iProyecto.buscarPorId("Proy2"));
		ProyectoConProducto proConProd8 = new ProyectoConProducto(8,
				15, new BigDecimal(40), iProducto.buscarPorId(3), 
				iProyecto.buscarPorId("Proy2"));
		ProyectoConProducto proConProd9 = new ProyectoConProducto(9,
				15, new BigDecimal(40), iProducto.buscarPorId(4), 
				iProyecto.buscarPorId("Proy2"));
		ProyectoConProducto proConProd10 = new ProyectoConProducto(10,
				15, new BigDecimal(40), iProducto.buscarPorId(5), 
				iProyecto.buscarPorId("Proy2"));
		
		ProyectoConProducto proConProd11 = new ProyectoConProducto(11,
				15, new BigDecimal(40), iProducto.buscarPorId(1), 
				iProyecto.buscarPorId("Proy5"));
		ProyectoConProducto proConProd12 = new ProyectoConProducto(12,
				15, new BigDecimal(40), iProducto.buscarPorId(2), 
				iProyecto.buscarPorId("Proy3"));
		ProyectoConProducto proConProd13 = new ProyectoConProducto(13,
				15, new BigDecimal(40), iProducto.buscarPorId(3), 
				iProyecto.buscarPorId("Proy3"));
		ProyectoConProducto proConProd14 = new ProyectoConProducto(14,
				15, new BigDecimal(40), iProducto.buscarPorId(4), 
				iProyecto.buscarPorId("Proy3"));
		ProyectoConProducto proConProd15 = new ProyectoConProducto(15,
				15, new BigDecimal(40), iProducto.buscarPorId(5), 
				iProyecto.buscarPorId("Proy3"));
		
		ProyectoConProducto proConProd16 = new ProyectoConProducto(16,
				15, new BigDecimal(40), iProducto.buscarPorId(1), 
				iProyecto.buscarPorId("Proy4"));
		ProyectoConProducto proConProd17 = new ProyectoConProducto(17,
				15, new BigDecimal(40), iProducto.buscarPorId(2), 
				iProyecto.buscarPorId("Proy4"));
		ProyectoConProducto proConProd18 = new ProyectoConProducto(18,
				15, new BigDecimal(40), iProducto.buscarPorId(3), 
				iProyecto.buscarPorId("Proy4"));
		ProyectoConProducto proConProd19 = new ProyectoConProducto(19,
				15, new BigDecimal(40), iProducto.buscarPorId(4), 
				iProyecto.buscarPorId("Proy4"));
		ProyectoConProducto proConProd20 = new ProyectoConProducto(20,
				15, new BigDecimal(40), iProducto.buscarPorId(5), 
				iProyecto.buscarPorId("Proy4"));
		
		ProyectoConProducto proConProd21 = new ProyectoConProducto(21,
				15, new BigDecimal(40), iProducto.buscarPorId(1), 
				iProyecto.buscarPorId("Proy6"));
		ProyectoConProducto proConProd22 = new ProyectoConProducto(22,
				15, new BigDecimal(40), iProducto.buscarPorId(2), 
				iProyecto.buscarPorId("Proy6"));
		ProyectoConProducto proConProd23 = new ProyectoConProducto(23,
				15, new BigDecimal(40), iProducto.buscarPorId(3), 
				iProyecto.buscarPorId("Proy6"));
		ProyectoConProducto proConProd24 = new ProyectoConProducto(24,
				15, new BigDecimal(40), iProducto.buscarPorId(4), 
				iProyecto.buscarPorId("Proy6"));
		ProyectoConProducto proConProd25 = new ProyectoConProducto(25,
				15, new BigDecimal(40), iProducto.buscarPorId(5), 
				iProyecto.buscarPorId("Proy6"));

		ProyectoConProducto proConProd26 = new ProyectoConProducto(26,
				15, new BigDecimal(40), iProducto.buscarPorId(1), 
				iProyecto.buscarPorId("Proy7"));
		ProyectoConProducto proConProd27 = new ProyectoConProducto(27,
				15, new BigDecimal(40), iProducto.buscarPorId(2), 
				iProyecto.buscarPorId("Proy7"));
		ProyectoConProducto proConProd28 = new ProyectoConProducto(28,
				15, new BigDecimal(40), iProducto.buscarPorId(3), 
				iProyecto.buscarPorId("Proy7"));
		ProyectoConProducto proConProd29 = new ProyectoConProducto(29,
				15, new BigDecimal(40), iProducto.buscarPorId(4), 
				iProyecto.buscarPorId("Proy7"));
		ProyectoConProducto proConProd30 = new ProyectoConProducto(30,
				15, new BigDecimal(40), iProducto.buscarPorId(5), 
				iProyecto.buscarPorId("Proy7"));
		
		ProyectoConProducto proConProd31 = new ProyectoConProducto(31,
				15, new BigDecimal(40), iProducto.buscarPorId(1), 
				iProyecto.buscarPorId("Proy5"));
		ProyectoConProducto proConProd32 = new ProyectoConProducto(32,
				15, new BigDecimal(40), iProducto.buscarPorId(2), 
				iProyecto.buscarPorId("Proy5"));
		ProyectoConProducto proConProd33 = new ProyectoConProducto(33,
				15, new BigDecimal(40), iProducto.buscarPorId(3), 
				iProyecto.buscarPorId("Proy5"));
		ProyectoConProducto proConProd34 = new ProyectoConProducto(34,
				15, new BigDecimal(40), iProducto.buscarPorId(4), 
				iProyecto.buscarPorId("Proy5"));
		ProyectoConProducto proConProd35 = new ProyectoConProducto(35,
				15, new BigDecimal(40), iProducto.buscarPorId(5), 
				iProyecto.buscarPorId("Proy5"));
	
		listaProyectoConProducto.add(proConProd1);
		listaProyectoConProducto.add(proConProd2);
		listaProyectoConProducto.add(proConProd3);
		listaProyectoConProducto.add(proConProd4);
		listaProyectoConProducto.add(proConProd5);
		listaProyectoConProducto.add(proConProd6);
		listaProyectoConProducto.add(proConProd7);
		listaProyectoConProducto.add(proConProd8);
		listaProyectoConProducto.add(proConProd9);
		listaProyectoConProducto.add(proConProd10);
		listaProyectoConProducto.add(proConProd11);
		listaProyectoConProducto.add(proConProd12);
		listaProyectoConProducto.add(proConProd13);
		listaProyectoConProducto.add(proConProd14);
		listaProyectoConProducto.add(proConProd15);
		listaProyectoConProducto.add(proConProd16);
		listaProyectoConProducto.add(proConProd17);
		listaProyectoConProducto.add(proConProd18);
		listaProyectoConProducto.add(proConProd19);
		listaProyectoConProducto.add(proConProd20);
		listaProyectoConProducto.add(proConProd21);
		listaProyectoConProducto.add(proConProd22);
		listaProyectoConProducto.add(proConProd23);
		listaProyectoConProducto.add(proConProd24);
		listaProyectoConProducto.add(proConProd25);
		listaProyectoConProducto.add(proConProd26);
		listaProyectoConProducto.add(proConProd27);
		listaProyectoConProducto.add(proConProd28);
		listaProyectoConProducto.add(proConProd29);
		listaProyectoConProducto.add(proConProd30);
		listaProyectoConProducto.add(proConProd31);
		listaProyectoConProducto.add(proConProd32);
		listaProyectoConProducto.add(proConProd33);
		listaProyectoConProducto.add(proConProd34);
		listaProyectoConProducto.add(proConProd35);
	}

}
