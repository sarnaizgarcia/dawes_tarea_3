package dawes.silvia.t3.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dawes.silvia.t3.modelo.beans.Departamento;

@Repository
public class DepartamentoImpl implements DepartamentoInt {
	
	private List<Departamento> listaDepartamentos;

	public DepartamentoImpl() {
		listaDepartamentos = new ArrayList<Departamento>();
		cargarDatos();
	}
	
	@Override
	public int insertarDepartamento(Departamento departamento) {
		if (listaDepartamentos.contains(departamento))
			return 0;
		else
			return listaDepartamentos.add(departamento) ? 1 : 0;
	}
	
	@Override
	public Departamento buscarPorId(int idDepartamento) {
		Departamento departamento = listaDepartamentos.stream()
				.filter(ele -> ele.getIdDepar() == idDepartamento)
				.findAny()
				.orElse(null);
		
		return departamento;
	}
	
	private void cargarDatos() {
		
		EmpleadoInt iEmpleado = new EmpleadoImpl();
		
		Departamento departamento1 = new Departamento(1, "Direc dpto 1", "Departamento1", iEmpleado.buscarPorId(1));
		Departamento departamento2 = new Departamento(2, "Direc dpto 2", "Departamento2", iEmpleado.buscarPorId(2));
		Departamento departamento3 = new Departamento(3, "Direc dpto 3", "Departamento3", iEmpleado.buscarPorId(4));
		Departamento departamento4 = new Departamento(4, "Direc dpto 4", "Departamento4", iEmpleado.buscarPorId(5));

		listaDepartamentos.add(departamento1);
		listaDepartamentos.add(departamento2);
		listaDepartamentos.add(departamento3);
		listaDepartamentos.add(departamento4);
	}

}
