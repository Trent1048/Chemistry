package compound;

import java.util.HashMap;
import element.Element;

public abstract class Compound {
	protected String name;
	protected String symbol;
	protected double atomicWeight;
	
	//getters
	public String getName(){
		return name;
	}
	
	public String getSymbol(){
		return symbol;
	}
	
	public double getAtomicWeight(){
		return atomicWeight;
	}
	
	public abstract HashMap<Element, Integer> getElements();
	
	//default overrides
	public String toString(){
		return symbol;
	}
	
	public boolean equals(Compound other){
		return name == other.getName() && atomicWeight == other.getAtomicWeight() && symbol == other.getSymbol();
	}
}