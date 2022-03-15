
public class Membro{
	private String location;
	private String name;
	public static Membro getInstance(String n, String l) {
		Membro m=null;
		n=n.trim();
		String[] x = l.split("-");
		int x1=Integer.parseInt(x[0]);
		int x2=Integer.parseInt(x[1]);
		if(x1<0) {
			System.out.println("Primeiro valor de localiza��o inv�lido");
			return m;
		}
		if(x1>x2) {
			System.out.println("Primeiro valor de localiza��o maior que o segundo");
			return m;
		}
		if(!(Character.isAlphabetic(n.charAt(0)))) {
			System.out.println("Primeiro carater n�o � uma letra");
			return m;
		}
		for(int i=1;i<n.length()-1;i++) {
			if(!(Character.isAlphabetic(n.charAt(i)) || 
					Character.isDigit(n.charAt(i)) ||
					n.substring(i, i+1).matches("[_.@]"))) {
				System.out.println(n);
				System.out.println(n.substring(i, i+1));
				System.out.println("Contem carater ilegal");
				return m;
			}
		}
		if(!(Character.isAlphabetic(n.charAt(n.length()-1)) || 
				Character.isDigit(n.charAt(n.length()-1)))){
			System.out.println("Contem carater ilegal");
			return m;
		}
		m=new Membro(n,l);
		return m;
	}
	private Membro(String name,String location) {
		this.location = location;
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public int getx1Location() {
		String[] x = location.split("-");
		int x1=Integer.parseInt(x[0]);
		return x1;
	}
	public int getx2Location() {
		String[] x = location.split("-");
		int x2=Integer.parseInt(x[1]);
		return x2;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean compareLocation(Membro m) {
		
		return location.equals(m.getLocation());

	}


	public String location_print() {
		StringBuilder str = new StringBuilder();
		String[] x = location.split("-");
		int x1=Integer.parseInt(x[0]);
		int x2=Integer.parseInt(x[1]);
		int dif=x2-x1;
		
		for(int i =0; i<=dif;i++) {
			if(name.length()<7) {
				if(i>=10-x1) { 
					str.append(" X   ");
					}
				else {
					str.append("X   ");
					}
			}
			else {
				if(i>=10-x1) { 
					str.append(" X   ");
					}
				else {
					str.append("X   ");
					}
			}
			
		}
		
		return str.toString();
		
	}
	@Override
	public String toString() {
		return name;
	}
	
	


}
