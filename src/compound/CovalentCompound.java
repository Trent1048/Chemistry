package compound;

import java.util.HashMap;
import element.Element;

public class CovalentCompound extends Compound {
	private HashMap<Element, Integer> elements;
	private static final String[] PREFIXES = {"Mono", "Di", "Tri", "Tetra", "Penta", "Hexa", "Hepta", "Octo", "Nona", "Deca", "Undeca", "Dodeca"};

	public CovalentCompound(Element e1, int e1Amount, Element e2, int e2Amount){
		if(e1Amount > 12 || e2Amount > 12){
			throw new IllegalArgumentException("Covalent compounds cannot have more than 12 of a single element in the bond");
		} 
		if((e1.isMetal() && !e1.isMetalloid()) || (e2.isMetal() && !e2.isMetalloid())){
			throw new IllegalArgumentException("Covalent compounds cannot contain metals");
		}
		elements = new HashMap<Element, Integer>();
		elements.put(e1, new Integer(e1Amount));
		elements.put(e2, new Integer(e2Amount));
		
		atomicWeight = e1.getAtomicWeight() * e1Amount + e2.getAtomicWeight() * e2Amount;
		
		//generating symbol
		symbol = "";
		symbol += e1.getSymbol();
		if(e1Amount > 1){
			symbol += e1Amount + "";
		}
		symbol += e2.getSymbol();
		if(e2Amount > 1){
			symbol += e2Amount + "";
			
		}
		
		//generating name
		name = "";
		if(e1Amount > 1){
			name += PREFIXES[e1Amount - 1];
		}
		name += e1.getName().toLowerCase() + " " + PREFIXES[e2Amount - 1] + e2.getIonName().toLowerCase();
		if(e2.getSymbol().equals("O") && e2Amount == 1){//fix monooxide and change it to monoxide
			int oIndex = name.lastIndexOf("o");
			name = name.substring(0, oIndex) + name.substring(oIndex + 1);
		}
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
	}
	
	public HashMap<Element, Integer> getElements(){
		return elements;
	}
}
