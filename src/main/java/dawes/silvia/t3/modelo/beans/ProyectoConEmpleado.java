package dawes.silvia.t3.modelo.beans;

import java.io.Serializable;
import java.util.Date;

public class ProyectoConEmpleado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int numeroOrden;
	private Date fechaIncorporación;
	private int horasAsignadas;
	private Empleado empleado;
	private Proyecto proyecto;

	public ProyectoConEmpleado() {
	}
	
	public ProyectoConEmpleado(int numeroOrden, Date fechaIncorporación, int horasAsignadas, Empleado empleado,
			Proyecto proyecto) {
		super();
		this.numeroOrden = numeroOrden;
		this.fechaIncorporación = fechaIncorporación;
		this.horasAsignadas = horasAsignadas;
		this.empleado = empleado;
		this.proyecto = proyecto;
	}

	public int getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public Date getFechaIncorporación() {
		return this.fechaIncorporación;
	}

	public void setFechaIncorporación(Date fechaIncorporación) {
		this.fechaIncorporación = fechaIncorporación;
	}

	public int getHorasAsignadas() {
		return this.horasAsignadas;
	}

	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empleado == null) ? 0 : empleado.hashCode());
		result = prime * result + ((fechaIncorporación == null) ? 0 : fechaIncorporación.hashCode());
		result = prime * result + horasAsignadas;
		result = prime * result + numeroOrden;
		result = prime * result + ((proyecto == null) ? 0 : proyecto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProyectoConEmpleado))
			return false;
		ProyectoConEmpleado other = (ProyectoConEmpleado) obj;
		if (empleado == null) {
			if (other.empleado != null)
				return false;
		} else if (!empleado.equals(other.empleado))
			return false;
		if (fechaIncorporación == null) {
			if (other.fechaIncorporación != null)
				return false;
		} else if (!fechaIncorporación.equals(other.fechaIncorporación))
			return false;
		if (horasAsignadas != other.horasAsignadas)
			return false;
		if (numeroOrden != other.numeroOrden)
			return false;
		if (proyecto == null) {
			if (other.proyecto != null)
				return false;
		} else if (!proyecto.equals(other.proyecto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProyectoConEmpleado [numeroOrden=" + numeroOrden + ", fechaIncorporación=" + fechaIncorporación
				+ ", horasAsignadas=" + horasAsignadas + ", empleado=" + empleado + ", proyecto=" + proyecto + "]";
	}

}
