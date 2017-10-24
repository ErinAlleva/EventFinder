package viagogo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class FindEvents {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // read input
		int inputX = 20;
		int inputY = 20;
		System.out.println("Enter x and y coordinates between -10 and 10 in the form x,y: ");
		String input = scanner.next();
		String[] split  = input.split(",");
		if (split.length == 2) { //make sure there are two items separated by comma
			inputX = Integer.parseInt(split[0]);
			inputY = Integer.parseInt(split[1]);
		} else { //if not make them enter again
			while (split.length != 2) {
				System.out.println("Please enter coordinates in form x,y");
				input = scanner.next();
				split  = input.split(",");
			}
		} //make sure inputs are within range 
		while (inputY  > 10 || inputX > 10 || inputY < -10 || inputX < -10) {
			System.out.println("Please pick coordinates between -10 and 10");
			input = scanner.next();
			split  = input.split(",");
			if (split.length == 2) {
				inputX = Integer.parseInt(split[0]);
				inputY = Integer.parseInt(split[1]);
			} else {
				System.out.println("Please enter coordinates in form x,y");
			}
		}
		Point inputPoint = new Point(inputX,inputY);
		ArrayList<Event> eventList = new ArrayList<Event>();

		//create events with ticket prices, coordinates, and event number, initializes distance to 0
		Random random = new Random();
		for (int i = 0; i < 200; i++) {
			ArrayList<Double> ticketPrices = new ArrayList<Double>();
			int x = random.nextInt(21)-10;
			int y = random.nextInt(21)-10;
			int numTickets = random.nextInt(24) + 1;
			for (int j = 0; j < numTickets; j++) {
				double price = random.nextDouble()*200 + 30;
				price = Math.floor(price * 100) / 100;
				ticketPrices.add(price);
				System.out.println(j + ": " +  price);
			}
			Event myEvent = new Event(i, x, y, ticketPrices, 0);
			if (!eventList.contains(myEvent)) {
				eventList.add(myEvent);
			}
		}
		
		//set distances from input point
		for (int i = 0; i < eventList.size(); i++) {
			double distFromPoint = eventList.get(i).distance(inputPoint);
			eventList.get(i).setDistance(distFromPoint);
		}
		Collections.sort(eventList);
		System.out.println("The 5 closest events to (" + inputX + "," + inputY + ") are:");
		for (int j = 0; j < 5; j++) {
			Event closeEvent = eventList.get(j);
			ArrayList<Double> ticketPrices = closeEvent.getTickets();
			Collections.sort(ticketPrices);
			System.out.println("Event #" + closeEvent.getNumIdentifier() + ": Distance: "+ closeEvent.getDistance() +" Price: " + 
			ticketPrices.get(0) + " x, y coordinates: " + closeEvent.getxCoord() + ", " + closeEvent.getyCoord());
		}
	}
	
	
}
