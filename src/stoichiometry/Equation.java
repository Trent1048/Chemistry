package stoichiometry;

import java.util.HashMap;
import compound.Compound;
import element.Element;

public class Equation {
	private HashMap<Compound, Integer> reactants;
	private HashMap<Compound, Integer> products;
	private HashMap<Compound, Integer> equation;
	private String equationAsString;
	private HashMap<String, Compound> compounds;
	private Compound[] compoundsArr;
	
	public Equation(HashMap<Compound, Integer> reactants, HashMap<Compound, Integer> products){
		this.reactants = reactants;
		this.products = products;
		equation = new HashMap<Compound, Integer>();
		equation.putAll(reactants);
		equation.putAll(products);
		if(!isBalanced()){
			throw new IllegalArgumentException("Equasion is not balanced");
		}
		compoundsArr = new Compound[equation.size()];
		int comp = 0;
		for(Compound compound : equation.keySet()){
			compoundsArr[comp] = compound;
			comp++;
		}
		calcString();		
	}
	
	//figures out what to print out for toString()
	private void calcString(){
		compounds = new HashMap<String, Compound>();
		equationAsString = "";
		int compoundsRemaining = reactants.size();
		for(Compound compound : reactants.keySet()){
			compounds.put(compound.getSymbol(), compound);
			compoundsRemaining--;
			int amount = reactants.get(compound).intValue();
			if(amount > 1){
				equationAsString += "" + amount;
			}
			equationAsString += compound.toString() + " ";
			if(compoundsRemaining > 0){
				equationAsString += "+ ";
			}
		}
		equationAsString += "--> ";
		compoundsRemaining = products.size();
		for(Compound compound : products.keySet()){
			compounds.put(compound.getSymbol(), compound);
			compoundsRemaining--;
			int amount = products.get(compound).intValue();
			if(amount > 1){
				equationAsString += "" + amount;
			}
			equationAsString += compound.toString();
			if(compoundsRemaining > 0){
				equationAsString += " + ";
			}
		}
	}
	
	public boolean isBalanced(){
		HashMap<Element, Integer> reactantsElements = new HashMap<Element, Integer>();
		HashMap<Element, Integer> productsElements = new HashMap<Element, Integer>();
		
		//makes list of all elements in reactants
		for(Compound compound : reactants.keySet()){
			HashMap<Element, Integer> compoundsElements = compound.getElements();
			for(Element element : compoundsElements.keySet()){
				if(reactantsElements.containsKey(element)){
					reactantsElements.replace(element, new Integer(compoundsElements.get(element).intValue() * reactants.get(compound).intValue() + reactantsElements.get(element).intValue()));
				} else {
					reactantsElements.put(element, new Integer(compoundsElements.get(element).intValue() * reactants.get(compound).intValue()) );
				}
			}
		}
		
		//makes list of all elements in products
		for(Compound compound : products.keySet()){
			HashMap<Element, Integer> compoundsElements = compound.getElements();
			for(Element element : compoundsElements.keySet()){
				if(productsElements.containsKey(element)){
					productsElements.replace(element, new Integer(compoundsElements.get(element).intValue() * products.get(compound).intValue() + productsElements.get(element).intValue()));
				} else {
					productsElements.put(element, new Integer(compoundsElements.get(element).intValue() * products.get(compound).intValue()));
				}
			}
		}
		return reactantsElements.equals(productsElements);
	}
	
	//helpful static methods
	public static double convertToMols(Element element, double grams){
		return grams / element.getAtomicMass();
	}
	
	public static double convertToMols(Compound compound, double grams){
		return grams / compound.getAtomicMass() ;
	}
	
	public static double convertToGrams(Element element, double moles){
		return moles * element.getAtomicMass();
	}
	
	public static double convertToGrams(Compound compound, double moles){
		return moles * compound.getAtomicMass();
	}
	
	/* takes in the string value of the compound that is known, how much of that compound
	 * there is, if that value is in mols or grams, what compound to solve for, and to return in mols or in grams */
	public double solve(String knownCompound, double amountOfCompound, boolean isInMols, String unknownCompound, boolean solveForMols){
	
		if(!(compounds.containsKey(knownCompound) && compounds.containsKey(unknownCompound))){
			throw new IllegalArgumentException("Equation does not contain one or more of these compounds");
		}
		Compound kC = getCompound(knownCompound);
		Compound uC = getCompound(unknownCompound);
		double knownMols = amountOfCompound;
		
		if(!isInMols){
			knownMols = convertToMols(kC, amountOfCompound);
		}
		
		double molsOfUnknown = knownMols * ((double)equation.get(uC) / (double)equation.get(kC));
		if(!solveForMols){
			return convertToGrams(uC, molsOfUnknown);
		}
		return molsOfUnknown;
	}

	/* same as normal solve except it takes in a HashMap<String, Double> of the reactants as strings
	 * and the corresponding amount of mols/grams */
	public double solveLR(HashMap<String, Double> reactantsWithAmounts, boolean isInMols, String unknownCompound, boolean solveForMols){
		int numOfCompounds = reactantsWithAmounts.size();
		String[] compoundsInE = new String[numOfCompounds];
		double[] mols = new double[numOfCompounds];
		
		int compoundNum = 0;
		for (String c : reactantsWithAmounts.keySet()) {
			Compound compound = getCompound(c);
			if(compound == null){
				throw new IllegalArgumentException("Compound " + c +" could not found in the equation");
			}
			double amount = reactantsWithAmounts.get(c).doubleValue();
			
			compoundsInE[compoundNum] = c;
			mols[compoundNum] = amount;
			
			if(!isInMols){
				mols[compoundNum] = convertToMols(compound, amount);
			}
			compoundNum++;
		}
				
		String lr = compoundsInE[0];
		double lrAmount = mols[0];
		
		/* solves all the compounds for every other compound and if that number is more than the amount there is, 
		 * that compound is the lr. returns solve for the unknown compound using the lr */
		for(int c = 0; c < numOfCompounds; c++){
			for(int cBefore = 0; cBefore < c; cBefore++){
				double solved = solve(compoundsInE[c], mols[c], true, compoundsInE[cBefore], true);
				if(solved > mols[cBefore]){
					lr = compoundsInE[cBefore];
					lrAmount = mols[cBefore];
				}
			}
			for(int cAfter = c + 1; cAfter < numOfCompounds; cAfter++){
				double solved = solve(compoundsInE[c], mols[c], true, compoundsInE[cAfter], true);
				if(solved > mols[cAfter]){
					lr = compoundsInE[cAfter];
					lrAmount = mols[cAfter];
				}
			}
		}
		return solve(lr, lrAmount, true, unknownCompound, solveForMols);
	}
	
	//getters
	public HashMap<Compound, Integer> getReactants(){
		return reactants;
	}
	
	public HashMap<Compound, Integer> getProducts(){
		return products;
	}
	
	public HashMap<Compound, Integer> getEquation(){
		return equation;
	}
	
	public Compound getCompound(String compound){
		return compounds.get(compound);
	}
	
	public Compound[] getCompounds(){
		return compoundsArr;
	}
	
	public String toString(){
		return equationAsString;
	}
}