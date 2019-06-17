package stoichiometry;

public class Thermodynamics {

	//returns the value inputed as a negative number
	//energy = specific heat capacity * mass * change in temperature 
	public static double calcEnergy(double q, double s, double m, double deltaT){
		double[] inputs = new double[]{q, s, m, deltaT};
		int negatives = 0;
		for(double num : inputs){
			if (num < 0){
				negatives++;
			}
		}
		if(negatives != 1){
			throw new IllegalArgumentException("Must input one negative value to be solved for");
		}
		
		if(q < 0){
			return s * m * deltaT;
		} else if(s < 0){
			return q / (m * deltaT);
		} else if(m < 0){
			return q / (s * deltaT);
		}
		return q / (s * m);
	}
}
