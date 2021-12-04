package dawes.silvia.t3.modelo.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Proyecto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String idProyecto;
	private BigDecimal costeReal;
	private BigDecimal costesPrevisto;
	private String descripcion;
	private String estado;
	private Date fechaFinPrevisto;
	private Date fechaFinReal;
	private Date fechaInicio;
	private BigDecimal ventaPrevisto;
	private List<ProyectoConEmpleado> proyectoConEmpleados;
	private Cliente cliente;
	private Empleado jefeProyecto;

	public Proyecto() {
	}
	
	public Proyecto(String idProyecto, BigDecimal costeReal, BigDecimal costesPrevisto, String descripcion,
			String estado, Date fechaFinPrevisto, Date fechaFinReal, Date fechaInicio, BigDecimal ventaPrevisto,
			List<ProyectoConEmpleado> proyectoConEmpleados, Cliente cliente, Empleado jefeProyecto) {
		super();
		this.idProyecto = idProyecto;
		this.costeReal = costeReal;
		this.costesPrevisto = costesPrevisto;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.fechaFinReal = fechaFinReal;
		this.fechaInicio = fechaInicio;
		this.ventaPrevisto = ventaPrevisto;
		this.proyectoConEmpleados = proyectoConEmpleados;
		this.cliente = cliente;
		this.jefeProyecto = jefeProyecto;
	}

	public String getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public BigDecimal getCosteReal() {
		return this.costeReal;
	}

	public void setCosteReal(BigDecimal costeReal) {
		this.costeReal = costeReal;
	}

	public BigDecimal getCostesPrevisto() {
		return this.costesPrevisto;
	}

	public void setCostesPrevisto(BigDecimal costesPrevisto) {
		this.costesPrevisto = costesPrevisto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFinPrevisto() {
		return this.fechaFinPrevisto;
	}

	public void setFechaFinPrevisto(Date fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}

	public Date getFechaFinReal() {
		return this.fechaFinReal;
	}

	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public BigDecimal getVentaPrevisto() {
		return this.ventaPrevisto;
	}

	public void setVentaPrevisto(BigDecimal ventaPrevisto) {
		this.ventaPrevisto = ventaPrevisto;
	}

	public List<ProyectoConEmpleado> getProyectoConEmpleados() {
		return this.proyectoConEmpleados;
	}

	public void setProyectoConEmpleados(List<ProyectoConEmpleado> proyectoConEmpleados) {
		this.proyectoConEmpleados = proyectoConEmpleados;
	}

	public ProyectoConEmpleado addProyectoConEmpleado(ProyectoConEmpleado proyectoConEmpleado) {
		getProyectoConEmpleados().add(proyectoConEmpleado);
		proyectoConEmpleado.setProyecto(this);

		return proyectoConEmpleado;
	}

	public ProyectoConEmpleado removeProyectoConEmpleado(ProyectoConEmpleado proyectoConEmpleado) {
		getProyectoConEmpleados().remove(proyectoConEmpleado);
		proyectoConEmpleado.setProyecto(null);

		return proyectoConEmpleado;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getJefeProyecto() {
		return this.jefeProyecto;
	}

	public void setJefeProyecto(Empleado jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((costeReal == null) ? 0 : costeReal.hashCode());
		result = prime * result + ((costesPrevisto == null) ? 0 : costesPrevisto.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaFinPrevisto == null) ? 0 : fechaFinPrevisto.hashCode());
		result = prime * result + ((fechaFinReal == null) ? 0 : fechaFinReal.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + ((idProyecto == null) ? 0 : idProyecto.hashCode());
		result = prime * result + ((jefeProyecto == null) ? 0 : jefeProyecto.hashCode());
		result = prime * result + ((proyectoConEmpleados == null) ? 0 : proyectoConEmpleados.hashCode());
		result = prime * result + ((ventaPrevisto == null) ? 0 : ventaPrevisto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Proyecto))
			return false;
		Proyecto other = (Proyecto) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (costeReal == null) {
			if (other.costeReal != null)
				return false;
		} else if (!costeReal.equals(other.costeReal))
			return false;
		if (costesPrevisto == null) {
			if (other.costesPrevisto != null)
				return false;
		} else if (!costesPrevisto.equals(other.costesPrevisto))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaFinPrevisto == null) {
			if (other.fechaFinPrevisto != null)
				return false;
		} else if (!fechaFinPrevisto.equals(other.fechaFinPrevisto))
			return false;
		if (fechaFinReal == null) {
			if (other.fechaFinReal != null)
				return false;
		} else if (!fechaFinReal.equals(other.fechaFinReal))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (idProyecto == null) {
			if (other.idProyecto != null)
				return false;
		} else if (!idProyecto.equals(other.idProyecto))
			return false;
		if (jefeProyecto == null) {
			if (other.jefeProyecto != null)
				return false;
		} else if (!jefeProyecto.equals(other.jefeProyecto))
			return false;
		if (proyectoConEmpleados == null) {
			if (other.proyectoConEmpleados != null)
				return false;
		} else if (!proyectoConEmpleados.equals(other.proyectoConEmpleados))
			return false;
		if (ventaPrevisto == null) {
			if (other.ventaPrevisto != null)
				return false;
		} else if (!ventaPrevisto.equals(other.ventaPrevisto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", costeReal=" + costeReal + ", costesPrevisto=" + costesPrevisto
				+ ", descripcion=" + descripcion + ", estado=" + estado + ", fechaFinPrevisto=" + fechaFinPrevisto
				+ ", fechaFinReal=" + fechaFinReal + ", fechaInicio=" + fechaInicio + ", ventaPrevisto=" + ventaPrevisto
				+ ", proyectoConEmpleados=" + proyectoConEmpleados + ", cliente=" + cliente + ", jefeProyecto="
				+ jefeProyecto + "]";
	}

}
