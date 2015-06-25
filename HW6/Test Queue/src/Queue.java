
public class Queue {
	//Nodes for head and tail of the queue
	Node head;
	Node tail;
	
	//add an object to the tail of the queue
	void add(Object o){
		System.out.println("Adding " + o.getClass().getName() + " " + o.toString() + " to the queue.");
		//Create new node, constructor sets reference to o Object and next node to null
		Node newNode = new Node(o);
		//first object in the queue
		if(isEmpty()){
			head = newNode;
			tail = newNode;
		}
		//add at the end of the queue and set new tail
		else{
			Node oldTail = tail;
			oldTail.nextNode = newNode;
			tail = newNode;
		}
	}
	
	//return and remove the object at the head
	Object next(){
		System.out.println("The next " + head.getObj().getClass().getName() + " int the queue is " + head.getObj().toString());
		//return null for empty queue
		if(isEmpty()){
			return null;
		}
		
		//remove and return removed head object
		else{
			Object oldHeadObject = head.getObj();
			head = head.nextNode;
			return oldHeadObject;	//return object inside node 
		}
		


	}
	
	//return a reference to the object at the head
	Object peek(){
		System.out.println("Peeking at the head of the queue shows "+ head.getObj().toString());
		if(isEmpty()) return null;
		return head.getObj();
	}
	
	//return length of the queue
	int size(){
		int count = 0;
		if(!isEmpty()){
			count++;
			for(Node n = head; n.nextNode != null; n = n.nextNode){
				count++;
			}	
		}
		return count;
	}
	
	//return true is the queue is empty
	boolean isEmpty(){
		return head == null;
	}
	
	//holds reference to object and next node in the queue
	private class Node{
		Object obj;
		Node nextNode;
		
		Node(Object o){
			obj = o;
			nextNode = null;
		}
		
		Node(Object o, Node n){
			obj = o;
			nextNode = n;
		}
		
		Object getObj(){
			return obj;
		}
	}
}
