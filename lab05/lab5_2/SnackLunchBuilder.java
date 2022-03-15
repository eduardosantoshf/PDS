package lab5_2;

public class SnackLunchBuilder implements LunchBuilder{
	private Lunch l;

	
	public SnackLunchBuilder () {
		this.l = new Lunch();
	}
	
	public void buildDrink() {
		l.setDrink("Sumo");
		
	}


	public void buildMainCourse() {
		l.setMainCourse("Pão com Panado");
		
	}


	public void buildSide() {
		l.setSide("Rissol");
		
	}

	public Lunch getMeal() {
		return this.l;
	}

}
