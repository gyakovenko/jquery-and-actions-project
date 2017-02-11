
public class ReplacementOfCharacters {

	public static void main(String[] args) {
		String subtotalString = "$4,300.33";
		String newSubtotalString = subtotalString.replaceAll(",", "");
		System.out.println(newSubtotalString);
		String newerSubtotalString = newSubtotalString.replaceAll("$", "");
		System.out.println(newerSubtotalString);
	}

}
