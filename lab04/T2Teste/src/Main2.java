

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main2 {
	static ArrayList<Familia> Rua;

	public static void main(String[] args) {
		int min=10000;
		int max= 0;
		ArrayList<Familia> rua = null;
		Scanner sc = new Scanner(System.in);
		String input, fileName;


		while(true) {
			System.out.println("\nCommands available: Load, Map, Add, Remove, List, Lookup, Clear, Quit");
			System.out.println("Command:");
			input=sc.next().toLowerCase();
			switch(input) {
			case "quit":
				System.exit(0);
                break;
			case "load":
				System.out.println("Insert File Name:");
				fileName = sc.next();
				//System.out.println(x.cabe�alho());
				Load(fileName);
				for(Familia f : Rua) {
						if(f.familiares.get(0).getx1Location()<min) {min=f.familiares.get(0).getx1Location();};
						if(f.familiares.get(0).getx2Location()>max) {max=f.familiares.get(0).getx2Location();};
					}
				for(Familia fa : Rua) {
					fa.getinit(min);
				}
				break;
			case "map":
				if(Rua==null) {System.out.println("Sem Dados!");}
				else {map(min,max);}
				break;
			case "add":
				System.out.println("Indique o nome:");
				String n_membro=sc.next();
				System.out.println("Indique a localiza��o x1-x2:");
				String pos=sc.next();
				//String[] d_membro=n_membro.split(" ");
				//for(String x : d_membro) {System.out.println(x);}
				
				add(n_membro,pos);
				break;
			case "remove":
				String s=sc.next();
				remove(s);
				break;
			case "clear":
				Rua.clear();
				break;
			case "lookup":
				System.out.println("Indique o nome:");
				String name=sc.next();
				for(Familia fa: Rua) {
					if(fa.hasFamName(name)) {
						System.out.println(fa.getinformation());
					}
				}
				break;
			case "list":
				list(Rua);

				break;
			
			}	
		}
	}
		
		

	
	public static ArrayList<Familia> Load(String filename) {
		ArrayList<Membro> all=new ArrayList<Membro>();
		Rua=new ArrayList<Familia>();
		Boolean Flag;
		 try {
		      File myObj = new File(filename);
		      Scanner myReader = new Scanner(myObj);
		      myReader.nextLine();
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] pessoa=data.split(" ");
		        
		        Membro x= Membro.getInstance(pessoa[1],pessoa[0]);
		        if(x==null) {
		        	System.exit(0);
		        }
		        all.add(x);
		        //System.out.println(data);
		      }
		      for(Membro membro : all) {
		    	  Flag=true;
		    	  for(Familia fam :Rua) {
		    		 if(membro.compareLocation(fam.getMembro())) {
		    			 fam.addmembro(membro);
		    			 Flag=false;
		    			 break;
		    			 }
		    		 
		    		 }
		    	  if(Flag) {
	 			 	Rua.add(new Familia(membro));
		    	  }
		    	  }
 
		      
		   
		      
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 	//for(Familia x : Rua) {System.out.println(x);}
		 	return Rua;
		  }
	public static void map(int min, int max) {
		Comandos z = new Comandos(min,max);
		System.out.println(z.cabecalho());
		for(Familia x : Rua) {
			System.out.print(x);
			}
	 	
	}
	public static void add(String nome,String location) {
		Membro novo=Membro.getInstance(nome,location);
		    	  for(Familia fam :Rua) {
		    		  if(fam.familiares.contains(novo)) {
		    			  System.out.println("Erro Membro j� existe");
		    			  
		    		  }
		    		  else if (novo.compareLocation(fam.getMembro())) {
		    			 fam.addmembro(novo);
		    			 break;
		    			 
		    			 }
		    		  //else {
		    			  //Rua.add(new Familia(novo));
		    		  //}
		    		 
		    		 }
		    	 
		    	  }
	public static void list(ArrayList<Familia> rua) {
		Set<String> persons = new TreeSet<>();
		
		for(Familia fam : rua) {
			String[] members=fam.getmembers().split("\n");
			for(int i=0; i<members.length;i++) {
				persons.add(members[i]);
			}
	
		}
		for(String cs: persons) {
			System.out.println(cs);
		}
        }
		
	
	public static void remove(String name) {
		boolean flag = true;
		for(Familia f: Rua) {
			if(f.hasFamName(name)) {
				f.removeFamName(name);
				flag = false;
				break;
			}
		}
		if(flag) {
			System.out.printf("N�o existe familiar com o nome %s%n");
		}
	}
}


