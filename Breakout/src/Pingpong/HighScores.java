package Pingpong;

import javax.swing.DefaultListModel;

public class HighScores<E> {
	private DefaultListModel<E> lista;
	
	int size = 10;
	
	public HighScores() {
		lista = new DefaultListModel<E>();
	}
	
	public void add(E element) {
		if(lista.size() == size) {
			lista.remove(size);
		} else {
			lista.addElement(element);
		}
	}
	
	public void remove(int element) {
		lista.remove(element);
	}
	
	public void sort() {
		for(int i = 0; i < lista.size() -1 ; i++) {
			for(int j = 0; j < i - 1; j++) {
				/*
				if(lista[j] > lista[j+1]) {
					int temp;
				}*/
			}
		}
	}
	public void isFull() {
		int listaStorlek = lista.size();
		if(listaStorlek == size) {
			
		}
	}
	
	public void isEmpy() {
		int listaStorlek = lista.size();
		if(listaStorlek == size) {
			
		}
	}
	
	public DefaultListModel<E> getList() {
		return lista;
	}
}
