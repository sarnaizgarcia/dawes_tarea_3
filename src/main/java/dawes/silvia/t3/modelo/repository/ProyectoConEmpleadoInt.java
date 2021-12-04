package dawes.silvia.t3.modelo.repository;

import java.util.List;

import dawes.silvia.t3.modelo.beans.ProyectoConEmpleado;

public interface ProyectoConEmpleadoInt {
	
	int insertarProyectoConEmpleado(ProyectoConEmpleado proyectoConEmpleado);
	ProyectoConEmpleado buscarProyectoConEmpleado(int ordenProyectoConEmpleado);
	List<ProyectoConEmpleado> buscarPorProyecto(String idProyecto);

}
