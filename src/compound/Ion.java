package compound;

import java.util.HashMap;
import java.util.LinkedHashMap;

import element.Element;

public class Ion {
	private static final String[] ROMAN_NUMERALS = {"I", "II", "III", "IV", "V", "VI", "VII"};
	private LinkedHashMap<Element, Integer> elements;
	private double atomicMass;
	private String name;
	private String symbol;
	private int charge;
	
	//for monatomic ions which are non-metal
	public Ion(Element element){
		elements = new LinkedHashMap<Element, Integer>();
		if(!element.isMetal()){
			elements.put(element, new Integer(1));
			symbol = element.getSymbol();
			name = element.getIonName();
			if(element.getSymbol().equals("H")){
				name = element.getName();
			}
			atomicMass = element.getAtomicMass();
			//calculating the charge
			if(element.hasFormalCharge()){
				charge = element.getFormalCharge();
			} else if(element.hasOneCharge()){
				charge = element.getCharges()[0];
			} else {
				charge = -4;//carbon is the only other non-metal
			}
		} else {
			throw new IllegalArgumentException("Use the Ion(Element element, int charge) constructor for metal monatomic ions");
		}
	}
	
	//for monatomic ions which are metals (or Hydrogen with a charge of -1, aka Hydride)
	public Ion(Element element, int charge){
		elements = new LinkedHashMap<Element, Integer>();
		if(element.isMetal()){
			elements.put(element, new Integer(1));
			symbol = element.getSymbol();
			name = element.getIonName();
			if(!element.hasOneCharge()){
				name += " (" + ROMAN_NUMERALS[charge - 1] + ")";
			}
			if(element.hasCharge(charge)){
				this.charge = charge;
			} else if(element.getSymbol().equals("H") && charge == -1){
				elements.put(element, new Integer(1));
				symbol = element.getSymbol();
				name = element.getIonName();
				this.charge = charge;
			} else {
				throw new IllegalArgumentException("Invalid charge");
			}
		} else {
			throw new IllegalArgumentException("Use the Ion(Element element) constructor for non-metal monatomic ions");
		}
	}
	
	//for polyatomic ions with only 2 elements
	public Ion(Element e1, int e1Amount, Element e2, int e2Amount, String name, int charge){
		elements = new LinkedHashMap<Element, Integer>();
		elements.put(e1, new Integer(e1Amount));
		elements.put(e2, new Integer(e2Amount));
		this.name = name;
		this.charge = charge;
		
		//calculating atomic weight and symbol
		atomicMass = e1.getAtomicMass() * e1Amount + e2.getAtomicMass() * e2Amount;
		symbol = "";
		symbol += e1.getSymbol();
		if(e1Amount > 1){
			symbol += "" + e1Amount; 
		}
		symbol += e2.getSymbol();
		if(e2Amount > 1){
			symbol += "" + e2Amount;
		}
	}
	
	//for polyatomic ions with more than 2 elements
	public Ion(LinkedHashMap<Element, Integer> ionsElements, String name, int charge){
		elements = ionsElements;
		this.name = name;
		this.charge = charge;
		
		//calculating atomic weight and symbol
		atomicMass = 0;
		symbol = "";
		for(Element element : elements.keySet()){
			int amount = elements.get(element).intValue();
			atomicMass += element.getAtomicMass() * amount;
			symbol += element.getSymbol();
			if(amount > 1){
				symbol += "" + amount;
			}			
		}
	}
	
	//getters	
	public double getAtomicMass(){
		return atomicMass;
	}
	
	public String getName(){
		return name;
	}
	
	public String getSymbol(){
		return symbol;
	}
	
	public int getCharge(){
		return charge;
	}
	
	public HashMap<Element, Integer> getElements(){
		return (HashMap<Element, Integer>)elements;
	}
	
	//default overrides
	public String toString(){
		return symbol;
	}
}