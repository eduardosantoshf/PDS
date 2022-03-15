package lab3_2;

import java.util.*;

public class Rua {

	    /**
	     * ATTRIBUTES
	     */
	    private List<Familia> familias;

	    /**
	     * CONSTRUCTORS
	     */
	    public Rua() {
	        this.familias = new ArrayList<>();
	    }

	    /**
	     * METHODS
	     */
	    // Checks if member already exists in street. If so return true; otherwise
	    // return false.
	    private Familia checkMember(String name) {
	        for (Familia fam : this.familias) {
	            if (fam.contains(name)) {
	                return fam;
	            }
	        }
	        return null;
	    }

	    // Validates each member info. If valid returns true; otherwise returns false.
	    private boolean validateMemberInfo(String name, int firstDoor, int lastDoor) {
	        if (firstDoor > lastDoor) {
	            System.err.println("ERROR: Door numbers [x1,x2] must be: 0 < x1 <= x2 ");
	            return false;
	        }

	        if (checkMember(name) != null) {
	            System.err.println("ERROR: Citizen already exists!");
	            return false;
	        }

	        if (!name.matches("[A-Za-z0-9_.@]+")) { // TODO : this verification is incomplete
	            System.err.println("ERROR: Name can only have alphas (lower and upper), '-', '.', and '@'");
	            return false;
	        }

	        if (!Character.isLetter(name.charAt(0))) {
	            System.err.println("ERROR: Name's first char needs to be a letter");
	            return false;
	        }

	        if (name.charAt(name.length() - 1) == '_' || name.charAt(name.length() - 1) == '.'
	                || name.charAt(name.length() - 1) == '@') {
	            System.err.println("ERROR: Name's last char can't be '_' or '.' or '@'");
	            return false;
	        }

	        if (name.length() > 40) {
	            System.err.println("ERROR: Name has a maximum size of 40 chars");
	            return false;
	        }

	        return true;
	    }

	    // calculates the maximum value of door
	    private int getMaxDoor() {
	        int lastDoor, maxDoor = 0;
	        for (Familia fam : this.familias) {
	            lastDoor = fam.getLastDoor();
	            if (lastDoor > maxDoor)
	                maxDoor = lastDoor;
	        }
	        return maxDoor;
	    }

	    public void add(String name, int firstDoor, int lastDoor) {
	        if (!validateMemberInfo(name, firstDoor, lastDoor)) {
	            return;
	        }

	        boolean added = false;
	        for (Familia fam : this.familias) {
	            if (fam.getFirstDoor() == firstDoor && fam.getLastDoor() == lastDoor) {
	                fam.add(name);
	                added = true;
	            }
	        }
	        if (!added) {
	            familias.add(new Familia(name, firstDoor, lastDoor));
	        }
	    }

	    // Searches for a citizen. If doesn't exist error; otherwise print his Familia
	    // info
	    public void lookup(String name) {
	        Familia memberFamily = checkMember(name);
	        if (memberFamily == null) {
	            System.err.println("ERROR: Citizen doesn't exist!");
	        } else {
	            StringBuilder sb = new StringBuilder();
	            sb.append(memberFamily.getFirstDoor()).append(" ");
	            sb.append(memberFamily.getLastDoor()).append(" ");
	            sb.append(memberFamily);
	            System.out.println(sb.toString());
	        }
	    }

	    // Implementation of function remove. Removes person.
	    // If, this person is the only member of his Familia remove Familia too from
	    // street.
	    public void remove(String name) {
	        Familia memberFamily = checkMember(name);
	        if (memberFamily == null) {
	            System.err.println("ERROR: Citizen doesn't exist!");
	        } else {
	            memberFamily.remove(name);
	            if (memberFamily.isEmpty())
	                this.familias.remove(memberFamily);
	        }
	    }

	    public void clear() {
	        this.familias.clear();
	    }

	    // Implementation of isEmpty function to this class
	    public boolean isEmpty() {
	        return this.familias.isEmpty();
	    }

	    @Override
	    public String toString() {
	        int maxDoor = getMaxDoor();
	        StringBuilder sb = new StringBuilder();
	        Collections.sort(familias, Collections.reverseOrder());
	        for (int i = 1; i < maxDoor + 1; i++) {
	            sb.append(String.format("%3d ", i));
	            for (Familia fam : familias) {
	                if (fam.getFamilyDoors().contains(i))
	                    sb.append(": ").append(fam.toString());
	            }
	            if (i < maxDoor)
	                sb.append("\n");
	        }
	        return sb.toString();
	    }

	    public void list() {
	        Set<String> persons = new TreeSet<>();
	        for(Familia fam: this.familias) {
	            persons.addAll(fam.getFamilyMembers());
	        }
	        String personInfo;
	        for (String person : persons) {
	            for(Familia fam: this.familias) {
	                personInfo = fam.personInfoToString(person);
	                if (personInfo != null) {
	                    System.out.println(personInfo);
	                    break;
	                }
	            }
	        }
	    }
	}


