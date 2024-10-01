
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> molecular_formula =new HashMap<String, String>();
		molecular_formula.put("C8H10N4O2", "1,3,7-Trimethylxanthine");
		molecular_formula.put("C16H19N3O5S", "beta_lactam_ring");
		molecular_formula.put("C55H72MgN4O5", "chromophore");
		System.out.println(molecular_formula);
		System.out.println(molecular_formula.get("C16H19N3O5S"));
		System.out.println(molecular_formula.values());
		for(String name: molecular_formula.keySet()) {
			System.out.println(name +"- "+molecular_formula.get(name));
		}

		System.out.println(molecular_formula.containsKey("C14H18N2O5"));
		System.out.println(molecular_formula.containsValue("Phenolic"));
		molecular_formula.replace("C8H10N4O2", "Cyclopentanoperhydrophenanthrene");
		System.out.println(molecular_formula);
		molecular_formula.putIfAbsent("C4H9NO2", "Inhibitory");
		System.out.println(molecular_formula.size());
		molecular_formula.remove("C55H72MgN4O5");
		System.out.println(molecular_formula);
	}

}