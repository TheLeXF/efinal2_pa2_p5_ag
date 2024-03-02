package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IMateriaRepository;
import com.uce.edu.repository.modelo.Materia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class MateriaServiceImpl implements IMateriaService{

	
	@Autowired
	private IMateriaRepository materiaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.insertar(materia);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia buscarCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.materiaRepository.selectCodigo(codigo);
	}

}
