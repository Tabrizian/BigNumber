import java.util.Scanner;

public class Input {
	public static String getInput() {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		String[] args;
		BigNumber ans = null;
		if (s.indexOf('+') != -1) {
			args = s.split("+");
			ans = new BigNumber(args[0]).manage(new BigNumber(args[1]), '+');
		} else if(s.indexOf('-') != -1) {
			args = s.split("-");
			ans = new BigNumber(args[0]).manage(new BigNumber(args[1]), '-');
		} else if(s.indexOf('*') != -1) {
			args = s.split("*");
			ans = new BigNumber(args[0]).manage(new BigNumber(args[1]), '*');
		}
		return ans.toString();
	}
}
