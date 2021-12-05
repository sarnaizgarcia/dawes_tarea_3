package dawes.silvia.t3.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dawes.silvia.t3.modelo.beans.Cliente;
import dawes.silvia.t3.modelo.beans.Empleado;
import dawes.silvia.t3.modelo.beans.Proyecto;
import dawes.silvia.t3.modelo.repository.ClienteInt;
import dawes.silvia.t3.modelo.repository.EmpleadoInt;
import dawes.silvia.t3.modelo.repository.ProyectoInt;

@Controller
@RequestMapping("/gestion")
public class ControlGestion {
	// Pasamos la referencia de implementaciones a variables.
	@Autowired
	private ProyectoInt listaProyectos;
	@Autowired
	private ClienteInt listaClientes;
	@Autowired
	private EmpleadoInt listaEmpleados;
	
	/**
	 * Se recoge el listado de los proyectos en un atributo para mostrarlos en la vista. 
	 * @param model
	 */
	@GetMapping("")
	public String inicioGestion(Model model) {
		model.addAttribute("listaProyectos", listaProyectos.buscarTodos());
		return "inicio-gestion";
	}
	
	/**
	 * Se recogen los listados de clientes y empleados para utilizarlos en la vista
	 * en la que se da dan de alta los proyectos.
	 * @param model
	 */
	@GetMapping("/altaProyecto")
	public String vistaAltaProyecto(Model model) {
		model.addAttribute("listaClientes", listaClientes.buscarTodos());
		model.addAttribute("listaEmpleados", listaEmpleados.buscarTodos());
		return "alta-proyecto";
	}
	
	/**
	 * Se crea un nuevo poyecto y buscamos el cliente y jefe de proyecto creado con el formulario.
	 * Se utilizan los atributos de ese proyecto para 
	 * @param model
	 * @param nuevoProyecto
	 */
	@PostMapping("/altaProyecto")
	public String altaProyecto(Model model, Proyecto nuevoProyecto) {
//		Proyecto proyecto = new Proyecto();
		Cliente cliente = listaClientes.buscarPorCif(nuevoProyecto.getCliente().getCif());
		Empleado jefeProyecto = listaEmpleados.buscarPorId(nuevoProyecto.getJefeProyecto().getIdEmpl());
//
//		proyecto.setIdProyecto(nuevoProyecto.getIdProyecto());
//		proyecto.setDescripcion(nuevoProyecto.getDescripcion());
//		proyecto.setEstado(nuevoProyecto.getEstado());
//		proyecto.setCliente(cliente);
//		proyecto.setJefeProyecto(jefeProyecto);

		
		nuevoProyecto.setCliente(cliente);
		nuevoProyecto.setJefeProyecto(jefeProyecto);

		listaProyectos.insertarProyecto(nuevoProyecto);

		return "redirect:/gestion";
	}

	@GetMapping("/terminarProyecto/{id}")
	public String vistaFinalizarProyecto(@PathVariable("id") String idProyecto, Model model) {
		Proyecto proyectoAFinalizar = listaProyectos.buscarPorId(idProyecto);
		model.addAttribute("proyectoAFinalizar", proyectoAFinalizar);
		return "finalizar-proyecto";
	}
	
	@PostMapping("/terminarProyecto/{id}")
	public String terminarProyecto(Model model, Proyecto proyecto, @PathVariable("id") String idProyecto) {
		Proyecto proyectoAFinalizar = listaProyectos.buscarPorId(idProyecto);
		proyectoAFinalizar.setEstado("Finalizado");
		proyectoAFinalizar.setFechaFinReal(proyecto.getFechaFinReal());
		proyectoAFinalizar.setCosteReal(proyecto.getCosteReal());

		return "redirect:/gestion";
	}
	
}
