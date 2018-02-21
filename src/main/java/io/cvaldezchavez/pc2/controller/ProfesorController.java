package io.cvaldezchavez.pc2.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import io.cvaldezchavez.pc2.dao.ProfesorDAOImpl;
import io.cvaldezchavez.pc2.exceptions.InvalidDataProfesorException;
import io.cvaldezchavez.pc2.model.Profesor;
import io.cvaldezchavez.pc2.service.FactoryService;

public class ProfesorController {
	
	public boolean insertProfesor(Profesor profesor) throws InvalidDataProfesorException
	{
		if(profesor.getAge() < 18) {
			throw new InvalidDataProfesorException("El Profesor no tiene la edad permitida!");			
		}
		return new ProfesorDAOImpl().insertEntity(profesor); 
	}
	
	public boolean updateProfesor(Profesor profesor)
	{
		return new ProfesorDAOImpl().updateEntity(profesor); 
	}
	
	public boolean deleteProfesor(Profesor profesor)
	{
		return new ProfesorDAOImpl().deleteEntity(profesor); 
	}
	
	public Profesor getProfesor(int id)
	{
		return new ProfesorDAOImpl().getEntity(id); 
	}
	
	public List<Profesor> listProfesor()
	{
		return new ProfesorDAOImpl().listEntity(); 
	}
	
	public Profesor getFirstElement()
	{
		return FactoryService.listProfesor.stream()
				.findFirst().orElse(null);
	}
	
	public boolean salaryTodosMayor2500()
	{
		int filter = (int) FactoryService.listProfesor.stream()
			.filter(pr -> pr.getSalary() > 2500)
			.count();
		return (FactoryService.listProfesor.size() == filter) ? true : false;
	}
	
	public List<Profesor> sueldoMayoryEdadMenoryApellidoNOA()
	{
		return FactoryService.listProfesor.stream()
					.filter(pr -> pr.getSalary() > 1500)
					.filter(pr -> pr.getAge() < 40)
					.filter(pr -> !String.valueOf(pr.getLastName().charAt(0)).equals("A") )
					.collect(Collectors.toList());
	}
	
	public List<String> sueldoBruto()
	{
		return FactoryService.listProfesor.stream()
					.map(s -> s.toSalaryBruto() + "\t" + (s.getSalary() * 15) + "\n")
					.collect(Collectors.toList());
	}
	
	public double sueldoPromedio()
	{
		return FactoryService.listProfesor.stream()
					.filter(pr -> pr.getAge() > 40)
					.flatMapToDouble(sa -> DoubleStream.of(sa.getSalary()))
					.average()
					.orElse(0);
	}

}
