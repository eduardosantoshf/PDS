package lab5_2;

public class CentralCantineLunchBuilder implements LunchBuilder{
	private Lunch l;
	
	
	public CentralCantineLunchBuilder() {
		this.l = new Lunch();
	}
	

	public void buildDrink() {
		l.setDrink("Água");	
	}

	public void buildMainCourse() {
		l.setMainCourse("Grelhada mista");	
	}


	public void buildSide() {
		l.setSide("Queijo fresco");
	}

	public Lunch getMeal() {

		return this.l;
	}

}
