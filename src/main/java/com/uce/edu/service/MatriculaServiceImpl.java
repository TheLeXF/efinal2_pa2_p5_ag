package com.uce.edu.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.IMateriaRepository;
import com.uce.edu.repository.IMatriculaRespository;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.repository.modelo.Matricula;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class MatriculaServiceImpl implements IMatriculaService{
	@Autowired
	private IMatriculaRespository matriculaRespository;
	@Autowired
	private  IMateriaRepository materiaRepository;
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar( Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRespository.insertar(matricula);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Matricula buscarPorid(Integer id) {
		// TODO Auto-generated method stub
		return this.matriculaRespository.select(id);
	}
	@Transactional(value = TxType.REQUIRES_NEW)
	@Async
	public void insertarEstudianteMateria(String cedula, String codigo) {
		Estudiante e1=this.estudianteRepository.selectCedula(cedula);
		Materia m1 = this.materiaRepository.selectCodigo(codigo);
		e1.getCedula();
		m1.getCodigo();
		
		Matricula mTemp= new Matricula();
		
		mTemp.setEstudiante(e1);
		mTemp.setMateria(m1);
		mTemp.setFechaRegistro(LocalDateTime.now());
		mTemp.setNombreHilo(Thread.currentThread().getName());
		
		this.guardar(mTemp);
	}
	

}
