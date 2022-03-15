package lab7_3;

import java.util.*;

public class Bloco implements Figura{
	String name;
	List <Figura> ls = new ArrayList<>();
	
	
	
	public Bloco(String str) {
		this.name = str;
		
	}

	
	public void add(Figura f) {
		ls.add(f);
		
		
	}
	

	@Override
	public String toString() {
		return "Window " + name;
	}


	public void draw(int nivel) {
		for(int i =0; i < nivel ; i++) {
			System.out.print("\t");
		}
		System.out.print(nivel + " -> " );
		System.out.println(this.toString());
		
		for(Figura f : ls) {
			f.draw(nivel + 1);
		}
	}


}
