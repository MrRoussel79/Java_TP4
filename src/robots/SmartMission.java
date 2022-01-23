package robots;

public class SmartMission extends BasicMission {

	private AbstractPolicy policy;

	public SmartMission(AbstractProblem gis, int n, AbstractPolicy policy) {
		super(gis, n);
		this.policy=policy;
		// TODO Auto-generated constructor stub
	}
	
	public void initialization() {

		for (int i = 0; i<this.robots.length; i++) {
			Point p = new Point(0.9, 0.9);
			Robot r = new Robot(p);
			set(i, r);
		}
	}
	
	public void run() {
		int indexRobot=0;
		System.out.println("getNbrPhase="+policy.duree(0));
		for (int phase=0;phase<policy.getNbrPhase();phase++){
			for(int iter=0; iter<policy.duree(phase); iter++) {
				for (int i = 0; i<this.robots.length; i++) {
					this.robots[i].setBehavior(policy.behavior(phase));
				}
				collect();
				store();
				for (int i = 0; i<robots.length; i++) {
					System.out.println("Robots "+i+" pos : "+robots[i].getPosition()+ " teneur : "+robots[i].getCurrentOreGrade());
				}
				System.out.println("iter="+iter+" "+Robot.getAllBestGain() + " "+Robot.getAllBestPosition().getx() +" "+ Robot.getAllBestPosition().gety());
				walk();
				indexRobot++;
			}
			
		}
		pr.close();

	}
	
	public static void main (String[] args){
		SimplePolicy policy=new SimplePolicy(6);
		policy.add(new Behavior(),20); // phase 0 de durée 60 itérations
		policy.add(new Follow(),5); // phase 1
		policy.add(new Behavior(),20); // phase 1
		policy.add(new Follow(),5); // phase 2
		policy.add(new Behavior(),5); // phase 2
		policy.add(new LocalBest(),20); // phase 2
		
		Eggholder pb=new Eggholder();
		SmartMission Sm = new SmartMission(pb, 200, policy);
		Sm.run();
		Viewer.display(pb);
	}
}
