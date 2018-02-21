package io.cvaldezchavez.pc2.generic;

import java.util.List;

public interface GenericDAO<T> {

	public boolean insertEntity(T param);
	
	public boolean updateEntity(T param);
	
	public boolean deleteEntity(T param);
	
	public T getEntity(int id);
	
	public List<T> listEntity();
	
}
