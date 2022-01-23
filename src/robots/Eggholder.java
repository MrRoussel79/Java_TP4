package robots;


public class Eggholder implements AbstractProblem{
	public double oreGrade (Point p){
		double x = 1024*(p.getx()-0.5);
		double y = 1024*(p.gety()-0.5);
		double t = (y+47)*Math.sin(Math.sqrt(Math.abs((x/2)+(y+47))))+x*Math.sin(Math.sqrt(Math.abs(x-y-47)));
		//return (255/(959.64+1049.13))*(t+1049.13);
		return (255*(t+1049.13)/(959.64+1049.13));
	}
	
	public static void main (String[] args){
		Eggholder pb=new Eggholder();
		System.out.println("teneur en [0,1] normalisée "+pb.oreGrade(new Point(0,1))/255);
		System.out.println("teneur en [1,0.895] normalisée "+ pb.oreGrade(new Point(1,0.895))/255);
		Viewer.display(pb);
	}
}
