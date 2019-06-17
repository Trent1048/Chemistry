package stoichiometry;

import java.util.HashMap;
import compound.Compound;

public class Equilibrium {

	public static double calcEquilibriumConstant(Equation equation, HashMap<Compound, Double> concentrations){
		if(!equation.getEquation().keySet().equals(concentrations.keySet())){
			throw new IllegalArgumentException("Must have concentrations of every compound in the equation");
		}
		double concOfReactants = 1.0;
		double concOfProducts = 1.0;
		HashMap<Compound, Integer> eReactants = equation.getReactants();
		HashMap<Compound, Integer> eProducts = equation.getProducts();
		for(Compound compound : eReactants.keySet()){
			concOfReactants *= Math.pow(concentrations.get(compound), eReactants.get(compound).intValue());
		}
		for(Compound compound : eProducts.keySet()){
			concOfProducts *= Math.pow(concentrations.get(compound), eProducts.get(compound).intValue());
		}
		return concOfProducts / concOfReactants;
	}
}