package robots;

import utilitaires.Printer;

public class BasicMission {
	//attributs
	protected AbstractProblem gisement;
	protected Robot[] robots;
	protected Printer pr;
	//méthode d'instance
	public BasicMission(AbstractProblem gis, int n){
		//constructeur
		gisement = gis;
		robots = new Robot[n];
		pr=new Printer("src/data/robots.txt");
		initialization();
	}
	
	public void set(int index, Robot r) {
		robots[index]=r;
	}
	
	public Robot get(int index) {
		return robots[index];
	}
	
	public void initialization() {

		for (int i = 0; i<robots.length; i++) {
			Point p = new Point(0.5, 0.5);
			Robot r = new Robot(p);
			Behavior b = new Behavior();
			r.setBehavior(b);
			set(i, r);
		}
	}
	public void collect(){
		for(int i=0; i<robots.length; i++){
			robots[i].setCurrentOreGrade(gisement.oreGrade(robots[i].getCurrent()));
		}
	}
	public void walk(){
		for(int i=0; i<robots.length; i++)
			robots[i].walk();
	}
	
	public void store(){
		
		pr.println("-1");
		for(int i=0; i<this.robots.length; i++){
			pr.println(this.robots[i].getCurrent().getx()+"\t"+robots[i].getCurrent().gety());
		}
	}
	public void run() {
		for (int iter=0;iter<100;iter++){
			collect();
			store();
			for (int i = 0; i<robots.length; i++) {
				System.out.println("Robots "+i+" pos : "+robots[i].getPosition()+ " teneur : "+robots[i].getCurrentOreGrade());
			}
			System.out.println("iter="+iter+" "+Robot.getAllBestGain()+" "+Robot.getAllBestPosition().getx()+" "+Robot.getAllBestPosition().gety());
			walk();
		}
		pr.close();

	}
	
	public static void main (String[] args){
		Sphere pb=new Sphere();
		BasicMission bm = new BasicMission(pb, 100);
		bm.run();
		Viewer.display(pb);
	}
}
