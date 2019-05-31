package element;
import java.util.*;

public class PeriodicTable {
	public static Hashtable<String, Element> elements;
	
	static {
		elements = new Hashtable<String, Element>();
		elements.put("H", new Element(1, 1.00794, "Hydrogen", new int[]{1}, "H"));
	}
	
	public static void main(String[] args){
		System.out.println(PeriodicTable.elements.get("H").getName());
	}
}
