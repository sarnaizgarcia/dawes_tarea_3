package dawes.silvia.t3.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dawes.silvia.t3.modelo.beans.Empleado;
import dawes.silvia.t3.modelo.beans.Perfile;
import dawes.silvia.t3.modelo.repository.EmpleadoInt;

@Controller
@RequestMapping("/login")
public class Login {
	
	@Autowired
	private EmpleadoInt iEmpleado;
	
	@GetMapping("")
	public String vistaLogin() {
		return "login";
	}
	
	@PostMapping("")
	public String login(Empleado empleado, RedirectAttributes attr, HttpSession sesion) {
		int idEmpleado = empleado.getIdEmpl();
		String emailEmpleado = empleado.getCorreo();
		String passwordEmpleado = empleado.getPassword();
		String redirect = "";
		
		Empleado existeEmpleado = iEmpleado.buscarPorEmail(emailEmpleado);
				
		if ((existeEmpleado != null) && (idEmpleado == existeEmpleado.getIdEmpl()) && (passwordEmpleado.equals(existeEmpleado.getPassword()))) {
			attr.addFlashAttribute("empleado", existeEmpleado);
			Perfile perfilEmpleado = existeEmpleado.getPerfile();
			sesion.setAttribute("empleado", existeEmpleado);
			if (perfilEmpleado.getIdPerfil() == 1)
				redirect = "redirect:/gestion";
			else if (perfilEmpleado.getIdPerfil() == 2)
				redirect = "redirect:/jefe";
		} else {
			redirect = "error-login";
		}
		
		return redirect;
	}
	
}
