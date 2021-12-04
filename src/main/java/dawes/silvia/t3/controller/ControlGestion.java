package dawes.silvia.t3.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
