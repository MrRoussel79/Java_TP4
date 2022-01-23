package robots;

public class Behavior {	
	public void move(Robot r){
		//Instanciation du point m
		Point m = new Point (0.5,0.5);
		//attributs
		Point A = new Point();
		Point MA =new Point();
		MA.setx(A.getx()-m.getx());
		MA.sety(A.gety()-m.gety());
		
		Point Pprime = new Point();
		Pprime.setx(r.getCurrent().getx()+MA.getx());
		Pprime.setx(r.getCurrent().gety()+MA.gety());
		

		r.setCurrentPosition(r.getCurrent().move(Pprime, 0.05));

	}
	public String getName() {
		return "Behavior";
	};
	
	public static void main (String[] args) {
		Point p=new Point(0.5,0.5); // initial location of robot
		Robot robot=new Robot(p);
		Behavior explore=new Behavior();
		robot.setBehavior(explore); // explore behavior set to robot.
		Point courant=new Point(0.5,0.5);
		for (int i=0;i<10;i++){
		robot.walk(); 
		//get position
		System.out.println(i+" : "+robot.getPosition());
		//Check distance
		System.out.println(i+" : "+courant.distance(robot.getCurrent()));
		//update courant to compare next time
		courant.setx(robot.getCurrent().getx());
		courant.sety(robot.getCurrent().gety());
		}

	}
}
