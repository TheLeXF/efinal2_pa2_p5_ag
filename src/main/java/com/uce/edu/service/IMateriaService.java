package com.uce.edu.service;

import com.uce.edu.repository.modelo.Materia;

public interface IMateriaService {
	
	public void guardar(Materia materia);
	public Materia buscarCodigo(String codigo);
}
