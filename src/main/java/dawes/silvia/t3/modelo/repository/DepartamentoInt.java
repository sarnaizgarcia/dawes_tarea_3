package dawes.silvia.t3.modelo.repository;

import dawes.silvia.t3.modelo.beans.Departamento;

public interface DepartamentoInt {
	
	int insertarDepartamento(Departamento departamento);
	Departamento buscarPorId(int idDepartamento);
}
