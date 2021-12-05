package dawes.silvia.t3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dawes.silvia.t3.modelo.beans.Proyecto;
import dawes.silvia.t3.modelo.beans.ProyectoConEmpleado;
import dawes.silvia.t3.modelo.beans.ProyectoConProducto;
import dawes.silvia.t3.modelo.repository.ProyectoConEmpleadoInt;
import dawes.silvia.t3.modelo.repository.ProyectoConProductoInt;
import dawes.silvia.t3.modelo.repository.ProyectoInt;

@Controller
@RequestMapping("/jefe")
public class JefeProyecto {
	// Se pasan la referencia de las implementaciones del modelo a variables.
	@Autowired
	ProyectoInt listaProyectos;
	@Autowired
	ProyectoConEmpleadoInt listaProyConEmpleado;
	@Autowired
	ProyectoConProductoInt listaProyConProducto;

	/**
	 * Se recogen todos los proyectos para mostrarlos en la vista.
	 * @param model
	 */
	@GetMapping("")
	public String inicioJefe(Model model) {
		model.addAttribute("listaProyectos", listaProyectos.buscarTodos());
		return "inicio-jefe";
	}
	
	/**
	 * Con el parámetro del id, se busca el proyecto del que se quieren saber los detalles
	 * y se buscan sus empleados y productos.
	 * Se añaden esos tres elemento como atributos para mostrarlos en la vista.
	 * @param idProyecto
	 * @param model
	 */
	@GetMapping("/verDetalle/{id}")
	public String verDetalle(@PathVariable("id") String idProyecto, Model model) {
		Proyecto proyectoEnDetalle = listaProyectos.buscarPorId(idProyecto);
		List<ProyectoConEmpleado> empleadosProyecto= listaProyConEmpleado.buscarPorProyecto(idProyecto);
		List<ProyectoConProducto> productosProyecto = listaProyConProducto.buscarPorProyecto(idProyecto);
		
		model.addAttribute("proyectoAVer", proyectoEnDetalle);
		model.addAttribute("empleadosProyecto", empleadosProyecto);
		model.addAttribute("productosProyecto", productosProyecto);
		
		return "detalle-proyecto";
	}
}
