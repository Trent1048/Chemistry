package compound;

import java.util.LinkedHashMap;

import element.Element;

public class Ion {
	private LinkedHashMap<Element, Integer> elements;
	private double atomicWeight;
	private String name;
	private String symbol;
	private int charge;
	
	public Ion(Element element, int amount){
		elements = new LinkedHashMap<Element, Integer>();
		if(element.isMetal()){
			throw new IllegalArgumentException("A monotomic ion must be a nonmetal");
		}
		elements.put(element, new Integer(amount));
		symbol = element.getSymbol();
		name = element.getName();
		atomicWeight = element.getAtomicWeight() * amount;
		if(element.hasFormalCharge()){
			charge = element.getFormalCharge();
		} else {
			charge = -4;//carbon is the only other non-metal (that is negatively charged)
		}
	}
	
	public Ion(LinkedHashMap<Element, Integer> ionsElements, String name){
		elements = new LinkedHashMap<Element, Integer>();
		elements = ionsElements;
		this.name = name;
		
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