package dawes.silvia.t3.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dawes.silvia.t3.modelo.beans.Empleado;
import dawes.silvia.t3.modelo.beans.Proyecto;
import dawes.silvia.t3.modelo.repository.ProyectoInt;

@Controller
@RequestMapping("/gestion")
public class ControlGestion {
	
	@Autowired
	private ProyectoInt listaProyectos;
	
	@GetMapping("")
	public String inicioGestion(HttpSession sesion, Model model) {
//		Empleado empleado = (Empleado) sesion.getAttribute("empleado");
		model.addAttribute("listaProyectos", listaProyectos.buscarTodos());

		return "inicio-gestion";
	}

}
