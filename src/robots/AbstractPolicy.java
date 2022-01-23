package robots;

public abstract class AbstractPolicy {	
	public AbstractPolicy(int n) {
	}
	public abstract Behavior behavior(int p);
	public abstract int duree(int p);
	public abstract int getNbrPhase();
}
