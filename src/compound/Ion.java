package compound;

import java.util.LinkedHashMap;

import element.Element;

public class Ion {
	private static final String[] ROMAN_NUMERALS = {"I", "II", "III", "IV", "V", "VI", "VII"};
	private LinkedHashMap<Element, Integer> elements;
	private double atomicWeight;
	private String name;
	private String symbol;
	private int charge;
	
	//for monotomic ions which are non-metal
	public Ion(Element element){
		elements = new LinkedHashMap<Element, Integer>();
		if(!element.isMetal()){
			elements.put(element, new Integer(1));
			symbol = element.getSymbol();
			name = element.getIonName();
			atomicWeight = element.getAtomicWeight();
			//calculating the charge
			if(element.hasFormalCharge()){
				charge = element.getFormalCharge();
			} else if(element.hasOneCharge()){
				charge = element.getCharges()[0];
			} else {
				charge = -4;//carbon is the only other non-metal
			}
		} else {
			throw new IllegalArgumentException("Use the Ion(Element element, int charge) constructor for metal monotomic ions");
		}
	}
	
	//for monotomic ions which are metals
	public Ion(Element element, int charge){
		elements = new LinkedHashMap<Element, Integer>();
		if(element.isMetal()){
			elements.put(element, new Integer(1));
			symbol = element.getSymbol();
			name = element.getIonName();
			if(!element.hasOneCharge()){
				name += " (" + ROMAN_NUMERALS[charge - 1] + ") ";
			}
			if(element.hasCharge(charge)){
				this.charge = charge;
			} else {
				throw new IllegalArgumentException("Invalid charge");
			}
		} else {
			throw new IllegalArgumentException("Use the Ion(Element element) constructor for non-metal monotomic ions");
		}
	}
	
	//for polyatomic ions
	public Ion(LinkedHashMap<Element, Integer> ionsElements, String name, int charge){
		elements = new LinkedHashMap<Element, Integer>();
		elements = ionsElements;
		this.name = name;
		this.charge = charge;
		
		//calculating atomic weight and symbol
		atomicWeight = 0;
		symbol = "";
		for(Element element : elements.keySet()){
			int amount = elements.get(element).intValue();
			atomicWeight += element.getAtomicWeight() * amount;
			symbol += element.getSymbol();
			if(amount > 1){
				symbol += "" + amount;
			}			
		}
	}
	
	//getters	
	public double getAtomicWeight(){
		return atomicWeight;
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
	
	//default overrides
	public String toString(){
		return symbol;
	}
}