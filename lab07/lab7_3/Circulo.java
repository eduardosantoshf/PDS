package lab7_3;

public class Circulo implements Figura{
	
	String name;

	
	public Circulo(String str) {
		this.name = str;
	}

	@Override
	public String toString() {
		return "Circulo " + name;
	}
	
	public void draw(int nivel) {
		for(int i =0; i < nivel ; i++) {
			System.out.print("\t");
		}
		System.out.print(nivel + " -> ");
		System.out.println(this.toString());
	
		
	}




}
