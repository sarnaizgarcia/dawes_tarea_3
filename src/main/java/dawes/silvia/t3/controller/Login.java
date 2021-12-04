package dawes.silvia.t3.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dawes.silvia.t3.modelo.beans.Empleado;
import dawes.silvia.t3.modelo.repository.ClienteInt;
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
	public String login(Empleado empleado, HttpSession sesion) {
		int idEmpleado = empleado.getIdEmpl();
		String emailEmpleado = empleado.getCorreo();
		String passwordEmpleado = empleado.getPassword();
		
		Empleado existeEmpleado = iEmpleado.buscarPorEmail(emailEmpleado);
		
		System.out.println(existeEmpleado);
		System.out.println(idEmpleado == existeEmpleado.getIdEmpl());
		System.out.println(passwordEmpleado.equals(existeEmpleado.getPassword()));
		
		if ((existeEmpleado != null) && (idEmpleado == existeEmpleado.getIdEmpl()) && (passwordEmpleado.equals(existeEmpleado.getPassword()))) {
			sesion.setAttribute("empleado", existeEmpleado);
			return "redirect:/inicio";
		} else
			return "error-login";
	}
	
}
