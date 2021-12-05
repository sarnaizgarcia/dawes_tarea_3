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
	// Se pasan la referencia de las implementaciones del modelo a variables.
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
	 * Se crea un nuevo poyecto.
	 * Con los parámetos del formulario, se buscan el cliente y el jefe de proyecto.
	 * Se añaden esos dos atributos al nuevo proyecto y se incluye en la lista de proyectos.
	 * @param model
	 * @param nuevoProyecto
	 */
	@PostMapping("/altaProyecto")
	public String altaProyecto(Model model, Proyecto nuevoProyecto) {
		Cliente cliente = listaClientes.buscarPorCif(nuevoProyecto.getCliente().getCif());
		Empleado jefeProyecto = listaEmpleados.buscarPorId(nuevoProyecto.getJefeProyecto().getIdEmpl());

		nuevoProyecto.setCliente(cliente);
		nuevoProyecto.setJefeProyecto(jefeProyecto);

		listaProyectos.insertarProyecto(nuevoProyecto);

		return "redirect:/gestion";
	}

	/**
	 * Se busca el proyecto que se quiere finalizar y se recoge en un atributo.
	 * @param idProyecto
	 * @param model
	 */
	@GetMapping("/terminarProyecto/{id}")
	public String vistaFinalizarProyecto(@PathVariable("id") String idProyecto, Model model) {
		Proyecto proyectoAFinalizar = listaProyectos.buscarPorId(idProyecto);
		model.addAttribute("proyectoAFinalizar", proyectoAFinalizar);
		return "finalizar-proyecto";
	}
	
	/**
	 * Con el parámeto del id del proyecto, se busca el proyecto que se quiere finalizar.
	 * Se pone el estado del proyecto a finalizado, se asignan los valores de la fecha de fin real
	 * y el coste real.
	 * @param model
	 * @param proyecto
	 * @param idProyecto
	 */
	@PostMapping("/terminarProyecto/{id}")
	public String terminarProyecto(Model model, Proyecto proyecto, @PathVariable("id") String idProyecto) {
		Proyecto proyectoAFinalizar = listaProyectos.buscarPorId(idProyecto);
		proyectoAFinalizar.setEstado("Finalizado");
		proyectoAFinalizar.setFechaFinReal(proyecto.getFechaFinReal());
		proyectoAFinalizar.setCosteReal(proyecto.getCosteReal());

		return "redirect:/gestion";
	}
	
}
