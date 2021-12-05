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
@RequestMapping("/logout")
public class Logout {
	
	/**
	 * Se elimina el usuario de la sesión y se invalida la sesión. 
	 * @param sesion
	 */
	@GetMapping("")
	public String vistaLogin(HttpSession sesion) {
		sesion.removeAttribute("usuario");
		sesion.invalidate();
		return "redirect:/login";
	}
		
}
