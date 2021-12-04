package dawes.silvia.t3.modelo.repository;

import java.util.List;

import dawes.silvia.t3.modelo.beans.Proyecto;

public interface ProyectoInt {
	
	int insertarProyecto(Proyecto proyecto);
	Proyecto buscarPorId(String idProyecto);
	List<Proyecto> buscarPorJefe(int idEmpleado);
	List<Proyecto> buscarTodos();

}
