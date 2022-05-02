package utility;

import java.util.Random;

public class Operation {
	public static String generatorRandom() {
		Random r = new Random();
		Integer i = r.nextInt();
		return i.toString();
		
	}
	
	public static long priceUppingCalculation(long amount,int uppingPercentage) {
		
		long calAmount= amount+(amount*uppingPercentage)/100;
		return calAmount;
	}

}
