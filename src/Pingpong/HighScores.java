package Pingpong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	
	public void add(int element, String ign) {
		//fixa så att ifall sista poänget i lista är större än element så ska den inte tas bort
				for(int i = 0; i < lista.size();i++) {
					if(lista.size() == size) {
						lista.remove(size - 1);
					}
				} 
		//pga att sortering är skum så fuska ja å la bara till 0:or, läs rapport
		if(element < 10) {
			lista.addElement((E) (ign + " 00" + element));
		} else if(element < 100) {
			lista.addElement((E) (ign + " 0" + element));
		} else {
			lista.addElement((E) (ign + " " + element));
		}
	}
	
	public void remove(int element) {
		lista.remove(element);
	}
	
	public void sort(DefaultListModel Lista) {
		//som iterator lista, "kopierar" av org listan för att hantera sortering
        ArrayList<String> tempLista = new ArrayList<>();
        for (int i = 0; i < Lista.size(); i++) {
            tempLista.add((String) Lista.getElementAt(i));
        }
        //sorterar in lista med en comporator som tar och sorterar så störst tal är först(skiter nu i namn pga comparator)
        Collections.sort(tempLista, new Comparator<String>() {
            @Override
            //delar upp 2 strings i taget och jämför endast poäng, letar efter mellanslaget mellan namn å poäng
            public int compare(String poäng1, String poäng2) {
            	//delar upp, och gör om string poäng till int poäng för att kunna jämföra
                int score1 = Integer.parseInt(poäng1.substring(poäng1.lastIndexOf(" ") + 1));
                int score2 = Integer.parseInt(poäng2.substring(poäng2.lastIndexOf(" ") + 1));
                return Integer.compare(score2, score1);
            }
        });
        //tömmer och lägger in de sorterade talen i listan i rätt ordning
        Lista.clear();
        for (String entry : tempLista) {
            Lista.addElement(entry);
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
