package element;
import java.util.*;

public class PeriodicTable {
	public static Hashtable<String, Element> elements;
	
	static {
		elements = new Hashtable<String, Element>();
		elements.put("H", new Element(1, 1.00794, "Hydrogen", new int[]{1}, "H", false));
		elements.put("He", new Element(2, 4.002602, "Helium", new int[]{0}, "He"));
		elements.put("Li", new Element(3, 6.941, "Lithium", new int[]{1}, "Li"));
		elements.put("Be", new Element(4, 9.012182, "Beryllium", new int[]{2}, "Be"));
		elements.put("B", new Element(5, 10.811, "Boron", new int[]{3}, "B"));
		elements.put("C", new Element(6, 12.011, "Carbon", new int[]{2, 4, -4}, "C", false));
		elements.put("N", new Element(7, 14.00674, "Nitrogen", new int[]{-3, 2, 3, 4, -4, 5, -5}, -3, "N"));
		elements.put("O", new Element(8, 15.9994, "Oxygen", new int[]{-2}, -2, "O"));
		elements.put("F", new Element(9, 18.9984032, "Fluorine", new int[]{-1}, -1, "F"));
		elements.put("Ne", new Element(10, 20.1797, "Neon", new int[]{0}, "Ne"));
		elements.put("Na", new Element(11, 22.989768, "Sodium", new int[]{1}, "Na"));
		elements.put("Mg", new Element(12, 24.3050, "Magnesium", new int[]{2}, "Mg"));
		elements.put("Al", new Element(13, 26.981539, "Alumininum", new int[]{3}, "Al"));
		elements.put("Si", new Element(14, 28.0855, "Silicon", new int[]{4}, "Si"));
		elements.put("P", new Element(15, 30.973762, "Phosphorus", new int[]{-3, 3, -4, 4, -5, 5}, -3, "P"));
		elements.put("S", new Element(16, 32.066, "Sulfur", new int[]{-2, 2, -4, 4, -6, 6}, -2, "S"));
		elements.put("Cl", new Element(17, 35.4527, "Chlorine", new int[]{-1, 1, -3, 3, -5, 5, -7, 7}, -1, "Cl"));
		elements.put("Ar", new Element(18, 39.948, "Argon", new int[]{0}, "Ar"));
		elements.put("K", new Element(19, 39.0983, "Potassium", new int[]{1}, "K"));
		elements.put("Ca", new Element(20, 40.078, "Calcium", new int[]{2}, "Ca"));
		elements.put("Sc", new Element(21, 44.955910, "Scandium", new int[]{3}, "Sc"));
		elements.put("Ti", new Element(22, 47.88, "Titanium", new int[]{3, 4}, "Ti"));
		elements.put("V", new Element(23, 50.9415, "Vanadium", new int[]{2, 3, 4, 5}, "V"));
		elements.put("Cr", new Element(24, 51.9961, "Chromium", new int[]{2, 3, 6}, "Cr"));
		elements.put("Mn", new Element(25, 54.93805, "Manganese", new int[]{2, 3, 4, 6, 7}, "Mn"));
		elements.put("Fe", new Element(26, 55.847, "Iron", new int[]{2, 3}, "Fe"));
		elements.put("Co", new Element(27, 58.93320, "Cobalt", new int[]{2, 3}, "Co"));
		elements.put("Ni", new Element(28, 58.6934, "Nickel", new int[]{2, 3}, "Ni"));
		elements.put("Cu", new Element(29, 63.546, "Copper", new int[]{1, 2}, "Cu"));
		elements.put("Zn", new Element(30, 65.39, "Zinc", new int[]{2}, "Zn"));
		elements.put("Ga", new Element(31, 69.723, "Gallium", new int[]{3}, "Ga"));
		elements.put("Ge", new Element(32, 72.61, "Germanium", new int[]{4}, "Ge"));
		elements.put("As", new Element(33, 74.92159, "Arsenic", new int[]{-3, 3, -5, 5}, "As"));
		elements.put("Se", new Element(34, 78.96, "Selenium", new int[]{-2, 4, 6}, -2, "Se"));
		elements.put("Br", new Element(35, 79.904, "Bromine", new int[]{-1, 1, -5, 5}, -1, "Br"));
		elements.put("Kr", new Element(36, 83.80, "Krypton", new int[]{0}, "Kr"));
		
	}
	
	public static void main(String[] args){
		System.out.println(PeriodicTable.elements.get("H").getName());
	}
}