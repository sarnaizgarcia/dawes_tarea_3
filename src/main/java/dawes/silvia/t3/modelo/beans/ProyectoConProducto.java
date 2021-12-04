package dawes.silvia.t3.modelo.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProyectoConProducto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int numeroOrden;
	private int cantidad;
	private BigDecimal precioAsignado;
	private Producto producto;
	private Proyecto proyecto;

	public ProyectoConProducto() {
	}

	public ProyectoConProducto(int numeroOrden, int cantidad, BigDecimal precioAsignado, Producto producto,
			Proyecto proyecto) {
		super();
		this.numeroOrden = numeroOrden;
		this.cantidad = cantidad;
		this.precioAsignado = precioAsignado;
		this.producto = producto;
		this.proyecto = proyecto;
	}

	public int getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioAsignado() {
		return this.precioAsignado;
	}

	public void setPrecioAsignado(BigDecimal precioAsignado) {
		this.precioAsignado = precioAsignado;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
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
		result = prime * result + cantidad;
		result = prime * result + numeroOrden;
		result = prime * result + ((precioAsignado == null) ? 0 : precioAsignado.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + ((proyecto == null) ? 0 : proyecto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProyectoConProducto))
			return false;
		ProyectoConProducto other = (ProyectoConProducto) obj;
		if (cantidad != other.cantidad)
			return false;
		if (numeroOrden != other.numeroOrden)
			return false;
		if (precioAsignado == null) {
			if (other.precioAsignado != null)
				return false;
		} else if (!precioAsignado.equals(other.precioAsignado))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
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
		return "ProyectoConProducto [numeroOrden=" + numeroOrden + ", cantidad=" + cantidad + ", precioAsignado="
				+ precioAsignado + ", producto=" + producto + ", proyecto=" + proyecto + "]";
	}

}
