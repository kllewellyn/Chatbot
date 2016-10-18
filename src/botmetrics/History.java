package botmetrics;

import java.util.ArrayDeque;
import java.util.Queue;

public class History {
	
	Queue<String> _history;
	
	public History(){
		_history = new ArrayDeque<String>();
	}

}
