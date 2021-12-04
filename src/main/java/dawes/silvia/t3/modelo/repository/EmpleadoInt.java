package dawes.silvia.t3.modelo.repository;

import java.util.List;

import dawes.silvia.t3.modelo.beans.Empleado;

public interface EmpleadoInt {
	
	int insertarEmpleado(Empleado empleado);
	Empleado buscarPorId(int idEmpleado);
	Empleado buscarPorEmail(String idEmpleado);
	List<Empleado> buscarTodos();
}
