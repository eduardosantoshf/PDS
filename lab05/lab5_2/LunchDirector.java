package lab5_2;

public class LunchDirector {
	private LunchBuilder l;

	public LunchDirector(LunchBuilder lb) {
		this.l = lb;
	}


	public Lunch getMeal() {
		return l.getMeal();
	}

	public void constructMeal() {
		l.buildDrink();
		l.buildMainCourse();
		l.buildSide();
		
	}

}
