package robots;


public class Sphere implements AbstractProblem {
	public double oreGrade (Point p){
		return (1-((p.getx()*p.getx()+p.gety()*p.gety())/2))*255;
	}
	
	public static void main (String[] args){
		Sphere pb=new Sphere();
		Viewer.display(pb);
		System.out.println("teneur en [0,0] normalisée "+pb.oreGrade(new Point(0,0))/255);
		System.out.println("teneur en [1,1] normalisée "+ pb.oreGrade(new Point(1,1))/255);
	}
}
