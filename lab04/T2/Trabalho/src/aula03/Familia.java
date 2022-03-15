package aula03;

import java.util.ArrayList;

public class Familia {
	private Membro membro;
	private int init;
	private static int numero_familia=0;
	private int numero;
	ArrayList<Membro> familiares= new ArrayList<Membro>();
	public Familia(Membro membro) {
		super();
		this.membro = membro;
		familiares.add(membro);
		numero_familia++;
		numero=numero_familia;
	}
	
	//

	public Membro getMembro() {
		return membro;
	}
	public boolean hasFamName(String name) {
		boolean flag = false;
		for (Membro m: familiares) {
			if(m.getName().equals(name)) {
				flag=true;
			}
		}
		return flag;
	}
	public void setMembro(Membro membro) {
		this.membro = membro;
	}
	
	public void addmembro(Membro m) {
		if(m.compareLocation(membro)) {
			familiares.add(m);
		}
	}
	public void removeFamName(String name) {
		for (Membro m: familiares) {
			if(m.getName().equals(name)) {
				familiares.remove(m);
				break;
			}
		}
	}
	public int getNumero_familia() {
		return numero;
	}
	
	public int getinit(int x) {
		init= x;
		return init;
	}
	public String getinformation() {
		StringBuilder str = new StringBuilder();
		str.append(membro.getLocation());
		str.append(" : ");
		for(Membro x: familiares) {
			str.append(x.getName());
			str.append(" ");
		}
		return str.toString();
		
		
	}
	public String getmembers() {
		StringBuilder str = new StringBuilder();
		for(Membro x: familiares) {
			str.append(x.getName());
			str.append(" ");
			str.append(x.getLocation());
			str.append("\n");
		}
		return str.toString();
	}


	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(Membro x : familiares) {
			String z="";
			if(x.getx1Location()!=init) {
				int d = x.getx1Location()-init;
				for(int i=0; i<d; i++) {
					z=z+"    ";
				
			}
				if(x.getx1Location()>=16) {z=z+"      ";}
			}
			x.toString();
			if(x.getName().length()<7) {
			str.append("     "+numero + "\t" + String.format("%12s", x.toString())+"  "+z+x.location_print()+"\n");
			}
			else {
				str.append("     "+numero + "\t" + String.format("%12s", x.toString())+"   "+z+x.location_print()+"\n");
			}
		}
		return str.toString();
	}
	

		
	
	
	

}
