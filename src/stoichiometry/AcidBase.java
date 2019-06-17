package stoichiometry;

public class AcidBase {

	public static double calcPH(double concentrationOfH){
		return -Math.log(concentrationOfH);
	}
	
	public static double calcConcentrationOfH(double pH){
		return Math.pow(10, -pH);
	}
	
	public static double calcPOH(double concentrationOfOH){
		return -Math.log(concentrationOfOH);
	}
	
	public static double calcConcentrationOfOH(double pOH){
		return Math.pow(10, -pOH);
	}
	
	public static double convertBetweenPHAndPOH(double pOHOrPH){
		return 14 - pOHOrPH;
	}
}