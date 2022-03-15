package lab7_3;

public class Rectangulo implements Figura{
	
	String name;

	
	public Rectangulo(String str) {
		this.name = str;
	}

	@Override
	public String toString() {
		return "Rectangulo " + name;
	}

	@Override
	public void draw(int nivel) {
		for(int i =0; i < nivel ; i++) {
			System.out.print("\t");
		}
		System.out.print(nivel + " -> " );
		System.out.println(this.toString());
		
	}

	
	

}
