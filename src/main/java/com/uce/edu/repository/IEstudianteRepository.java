package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Matricula;

public interface IEstudianteRepository {

	public void insertar(Estudiante estudiante);

	public Estudiante selectCedula(String cedula);
	
	public void updateEstudianteMatricula(Matricula matricula, String cedula);
}
