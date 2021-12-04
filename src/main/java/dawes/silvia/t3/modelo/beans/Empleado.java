package dawes.silvia.t3.modelo.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Empleado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idEmpl;
	private String correo;
	private Date fechaIngreso;
	private Date fechaNacimiento;
	private String nombre;
	private BigDecimal salario;
	private Departamento departamento;
	private Perfile perfile;

	public Empleado() {
	}
	
	public Empleado(int idEmpl, String correo, Date fechaIngreso, Date fechaNacimiento, String nombre,
			BigDecimal salario, Departamento departamento, Perfile perfile) {
		super();
		this.idEmpl = idEmpl;
		this.correo = correo;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.salario = salario;
		this.departamento = departamento;
		this.perfile = perfile;
	}

	public int getIdEmpl() {
		return this.idEmpl;
	}

	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Perfile getPerfile() {
		return this.perfile;
	}

	public void setPerfile(Perfile perfile) {
		this.perfile = perfile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result + ((fechaIngreso == null) ? 0 : fechaIngreso.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + idEmpl;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((perfile == null) ? 0 : perfile.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Empleado))
			return false;
		Empleado other = (Empleado) obj;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		if (fechaIngreso == null) {
			if (other.fechaIngreso != null)
				return false;
		} else if (!fechaIngreso.equals(other.fechaIngreso))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (idEmpl != other.idEmpl)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (perfile == null) {
			if (other.perfile != null)
				return false;
		} else if (!perfile.equals(other.perfile))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpl=" + idEmpl + ", correo=" + correo + ", fechaIngreso=" + fechaIngreso
				+ ", fechaNacimiento=" + fechaNacimiento + ", nombre=" + nombre + ", salario=" + salario
				+ ", departamento=" + departamento + ", perfile=" + perfile + "]";
	}

}