package dawes.silvia.t3.modelo.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String cif;
	private String domicilio;
	private BigDecimal facturacionAnual;
	private String nombre;
	private int numeroEmpleados;

	public Cliente() {
	}
	
	public Cliente(String cif, String domicilio, BigDecimal facturacionAnual, String nombre, int numeroEmpleados) {
		super();
		this.cif = cif;
		this.domicilio = domicilio;
		this.facturacionAnual = facturacionAnual;
		this.nombre = nombre;
		this.numeroEmpleados = numeroEmpleados;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public BigDecimal getFacturacionAnual() {
		return this.facturacionAnual;
	}

	public void setFacturacionAnual(BigDecimal facturacionAnual) {
		this.facturacionAnual = facturacionAnual;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroEmpleados() {
		return this.numeroEmpleados;
	}

	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cif == null) ? 0 : cif.hashCode());
		result = prime * result + ((domicilio == null) ? 0 : domicilio.hashCode());
		result = prime * result + ((facturacionAnual == null) ? 0 : facturacionAnual.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + numeroEmpleados;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		if (cif == null) {
			if (other.cif != null)
				return false;
		} else if (!cif.equals(other.cif))
			return false;
		if (domicilio == null) {
			if (other.domicilio != null)
				return false;
		} else if (!domicilio.equals(other.domicilio))
			return false;
		if (facturacionAnual == null) {
			if (other.facturacionAnual != null)
				return false;
		} else if (!facturacionAnual.equals(other.facturacionAnual))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroEmpleados != other.numeroEmpleados)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", domicilio=" + domicilio + ", facturacionAnual=" + facturacionAnual
				+ ", nombre=" + nombre + ", numeroEmpleados=" + numeroEmpleados + "]";
	}

}
