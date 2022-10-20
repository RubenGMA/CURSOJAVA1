package com.curso.bankweb.persistencia;

import java.util.List;


public interface GenericDAO<T> {
	public void add(T entidad);
	public T[] getAll();
	public T getByIndex(int index);
}
