package compound;

import java.util.HashMap;
import element.Element;

public abstract class Compound {
	protected String name;
	protected String symbol;
	protected double atomicMass;
	
	//getters
	public String getName(){
		return name;
	}
	
	public String getSymbol(){
		return symbol;
	}
	
	public double getAtomicMass(){
		return atomicMass;
	}
	
	public abstract HashMap<Element, Integer> getElements();
	
	//default overrides
	public String toString(){
		return symbol;
	}
	
	public boolean equals(Compound other){
		return name == other.getName() && atomicMass == other.getAtomicMass() && symbol == other.getSymbol();
	}
}