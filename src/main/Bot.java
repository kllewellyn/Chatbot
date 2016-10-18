package main;

import java.util.*;

public class Bot {

	//Super basic chatbot using the main method -- this is what I've done before so
	//using this as a baseline
	
	static String input;
	static int random;
	
	public static void main(String[] args){
		
		System.out.println("Hello, I am Bot");
		Scanner keyboard = new Scanner(System.in);
		input = keyboard.nextLine();
		do{
			if(input.contains("mom") || input.contains("dad") || input.contains("sister")){
				System.out.println("how is your family?");
			}
			else if(input.contains("hi")){
				System.out.println("how are you?");
			}
			else if(input.contains("weather")){
				System.out.println("I do not know the weather, you should ask Siri");
			}
			else if(input.contains("fortune")){
				System.out.println("You will be prosperous at the next full moon");
			}
			else if(input.contains("UNC") || input.contains("unc")){
				System.out.println("GO HEELS!");
			}
			else{
				random = (int) (Math.random()*5);
				randomizer(random);
			}
			input = keyboard.nextLine();
		}while(!input.equals("Bye"));
		
	}
	
	public static void randomizer(int i){
		if(i == 0){
			System.out.println("May the force be with you");
		}
		else if(i == 1){
			System.out.println("LOL");
		}
		else if(i == 2){
			System.out.println("No way!?");
		}
		else if(i == 3){
			System.out.println("Tell me more");
		}
		else if(i==4){
			System.out.println("Excuse you");
		}
		else{
			System.out.println("I do not understand please try another response");
		}
	}
	
}
