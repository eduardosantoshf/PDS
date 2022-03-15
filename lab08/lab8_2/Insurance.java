package lab8_2;

import java.util.ArrayList;

public class Insurance {
	
	 private static ArrayList<Person> registos = new ArrayList<>();

	    public static boolean regist(Person p){
	        if(registos.contains(p)){
	            return false;
	        }else{
	            registos.add(p);
	            return true;
	        }
	    }

	    public ArrayList<Person> getRecords(){
	        return registos;
	    }

}
