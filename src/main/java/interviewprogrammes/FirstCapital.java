package interviewprogrammes;

class FirtCapitak{
	public static void main(String...args) {
		String D="my name is dEEpak";
		D=D.toLowerCase();
		char[] jrD=D.toCharArray();
		String srD="";
		jrD[0]=(char) (jrD[0]-32);
		for(int i=0;i<jrD.length;i++) {
			if(jrD[i]==' ') {
				jrD[i+1]=(char)(jrD[i+1]-32);
				
			}
			 srD=srD+jrD[i];
			
		}
		System.out.println(srD);
	}
}
