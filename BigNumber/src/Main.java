import java.math.BigInteger;


public class Main {

	public static void main(String[] args) {
		
		BigNumber a = new BigNumber("123456789101112131415161718192014397937421097431097430918703947810943871098437102837493270");
		BigNumber b = new BigNumber("1234567891011121314151617181920");
		System.out.println(a.multiply(b));
		
		BigInteger agood = new BigInteger("123456789101112131415161718192014397937421097431097430918703947810943871098437102837493270");
		BigInteger bgood = new BigInteger("1234567891011121314151617181920");
		System.out.println(agood.multiply(bgood));
	}

}
