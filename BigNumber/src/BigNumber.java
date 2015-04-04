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
		return new BigNumber(num.toString());
	}

	public BigNumber divide10(int m) {
		StringBuilder strbuild = new StringBuilder(number);

		try {
			return new BigNumber(strbuild.substring(m).toString());
		} catch (Exception e) {
			return new BigNumber("0");
		}
		
	}

	public BigNumber remain10(int m) {
		StringBuilder strbuild = new StringBuilder(number);
		try {
			strbuild = new StringBuilder(strbuild.substring(0, m));
			return new BigNumber(strbuild.reverse().toString());
		} catch (Exception e) {
			return new BigNumber(number);
		}
	}
	
	public BigNumber multiply10(int m) {
		StringBuilder strbuild = new StringBuilder(number);
		for (int i = 0; i < m; i++) {
			strbuild.insert(0, '0');
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
			r = x.add(y).multiply(w.add(z));
			p = x.multiply(w);
			q = y.multiply(z);
			return p.multiply10(2*m).add(r.subtract(p.add(q)).multiply10(m)).add(q);
		}
	}

	public boolean isZero() {
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if (c != '0')
				return false;
		}
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
