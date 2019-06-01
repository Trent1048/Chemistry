package element;
import java.util.*;

public class PeriodicTable {
	public static Hashtable<String, Element> elements;
	
	static {
		elements = new Hashtable<String, Element>();
		elements.put("H", new Element(1, 1.00794, "Hydrogen", new int[]{1}, "H"));
		elements.put("He", new Element(2, 4.002602, "Helium", new int[]{0}, "He"));
		elements.put("Li", new Element(3, 6.941, "Lithium", new int[]{1}, "Li"));
		elements.put("Be", new Element(4, 9.012182, "Beryllium", new int[]{2}, "Be"));
		elements.put("B", new Element(5, 10.811, "Boron", new int[]{3}, "B"));
		elements.put("C", new Element(6, 12.011, "Carbon", new int[]{2, 4, -4}, "C"));
		elements.put("N", new Element(7, 14.00674, "Nitrogen", new int[]{-3, 2, 3, 4, -4, 5, -5}, -3, "N"));
		elements.put("O", new Element(8, 15.9994, "Oxygen", new int[]{-2}, -2, "O"));
		elements.put("F", new Element(9, 18.9984032, "Fluorine", new int[]{-1}, -1, "F"));
		elements.put("Ne", new Element(10, 20.1797, "Neon", new int[]{0}, "Ne"));
		elements.put("Na", new Element(11, 22.989768, "Sodium", new int[]{1}, "Na"));
		elements.put("Mg", new Element(12, 24.3050, "Magnesium", new int[]{2}, "Mg"));
		elements.put("Al", new Element(13, 26.981539, "Alumininum", new int[]{3}, "Al"));
		elements.put("Si", new Element(14, 28.0855, "Silicon", new int[]{4}, "Si"));
		elements.put("P", new Element(15, 30.973762, "Phosphorus", new int[]{-3, 3, -4, 4, -5, 5}, -3, "P"));//Weird charges
		elements.put("S", new Element(16, 32.066, "Sulfur", new int[]{-2, 2, -4, 4, -6, 6}, -2, "S"));
	}
	
	public static void main(String[] args){
		System.out.println(PeriodicTable.elements.get("H").getName());
	}
}