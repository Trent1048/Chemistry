package stoichiometry;

import java.util.HashMap;
import compound.Compound;
import element.Element;

public class Equation {
	private HashMap<Compound, Integer> reactants;
	private HashMap<Compound, Integer> products;
	
	public Equation(HashMap<Compound, Integer> reactants, HashMap<Compound, Integer> products){
		this.reactants = reactants;
		this.products = products;
		if(!isBalanced()){
			throw new IllegalArgumentException("Equasion is not balanced");
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
					reactantsElements.replace(element, new Integer(compoundsElements.get(element).intValue() + reactantsElements.get(element).intValue()));
				} else {
					reactantsElements.put(element, compoundsElements.get(element));
				}
			}
		}
		
		//makes list of all elements in products
		for(Compound compound : products.keySet()){
			HashMap<Element, Integer> compoundsElements = compound.getElements();
			for(Element element : compoundsElements.keySet()){
				if(productsElements.containsKey(element)){
					productsElements.replace(element, new Integer(compoundsElements.get(element).intValue() + productsElements.get(element).intValue()));
				} else {
					productsElements.put(element, compoundsElements.get(element));
				}
			}
		}
		
		return reactantsElements.equals(productsElements);
	}
}