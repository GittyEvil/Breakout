package Pingpong;

import javax.swing.DefaultListModel;

public class LatestRuns<E> {

	private DefaultListModel<E> lista;
	
	
	public LatestRuns() {
		lista = new DefaultListModel<E>();
	}
	
	public void add(E element) {
		lista.add(0, element);
	}
	
	public void remove(int element) {
		lista.remove(element);
	}
	public DefaultListModel<E> getList() {
		return lista;
	}
}
