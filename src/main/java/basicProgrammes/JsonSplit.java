package basicProgrammes;

public class JsonSplit {

	public static void main(String[] args) {
         String str="2021-11-02T08:15:11.208Z";
         
         String[] str1=str.split("T");
       String str2=str.split("T")[0];
       String str3=str1[1];
       String[] date=str2.split("-");
       System.out.println("year is"+date[0]);
       System.out.println(str3);
       String[]time=str3.split(":");
       System.out.println("hours :"+time[0]);
       System.out.println("minutes :"+time[1]);
       System.out.println("seconds are :"+time[2]);
       String second=time[2];
       String second2=second.split("[.]")[1];
       System.out.println(second.substring(0,2));
      
      
	}

}
