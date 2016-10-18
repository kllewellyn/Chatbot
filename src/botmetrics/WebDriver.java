package botmetrics;

public class WebDriver {

	public static void main(String[] args) {
		String input = args[0];
		Bot chatty = new ABot("Bot");
		System.out.println(chatty.parser(input));
	}
	
}
