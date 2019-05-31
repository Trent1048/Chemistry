package element;

public class Element {
	private int atomicNum;
	private double atomicWeight;
	private String name;
	private int[] charges;
	private String symbol;
	
	public Element(int atomicNum, double atomicWeight, String name, int[] charges, String symbol){
		this.atomicNum = atomicNum;
		this.atomicWeight = atomicWeight;
		this.name = name;
		this.charges = charges;
		this.symbol = symbol;
	}
	
	//getters
	public int getAtomicNum(){
		return atomicNum;
	}
	
	public double getAtomicWeight(){
		return atomicWeight;
	}
	
	public String getName(){
		return name;
	}
	
	public int[] getCharges(){
		return charges;
	}
	
	public String getSymbol(){
		return symbol;
	}
	
	//checkers
	public boolean hasCharge(int checkedCharge){
		for(int charge : charges){
			if(charge == checkedCharge){
				return true;
			}
		}
		return false;
	}
}
