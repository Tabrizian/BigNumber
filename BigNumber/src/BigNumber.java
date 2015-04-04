public class BigNumber {
	private String number;

	public BigNumber(String number) {
		StringBuilder strBuild = new StringBuilder(number);
		this.number = strBuild.reverse().toString();
	}

	public int getAt(int i) {
		return Integer.parseInt(number.charAt(i) + "");
	}

	public BigNumber add(BigNumber num2) {
		StringBuilder num = new StringBuilder();
		num.reverse();
		int remain = 0;
		for (int i = 0; i < number.length(); i++) {
			int number1 = 0;
			try {
				number1 = this.getAt(i);
			} catch (Exception e) {
			}
			int number2 = 0;
			try {
				number2 = num2.getAt(i);
			} catch (Exception e) {
			}
			int temp = number1 + number2 + remain;
			remain = temp / 10;
			temp = temp % 10;

			num.append(temp);
		}
		if (remain > 0)
			num.append(remain);
		return new BigNumber(num.toString());
	}
	
	public BigNumber subtract(BigNumber num2) {
		StringBuilder num = new StringBuilder();
		num.reverse();
		int remain = 0;
		boolean subtracted = false;
		for (int i = 0; i < number.length(); i++) {
			
			int number1 = 0;
			try {
				number1 = this.getAt(i);
			} catch (Exception e) {
			}
			int number2 = 0;
			try {
				number2 = num2.getAt(i);
			} catch (Exception e) {
			}
			
			if (subtracted) {
				number1--;
				subtracted = false;
			}
			int temp = number1 - number2 + remain;
			
			if(temp < 0){
				subtracted = true;
				temp += 10;
			}
				
			remain = temp / 10;
			temp = temp % 10;

			num.append(temp);
		}
		if (remain > 0)
			num.append(remain);
		return new BigNumber(num.toString());
	}
	

	@Override
	public String toString() {
		return number;
	}
}
