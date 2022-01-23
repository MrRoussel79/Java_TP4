package robots;

import java.util.*;
import java.lang.Math;

public class Point {
	private double x;
	private double y;
	private static Random random=new Random(0);
	
	public Point(){
		x=random.nextDouble();
		y=random.nextDouble();
	}
	
	public Point(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	public double distance(Point p){
		return Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y));
	}
	
	public Point move(Point target, double d) {
		if (distance(target)<=d){
			return target;
		}
		else{
			Point p = new Point();
			p.x=(d/distance(target))*(target.x-x)+x;
			if (p.x<0){
				p.x=0;
			}
			else if (p.x>1){
				p.x=1;
			}
			p.y=(d/distance(target))*(target.y-y)+y;
			if (p.y<0){
				p.y=0;
			}
			else if (p.y>1){
				p.y=1;
			}
			return p;
		}
	}
	
	public double getx (){
		return x;
	}
	
	public double gety (){
		return y;
	}
	
	public void setx (double x){
		this.x=x;
	}
	
	public void sety (double y){
		this.y=y;
	}
	
	public static void main(String[] args){
		Point current = new Point();
		Point target = new Point();
		double d = 0.2;
		System.out.println(current.distance(target));
		Point p = current.move(target, d);
		System.out.println(current.distance(p));
	}
}
