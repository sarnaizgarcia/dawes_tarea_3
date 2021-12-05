package dawes.silvia.t3.modelo.repository;

import java.util.List;

import dawes.silvia.t3.modelo.beans.Producto;

public interface ProductoInt {
	
	int insertarProducto(Producto producto);
	Producto buscarPorId(int idProducto);
	List<Producto> buscarTodos();


}
