package Pingpong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class HighScores<E> {
	private DefaultListModel<E> lista;
	
	private int size = 10;
	
	public HighScores() {
		lista = new DefaultListModel<E>();
	}
	
	public void add(E element) {
		if(lista.size() == size) {
			lista.remove(size - 1);
		} 
		
		lista.addElement(element);
	}
	
	public void remove(int element) {
		lista.remove(element);
	}
	
	public void sort(DefaultListModel Lista) {
		//som iterator lista, "kopierar av org listan för att hantera sortering"
		ArrayList<String>  tempLista = new ArrayList<>();
		for (int i = 0; i < Lista.size(); i++) {
			tempLista.add((String) Lista.get(i));
		}
		//lägger in största talen först
		Collections.sort(tempLista, Collections.reverseOrder());
		//tömmer och lägger in de sorterade talen i listan i rätt ordning
		Lista.removeAllElements();
		for (String s : tempLista) {
			Lista.addElement(s);
		}
	}

	
	public void isFull() {
		int listaStorlek = lista.size();
		if(listaStorlek == size) {
			
		}
	}
	
	public void isEmpy() {
		int listaStorlek = lista.size();
		if(listaStorlek == 0) {
			
		}
	}
	
	public DefaultListModel<E> getList() {
		return lista;
	}
}
