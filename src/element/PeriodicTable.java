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
		elements.put("Rb", new Element(37, 85.4678, "Rubidium", new int[]{1}, "Rb"));
		elements.put("Sr", new Element(38, 87.62, "Strontium", new int[]{2}, "Sr"));
		elements.put("Y", new Element(39, 88.90585, "Yttrium", new int[]{3}, "Y"));
		elements.put("Zr", new Element(40, 91.224, "Zirconium", new int[]{4}, "Zr"));
		elements.put("Nb", new Element(41, 92.90638, "Niobium", new int[]{3, 5}, "Nb"));
		elements.put("Mo", new Element(42, 95.94, "Molybdenum", new int[]{2, 3, 4, 5, 6}, "Mo"));
		elements.put("Tc", new Element(43, 97.9072, "Technryium", new int[]{7}, "Tc"));
		elements.put("Ru", new Element(44, 101.07, "Ruthenium", new int[]{2, 3, 4, 6, 8}, "Ru"));
		elements.put("Rh", new Element(45, 102.90550, "Rhodium", new int[]{2, 3, 4}, "Rh"));
		elements.put("Pd", new Element(46, 106.42, "Palladium", new int[]{2, 4}, "Pd"));
		elements.put("Ag", new Element(47, 107.8682, "Silver", new int[]{1}, "Ag"));
		elements.put("Cd", new Element(48, 112.411, "Cadmium", new int[]{2}, "Cd"));
		elements.put("In", new Element(49, 114.818, "Indium", new int[]{3}, "In"));
		elements.put("Sn", new Element(50, 118.71, "Tin", new int[]{2, 4}, "Sn"));
		elements.put("Sb", new Element(51, 121.757, "Antimony", new int[]{3, -3, 5, -5}, "Sb"));
		elements.put("Te", new Element(52, 127.6, "Tellurium", new int[]{-2, 4, 6}, "Te"));
		elements.put("I", new Element(53, 126.90447, "Iodine", new int[]{-1, 1, -5, 5, -7, 7}, -1, "I"));
		elements.put("Xe", new Element(54, 131.29, "Xenon", new int[]{0}, "Xe"));
		elements.put("Cs", new Element(55, 132.90543, "Cesium", new int[]{1}, "Cs"));
		elements.put("Ba", new Element(56, 137.327, "Barium", new int[]{2}, "Ba"));
		elements.put("La", new Element(57, 138.9055, "Lanthanum", new int[]{3}, "La"));
		elements.put("Hf", new Element(58, 140.115, "Cerium", new int[]{3, 4}, "Ce"));
		elements.put("Pr", new Element(59, 140.90765, "Praseodymium", new int[]{3, 4}, "Pr"));
		elements.put("Nd", new Element(60, 144.24, "Neodymium", new int[]{3}, "Nd"));
		elements.put("Pm", new Element(61, 144.9127, "Promethium", new int[]{3}, "Pm"));
		elements.put("Sm", new Element(62, 150.36, "Samarium", new int[]{2, 3}, "Sm"));
		elements.put("Eu", new Element(63, 151.965, "Europium", new int[]{2, 3}, "Eu"));
		elements.put("Gd", new Element(64, 157.25, "Gadolinium", new int[]{3}, "Gd"));
		elements.put("Tb", new Element(65, 158.92534, "Terbium", new int[]{3, 4}, "Tb"));
		elements.put("Dy", new Element(66, 162.5, "Dysprosium", new int[]{3}, "Dy"));
		elements.put("Ho", new Element(67, 164.93032, "Holmium", new int[]{3}, "Ho"));
		elements.put("Er", new Element(68, 167.26, "Erbium", new int[]{3}, "Er"));
		elements.put("Tm", new Element(69, 168.93421, "Thulium", new int[]{2, 3}, "Tm"));
		elements.put("Yb", new Element(70, 173.04, "Ytterbium", new int[]{2, 3}, "Yb"));
		elements.put("Lu", new Element(71, 174.967, "Lutetium", new int[]{3}, "Lu"));
		elements.put("Hf", new Element(72, 178.49, "Hafnium", new int[]{4}, "Hf"));
		elements.put("Ta", new Element(73, 180.9479, "Tantalum", new int[]{5}, "Ta"));
		elements.put("W", new Element(74, 183.84, "Tungsten", new int[]{2, 3, 4, 5, 6}, "W"));
		elements.put("Re", new Element(75, 186.207, "Rhenium", new int[]{-1, 2, 4, 5, 7}, "Re"));
		elements.put("Os", new Element(76, 190.23, "Osmium", new int[]{2, 3, 4, 6, 8}, "Os"));
		elements.put("Ir", new Element(77, 192.22, "Iridium", new int[]{2, 3, 4, 6}, "Ir"));
		elements.put("Pt", new Element(78, 195.08, "Platinum", new int[]{2, 4}, "Pt"));
		elements.put("Au", new Element(79, 196.96654, "Gold", new int[]{1, 3}, "Au"));
		elements.put("Hg", new Element(80, 200.59, "Mercury", new int[]{1, 2}, "Hg"));
	}
	
	public static void main(String[] args){
		System.out.println(PeriodicTable.elements.get("H").getName());
	}
}