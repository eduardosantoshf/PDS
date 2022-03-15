package lab7_3;

public class Quadrado implements Figura {
	String name;

	
	public Quadrado(String str) {
		this.name = str;
	}

	@Override
	public String toString() {
		return "Quadrado "  + name;
	}
	
	public void draw(int nivel) {
		for(int i =0; i < nivel ; i++) {
			System.out.print("\t");
		}		System.out.print(nivel + " -> " );
		System.out.println(this.toString());
		
	}


}
