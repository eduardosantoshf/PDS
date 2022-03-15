package lab5_2;

public class Lunch {

	protected String drink;
	protected String mainCourse;
	protected String side;

	
	public String toString() {
		return "Lunch [drink = " + drink + ", main course = " + mainCourse + ", side = " + side + "]";
	}


	public void setDrink(String string) {
		this.drink = string;
	}


	public void setMainCourse(String string) {
		this.mainCourse = string;
		
	}

	public void setSide(String side) {
		this.side = side;
	}
	
	
	
	

}
