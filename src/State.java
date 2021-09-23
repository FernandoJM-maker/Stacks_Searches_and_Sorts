/**
* <p>
* The state class will store information of every state, which is used later in the program to
* compare all 50 states. Fields for comparison include state name, capitol, region, median income,
* case rate fatality, death rate, and the case rate of COVID-19. There are also get/set methods for 
* each field.
* <p>
*
* @author <Fernando Jimenez Mendez>
* @version <February 20, 2021>
*/

public class State {
	
	public String stateName, stateCapitol, stateRegion;
	private double medianIncome, population, cases, deaths; 
	public double crimeRate;
	public double CFR;
	public double deathRate;
	public double caseRate;
	
	String stateInfoArr[] = new String[9];
	
	/**
	* <p>
	* The constructor of this class will take a String as its parameter and split it into an
	* array so that each field can be distributed accordingly to their proper get/set methods.
	* <p>
	*
	* @param String state
	* @return Nothing
	*/
	
	public State(String state){ //Constructor
		
		stateInfoArr = state.split(",");
	}
	
	/**
	* This method sets the case rate of the state by dividing cases by population and multiplying that
	* by 100000.
	*
	* @param None
	* @return None
	*/
	
	private void setCaseRate() {
			
		caseRate = cases/population * 100000;
	}
	
	/**
	* This method gets the case rate and calls the setCaseRate() beforehand.
	*
	* @param None
	* @return double case rate
	*/
	
	public double getCaseRate() {
		setCaseRate();
		return caseRate;
	}
	
	/**
	* This method sets the death rate by dividing deaths by population and multiplying that by
	* 100000.
	*
	* @param None
	* @return None
	*/
		
	private void setDeathRate() {
			
		deathRate = (deaths/population) * 100000;
	}
	
	/**
	* This method gets the death rate and calls the setDeathRate() beforehand.
	*
	* @param None
	* @return double deathRate
	*/
	
	public double getDeathRate() {
		setDeathRate();
		return deathRate;
	}
	
	/**
	* This method sets the critical fatality rate by dividing deaths by cases.
	*
	* @param None
	* @return None
	*/
	
	protected void setCFR() {
		CFR = deaths/cases;
	}
	
	/**
	* This method gets the critical fatality rate and calls the setCFR() beforehand.
	*
	* @param None
	* @return Double CFR
	*/
	
	public double getCFR() {
		setCFR();
		return CFR;
	}
	
	/**
	* This method sets the state name.
	*
	* @param None
	* @return None
	*/
	
	private void setStateName() {
		
		stateName = stateInfoArr[0];
	}
	
	/**
	* This method gets the state name and calls the setStateName() beforehand.
	*
	* @param None
	* @return String stateName
	*/
	
	public String getStateName() {
		setStateName();
		return stateName;
	}
	
	/**
	* This method sets the stateCapitol name.
	*
	* @param None
	* @return None
	*/
	
	private void setStateCapitol() {
		
		stateCapitol = stateInfoArr[1];
	}
	
	/**
	* This method sets the state region name.
	*
	* @param None
	* @return None
	*/
	
	private void setStateRegion() {
		
		stateRegion = stateInfoArr[2];
	}
	
	/**
	* This method sets the population of the array by parsing it as an integer from a String.
	*
	* @param None
	* @return None
	*/
	
	private void setPopulation() {
		
		population = Double.parseDouble(stateInfoArr[4]);
	}
	
	/**
	* This method sets the cases of the state by parsing it as a double from a string.
	*
	* @param None
	* @return None
	*/
	
	private void setCases() {
		
		cases = Double.parseDouble(stateInfoArr[5]);
	}
	
	/**
	* This method sets the deaths in a state by parsing it from a string.
	*
	* @param None
	* @return None
	*/
	
	private void setDeaths() {
		
		deaths = Double.parseDouble(stateInfoArr[6]);
	}
	
	/**
	* This method sets the median income of the households in that state by parsing it from a
	* string to a double.
	*
	* @param None
	* @return None
	*/
	
	private void setMedianIncome() {
		
		medianIncome = Double.parseDouble(stateInfoArr[7]);
	}
	
	/**
	* This method gets the median income of the households in that state. It calls getMedianIncome()
	* beforehand.
	*
	* @param None
	* @return double medianIncome
	*/
	
	public double getMedianIncome() {
		setMedianIncome();
		return medianIncome;
	}
	
	/**
	* This method sets the violent crime rate by parsing it from a string to a double.
	*
	* @param None
	* @return None
	*/
	
	private void setViolentCrimeRate() {
		
		crimeRate = Double.parseDouble(stateInfoArr[8]);
	}
	
	/**
	* This method gets the violent crime rate and calls setViolentCrimeRate() beforehand.
	*
	* @param None
	* @return double crimeRate
	*/
	
	public double getViolentCrimeRate() {
		setViolentCrimeRate();
		return crimeRate;
	}
	
	/**
	*<p>
	* This method sets up all of the data variables in the states by using the set() methods
	* for each of their specific values
	*<p>
	*
	* @param None
	* @return None
	*/
	
	public void setStateInfo() {
		
		setStateName();
		setStateCapitol();
		setStateRegion();
		setPopulation();
		setCases();
		setDeaths();
		setMedianIncome();
		setViolentCrimeRate();
		
	}
	
	
	/**
	* This method is used in the stack and queue classes to print each state out in a report
	* using the right format. There are no parameters/return values.
	*
	* @param None
	* @return None
	*/
	
	public void printStatesReport() {
		
		setStateInfo();
			
		for(int j = 0; j < 6; j++) {				
				
			if(j == 0) {
				
				System.out.printf("%-8s\t", stateName);
			}
				
			else if(j == 1) {
				System.out.printf("%.0f\t", medianIncome);
			}
				
			else if(j == 2) {
				System.out.printf("%.1f\t", crimeRate);
			}
				
			else if(j == 3) {
				System.out.printf("%.6f\t", getCFR());
			}
				
			else if(j == 4) {
				
				if(medianIncome == 64894 || medianIncome == 58275) {
					System.out.printf("%.2f\t", getCaseRate());
				}
				
				else {
					System.out.printf("%.2f\t\t", getCaseRate());
				}
				
			}
				
			else if(j == 5) {
				System.out.printf("%.2f\n", getDeathRate());
				System.out.println();
			}
		}
	}//End of method	
}
