package robots;

public class Follow extends Behavior{
	/*
	public void move(Robot r){
		//attributs
		Point A = new Point(Robot.getAllBestPosition().getx(), Robot.getAllBestPosition().gety());
		r.setCurrentPosition(r.getCurrent().move(A, 0.05));
	}*/
	
	public void move(Robot r){
		//construteur
		Point m = new Point (0.5,0.5);
		//attributs
		Point A = new Point(Robot.getAllBestPosition().getx(), Robot.getAllBestPosition().gety());
		Point MA =new Point();
		MA.setx(A.getx()-m.getx());
		MA.sety(A.gety()-m.gety());

		Point Pprime = new Point();
		Pprime.setx(r.getCurrent().getx()+MA.getx());
		Pprime.sety(r.getCurrent().gety()+MA.gety());
		

		r.setCurrentPosition(r.getCurrent().move(Pprime, 0.005));

	}
	
	public String getName() {
		return "Follow";
	};
}
