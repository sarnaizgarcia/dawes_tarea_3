package dawes.silvia.t3.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import dawes.silvia.t3.modelo.beans.Empleado;

@Repository
public class EmpleadoImpl implements EmpleadoInt {
	
	private List<Empleado> listaEmpleados;

	public EmpleadoImpl() {
		listaEmpleados = new ArrayList<Empleado>();
		cargarDatos();
	}


	@Override
	public int insertarEmpleado(Empleado empleado) {
		if (listaEmpleados.contains(empleado))
			return 0;
		else
			return listaEmpleados.add(empleado) ? 1 : 0;
	}
	
	private void cargarDatos() {
		PerfileInt iPerfile = new PerfileImpl();
		
		Empleado empleado1 = new Empleado(1, "empleado1@proy.com", new Date(), new Date(), "Empleado1", new BigDecimal(40000), iPerfile.buscarPorId(1), "1234");
		Empleado empleado2 = new Empleado(2, "empleado2@proy.com", new Date(), new Date(), "Empleado2", new BigDecimal(30000), iPerfile.buscarPorId(1), "1234");
		Empleado empleado3 = new Empleado(3, "empleado3@proy.com", new Date(), new Date(), "Empleado3", new BigDecimal(50000), iPerfile.buscarPorId(2), "1234");
		Empleado empleado4 = new Empleado(4, "empleado4@proy.com", new Date(), new Date(), "Empleado4", new BigDecimal(45000), iPerfile.buscarPorId(3), "1234");
		Empleado empleado5 = new Empleado(5, "empleado5@proy.com", new Date(), new Date(), "Empleado5", new BigDecimal(35000), iPerfile.buscarPorId(4), "1234");
		Empleado empleado6 = new Empleado(6, "empleado6@proy.com", new Date(), new Date(), "Empleado6", new BigDecimal(60000), iPerfile.buscarPorId(4), "1234");
		
		listaEmpleados.add(empleado1);
		listaEmpleados.add(empleado2);
		listaEmpleados.add(empleado3);
		listaEmpleados.add(empleado4);
		listaEmpleados.add(empleado5);
		listaEmpleados.add(empleado6);
	}

	@Override
	public Empleado buscarPorId(int idEmpleado) {
		Empleado empleado = listaEmpleados.stream()
				.filter(ele -> ele.getIdEmpl() == idEmpleado)
				.findAny()
				.orElse(null);
		
		return empleado;
	}


	@Override
	public Empleado buscarPorEmail(String emailEmpleado) {
		System.out.println(emailEmpleado);
		System.out.println(listaEmpleados);

		Empleado empleado = listaEmpleados.stream()
				.filter(ele -> ele.getCorreo().equals(emailEmpleado))
				.findAny()
				.orElse(null);
		
		return empleado;
	}

}
