package compound;

public abstract class Compound {
	protected String name;
	protected String symbol;
	
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
}