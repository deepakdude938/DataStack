package basicProgrammes;

public class Replace {

	public static void main(String[] args) {
		String a="One"+(1+2)+"Two";
		String r=a.replaceFirst(a.charAt(2)+"",'k'+"");
		System.out.println(a);
	}

}
