package stoichiometry;

import java.util.ArrayList;
import java.util.HashMap;
import compound.Compound;
import compound.CovalentCompound;
import element.Element;

public class Solution {
	
	public static double calcMolarity(double mols, double liters){
		return mols / liters;
	}

	public static boolean isSoluble(Compound compound){
		// covalent compounds are non soluble
		if(compound instanceof CovalentCompound){
			return false;
		}
		String compoundSymbol = compound.getSymbol();
		HashMap<Element, Integer> compElements = compound.getElements();
		ArrayList<String> compENames = new ArrayList<String>();
		
		for(Element e : compElements.keySet()){
			compENames.add(e.getSymbol());
		}
		// element groupings to help with solubility rules
		String[] alkaliMetals = new String[]{"Li", "Na", "K", "Rb", "Cs"};
		
		if(compENames.contains("NO3")){
			return true;
		} 	
		for(String alkaliMetal : alkaliMetals){
			if(compENames.contains(alkaliMetal)){
				return true;
			}
		}
		if(compENames.contains("NH4")){
			return true;
		}
		if(!(compENames.contains("Ag") || compENames.contains("Pb") || compENames.contains("Hg2")) && 
			(compENames.contains("Cl") || compENames.contains("Br") || compENames.contains("I"))){
			return true;
		}
		if(compENames.contains("SO4") && !(compoundSymbol.equals("PbSO4") || compoundSymbol.equals("Hg2SO4") || compoundSymbol.equals("CaSO4"))){
			return true;
		}
		if(compoundSymbol.equals("Ba(OH)2") || compoundSymbol.equals("Sr(OH)2") || compoundSymbol.equals("Ca(OH)2")){
			return true;
		}
		return false;
	}
	
	public static ArrayList<Compound> findPrecipitate(Equation equation){
		Compound[] compounds = equation.getCompounds();
		ArrayList<Compound> precipitates = new ArrayList<Compound>();
		for(Compound compound : compounds){
			if(!isSoluble(compound)){
				precipitates.add(compound);
			}
		}
		if(precipitates.size() == 0){
			return null;
		}
		return precipitates;
	}
	
}
