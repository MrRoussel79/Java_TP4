package robots;

public class Robot {
	//attributs
	private Point current;
	private Point lastLocalSpot;
	private double currentOreGrade;
	private double maxOreGrade;
	private Behavior behavior;
	
	private static Point globalLastLocalSpot;
	private static double globalMaxOreGrade;
	//méthode d'instance
	public Robot(Point p) {
		current=p;
		lastLocalSpot=p;
		//currentOreGrade=behavior.oreGrade(p);
		maxOreGrade=0;
	}
	
	public String getPosition() {
		return current.getx()+"; "+current.gety();
	}
	
	public Point getBestPosition(){
		return this.lastLocalSpot;
	}
	
	public Point getCurrent() {
		return current;
	}
	
	public void walk() {
		behavior.move(this);
	}
	public double getCurrentOreGrade() {
		return currentOreGrade;
	}
	public void setCurrentOreGrade(double ore) {
		currentOreGrade=ore;
		if (currentOreGrade>maxOreGrade) {
			lastLocalSpot=current;
			maxOreGrade=currentOreGrade;
			if (maxOreGrade>globalMaxOreGrade)
				globalMaxOreGrade=maxOreGrade;
				globalLastLocalSpot=current;
		}
	}
	public static double getAllBestGain(){
		return globalMaxOreGrade;
	}
	public static Point getAllBestPosition(){
		return globalLastLocalSpot;
	}
	
	public void setCurrentPosition(Point p) {
		if (currentOreGrade>maxOreGrade) {
			lastLocalSpot=current;
			maxOreGrade=currentOreGrade;
		}
		current=p;
	}
	
	public void setBehavior(Behavior b) {
		behavior=b;
	}
}
