package lab8_2;

import java.util.ArrayList;

public class Parking {
	
	 private static ArrayList<Person> peopleAllowed = new ArrayList<>();

	    public static boolean allow(Person p){
	        if(peopleAllowed.contains(p)){
	            return false;
	        }else{
	            peopleAllowed.add(p);
	            return true;
	        }
	    }

	    public ArrayList<Person> getRecords(){
	        return peopleAllowed;
	    }

}
