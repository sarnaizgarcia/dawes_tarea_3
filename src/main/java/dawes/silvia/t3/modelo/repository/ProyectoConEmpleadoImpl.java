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
//		cargarDatos();
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
		
		ProyectoConEmpleado proConEmp1 = new ProyectoConEmpleado(1, new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
					300, iEmpleado.buscarPorId(1), iProyecto.buscarPorId("Proy1"));		
		ProyectoConEmpleado proConEmp2 = new ProyectoConEmpleado(2, new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				150, iEmpleado.buscarPorId(2), iProyecto.buscarPorId("Proy2"));
		ProyectoConEmpleado proConEmp3 = new ProyectoConEmpleado(3, new SimpleDateFormat("yyyy/MM/dd").parse("2021/07/25"),
				400, iEmpleado.buscarPorId(1), iProyecto.buscarPorId("Proy3"));

		listaProyectoConEmpleado.add(proConEmp1);
		listaProyectoConEmpleado.add(proConEmp2);
		listaProyectoConEmpleado.add(proConEmp3);
	}

	@Override
	public List<ProyectoConEmpleado> buscarPorProyecto(String idProyecto) {
		List<ProyectoConEmpleado> empleadosEnProyecto = new ArrayList<ProyectoConEmpleado>();
		listaProyectoConEmpleado.forEach(ele -> {
			if (ele.getProyecto().equals(idProyecto))
				empleadosEnProyecto.add(ele);
		});
				
		return empleadosEnProyecto;
	}
	

}
