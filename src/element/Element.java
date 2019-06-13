package element;

public class Element {
	private int atomicNum;
	private double atomicMass;
	private String name;
	private int[] charges;
	private String symbol;
	private boolean isMetal;
	private boolean isMetalloid;
	private String ionName;
	
	//for groups VA, VIA, and VIIA with weird charges
	private int formalCharge;
	private boolean hasFormalCharge;
	
	public Element(int atomicNum, double atomicMass, String name, int[] charges, String symbol){
		this.atomicNum = atomicNum;
		this.atomicMass = atomicMass;
		this.name = name;
		this.charges = charges;
		this.symbol = symbol;
		hasFormalCharge = false;
		if(charges.length > 0 && charges[0] == 0) {
			isMetal = false;
		} else {
			isMetal = true;
		}
		isMetalloid = false;
		generateIonName();
	}
	
	public Element(int atomicNum, double atomicMass, String name, int[] charges, String symbol, boolean isMetal, boolean isMetalloid){
		this.atomicNum = atomicNum;
		this.atomicMass = atomicMass;
		this.name = name;
		this.charges = charges;
		this.symbol = symbol;
		hasFormalCharge = false;
		this.isMetal = isMetal;
		this.isMetalloid = isMetalloid;
		generateIonName();
	}
	
	public Element(int atomicNum, double atomicMass, String name, int[] charges, int formalCharge, String symbol){
		this.atomicNum = atomicNum;
		this.atomicMass = atomicMass;
		this.name = name;
		this.charges = charges;
		this.symbol = symbol;
		this.hasFormalCharge = true;
		this.formalCharge = formalCharge;
		isMetal = false;
		isMetalloid = false;
		generateIonName();
	}
	
	//helper methods
	private void generateIonName(){
		if(isMetal || charges[0] == 0){
			ionName = name;
		} else if(symbol == "H"){
			ionName = "Hydride";
		} else if(symbol == "P"){
			ionName = "Phosphide";
		} else if(symbol == "S"){
			ionName = "Sulfide";
		} else if(symbol == "C"){
			ionName = "Carbide";
		} else if(symbol == "Se"){
			ionName = "Selenide";
		} else if(name.endsWith("gen")){
			ionName = name.substring(0, name.indexOf("gen") - 1) + "ide";
		} else {
			ionName = name.substring(0, name.indexOf("ine")) + "ide";
		}
	}
	
	//getters
	public int getAtomicNum(){
		return atomicNum;
	}
	
	public double getAtomicMass(){
		return atomicMass;
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
			throw new UnsupportedOperationException(name + " does not have a formal charge");
		}
		return formalCharge;
	}
	
	public String getIonName(){
		return ionName;
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
	
	public boolean isMetal() {
		return isMetal;
	}
	
	public boolean isMetalloid(){
		return isMetalloid;
	}
	
	//default overrides
	public String toString(){
		return symbol;
	}
	
	public boolean equals(Element other){
		return other.getName() == name && other.getSymbol() == symbol && other.getAtomicNum() == atomicNum;
	}
}
