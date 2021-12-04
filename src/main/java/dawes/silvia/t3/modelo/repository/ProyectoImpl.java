package dawes.silvia.t3.modelo.repository;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dawes.silvia.t3.modelo.beans.Proyecto;

@Repository
public class ProyectoImpl implements ProyectoInt {
	
	private List<Proyecto> listaProyectos;
	
	public ProyectoImpl() throws ParseException {
		listaProyectos = new ArrayList<Proyecto>();
//		cargarDatos();
	}

	@Override
	public int insertarProyecto(Proyecto proyecto) {
		if (listaProyectos.contains(proyecto))
			return 0;
		else
			return listaProyectos.add(proyecto) ? 1 : 0;
	}

	@Override
	public Proyecto buscarPorId(String idProyecto) {
		Proyecto proyecto = listaProyectos.stream()
				.filter(ele -> ele.getIdProyecto().equals(idProyecto))
				.findAny()
				.orElse(null);
		
		return proyecto;
	}
	
	private void cargarDatos() throws ParseException {
		ClienteInt iCliente = new ClienteImpl();
		EmpleadoInt iEmpleado = new EmpleadoImpl();
		ProyectoConEmpleadoInt iProyConEmp = new ProyectoConEmpleadoImpl();
		
		Proyecto proyecto1 = new Proyecto("Proy1", 
				new BigDecimal(1000000), 
				new BigDecimal(780000), 
				"Descripción proyecto1", 
				"Finalizado", 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/05/17"),
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/06/17"),
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/01/17"),
				new BigDecimal(2500000), 
				iCliente.buscarPorCif("11111111A"), 
				iEmpleado.buscarPorId(1));
		
		Proyecto proyecto2 = new Proyecto("Proy2", 
				new BigDecimal(1200000), 
				new BigDecimal(1000000), 
				"Descripción proyecto2", 
				"En curso", 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/05/17"),
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/06/17"),
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/01/17"),
				new BigDecimal(2500000), 
				iCliente.buscarPorCif("22222222B"), 
				iEmpleado.buscarPorId(3));
		
		Proyecto proyecto3 = new Proyecto("Proy3", 
				new BigDecimal(1000000), 
				new BigDecimal(780000), 
				"Descripción proyecto3", 
				"En curso", 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/05/17"),
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/06/17"),
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/01/17"),
				new BigDecimal(2500000), 
				iCliente.buscarPorCif("33333333C"), 
				iEmpleado.buscarPorId(4));
		
		listaProyectos.add(proyecto1);
		listaProyectos.add(proyecto2);
		listaProyectos.add(proyecto3);
	}

}
