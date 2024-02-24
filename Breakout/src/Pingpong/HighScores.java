package Pingpong;

import javax.swing.DefaultListModel;

public class HighScores<E> {
	private DefaultListModel<E> lista;
	
	public HighScores() {
		lista = new DefaultListModel<E>();
	}
	
	public void add(E element) {
		lista.addElement(element);
	}
	
	public void remove(int element) {
		lista.remove(element);
	}
	
	public DefaultListModel<E> getList() {
		return lista;
	}
}
