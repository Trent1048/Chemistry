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
}