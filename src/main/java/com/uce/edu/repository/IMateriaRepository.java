package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.repository.modelo.Matricula;

public interface IMateriaRepository {
	
	public void insertar(Materia materia);

	public Materia selectCodigo(String codigo);
	
	public void updateMateriaMatricula(Matricula matricula, String codigo);
}
