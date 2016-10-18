package botmetrics;


import com.sun.speech.freetts.Voice;

import com.sun.speech.freetts.VoiceManager;

import comp110.Baemoji;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;



public class Driver extends Application implements EventHandler{

	
	Button button;
	TextField paramField;
	ABot chatty;
	TextArea message;
	VBox layout;
	VBox leftSide;
	ScrollPane scroll;
	BorderPane border;
	Thread chatbot, user;
	String temp, userSays;
	
	Group scroller;
	
	public static void main(String[] args) {	
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		temp = "";
		chatty = new ABot("Chatty");
	
		primaryStage.setTitle("Chat");
		
		border = new BorderPane();
		paramField = new TextField();
		button = new Button("Send");
		layout = new VBox();
		scroller = new Group();
		scroller.getChildren().add(layout);
		leftSide = new VBox();
		
		HBox test = new HBox();
		test.setPrefWidth(500);
		paramField.setPrefWidth(390);
		scroll = new ScrollPane();
		
	
		button.setAlignment(Pos.BOTTOM_RIGHT);
		paramField.setAlignment(Pos.BOTTOM_RIGHT);
		test.getChildren().add(paramField);
		test.getChildren().add(button);
		test.setAlignment(Pos.BOTTOM_LEFT);
		
		Baemoji face = chatty._face;
		Node faceNode = face.getShapes().toFX();
		leftSide.getChildren().add(faceNode);
		Label chatLabel = new Label(chatty._name);
		chatLabel.setAlignment(Pos.BASELINE_CENTER);
		leftSide.getChildren().add(chatLabel);
		VBox.setMargin(faceNode, new Insets(10, 10, 10, 10));
		
				
		//User can press Enter key to operate chat rather than submit button
		paramField.setOnAction(this::handleInput);
		button.setOnAction(this::actionPerformed);
		
	
		layout.setPrefWidth(440);
		
		
		scroll.setContent(scroller);
		
		
		border.setCenter(scroll);
		border.setRight(leftSide);
		border.setBottom(test);
		
		
		Scene scene = new Scene(border, 562, 630);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Want to prompt the user with an introduction so that the very first input will set the user name

		Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();		//Initializing the voice for chatbot
             
        voice = voiceManager.getVoice("kevin16");
        voice.allocate();
		
		TextField intro = new TextField(chatty.introduction());
		intro.setEditable(false);
		
		Label chattySays = new Label(chatty._name + " says: ");		//Adding the chatbot says label
		layout.getChildren().add(chattySays);
		VBox.setMargin(chattySays, new Insets(5, 5, 5, 5));
		
		layout.getChildren().add(intro);							//Adding the very first intro to the layout
		VBox.setMargin(intro, new Insets(5, 5, 5, 5));
		
		final Task task = new Task() {							//Prompts chatbot to speak its response on a separate thread
		     @Override
		     protected Object call() throws Exception {
		    	 voice.speak(chatty.introduction());
		       return null;
		     }
		   };
		   Thread thread = new Thread(task);
		   thread.start();		   
		
	}
	
	public void handleInput(ActionEvent e) {
		//System.setProperty("mbrola.base", "/Users/kayleellewellyn/Documents/mbrola");
		temp = paramField.getText();
		 
		//Chatbot prompts user to enter user name
		 boolean intro = false;
		 if(!intro){
			 intro = true;
			 paramField.clear();
			 chatty.setUserName(temp);
			 
			 TextField user = new TextField(temp + "\n");
			 Label userSays = new Label(chatty.getUserName() + " says: ");
			 user.setAlignment(Pos.CENTER_RIGHT);
				
			 layout.getChildren().add(userSays);
				VBox.setMargin(userSays, new Insets(5, 5, 5, 5));
				layout.getChildren().add(user);
				VBox.setMargin(user, new Insets(5, 5, 5, 5));
				
				Voice voice;
		        VoiceManager voiceManager = VoiceManager.getInstance();
		             
		        voice = voiceManager.getVoice("kevin16");
		        voice.allocate();	
		        
		        String chattyResponse = chatty.niceToMeet();
				TextField chatbot = new TextField(chattyResponse + "\n");
				chatbot.setEditable(false);
				Label chattySays = new Label(chatty._name + " says: ");
				layout.getChildren().add(chattySays);
				VBox.setMargin(chattySays, new Insets(5, 5, 5, 5));
				layout.getChildren().add(chatbot);
				VBox.setMargin(chatbot, new Insets(5, 5, 5, 5));

				final Task task = new Task() {
				     @Override
				     protected Object call() throws Exception {
				    	 voice.speak(chattyResponse);
				       return null;
				     }
				   };
				   Thread thread = new Thread(task);
				   thread.start();		   
				
				
		 } 
//		 else if(temp.contains("bye")){
//			TextField input = new TextField(temp+ "\n");
//			input.disableProperty();
//			layout.getChildren().add(input);
//			TextField bye = new TextField(chatty.bye());
//			bye.disableProperty();
//			layout.getChildren().add(bye);
//			layout.getChildren().remove(paramField);
//			layout.getChildren().remove(button);
//			paramField.disableProperty();
//			button.disableProperty();
//		}
		else{
			paramField.clear();
			TextField user = new TextField(temp + "\n");
			
			//want to set text alignment to the right for the user
			user.setAlignment(Pos.CENTER_RIGHT);
			
			Voice voice;
	        VoiceManager voiceManager = VoiceManager.getInstance();
	             
	        voice = voiceManager.getVoice("kevin16");
	        voice.allocate();
			
			user.setEditable(false);
			Label userSays = new Label(chatty.getUserName() + " says: ");

			
			layout.getChildren().add(userSays);
			VBox.setMargin(userSays, new Insets(5, 5, 5, 5));
			layout.getChildren().add(user);
			VBox.setMargin(user, new Insets(5, 5, 5, 5));
			
			
			
			
			String chattyResponse = chatty.parser(temp);
			TextField chatbot = new TextField(chattyResponse + "\n");
			chatbot.setEditable(false);
			Label chattySays = new Label(chatty._name + " says: ");
			layout.getChildren().add(chattySays);
			VBox.setMargin(chattySays, new Insets(5, 5, 5, 5));
			layout.getChildren().add(chatbot);
			VBox.setMargin(chatbot, new Insets(5, 5, 5, 5));

			final Task task = new Task() {
			     @Override
			     protected Object call() throws Exception {
			    	 voice.speak(chattyResponse);
			       return null;
			     }
			   };
			   Thread thread = new Thread(task);
			   thread.start();		   
			
		}
	}

	@Override
	public void handle(Event event) {
	
	}
	
	public void actionPerformed(ActionEvent ae) {
		System.setProperty("mbrola.base", "/Users/kayleellewellyn/Documents/mbrola");
//        VoiceManager vm = VoiceManager.getInstance();
//        Voice voice = vm.getVoice("kevin16");
//        voice.allocate();
//        voice.speak(temp);
		Voice voice;
	
        VoiceManager voiceManager = VoiceManager.getInstance();     
        voice = voiceManager.getVoice("mbrola_us1");
        voice.allocate();
        voice.speak("hello world");
	}


}
