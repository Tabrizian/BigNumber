public class BigNumber {
	private String number;

	public BigNumber(String number) {
		this.number = number;
	}

	public int getAt(int i) {
		return Integer.parseInt(number.charAt(number.length() - i - 1) + "");
	}

	public BigNumber add(BigNumber num2) {
		StringBuilder num = new StringBuilder();
		int remain = 0;
		int length = number.length();
		if(length < num2.number.length())
			length = num2.number.length();
		for (int i = 0; i < length; i++) {
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
		num = num.reverse();
		return new BigNumber(num.toString());
	}

	public BigNumber subtract(BigNumber num2) {
		StringBuilder num = new StringBuilder();
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

			if (temp < 0) {
				subtracted = true;
				temp += 10;
			}

			remain = temp / 10;
			temp = temp % 10;

			num.append(temp);
		}
		if (remain > 0)
			num.append(remain);
		num.reverse();
		return new BigNumber(num.toString());
	}

	public BigNumber divide10(int m) {
		StringBuilder strbuild = new StringBuilder(number);

		try {
			return new BigNumber(strbuild.substring(0, number.length() - m).toString());
		} catch (Exception e) {
			return new BigNumber("0");
		}

	}

	public BigNumber remain10(int m) {
		StringBuilder strbuild = new StringBuilder(number);
		try {
			strbuild = new StringBuilder(strbuild.substring(number.length() 
					- m, number.length()));
			return new BigNumber(strbuild.toString());
		} catch (Exception e) {
			return new BigNumber(number);
		}
	}

	public BigNumber multiply10(int m) {
		StringBuilder strbuild = new StringBuilder(number);
		for (int i = 0; i < m; i++) {
			strbuild.insert(number.length(), '0');
		}
		return new BigNumber(strbuild.toString());
	}

	public BigNumber multiply(BigNumber num) {
		BigNumber x, y, w, z, r, p, q;
		int m, n;
		n = num.number.length();

		if (this.number.length() > n)
			n = this.number.length();

		if (num.isZero() || isZero()) {
			return new BigNumber("0");
		}

		else if (n <= 4) {
			return new BigNumber(String.valueOf(Integer.parseInt(num.number)
					* Integer.parseInt(number)));
		}

		else {
			m = n / 2;
			x = this.divide10(m);
			y = this.remain10(m);
			w = num.divide10(m);
			z = num.remain10(m);
			BigNumber xSumy = x.add(y);
			BigNumber wSumz = w.add(z);
			r = xSumy.multiply(wSumz);
			
			p = x.multiply(w);
			q = y.multiply(z);
			BigNumber pmultiply = p.multiply10(2 * m);
			BigNumber pSumq = p.add(q);
			BigNumber rMinuspSumq = r.subtract(pSumq);
			return pmultiply.add(rMinuspSumq.multiply10(m))
					.add(q);
		}
	}

	public boolean isZero() {
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if (c != '0')
				return false;
		}
		if(number == null)
			return true;
		else
			return true;
			
	}

	public int compare(BigNumber num) {
		return num.number.compareTo(number);
	}

	@Override
	public String toString() {
		return number;
	}
}
