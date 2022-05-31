import java.util.Scanner;

/*   
Assignment 2 
Class: CCCS 315           */

/**
 * Main class, it will test the program
 * @author MariamJael
 *
 */
public class Main {

	public static void main(String[] args) {		
        //Calling test method
		test();					
		}
	
	/**
	 * Method that use all the methods required and take input from user
	 */
	public static void test() {
	    	 
	    	 //Creating a stack
	    	 ListStack listStack = new ListStack();
	    	 
	    	 //Creating an scanner
	    	 Scanner myScanner= new Scanner(System.in);
	    	 
	    	 //Creating variable
	    	 int n=0;
	    	 int number=0;
	   
	    	 while(n!=1) {
	    		 
	    		 System.out.print("Please enter a command\n>");
	    		 String command=myScanner.nextLine();
	    	
	    		 //Case when given command is integer
	    		 if (command!=null && convertToInt(command)!=-1) {
	    			 number=convertToInt(command);
	    			 command="Integer";
	    		 }
	    		      		 
	    		 switch(command) {
	    		 
	    		 //When command is an integer
	    		 case "Integer":		 
	    			 //Pushing integer to the stack
	    			 listStack.push(number);
	    			 //System.out.println(listStack.toString());// just for testing	
	    			 break;
	    		 
	    		 //When command is + sign, sum two last items 
	    		 case "+":
	    			 
	    			 //Checking if stack is not empty and has at least two values
	    			 if(listStack.isEmpty()!=true && listStack.size()>=2) {				 
	    				
	    				int sum=0; //variable that will keep the sum of the last two elements in the stack
	    				//Loop to pop the last two values
	    				for(int i=0; i<2;i++) {
	    					sum+=listStack.pop();
	    				}
	    				//Pushing value to the stack
	    				listStack.push(sum);
	    			 }  
	    			// System.out.println(listStack.toString());//just for testing	
	    			 //If the stack does not have two items, do nothing	    			  			 
	    			 break;
	    		
	    		 //When command is * sign, it will multiply the last 2 items
	    		 case "*":
	    			 if(listStack.isEmpty()!=true && listStack.size()>=2) {
	    				 
		    				int mult=1; //variable that will keep the multiplication of the last two elements in the stack
		    				//Loop to pop the last two values
		    				for(int i=0; i<2;i++) {
		    					mult=mult*listStack.pop();
		    				}
		    				//Pushing value to the stack
		    				listStack.push(mult);
		    			 }
		    			 //System.out.println(listStack.toString());//testing		    			 
		    			 //If the stack does not have two items, do nothing	    			  			 
		    			 break;
	    			 
	    		 //Print stack
	    		 case "?":
	    			 System.out.println( listStack.toString());    			
	    			 break;
	    		
	    		//Pop and print the value 
	    		 case "P":
	    			 //Checking if stack is not empty
	    			 if(listStack.isEmpty()!=true) {
	    				 System.out.println( "\n"+listStack.pop()+"\n"); 
	    			 }  			 
	    			 break;
	    		
	    		 //End program
	    		 case "$":
	    			 System.out.println("\nYou decided to end the program. Bye!");
	    			 n=1;
	    			 break;
	    		
	    		 //If user inputs other values, ignore it
	    		 default:
	    			 break;	    		 
	    	 }//end of switch    	     		   
	   }//end of while
     }//end of test method
	
	
	/**
	 * Method that checks if input is an integer
	 * @param command
	 * @return
	 */
	public static int convertToInt(String command) {
		
		try{
			 // is an integer
			  int number = Integer.parseInt(command);
			  return number;
			 
			// not an integer
			} catch (NumberFormatException e) {
			 return -1;
			}

	}
}//end of main class


/**
 * An stack interface that it will be implemented in Stack class
 * @author MariamJael
 *
 */
interface Stack {
    //Fixed primitive value using wrapper class Integer -> use null instead for pop if list empty
    Integer size();

    boolean isEmpty();

    void push(Integer data);

    Integer pop();
}

/**
 * A linked list class that will create a single linked list
 * @author MariamJael
 *
 */
class SinglyLinkedList {

 class Node {
     private Integer data;
     private Node nextNode;

     Node(Integer data, Node nextNode) {
         this.data = data;
         this.nextNode = nextNode;
     }

     // Getter method to return element
     Integer getElement() {
         return data;
     }

     // Getter method to return next node
     Node getNextNode() {
         return nextNode;
     }

     // Setter method to set next node
     void setNextNode(Node node) {
         nextNode = node;
     }
 }

 private Node head = null;
 private Integer size = 0;

 public Integer size() {
     return size;
 }

 public boolean isEmpty() {
     return size == 0;
 }

 public void addFirst(Integer data) {
     // a new node linked to the new element 
     head = new Node(data, head);
     size++;
 }

 public Integer removeFirst() {
     if (isEmpty())
         return null;

     Node temp = head;
     head = head.getNextNode();

     size--;

     return temp.getElement();
 }
 
 public String toString() {			
    String listString="";
	Node currentHead=head;
	
	 while (currentHead!= null){ 
		    listString= listString+currentHead.data+"\n";
	        currentHead = currentHead.nextNode; 
	    } 
   return "\n"+listString;
}
}

/**
 * Class to hold integer values in stack data structure
 * @author MariamJael
 *
 */
class ListStack implements Stack {

 //Initializing linked list
 SinglyLinkedList list = new SinglyLinkedList();

 @Override
 public Integer size() {
     return list.size();
 }

 @Override
 public boolean isEmpty() {
     return list.isEmpty();
 }

 @Override
 public void push(Integer data) {
     // Add data to linked list at start (head), list holds data in stack structure
     list.addFirst(data);
 }

 @Override
 public Integer pop() {
     // Removes first element and returns it
     return list.removeFirst();
 }
 
 @Override
 public String toString() {
		
		return list.toString();
	}
}//End of ListsStack class




