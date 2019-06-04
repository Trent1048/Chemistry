package compound;

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
	
	//default overrides
	public String toString(){
		return symbol;
	}
	
	public double getAtomicWeight(){
		return atomicWeight;
	}
}