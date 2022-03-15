
import java.io.*;
import java.util.*;

public class StreetMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> street = new ArrayList<String>();
		TreeMap<String, ArrayList<String>> families = new TreeMap<String, ArrayList<String>>();
		Boolean quit = false;
		while (!quit) {
			System.out.print("Load, Map, Add, Remove, List, Lookup, Clear, Quit\nCommand: ");
		    String[] comm = in.nextLine().split(" ");
			switch (comm[0].toLowerCase()) {
			
		    case "load":
		    	street = new ArrayList<String>();
		    	LoadStreet(comm, street, families);
		    	continue;
		    	
		    case "map":
		    	MapStreet(families);
		    	continue;
		    	
		    case "add":
		    	AddStreet(comm, street, families);
		    	continue;
		    	
		    case "remove":
		    	RemoveStreet(comm, street, families);
		    	continue;
		    	
		    case "list":
		    	ListStreet(street);
		    	continue;
		    	
		    case "lookup":
		    	LookupStreet(comm, street, families);
		    	continue;
		    	
		    case "clear":
		    	street = new ArrayList<String>();
		    	families = new TreeMap<String, ArrayList<String>>();
		    	continue;
		    	
		    case "quit":
		    	quit = true;
		    	continue;
		    	
		    default:
		    	System.out.println("[ERROR] \""+comm[0]+"\" is not a command.");
		    }
		}
		in.close();
	}

	private static void LoadStreet(String[] comm, ArrayList<String> street, TreeMap<String, ArrayList<String>> families) {
		if (comm.length < 2) {
    		System.out.println("[ERROR] Wrong command format.");
    		return;
    	}
		File file = new File(comm[1]);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] Was not able to load file.");
			return;
		}
		
		// Add people to the street
		while (sc.hasNextLine()) {
			String tline = sc.nextLine();
			if (tline.contains(">")) continue;
			String[] line = tline.replace("-", " ").split(" ");
			
			// Verify the name follows the rules
			if (line.length != 3
					| !line[2].matches("[a-zA-Z0-9_.@]+") 
					| street.contains(line[2]+" "+line[0]+" "+line[1])
					| !line[2].matches("^[a-zA-Z].*[a-zA-Z0-9]$")
					| line[2].length() > 30
					| line[2].length() < 3)
			{sc.close(); System.out.println("[ERROR] File has an error."); return;}
			street.add(line[2]+" "+line[0]+" "+line[1]);
		}
		sc.close();;
		
		// Add people to their families
    	for (String key : street) {
    		String[] nload = key.split(" ");
    		String fkey = nload[1]+" "+nload[2];
    		if (!families.containsKey(fkey)) {
    			ArrayList<String> family = new ArrayList<String>();
    			family.add(nload[0]);
    			families.put(fkey, family);
    		} else {
    			families.get(fkey).add(nload[0]);
    		}
    	}
	}

	private static void MapStreet(TreeMap<String, ArrayList<String>> families) {
    	if (families.isEmpty()) {
    		System.out.println("[ERROR] Street doesn't have any elements.");
    		return;
    	}
    	int min = 31;
    	int max = -1;
    	int maxname = -1;
    	
    	// This is used to order the families
    	TreeMap<Integer, List<String>> maporder = new TreeMap<Integer, List<String>>(
    			new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o2.compareTo(o1);
					}
    			});
    	
    	// Add the families to maporder and get sizes for the output
    	for (String key : families.keySet()) {
    		for (String name : families.get(key)) if (name.length() > maxname) maxname = name.length();
    		String[] skey = key.split(" ");
    		int n2 = Integer.parseInt(skey[1]);
    		int n1 = Integer.parseInt(skey[0]);
    		int len = n2-n1;
    		if (n1 < min) min = n1;
    		if (n2 > max) max = n2;
    		if (!maporder.containsKey(len)) {
    			ArrayList<String> temp = new ArrayList<String>();
    			temp.add(key);
    			maporder.put(len, temp);
    		} else {
    			maporder.get(len).add(key);
    		}
    	}
    	
    	// Making the output
    	String format = "FAMILY %"+maxname+"s";
    	for (int i = min; i <= max; i++) format += String.format("%4d", i);
    	System.out.printf(format+"\n", "NAME");
    	format = "%6d %"+maxname+"s%s\n";
    	String output = "";
    	String xoutput = "";
    	int family = 0;
    	for (Integer fnum : maporder.keySet()) {
    		for (String key : maporder.get(fnum)) {
    			for (int i = min; i <= max; i++) {
    				if (i >= Integer.parseInt(key.split(" ")[0]) && i <= Integer.parseInt(key.split(" ")[1])) {
    					xoutput += "   X";
    				} else xoutput += "    ";
    			}
    			++family;
    			for (String name : families.get(key)) {
    	    		output += String.format(format, family, name, xoutput);
    			}
    			xoutput = "";
    		}
    	}
    	System.out.print(output);
	}

	private static void AddStreet(String[] comm, ArrayList<String> street, TreeMap<String, ArrayList<String>> families) {
    	if (comm.length < 4 | !comm[2].matches("[0-9]+") | !comm[3].matches("[0-9]+")) {
    		System.out.println("[ERROR] Wrong command format.");
    		return;
    	}
    	String fkey = comm[2]+" "+comm[3];
    	if (street.contains(comm[1]+" "+fkey)) {
    		System.out.println("[ERROR] Street already contains "+comm[1]+".");
    		return;
    	}
		if (!comm[1].matches("[a-zA-Z0-9_.@]+")
				| !comm[1].matches("^[a-zA-Z].*[a-zA-Z0-9]$")
				| comm[1].length() > 30
				| comm[1].length() < 3) {
			System.out.println("[ERROR] Name "+comm[1]+" cannot be accepted.");
			return;
		}
		
		// Add to the street
    	street.add(comm[1]+" "+fkey);
    	
    	// Add to the family
		if (!families.containsKey(fkey)) {
			ArrayList<String> family = new ArrayList<String>();
			family.add(comm[1]);
			families.put(fkey, family);
		} else {
			families.get(fkey).add(comm[1]);
		}
	}

	private static void RemoveStreet(String[] comm, ArrayList<String> street, TreeMap<String, ArrayList<String>> families) {
    	if (comm.length < 3) {
    		System.out.println("[ERROR] Wrong command format.");
    		return;
    	}
		if (street.isEmpty()) {
    		System.out.println("[ERROR] Street doesn't have any elements.");
    		return;
    	}
    	Boolean removed = false;
    	ArrayList<String> torem = new ArrayList<String>();
    	for (String key : street) {
    		if (key.contains(comm[1])) {
    			String[] nremove = key.split(" ");
    			String fkey = nremove[1]+" "+nremove[2];
    			
    			// Remove from the family
    			families.get(fkey).remove(comm[1]);
    			
    			// If family is empty remove it
    			if (families.get(fkey).isEmpty()) families.remove(fkey);
    			torem.add(key);
    			//street.remove(key); gives an error
    			removed = true;
    		}
    	}
    	
    	// Did the remove from the street after the loop because of an error
		for (String key : torem) {
			street.remove(key);
		}
    	if (!removed) System.out.println("[ERROR] Street doesn't contain "+comm[1]+".");
    	if (street.isEmpty()) street = null;
	}

	private static void ListStreet(ArrayList<String> street) {
    	if (street.isEmpty()) {
    		System.out.println("[ERROR] Street doesn't have any elements.");
    		return;
    	}
    	Collections.sort(street, String.CASE_INSENSITIVE_ORDER);
    	String outputlist = "";
    	for (String key : street) {
    		outputlist += key+"\n";
    	}
    	System.out.print(outputlist);
	}

	private static void LookupStreet(String[] comm, ArrayList<String> street, TreeMap<String, ArrayList<String>> families) {
    	if (comm.length < 2) {
    		System.out.println("[ERROR] Wrong command format.");
    		return;
    	}
    	if (street.isEmpty()) {
    		System.out.println("[ERROR] Street doesn't have any elements.");
    		return;
    	}
    	String outlookup = "";
    	for (String key : families.keySet()) {
    		if (families.get(key).contains(comm[1])) {
    			outlookup += key+" :";
    			for (String name : families.get(key)) {
    				outlookup += " "+name;
    			}
    			outlookup += "\n";
    		}
    	}
    	System.out.print(outlookup);
	}
}
