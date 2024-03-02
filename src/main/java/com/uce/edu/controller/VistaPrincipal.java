package com.uce.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IMateriaService;
import com.uce.edu.service.IMatriculaService;

//URL: http://localhost:8080/main/principal
@Controller
@RequestMapping("/main")
public class VistaPrincipal {
	
	@Autowired
	private IMateriaService materiaService;
	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IMatriculaService matriculaService;
	
	
	@PostMapping("/estudiante")
	public String guardarEstudiante (Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
		return "insertarEstudiante";
	}
	
	@PostMapping("/materia")
	public String guardarMateria (Materia materia) {
		this.materiaService.guardar(materia);
		return "insertarMateria";
	}
	
	@GetMapping("/principal")
	public String vistaPrincipal() {
		return "vistaPrincipal";
	}
	
	@PostMapping("/matricula")
	public String guardarMateria(Matricula matricula) {
		//this.matriculaService.guardar(matricula);
		return "insertarMatricula";
	}
}
