package io.cvaldezchavez.pc2.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import io.cvaldezchavez.pc2.model.Profesor;

public class FactoryService {
	
	private static final String db = "dbprofesor.txt";
	public static final List<Profesor> listProfesor = new ArrayList<>();
	
	private FactoryService()
	{
	}
	
	public static List<Profesor> ReadDBClassic()
	{
		listProfesor.clear();
		try(
				BufferedReader br = new BufferedReader(
						new InputStreamReader(new FileInputStream(db)));
				) 
		{
			String line;
			Profesor pr;
			while((line = br.readLine()) != null)
			{
				Object[] oline = line.split("\\,");
				pr = new Profesor();
				pr.setId(Integer.parseInt(oline[0].toString()));
				pr.setFirstName(oline[1].toString());
				pr.setLastName(oline[2].toString());
				pr.setSalary(Double.parseDouble(oline[3].toString()));
				pr.setAge(Integer.parseInt(oline[4].toString()));
				listProfesor.add(pr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listProfesor;
	}
	
	public static List<Profesor> ReadDbBuffered()
	{
		listProfesor.clear();
		try (BufferedReader br = Files.newBufferedReader(Paths.get(db))) {
			long items = br.lines()
				.map(s -> s.split(","))
				.filter(oa -> oa.length > 1)
				.peek(a -> System.out.println(a.length))
				.map(as -> listProfesor.add(new Profesor(Integer.parseInt(as[0].toString()), as[1], as[2], Double.parseDouble(as[3].toString()), Integer.parseInt(as[4].toString()))))
				.count();
			System.out.println("Count lines " + items);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listProfesor;
	}
	
	public static void writeBuffered()
	{
		try (BufferedWriter wt = Files.newBufferedWriter(Paths.get(db))) {
			listProfesor.stream()
				.map(pr -> pr.toWriting())
				.forEach(s -> { try {
					wt.write(s);
				} catch (IOException e) {
					e.printStackTrace();
				}});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
