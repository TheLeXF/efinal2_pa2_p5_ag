package com.uce.edu.service;

import com.uce.edu.repository.modelo.Matricula;

public interface IMatriculaService {
	
	public void guardar(Matricula matricula);

	public Matricula buscarPorid(Integer id);
	
	
	
}
