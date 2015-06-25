
public class TestQueue {
	public static void main (String[] args){
		//test data
		final Fraction[] FRACTION_DATA = {new Fraction(1,1), new Fraction(1,2), new Fraction(1,3), new Fraction(1,4), new Fraction(1,5)};
		
		Queue q = new Queue();
		//add fractions to the queue
		for(int i = 0; i < FRACTION_DATA.length; i++){
			q.add(FRACTION_DATA[i]);
		}
		//peek the head and remove each head from queue
		while(!q.isEmpty()){
			q.peek();
			q.next();	
		}	
	}

}
