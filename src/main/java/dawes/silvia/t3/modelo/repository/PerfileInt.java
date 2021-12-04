package dawes.silvia.t3.modelo.repository;

import dawes.silvia.t3.modelo.beans.Perfile;

public interface PerfileInt {
	
	int insertarPerfile(Perfile perfile);
	Perfile buscarPorId(int idPerfile);

}
