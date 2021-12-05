package dawes.silvia.t3.modelo.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dawes.silvia.t3.modelo.beans.ProyectoConEmpleado;

@Repository
public class ProyectoConEmpleadoImpl implements ProyectoConEmpleadoInt {
	
	private List<ProyectoConEmpleado> listaProyectoConEmpleado;
	
	public ProyectoConEmpleadoImpl() throws ParseException {
		listaProyectoConEmpleado = new ArrayList<ProyectoConEmpleado>();
		cargarDatos();
	}
	
	@Override
	public int insertarProyectoConEmpleado(ProyectoConEmpleado proyectoConEmpleado) {
		if (listaProyectoConEmpleado.contains(proyectoConEmpleado))
			return 0;
		else
			return listaProyectoConEmpleado.add(proyectoConEmpleado) ? 1 : 0;
	}

	@Override
	public ProyectoConEmpleado buscarProyectoConEmpleado(int ordenProyectoConEmpleado) {
		ProyectoConEmpleado proyectoConEmpleado = listaProyectoConEmpleado.stream()
				.filter(ele -> ele.getNumeroOrden() == ordenProyectoConEmpleado)
				.findAny()
				.orElse(null);
		
		return proyectoConEmpleado;
	}
		
	private void cargarDatos() throws ParseException {
		EmpleadoInt iEmpleado = new EmpleadoImpl();
		ProyectoInt iProyecto = new ProyectoImpl();
		
		ProyectoConEmpleado proConEmp1 = new ProyectoConEmpleado(1, 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				100, iEmpleado.buscarPorId(8), 
				iProyecto.buscarPorId("Proy2"));		
		ProyectoConEmpleado proConEmp2 = new ProyectoConEmpleado(2, 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				200, iEmpleado.buscarPorId(9), 
				iProyecto.buscarPorId("Proy2"));
		ProyectoConEmpleado proConEmp3 = new ProyectoConEmpleado(3, 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				300, iEmpleado.buscarPorId(3), 
				iProyecto.buscarPorId("Proy4"));
		ProyectoConEmpleado proConEmp4 = new ProyectoConEmpleado(4, 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				400, iEmpleado.buscarPorId(10), 
				iProyecto.buscarPorId("Proy4"));		
		ProyectoConEmpleado proConEmp5 = new ProyectoConEmpleado(5, 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				500, iEmpleado.buscarPorId(11), 
				iProyecto.buscarPorId("Proy5"));
		ProyectoConEmpleado proConEmp6 = new ProyectoConEmpleado(6, 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				600, iEmpleado.buscarPorId(6), 
				iProyecto.buscarPorId("Proy6"));
		ProyectoConEmpleado proConEmp7 = new ProyectoConEmpleado(7, 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				70, iEmpleado.buscarPorId(12), 
				iProyecto.buscarPorId("Proy7"));		
		ProyectoConEmpleado proConEmp8 = new ProyectoConEmpleado(8, 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				80, iEmpleado.buscarPorId(1), 
				iProyecto.buscarPorId("Proy7"));
		ProyectoConEmpleado proConEmp9 = new ProyectoConEmpleado(9, 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				90, iEmpleado.buscarPorId(2), 
				iProyecto.buscarPorId("Proy6"));
		ProyectoConEmpleado proConEmp10 = new ProyectoConEmpleado(10, 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				120, iEmpleado.buscarPorId(3), 
				iProyecto.buscarPorId("Proy5"));		
		ProyectoConEmpleado proConEmp11 = new ProyectoConEmpleado(11, 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				140, iEmpleado.buscarPorId(4), 
				iProyecto.buscarPorId("Proy4"));
		ProyectoConEmpleado proConEmp12 = new ProyectoConEmpleado(12,
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				160, iEmpleado.buscarPorId(5), 
				iProyecto.buscarPorId("Proy3"));
		ProyectoConEmpleado proConEmp13 = new ProyectoConEmpleado(13, 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				180, iEmpleado.buscarPorId(6), 
				iProyecto.buscarPorId("Proy2"));
		ProyectoConEmpleado proConEmp14 = new ProyectoConEmpleado(14, 
				new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				220, iEmpleado.buscarPorId(7), 
				iProyecto.buscarPorId("Proy1"));

		listaProyectoConEmpleado.add(proConEmp1);
		listaProyectoConEmpleado.add(proConEmp2);
		listaProyectoConEmpleado.add(proConEmp3);
		listaProyectoConEmpleado.add(proConEmp4);
		listaProyectoConEmpleado.add(proConEmp5);
		listaProyectoConEmpleado.add(proConEmp6);
		listaProyectoConEmpleado.add(proConEmp7);
		listaProyectoConEmpleado.add(proConEmp8);
		listaProyectoConEmpleado.add(proConEmp9);
		listaProyectoConEmpleado.add(proConEmp10);
		listaProyectoConEmpleado.add(proConEmp11);
		listaProyectoConEmpleado.add(proConEmp12);
		listaProyectoConEmpleado.add(proConEmp13);
		listaProyectoConEmpleado.add(proConEmp14);
	}

	@Override
	public List<ProyectoConEmpleado> buscarPorProyecto(String idProyecto) {
		List<ProyectoConEmpleado> empleadosEnProyecto = new ArrayList<ProyectoConEmpleado>();
		listaProyectoConEmpleado.forEach(ele -> {
			if (ele.getProyecto().getIdProyecto().equals(idProyecto))
				empleadosEnProyecto.add(ele);
		});
				
		return empleadosEnProyecto;
	}
	

}
