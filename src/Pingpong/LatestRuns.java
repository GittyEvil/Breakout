package Pingpong;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;

public class LatestRuns<E> {

	private DefaultListModel<E> lista;
	
	int size = 3;
	public LatestRuns() {
		lista = new DefaultListModel<E>();
	}
	
	public void add(E element) {
		if(lista.size() == size) {
			lista.remove(size - 1);
		}
		lista.add(0, element);
	}
	
	public void remove(int element) {
		lista.remove(element);
	}
	
	public void isFull() {
		int listaStorlek = lista.size();
		if(listaStorlek == size) {
			
		}
	}
	
	public void isEmpty() {
		int listaStorlek = lista.size();
		if(listaStorlek == 0) {
			
		}
	}
	
	public DefaultListModel<E> getList() {
		return lista;
	}
}
