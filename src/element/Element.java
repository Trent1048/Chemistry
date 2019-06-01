package element;

public class Element {
	private int atomicNum;
	private double atomicWeight;
	private String name;
	private int[] charges;
	private String symbol;
	
	//for groups VA, VIA, and VIIA with weird charges
	private int formalCharge;
	private boolean hasFormalCharge;
	
	public Element(int atomicNum, double atomicWeight, String name, int[] charges, String symbol){
		this.atomicNum = atomicNum;
		this.atomicWeight = atomicWeight;
		this.name = name;
		this.charges = charges;
		this.symbol = symbol;
		this.hasFormalCharge = false;
	}
	
	public Element(int atomicNum, double atomicWeight, String name, int[] charges, int formalCharge, String symbol){
		this.atomicNum = atomicNum;
		this.atomicWeight = atomicWeight;
		this.name = name;
		this.charges = charges;
		this.symbol = symbol;
		this.hasFormalCharge = true;
		this.formalCharge = formalCharge;
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
	
	public int getNumOfCharges(){
		return charges.length;
	}
	
	public String getSymbol(){
		return symbol;
	}
	
	public int getFormalCharge(){
		if(!hasFormalCharge){
			throw new UnsupportedOperationException();
		}
		return formalCharge;
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
	
	public boolean hasOneCharge(){
		return getNumOfCharges() == 1;
	}
	
	public boolean hasFormalCharge(){
		return hasFormalCharge;
	}
}
