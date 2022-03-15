
public class Comandos {
	private Membro membro;
	private int  first_position;
	private int last_position;
	
	
	public Comandos(int first_position, int last_position) {
		super();
		this.first_position = first_position;
		this.last_position = last_position;
	}
	

	public String cabecalho(){
		StringBuilder str = new StringBuilder();
		str.append("FAMILY\t\t");
		
		str.append("NAME  ");
		for(int i =first_position; i<=last_position;i++) {
			str.append(i+"   ");
		}
		return str.toString();
		
	
		
	}
	

}
