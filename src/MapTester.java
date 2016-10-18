import java.util.ArrayList;

public class MapTester {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			numbers.add(i);
		}
		
		numbers.stream()
		       .filter( (x) -> x % 2 == 0 )
		       .map( (x) -> x * x )
		       .forEach( (x) -> System.out.println(x))
		       ;
		
		
	}
	
}
