package servlets;

public class Logic {
	public static boolean isNumeric(String str) {				//metoda sprawdzaj¹ca czy dane s¹ liczbowe
		try{
			double d= Double.parseDouble(str);
		}
		catch(NumberFormatException nfe) {
			return false;
		}
		
		return true;
	}
	
	public static float costOfCredit(int interest, int pipa ) {		//metoda licz¹ca koszt kredytu DO MODYFIKACJI 
		return ((interest/100.0f)*pipa);
	}
	
	public static float calculationOfInstalmentsDescending(float S, float N, float n, float r, float interest, float pipa, float fixedFee ) {		//metoda licz¹ca raty kredytu- malej¹ce.
		/*ratan = S/N[1+(N-n+1)r]
		 * S – kwota zaci¹gniêtego kredytu (kwota brutto, wraz z kosztami oko³okredytowymi)
			N – iloœæ rat
			n – numer poszukiwanej raty
			r – oprocentowanie nominalne dla okresu
		 */
		float ratan=(S/N*(1+(N-n+1)*((r/100)/12)))+((interest/100.0f)*pipa)/N+fixedFee;
		return ratan;
	}
	
	public static float calculationOfInstalmentsConstans(float S, float n, float r, float m, float interest, float pipa, float fixedFee) {	//metoda licz¹ca raty kredytu- stale.
		/*rata =(S*q^n)*((q-1)/(q^n-1))
		 * S – kwota zaci¹gniêtego kredytu (kwota brutto, wraz z kosztami oko³okredytowymi)
			n – iloœæ rat
			r – oprocentowanie nominalne dla okresu
			m – iloœæ rat w okresie (najczêœciej w roku) 
			
		 */
		float q=1+((r/100)/m);
		float rata = (float) ((S*Math.pow(q, n))*((q-1)/(Math.pow(q, n)-1)))+((interest/100.0f)*pipa)/n+fixedFee;
		return rata;
		
	}


	public static float calculationOfInterest(int credit, int percentage, int num) {				//obliczenie wartoœci odsetek
		//(kredyt * oprocentowanie * (iloœæ rat +1) / 2400)
		float interest= (credit*percentage*(num+1))/2400;
		return interest;
	}

}
