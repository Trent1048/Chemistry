package compound;

import java.util.HashMap;
import element.Element;

public class Metal extends Compound {
	Element metal;
	int charge;

	public Metal(Element element, int charge){
		if(!element.isMetal()){
			throw new IllegalArgumentException("Cannot create a Metal out of a non-metal Element");
		}
		this.charge = charge;
		name = element.getName();
		atomicMass = element.getAtomicMass();
		symbol = element.getSymbol();
		metal = element;
	}

	public HashMap<Element, Integer> getElements() {
		HashMap<Element, Integer> metals = new HashMap<Element, Integer>();
		metals.put(metal, new Integer(1));
		return metals;
	}
}
