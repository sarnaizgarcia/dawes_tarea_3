package dawes.silvia.t3.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	public String inicioGestion(HttpSession sesion, Model model) {
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
		nuevoProyecto.getJefeProyecto();
		listaProyectos.insertarProyecto(nuevoProyecto);
		return "redirect:/gestion";
	}

	@GetMapping("/terminarProyecto/{id}")
	public String vistaFinalizarProyecto(@PathVariable("id") String idProyecto, Model model) {
		Proyecto proyectoAFinalizar = listaProyectos.buscarPorId(idProyecto);
		model.addAttribute("proyectoAFinalizar", proyectoAFinalizar);
		return "finalizar-proyecto";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		webDataBinder.registerCustomEditor(Date.class, 
				new CustomDateEditor(sdf, false));
	}
	
	@PostMapping("/terminarProyecto/{id}")
	public String finalizarProyecto(Proyecto proyecto, @PathVariable("id") String idProyecto,
			@DateTimeFormat(pattern="yyyy/MM/dd") Date endTime) {
		Proyecto proyectoAFinalizar = listaProyectos.buscarPorId(idProyecto);
		proyectoAFinalizar.setEstado("Finalizado");
		return "redirect:/";
	}
	
}
