/**
* This class creates a priority queue which will store all of the state values (POOR, FAIR, GOOD, and VGOOD)
* in their separate queues. This class is called in Main and it includes the insert(), remove(), 
* printQueue(), isEmpty(), and isFull(). 
*
* @author <Fernando Jimenez Mendez>
* @version <February 20, 2021>
*/
public class PriorityQ {
	
	public int max;
	private State[] priorityQ;
	private int numItems;
	
	/**
	* This constructor takes the size of the queue being created, which would generally be determined
	* by the amount of values that some states qualify for, so it varies. It then sets up the maximum size 
	* of the queue, a number of items variable, and creates a new queue array with the new size 
	* being taken from the parameter.
	*
	* @param int size
	* @return None
	*/
	
	public PriorityQ(int size) {
		
		max = size;
		priorityQ = new State[50];
		numItems = 0;
	}
	
	/**
	* This method inserts a state object in the queue array.
	*
	* @param State object
	* @return None
	*/
	
	public void insert(State val) {
		
		priorityQ[numItems++] = val;
	}
	
	/**
	* This method shifts all of the state objects, effectively removing the state object that came
	* from the parameter. It then returns a state object.
	*
	* @param None
	* @return State object
	*/
	
	public State remove() {
		
		double minFound = priorityQ[0].getDeathRate();
		
		for(int i = 0; i < numItems; i++) {//Finds minimum value in priorityQ
			
			minFound = Math.min(minFound, priorityQ[i].getDeathRate());
		}
		
		int index = 0;
		
		for(int i = 0; i < numItems; i++) {//Finds index of minimum value in priorityQ
			
			if(minFound == priorityQ[i].getDeathRate()) {
				break;
			}
			else {
				index++;
			}
		}
		
		State val = priorityQ[index]; //value being returned
		
		while(priorityQ[index + 1] != null) {			
			
			priorityQ[index] = priorityQ[index + 1];
			index++;
		}
		
		priorityQ[numItems - 1] = null;
		
		--numItems;
		
		return val;
	}
	
	/**
	* This method prints the entire queue of states in a neat format.
	*
	* @param None
	* @return None
	*/
	
	public void printQueue() {
		
		System.out.println("Name\t\tMHI\tVCR\tCFR\t\tCase Rate\tDeath Rate ");
		System.out.println("--------------------------------------------------------------------------");
		
		for(int i = 0; i < numItems; i++) { //sets information on states
			priorityQ[i].setStateInfo();
		}
		
		for(int i = 0; i < numItems; i++) { //prints state queues
			
			priorityQ[i].printStatesReport();
		}
		
	}
	
	/**
	* This method checks if the queue is empty. It returns true if it's false by checking if there
	* are zero items in the queue.
	*
	* @param None
	* @return Boolean value
	*/
	
	public boolean isEmpty() {
		
		return (numItems == 0);
	}
	
	/**
	* This method checks if the queue is full. It returns true if the queue is full by checking if 
	* the number of items matches the maximum amount of elements in the queue array. 
	*
	* @param None
	* @return Boolean value
	*/
	
	public boolean isFull() {
		
		return (numItems == max);
	}

}
