import java.math.BigInteger;
import java.util.Scanner;

public class Input {
	public static String getInput() {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		String[] args;
		String ans = null;
		if (s.indexOf('+') != -1) {
			args = s.split("\\+");
			ans = new BigNumber(args[0]).manage(new BigNumber(args[1]), '+')
					.toString();
		} else if (s.indexOf('<') != -1) {
			args = s.split("<");
			ans = String.valueOf(new BigNumber(args[0])
					.compareTo((new BigNumber(args[1]))));
		} else if (s.indexOf('>') != -1) {
			args = s.split(">");
			ans = String.valueOf(new BigNumber(args[1])
					.compareTo((new BigNumber(args[0]))));
		} else if (s.indexOf('-') != -1) {
			args = s.split("-");
			if (args.length == 3) {
				ans = new BigNumber("-"+args[1])
						.manage(new BigNumber(args[2]), '-').toString();
			}
			else{
				ans = new BigNumber(args[0])
						.manage(new BigNumber(args[1]), '-').toString();
			}
		} else if (s.indexOf('*') != -1) {
			args = s.split("\\*");
			ans = new BigNumber(args[0]).manage(new BigNumber(args[1]), '*')
					.toString();
		} else if (s.indexOf('!') != -1) {
			args = s.split("!");
			ans = String.valueOf((new BigNumber(args[1]).isZero()));
		}

		return ans.toString();
	}
}
