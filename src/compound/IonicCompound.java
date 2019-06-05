package compound;

import java.util.HashMap;
import java.util.LinkedHashMap;

import element.Element;

public class IonicCompound extends Compound {
	private LinkedHashMap<Ion, Integer> ions;
	private int charge;

	//cation is positive, anion is negative
	public IonicCompound(Ion cat, int catAmount, Ion an, int anAmount){
		ions = new LinkedHashMap<Ion, Integer>();
		ions.put(cat, new Integer(catAmount));
		ions.put(an, new Integer(anAmount));
		
		//setting charge and making sure it is neutral
		int catCharge = cat.getCharge() * catAmount;
		int anCharge = an.getCharge() * anAmount;
		if(!(catCharge > 0 && anCharge < 0)){
			throw new IllegalArgumentException("The cation must have a positive charge and the anion must have a negative charge");
		}
		charge = catCharge + anCharge;
		if(!isNeutral()){
			throw new IllegalArgumentException("Ionic compounds must have a neutral charge");
		}
		
		//calculating name and symbol
		name = cat.getName() + " " + an.getName();
		symbol = cat.getSymbol();
		if(catAmount > 1){
			symbol += "" + catAmount;
		}
		if(anAmount > 1){
			if(an.getElements().size() > 1){//make sure only polyatomic ions get the parentheses
				symbol += "(" + an.getSymbol() + ")" + anAmount;
			} else {
				symbol += an.getSymbol() + anAmount;
			}
		} else {
			symbol += an.getSymbol();
		}
	}
	
	private boolean isNeutral(){
		return charge == 0;
	}
	
	public HashMap<Element, Integer> getElements(){
		HashMap<Element, Integer> elements = new HashMap<Element, Integer>();
		for(Ion ion : ions.keySet()){
			HashMap<Element, Integer> ionsElements = ion.getElements();
			for(Element element : ionsElements.keySet()){
				if(!elements.containsKey(element)){
					elements.put(element, ionsElements.get(element));
				} else {
					elements.replace(element, new Integer(elements.get(element).intValue() + ionsElements.get(element).intValue()));
				}
			}
		}
		return elements;
	}
}
