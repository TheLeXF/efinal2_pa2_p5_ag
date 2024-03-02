package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Matricula;

public interface IMatriculaRespository {

	public void insertar(Matricula matricula);

	public Matricula select(Integer id);
	
	
}
