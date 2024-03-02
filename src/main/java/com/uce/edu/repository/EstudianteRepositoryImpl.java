package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Estudiante selectCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery=this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula=:cedula",Estudiante.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void updateEstudianteMatricula(Matricula matricula, String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante>myQuery= this.entityManager.createQuery("UPDATE Estudiante e SET e.matriculas=:matricula WHERE e.cedula = :cedula",Estudiante.class);
		myQuery.setParameter("matricula", matricula);
		myQuery.setParameter("cedula", cedula);
		myQuery.executeUpdate();
	}

	
}
