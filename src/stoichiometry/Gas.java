package stoichiometry;

public class Gas {

	public static final double R_ATM = 0.08206;
	public static final double R_MM_HG = 62.364;
	public static final double R_KPA = 8.3144621;
	
	//conversions between units of pressure
	public static double convertMmHgToAtm(double mmHg){
		return mmHg / 760.0;
	}
	
	public static double convertMmHgToKPa(double mmHg){
		return mmHg / 7.50062;
	}
	
	public static double convertKPaToAtm(double kPa){
		return kPa / 101.325;
	}
	
	public static double convertKPaToMmHg(double kPa){
		return kPa * 7.50062;
	}
	
	public static double convertAtmToMmHg(double atm){
		return atm * 760.0;
	}
	
	public static double convertAtmToKPa(double atm){
		return atm * 101.325;
	}
	
	//returns the value inputed as a negative number
	//pressure * volume = mols * gas constant * temperature 
	public static double idealGasLaw(double p, double v, double n, double r, double t){
		double[] inputs = new double[]{p, v, n, t};
		int negatives = 0;
		for(double num : inputs){
			if (num < 0){
				negatives++;
			}
		}
		if(negatives != 1){
			throw new IllegalArgumentException("Must input one negative value to be solved for");
		}
		if(!(r == R_ATM || r == R_MM_HG || r == R_KPA)){
			throw new IllegalArgumentException("Incorrect r value, use R_ATM, R_MM_HG, or R_KPA");
		}
		
		if(p < 0){
			return (n * r * t) / v;
		} else if(v < 0){
			return (n * r * t) / p;
		} else if(n < 0){
			return (p * v) / (r * t);
		}
		return (p * v) / (n * r);
	}
	
	//returns the value inputed as a negative number
	//(pressure1 * volume1) / tempature1 = (pressure2 * volume2) / tempature2
	public static double combinedGasLaw(double p1, double v1, double t1, double p2, double v2, double t2){
		double[] inputs = new double[]{p1, v1, t1, p2, v2, t2};
		int negatives = 0;
		for(double num : inputs){
			if (num < 0){
				negatives++;
			}
		}
		if(negatives != 1){
			throw new IllegalArgumentException("Must input one negative value to be solved for");
		}
		
		if(p1 < 0){
			return (p2 * v2 * t1) / (t2 * v1);
		} else if(v1 < 0){
			return (p2 * v2 * t1) / (t2 * p1);
		} else if(t1 < 0){
			return (t2 * p1 * v1) / (p2 * v2);
		} else if(p2 < 0){
			return (p1 * v1 * t2) / (t1 * v2);
		} else if(v2 < 0){
			return (p1 * v1 * t2) / (t1 * p2);
		}
		return (t1 * p2 * v2) / (p1 * v1);
	}
}