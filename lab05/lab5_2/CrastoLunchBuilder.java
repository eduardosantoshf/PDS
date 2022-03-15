package lab5_2;

public class CrastoLunchBuilder implements LunchBuilder {
	private Lunch l;
	
	
	public CrastoLunchBuilder() {
		this.l = new Lunch();
	}
	
	public void buildDrink() {
		l.setDrink("Vinho tinto");
		
	}

	public void buildMainCourse() {
		l.setMainCourse("Bacalhau à lagareiro");
		
	}

	
	public void buildSide() {
		l.setSide("Broa");
		
	}

	public Lunch getMeal() {
		return this.l;
	}
}