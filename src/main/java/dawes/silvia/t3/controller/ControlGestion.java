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

import dawes.silvia.t3.modelo.beans.Empleado;
import dawes.silvia.t3.modelo.beans.Proyecto;
import dawes.silvia.t3.modelo.repository.ClienteInt;
import dawes.silvia.t3.modelo.repository.EmpleadoInt;
import dawes.silvia.t3.modelo.repository.ProyectoInt;

@Controller
@RequestMapping("/gestion")
public class ControlGestion {
	
	@Autowired
	private ProyectoInt listaProyectos;
	@Autowired
	private ClienteInt listaClientes;
	@Autowired
	private EmpleadoInt listaEmpleados;
	
	@GetMapping("")
	public String inicioGestion(Model model) {
		model.addAttribute("listaProyectos", listaProyectos.buscarTodos());
		return "inicio-gestion";
	}
	
	@GetMapping("/altaProyecto")
	public String vistaAltaProyecto(Model model) {
		model.addAttribute("listaClientes", listaClientes.buscarTodos());
		model.addAttribute("listaEmpleados", listaEmpleados.buscarTodos());
		return "alta-proyecto";
	}
	
	@PostMapping("/altaProyecto")
	public String altaProyecto(Model model, Proyecto nuevoProyecto) {
		Proyecto proyecto = new Proyecto();
		proyecto.setIdProyecto(nuevoProyecto.getIdProyecto());
		proyecto.setDescripcion(nuevoProyecto.getDescripcion());
		proyecto.setCliente(nuevoProyecto.getCliente());
		proyecto.setEstado(nuevoProyecto.getEstado());
		proyecto.setJefeProyecto(nuevoProyecto.getJefeProyecto());
		listaProyectos.insertarProyecto(proyecto);
		System.out.println(proyecto);

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
