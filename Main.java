
/*   
  Assignment 1 
  Class: Data struc & Alg           */


/**
 * Main class will test all methods
 * @author MariamJael
 *
 */
public class Main {

		

		public static LinkedList linkedlist;
		
		
		
			/**
			 * Code will be tested here
			 * @param args
			 */
			public static void main(String[] args) {
				// TODO Auto-generated method stub
		          
				 
				  //Creating a linkedlist object
				LinkedList linkedlist= new LinkedList();
				
				 
				//Testing add method
				linkedlist.add(114); 
				linkedlist.add(1212); 
				linkedlist.add(222); 
				linkedlist.add(17); 		
			      
				//testing toString method
				System.out.println("List 1:");
				System.out.println(linkedlist);		
				
				//testing remove method
				linkedlist.remove(222);
				System.out.println();
				System.out.println("List after removing element 222");
				System.out.println(linkedlist);	
				
				linkedlist.remove(17);
				System.out.println();
				System.out.println("List after removing element 17");
				System.out.println(linkedlist);	
				
				//testing size method
				System.out.println();
				System.out.println("Size of linkedlist1: "+linkedlist.size());//output: 2
				
				linkedlist.add(114); 
				linkedlist.add(1212); 
				System.out.println();
				
				System.out.println("List1 after adding elements 114 and 1212");
				System.out.println(linkedlist);	
				
				System.out.println();
				System.out.println("Size of linkedlist1: "+linkedlist.size());//output: 4
				
				
				//testing contain method
				System.out.println();
				System.out.println("List1 contains element 114: "+linkedlist.contain(114));//output: true
				System.out.println("List1 contains element 222: "+linkedlist.contain(222));//output: false
				System.out.println("List1 contains element 5: "+linkedlist.contain(5));//output: false
			    System.out.println();
			    
				//Creating 2 linkedlists
				LinkedList linkedlist2= new LinkedList();
				
				//Adding values method
				linkedlist2.add(114); 
				linkedlist2.add(1212); 
				linkedlist2.add(114); 
				linkedlist2.add(1212); 
				
				//testing toString method
				System.out.println("List 2 is:");
				System.out.println(linkedlist2);	
				
				LinkedList linkedlist3= new LinkedList();
				
				//Adding values method
				linkedlist3.add(1); 
				linkedlist3.add(2); 
				linkedlist3.add(3); 
				linkedlist3.add(4); 
				
				//testing toString method
				System.out.println();
				System.out.println("List 3 is:");
				System.out.println(linkedlist3);
				
				//testing compare method
				System.out.println();
				//output should be true
				System.out.println("List1 is equals to list2: "+linkedlist.compare(linkedlist2));
				
				System.out.println();
				//output should be false
				System.out.println("List2 is equals to list3: "+linkedlist2.compare(linkedlist3));
				
				
				
			}

}

class LinkedList {
	
	
	
	//Node currentHead;
	
	//#1 Constructor
	public LinkedList() {
		
	}
	
	/**
	 * Node class
	 * @author MariamJael
	 *
	 */
	static public class Node{
		
		
		int element;
		Node next;		
	
	}
	
	static int counter=-1;//this will count elements in linkedlist
	Node head = null;//erased static part
	
	
	
	/**
	 * #2 Add method which append new elements to the head of the linkedlist
	 * @param element
	 */
	public void add(int element) {
		
		 
		  Node newNode = new Node(); 
	      newNode.element = element; 
	      newNode.next = head; 
	      head = newNode; 
	      
	      if(newNode!=null) {
	    	  increaseCounter();//increasing counter
	      }
	}

	/**
	 * Getter of counter
	 * @return
	 */
	private static int getCounter() {
		return counter;
	}
 
	/**
	 * Helper method that increases number of elements in counter
	 */
	private static void increaseCounter() {
		counter++;
	}
 
	/**
	 * Helper method that decreases number of elements in counter
	 */
	private void decreaseCounter() {
		counter--;
	}
	
	
	/**
	 * #3 Remove method, it will delete the first occurrence of a given value
	 * @param element
	 */
	public void remove(int element) {
		
		//Thinking process:
		//I first made this code to consider case when linkedlist is empty
		
	    /*
		if(head==null) {	
			System.out.println("LinkedList is empty");
		}
		*/
		
		
		//Case when linkedlist has only one element and it is the same as given element	
	    if(head!=null && head.element==element) {
	    	head=head.next; //this will eliminate the current element by changing head to next node
	    	//head.toString();//chekc this
	    }
				
		Node currentHead=head;//pointer to current head
		
		//Case when linkedlist has more than one element
		while(currentHead!=null && currentHead.next!=null) {
			
			//Original code for if condition
			//if(currentHead.element==element) {	
			    //currentHead=currentHead.next;
			    //break;
			//I changed to the following
			
			
			//Checking if next node has given element
			if(currentHead.next.element==element) {				
      			//pointer will point to the next.next element which will get rid of currentHead.next element
				currentHead.next=currentHead.next.next;
				decreaseCounter();//decreasing counter
				break;
			}
			else {
				currentHead=head.next;//updating head in case we don't find given element
			}		
		}		
	}
	
	
	//tested
	/**
	 * #4 Returns the size of the linkelist
	 * @return 0 if linkedlist is empty or the size of linkedlist
	 */
	public int size() {
		
		/*Node currentHead=head;
		int counter=0;
		
		 while (currentHead!= null){ 
			    counter++;
			    currentHead=currentHead.next;//moving to next node
		 } 
		return counter;*/
	
	
	return getCounter();
	
	}
	
	
	
	/**
	 * #5 This method checks if the arayList has given value or not
	 * @return true if given element is in the linkedlist and false otherwise
	 */
	public boolean contain(int element) {
			
		Node currentHead=head;
		
		//going to each node
		while (currentHead != null)
        {
			//case when element is in the list
            if (currentHead.element == element)
                return true;    //data found
            currentHead = currentHead.next;
        }
        return false;  
	}
	
	
	
	//tested
	@Override
	/**
	 * #6 Returns the element value of linkedlist as a string
	 */
	public String toString() {
		
		String listString="";
		Node currentHead=head;
		
		 while (currentHead!= null){ 
			    listString= listString+currentHead.element+"->";
		        currentHead = currentHead.next; 
		    } 
	     return listString;
		}
	
	/**
	 * #7 This method will compare two linkedlists
	 * @param A
	 * @param B
	 * @return true if two list are the same and false otherwise
	 */
	public boolean compare(LinkedList linkedlist2) {
		
		Node list1Node=this.head;
		Node list2Node=linkedlist2.head;
		
		
		while(list1Node!= null && list2Node!= null){
			//comparing each element
		    if(list1Node.element!=list2Node.element){
		        return false;
		    }
		    list1Node= list1Node.next;//going to next node
		    list2Node = list2Node.next;//going to next node
		}
		return true;
		
		
	}

	
}