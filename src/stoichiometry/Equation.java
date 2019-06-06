package stoichiometry;

import java.util.ArrayList;
import java.util.HashMap;
import compound.Compound;
import element.Element;

public class Equation {
	private HashMap<Compound, Integer> reactants;
	private HashMap<Compound, Integer> products;
	private String equationAsString;
	
	public Equation(HashMap<Compound, Integer> reactants, HashMap<Compound, Integer> products){
		this.reactants = reactants;
		this.products = products;
		if(!isBalanced()){
			throw new IllegalArgumentException("Equasion is not balanced");
		}
		calcString();		
	}
	
	public Equation(String asString){
		equationAsString = asString;
		//makes string into tokens
		String[] equationAsTokens = asString.split(" ");
		//divides it into reactants and products
		ArrayList<String> reactantsAsTokens = new ArrayList<String>();
		ArrayList<String> productsAsTokens = new ArrayList<String>();
		boolean hasReachedEquals = false;
		for(String compoundToken : equationAsTokens){
			if(compoundToken.equals("-->")){
				hasReachedEquals = true;
			} else if(!compoundToken.equals("+")){
				if(hasReachedEquals){
					productsAsTokens.add(compoundToken);
				} else {
					reactantsAsTokens.add(compoundToken);
				}
			}
		}
		if(!hasReachedEquals){
			throw new IllegalArgumentException("Equation did not contain \"-->\"");
		}
		//turns tokens into elements and stores them in the products and reactants HashMaps
		for(String compoundToken : reactantsAsTokens){
			boolean addedCompoundToReactants = false;
			//splits compound into each half of the compound (elements/ions)
			String firstHalf = "";
			String secondHalf = "";

			//Idea: 1st, do NH4 test and have special case for that
			//then find the 2nd capital letter and split it that way
			
			if(compoundToken.substring(0, 1).equals("(")) {//meaning NH4 is the cation and there are more than 1
				
			} else if(compoundToken.substring(0, 3).equals("NH4")) {
				
			} else {
			
			}
		}
		
	}
	
	//figures out what to print out for toString()
	private void calcString(){
		equationAsString = "";
		int compoundsRemaining = reactants.size();
		for(Compound compound : reactants.keySet()){
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
	
	private boolean isBalanced(){
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
	
	public String toString(){
		return equationAsString;
	}
	
	private boolean isInt(String str){
		try {
			int strAsInt = Integer.parseInt(str);
		} catch (NumberFormatException e){
			return false;
		}
		return true;
	}
}