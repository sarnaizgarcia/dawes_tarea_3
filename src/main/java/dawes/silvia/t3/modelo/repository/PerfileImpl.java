package dawes.silvia.t3.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dawes.silvia.t3.modelo.beans.Perfile;

@Repository
public class PerfileImpl implements PerfileInt {
	
	private List<Perfile> listaPerfile;
	
	public PerfileImpl() {
		listaPerfile = new ArrayList<Perfile>();
		cargarDatos();
	}

	@Override
	public int insertarPerfile(Perfile perfile) {
		if (listaPerfile.contains(perfile))
			return 0;
		else
			return listaPerfile.add(perfile) ? 1 : 0;
	}

	private void cargarDatos() {
		Perfile perfile1 = new Perfile(1, "Control de Gestión");
		Perfile perfile2 = new Perfile(2, "Jefe de Proyecto");
		Perfile perfile3 = new Perfile(3, "Operativo");
		Perfile perfile4 = new Perfile(4, "Recursos Humanos");
		
		listaPerfile.add(perfile1);
		listaPerfile.add(perfile2);
		listaPerfile.add(perfile3);
		listaPerfile.add(perfile4);
	}

	@Override
	public Perfile buscarPorId(int idPerfile) {
		Perfile perfile = listaPerfile.stream()
				.filter(ele -> ele.getIdPerfil() == idPerfile)
				.findAny()
				.orElse(null);
		
		return perfile;
	}
}
