package dawes.silvia.t3.modelo.repository;

import dawes.silvia.t3.modelo.beans.Factura;

public interface FacturaInt {
	
	int insertarFactura(Factura factura);
	Factura buscarFacturaPorId(String idFactura);

}
