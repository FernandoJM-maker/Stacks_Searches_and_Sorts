/**
* This class creates a stack which will store all of the 4 queue values (POOR, FAIR, GOOD, and VGOOD)
* in their respective order. This class is called in Main and it includes the push(), pop(), printStack(),
* isEmpty(), and isFull(). 
*
* @author <Fernando Jimenez Mendez>
* @version <February 20, 2021>
*/
public class Stack {
	
	private int max;
	private State[] stackArr;
	private int top;
	
	/**
	* This constructor takes the size of the stack being created, which would generally be 50 for all
	* of the states.It then sets up the maximum size of the stack, the top of the stack, and creates
	* a new stack array with the new size being taken from the parameter.
	*
	* @param int size
	* @return None
	*/
	
	public Stack(int size) {
		
		max = size;
		top = -1;
		stackArr = new State[max];
		
	}
	
	/**
	* This method inserts a state object to the top of the stack.
	*
	* @param State object
	* @return None
	*/
	
	public void push(State val) { //PUSH METHOD
		
		stackArr[++top] = val;
	}
	
	/**
	* This method takes out the element at the top of the array and returns its value.
	*
	* @param None
	* @return State object 
	*/
	
	public State pop() {
		
		return stackArr[top--];
	}
	
	/**
	* This method prints the entire stack.
	*
	* @param None
	* @return None
	*/
	
	public void printStack() {
		
		System.out.println("\nStack contents: \n");
		
		System.out.println("Name\t\tMHI\tVCR\tCFR\t\tCase Rate\tDeath Rate ");
		System.out.println("--------------------------------------------------------------------------");
		
		for(int i = top; i > -1; i--) { //sets information on states
			stackArr[i].setStateInfo();
		}
		
		for(int i = top; i > -1; i--) { //prints state stack
			
			stackArr[i].printStatesReport();
		}
		
	}
	
	/**
	* This method checks if the stack is empty by checking if the top of the array is negative one.
	* Returns true if it is empty.
	*
	* @param None
	* @return Boolean value
	*/
	
	public boolean isEmpty() {
		
		return (top == -1);
	}
	
	/**
	* This method checks if the stack is full by checking if the top of the stack has reached the 
	* end of the array. Returns true if the queue is full.
	*
	* @param None
	* @return Boolean value
	*/
	
	public boolean isFull() {
		
		return (top == max - 1);
	}
}
