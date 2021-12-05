package dawes.silvia.t3.modelo.repository;

import java.util.List;

import dawes.silvia.t3.modelo.beans.ProyectoConProducto;

public interface ProyectoConProductoInt {

	int insertarProyectoConProducto(ProyectoConProducto proyectoConProducto);
	ProyectoConProducto buscarProyectoConProducto(int idProyectoConProducto);
	List<ProyectoConProducto> buscarPorProyecto(String idProyecto);


}
