package robots;

public class SimplePolicy extends AbstractPolicy {
	private Behavior[] behaviors;
	private int[] durees;
	
	private int caseNulle;
	
	public SimplePolicy(int n) {
		super(n);
		behaviors=new Behavior[n];
		durees = new int[n];
		caseNulle=0;
	}
	
	public int getNbrPhase() {
		return behaviors.length;
	}
	
	@Override
	public Behavior behavior(int p) {
		return behaviors[p];
	}

	@Override
	public int duree(int p) {
		return durees[p];
	}
	
	public void add(Behavior b, int tps) {
		behaviors[caseNulle]=b;
		durees[caseNulle]=tps;
		caseNulle++;
	}

	public static void main (String[] args){
		SimplePolicy policy=new SimplePolicy(3);
		policy.add(new Behavior(),60); // phase 0 de durée 60 itérations
		policy.add(new LocalBest(),20); // phase 1
		policy.add(new Follow(),20); // phase 2
		for(int i=0; i<3; i++) System.out.println(policy.behaviors[i].getName() +" "+ policy.durees[i]);
	}
}
