package dawes.silvia.t3.modelo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dawes.silvia.t3.modelo.beans.Producto;

@Repository
public class ProductoImpl implements ProductoInt {
	
	private List<Producto> listaProductos;

	public ProductoImpl() {
		listaProductos = new ArrayList<Producto>();
		cargarDatos();
	}

	@Override
	public int insertarProducto(Producto producto) {
		if (listaProductos.contains(producto))
			return 0;
		else
			return listaProductos.add(producto) ? 1 : 0;
	}

	@Override
	public Producto buscarPorId(int idProducto) {
		Producto producto = listaProductos.stream()
				.filter(ele -> ele.getIdProducto() == idProducto)
				.findAny()
				.orElse(null);
		
		return producto;
	}

	@Override
	public List<Producto> buscarTodos() {
		return listaProductos;
	}
	
	private void cargarDatos() {

		Producto producto1 = new Producto(1, "Producto1",
				"Producto1 tralará", new BigDecimal(2000), 45);
		Producto producto2 = new Producto(2, "Producto2",
				"Producto2 tralará", new BigDecimal(3000), 50);
		Producto producto3 = new Producto(3, "Producto3",
				"Producto3 tralará", new BigDecimal(1500), 30);
		Producto producto4 = new Producto(4, "Producto4",
				"Producto4 tralará", new BigDecimal(1000), 70);
		Producto producto5 = new Producto(5, "Producto5",
				"Producto5 tralará", new BigDecimal(8000), 20);
		
		listaProductos.add(producto1);
		listaProductos.add(producto2);
		listaProductos.add(producto3);
		listaProductos.add(producto4);
		listaProductos.add(producto5);
	}

}
