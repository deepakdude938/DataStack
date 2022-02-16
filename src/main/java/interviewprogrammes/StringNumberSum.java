package interviewprogrammes;

public class StringNumberSum {

	public static void main(String[] args) {
        String M="A1B5C7d9";     //String am="mahesh27ghotale10@gmail.com"//
        char[] m=M.toCharArray();
        int mk=0;
       for(int i=0;i<m.length;i++) {
    	 
        	if(m[i]>='0' && m[i]<='9') {
        		int j=Character.getNumericValue(m[i]);
        		mk=mk+j;
        		        	}
        	
        }
       System.out.println(mk);
	}

}