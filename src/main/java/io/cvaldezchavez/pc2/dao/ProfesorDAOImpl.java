package io.cvaldezchavez.pc2.dao;

import java.util.ArrayList;
import java.util.List;

import io.cvaldezchavez.pc2.generic.GenericDAO;
import io.cvaldezchavez.pc2.model.Profesor;
import io.cvaldezchavez.pc2.service.FactoryService;

public class ProfesorDAOImpl implements GenericDAO<Profesor> {

	@Override
	public boolean insertEntity(Profesor param) {
		int ccurr = FactoryService.listProfesor.size();
		FactoryService.listProfesor.add(param);
		FactoryService.writeBuffered();
		int cnow = FactoryService.listProfesor.size();
		return (ccurr < cnow) ? true : false;
	}

	@Override
	public boolean updateEntity(Profesor param) {
		int index = -1;
		index = FactoryService.listProfesor.indexOf(param);
		System.out.println(index);
		if (index != -1)
		{
			FactoryService.listProfesor.set(index, param);
			FactoryService.writeBuffered();			
		}
		return (index != -1) ? true : false;
	}

	@Override
	public boolean deleteEntity(Profesor param) {
		boolean state = false; 
		state = FactoryService.listProfesor.removeIf(pr -> pr.getId() == param.getId());
		if (state) FactoryService.writeBuffered();
		return state;
	}

	@Override
	public Profesor getEntity(int id) {
		return FactoryService.listProfesor.stream()
					.filter(pr -> pr.getId() == id)
					.findFirst()
					.orElse(null);
	}

	@Override
	public List<Profesor> listEntity() {
		return new ArrayList<>(FactoryService.ReadDbBuffered());
	}

}
