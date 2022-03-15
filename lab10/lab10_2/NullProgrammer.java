package lab10_2;

class NullProgrammer extends Employee {

	    public NullProgrammer(String name) {
	        this.name = name;
	    }
	    
	    @Override
	    public String getName() {
	        return "Desculpe, mas não existe programadores de " + this.name;
	    }
}


