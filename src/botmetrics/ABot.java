package botmetrics;

import java.util.ArrayList;
import java.util.Stack;

import comp110.Baemoji;

public class ABot implements Bot{

	String _name;
	Baemoji _face;
	
	String _userName;
	int _count;
	ArrayList<String> _history;
	
	//one constructor that requires a name input to build chatbot AND Baemoji
	//The baemoji is now associated with the Chatbot
	public ABot(String name){
		_name = name;
		_face = new Baemoji();
		_count = 0;
		_userName = "user";
		_history = new ArrayList<String>();
	}
	
	public Baemoji getFace() {
		return _face;
	}
	
	public ArrayList<String> getHistory(){
		return _history;
	}
	
	public void setUserName(String n){
		_userName = n;
	}
	
	public String getUserName(){
		return _userName;
	}
	
	//looks for keywords
	public String parser(String input){
		_history.add(input);
		_count++;
		if(input.contains("mom")){
			_history.add(family("mom"));
			return family("mom");
		}
		else if(input.contains("weather")){
			_history.add(weather());
			return weather();
		}
		else if(input.contains("sister")){
			_history.add(family("sister"));
			return family("sister");
		}
		else if(input.contains("dad")){
			_history.add(family("dad"));
			return family("dad");
		}
		else if(input.contains("brother")){
			_history.add(family("brother"));
			return family("brother");
		}
		else if(input.contains("hello") || input.contains("hey")){
			_history.add(introduction());
			return introduction();
		}
		else if(_history.get(_count - 1).contains("What is your name?")){
			setUserName(input);
			_history.add(niceToMeet());
			return niceToMeet();
		}
		else if(input.contains("what's up") || input.contains("whats up")){
			_history.add(wassup());
			return wassup();
		}
		else if(input.contains("how are you")){
			_history.add(howRU());
			return howRU();
		}
		else if(input.contains("joke")){
			_history.add(joker());
			return joker();
		}
		else if(input.contains("you")){
			_history.add(really());
			return really();
		}
		else if(input.contains("soccer")){
			_history.add(sport("soccer"));
			return sport("soccer");
		}
		else if(input.contains("not much")){
			_history.add(okay());
			return okay();
		}
		else if(input.contains("what have i said") || input.contains("what did i say")){
			return history();
		}
		else if(input.contains("thank")){
			return welcome();
		}
		else{
			_history.add(random());
			return random();
		}
		

	}
	
	//basic method to introduce
	public String introduction(){
		return "hello, my name is " + _name + ". What is your name?";
	}
	
	public String niceToMeet(){
		return "nice to meet you " + getUserName();
	}
	
	public String howRU(){
		return "I'm well, how are you?";
	}
	
	//helper method for parser, returns a question inquiring about a family member
	public String family(String famMember){
		return "How is your " + famMember;
	}
	
	//helper method for parser, returns question asking how user is doing
	public String wassup(){
		return "nothing much, how about you?";
	}
	
	//tells the user to check Siri
	public String weather(){
		return "I do not know the weather, go ask Siri";
	}
	
	//Randomly generates a response if keywords not found in parser
	public String random(){
		int randomizer = (int)(Math.random() * 5);
		if(randomizer == 1){
			return "May the force be with you";
		}
		else if(randomizer == 2){
			return "Dudeeeee!";
		}
		else if(randomizer == 3){
			return "Are you serious?";
		}
		else if(randomizer == 4){
			return "Tell me more";
		}
		else{
			return "OMG";
		}
	}
	
	public String sport(String s){
		return "What is your favorite " + s + " team?";
	}
	
	public String joker(){
		int jokerNum = (int)(Math.random() * 2);
		if(jokerNum == 0){
			return "haha";
		}
		else if(jokerNum == 1){
			return "Whenever I find the key to success, someone changes the locks";
		}
		else //if(jokerNum == 2){
			return "lol";
	}
	
	public String bye(){
		return "Okay, I see how it is. I'm leaving.";
	}
	
	public String really(){
		return "What are you trying to say about me?";
	}
	
	public String okay(){
		return "Cool";
	}
	
	public String history(){
		String hist = "";
		for(int i = 0; i < _history.size(); i = i+2){
			hist = _history.get(i) + "\n";
		}
		return hist;
	}
	
	public String welcome(){
		return "you are welcome";
	}
	
}
