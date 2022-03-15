package lab3_2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {


	    public static void main(String[] args) {
	        Rua rua = new Rua();
	        menu(rua, args);

	    }

	    // Menu function that handles the user interface of the program
	    public static void menu(Rua rua, String[] args) {
	       
	        while (true) {
	            System.out.println("\nCommands available: Load, Map, Add, Remove, List, Lookup, Clear, Quit");
	            System.out.println("Command:");
	            Scanner sc = new Scanner (System.in);
	            String input = sc.next().toLowerCase();
	            switch (input) {
	            case "quit":
	                System.exit(0);
	                break;

	            case "load":
	                System.out.println("Insert File Name:");
	                String fileName = sc.next();
	                readLoadFile(fileName, rua);
	                break;

	            case "map":
	                if (rua.isEmpty())
	                    System.out.println("\nYou didn't add any information yet!");
	                else
	                    System.out.println(rua);
	                break;

	            case "add":
	                System.out.println("Insert name x1 x2:");
	                if (args.length == 0)
	                    sc.nextLine();
	                String[] memberData = dealWithMemberInput(sc.nextLine().trim());
	                if (memberData != null) {
	                    rua.add(memberData[0], Integer.parseInt(memberData[1]), Integer.parseInt(memberData[2]));
	                }
	                break;

	            case "remove":
	                if (rua.isEmpty()) {
	                    System.out.println("\nYou didn't add any information yet!");
	                } else {
	                    System.out.print("Insert Person's Name:");
	                    String personName = sc.next();
	                    rua.remove(personName);
	                }
	                break;

	            case "list":
	                if (rua.isEmpty()) {
	                    System.out.println("\nYou didn't add any information yet!");
	                } else {
	                    rua.list();
	                }
	                break;

	            case "lookup":
	                if (rua.isEmpty()) {
	                    System.out.println("\nYou didn't add any information yet!");
	                } else {
	                    System.out.println("Insert Person's Name:");
	                    String personName = sc.next();
	                    rua.lookup(personName);
	                }
	                break;

	            case "clear":
	                rua.clear();
	                break;

	            default:
	                System.err.println("ERROR: Command does not exist!");
	            }
	        }
	    }


	    // Reads members' info from file and inserts it to rua
	    public static void readLoadFile(String fileName, Rua rua) {
	    	ArrayList<String> contents = new ArrayList<>();
	        try {
	        	
	        	 
	        	try (FileReader f = new FileReader(fileName)) {
	        	    StringBuffer sb = new StringBuffer();
	        	    while (f.ready()) {
	        	        char c = (char) f.read();
	        	        if (c == '\n') {
	        	            contents.add(sb.toString());
	        	            sb = new StringBuffer();
	        	        } else {
	        	            sb.append(c);
	        	        }
	        	    }
	        	    if (sb.length() > 0) {
	        	        contents.add(sb.toString());
	        	    }
	        	}       
	        	

	        } catch (IOException ex) {
	            System.err.println("ERROR: Invalid File Name!");
	            return;
	        }
	        for (int i = 0; i < contents.size(); i++) {
	            String line = contents.get(i).toString();
	            if (i == 0 & line.charAt(0) == '>')
	                continue;
	            else {
	                String[] personInfo = line.split("[-|\\s]+");
	                rua.add(personInfo[2], Integer.parseInt(personInfo[0]), Integer.parseInt(personInfo[1]));
	            }
	        }
	    }

	    // Checks if input is correspondent to expected (number of elements and it's
	    // type).
	    // If input is valid return String[] = {name, x1, x2}; otherwise returns null.
	    public static String[] dealWithMemberInput(String memberInput) {
	        String[] data = memberInput.split(" ");
	        if (data.length != 3 || data[0].isEmpty() || data[1].isEmpty() || data[2].isEmpty()) {
	            System.err.println("ERROR: BAD input");
	            return null;
	        }

	        if (!(data[1].matches("^\\d+$") && data[1].matches("^\\d+$"))) {
	            System.err.println("Second and Third argument must be positive integers!");
	            return null;
	        }
	        return data;
	    }
	}
