package viagogo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;

public class Event implements Comparable<Event>{
	private int numIdentifier;
	private double cost;
	private int xCoord;
	private int yCoord;
	private ArrayList<Double> tickets; 
	private double distance;
	
	public Event(int numIdentifier, int xCoord, int yCoord, ArrayList<Double> tickets, double distance) {
		super();
		this.numIdentifier = numIdentifier;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.tickets = tickets;
		this.distance = distance;
	}
	
	public double distance(Point point) {
		double distance = Math.abs(point.x- this.getxCoord()) + Math.abs(point.y-this.getyCoord());
		return distance;
	}
	
	
	public int hashCode(){
        /*System.out.println("In hashcode");
        int hashcode = 0;
        hashcode = xCoord*20;
        hashcode += yCoord%7;
        return hashcode;
        */
		return Objects.hash(numIdentifier, xCoord, yCoord, tickets, distance);
    }
	
	public boolean equals(Object obj){
        if (obj instanceof Event) {
            Event myEvent = (Event) obj;
            return ((myEvent.xCoord == this.xCoord) &&( myEvent.yCoord == this.yCoord));
        } else {
            return false;
        }
    }
     
	
	public int getNumIdentifier() {
		return numIdentifier;
	}
	public void setNumIdentifier(int numIdentifier) {
		this.numIdentifier = numIdentifier;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getxCoord() {
		return xCoord;
	}
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	public int getyCoord() {
		return yCoord;
	}
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	public ArrayList<Double> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<Double> tickets) {
		this.tickets = tickets;
	}
	
	public double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	@Override public int compareTo(Event other) {
		double compareDistance = ((Event)other).getDistance();
		return (int) (this.distance - compareDistance);
	}
	

}
