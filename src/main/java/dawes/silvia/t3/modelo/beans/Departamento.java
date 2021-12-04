package dawes.silvia.t3.modelo.beans;

import java.io.Serializable;

public class Departamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idDepar;
	private String direccion;
	private String nombre;
	private Empleado jefeDepar;

	public Departamento() {
	}
	
	public Departamento(int idDepar, String direccion, String nombre, Empleado jefeDepar) {
		super();
		this.idDepar = idDepar;
		this.direccion = direccion;
		this.nombre = nombre;
		this.jefeDepar = jefeDepar;
	}

	public int getIdDepar() {
		return this.idDepar;
	}

	public void setIdDepar(int idDepar) {
		this.idDepar = idDepar;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Empleado getJefeDepar() {
		return this.jefeDepar;
	}

	public void setJefeDepar(Empleado jefeDepar) {
		this.jefeDepar = jefeDepar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + idDepar;
		result = prime * result + ((jefeDepar == null) ? 0 : jefeDepar.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Departamento))
			return false;
		Departamento other = (Departamento) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (idDepar != other.idDepar)
			return false;
		if (jefeDepar == null) {
			if (other.jefeDepar != null)
				return false;
		} else if (!jefeDepar.equals(other.jefeDepar))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [idDepar=" + idDepar + ", direccion=" + direccion + ", nombre=" + nombre + ", jefeDepar="
				+ jefeDepar + "]";
	}

}