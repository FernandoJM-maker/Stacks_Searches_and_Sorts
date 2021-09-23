/**
* COP 3530: Project 2 – Stacks and PriorityQ Queues
* <p>
* This is the Driver class of the entire program. This class is used to obtain the user input,
* create objects from other classes, and ultimately exit the program at the end. This class gives us
* an output of all the states shown in their respective categories (POOR, FAIR, GOOD, VGOOD). After
* that, a stack is made with all of those states inserted. The last task that this program completes
* would be to print the entire stack of all 50 states.
*
* @author <Fernando Jimenez Mendez>
* @version <February 20, 2021>
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project2 {
	
	static Scanner in = new Scanner(System.in);
	static String[] myArr = new String[50];

	public static void main(String[] args) {
		
		String fileName = new String();
		
		System.out.println("COP3530 Project 1");
		System.out.println("Instructor Xudong Liu\n\n");
		System.out.println("Stacks and Priority Queues\n");
		
		System.out.print("Please enter the name of the CSV file: ");
		fileName = in.next();
		System.out.println();
		
		Scanner inFile = null;
		try {
			
			inFile = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e){
			
			System.out.println("File was not found!");
			System.exit(1);
		}
		
		inFile.nextLine();
		inFile.useDelimiter("\n");
		int i = 0;
		while(inFile.hasNext()) {
			
			myArr[i] = inFile.next();		
			i++;
		}
		
		State[] state = new State[50];
		
		for(int j = 0; j < 50; j++) {
			
			state[j] = new State(myArr[j]);
		}
		
		for(int j = 0; j < 50; j++) {
			state[j].setStateInfo();
		}
		
		//************************************
		
		int tempNum = 0;
		
		for(int j = 0; j < 50; j++) { 
			
			if(state[j].getDeathRate() >= 150) {
				tempNum++;
			}
		}
		
		
		PriorityQ POOR = new PriorityQ(tempNum);
		
		
		for(int j = 0; j < 50; j++) { //Inserting on POOR group
			
			if(state[j].getDeathRate() >= 150) {
				
				POOR.insert(state[j]);
			}
		}
		
		System.out.println("\nPOOR Priority Queue Contents: \n");
		POOR.printQueue();
		
		//**************************************
		
		tempNum = 0;
		
		for(int j = 0; j < 50; j++) {
			
			if(state[j].getDeathRate() >= 100 && state[j].getDeathRate() < 150) {
				tempNum++;
			}
		}
		
		PriorityQ FAIR = new PriorityQ(tempNum);
		
		for(int j = 0; j < 50; j++) { //Inserting on FAIR group
			
			if(state[j].getDeathRate() >= 100 && state[j].getDeathRate() < 150) {
				
				FAIR.insert(state[j]);
			}
		}
		
		System.out.println("\nFAIR Priority Queue Contents: \n");
		FAIR.printQueue();
		
		//****************************************
		
		tempNum = 0;
		
		for(int j = 0; j < 50; j++) {
			
			if(state[j].getDeathRate() >= 50 && state[j].getDeathRate() < 100) {
				tempNum++;
			}
		}
		
		PriorityQ GOOD = new PriorityQ(tempNum);
		
		for(int j = 0; j < 50; j++) { //Inserting on GOOD group
			
			if(state[j].getDeathRate() >= 50 && state[j].getDeathRate() < 100) {
				
				GOOD.insert(state[j]);
			}
		}
		
		System.out.println("\nGOOD Priority Queue Contents: \n");
		GOOD.printQueue();
		
		//******************************************
		
		tempNum = 0;
		
		for(int j = 0; j < 50; j++) {
			
			if(state[j].getDeathRate() < 50) {
				tempNum++;
			}
		}
		
		PriorityQ VGOOD = new PriorityQ(tempNum);
		
		for(int j = 0; j < 50; j++) { //Inserting on VGOOD group
			
			if(state[j].getDeathRate() < 50) {
				
				VGOOD.insert(state[j]);
			}
		}
		
		System.out.println("\nVGOOD Priority Queue Contents: \n");
		VGOOD.printQueue();
		
		//****************************************************
		
		Stack stack = new Stack(50);
		
		while(POOR.isEmpty() == false) {
			
			stack.push(POOR.remove());
		}
		
		while(FAIR.isEmpty() == false) {
			
			stack.push(FAIR.remove());
		}
		
		while(GOOD.isEmpty() == false) {
			
			stack.push(GOOD.remove());
		}
		
		while(VGOOD.isEmpty() == false) {
			
			stack.push(VGOOD.remove());
		}
		
		stack.printStack();
		
		in.close();
		inFile.close();
		
	}//End of method

}
