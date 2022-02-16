package practicecodes;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonDemo {

	public static void main(String[] args) throws Throwable {
              FileReader reader=new FileReader("D:\\MaheshWorkSpace\\MaheshMavenProject\\jsonfile\\string_Text.json");
              
              JSONParser parser=new JSONParser();
              JSONObject obj=(JSONObject)parser.parse(reader);
              System.out.println(obj.get("deleted"));
              
              JSONArray array=(JSONArray)obj.get("definition");
              
           for(int i=0;i<array.size();i++) {
           	  JSONObject obj2=(JSONObject)array.get(i);
           	 
           	  System.out.println(obj2.get("key"));
//            	  System.out.println(obj2.get("_id"));
//            	  System.out.println(obj2.get("type"));
//            	  
              }
              System.out.println("=========================================_id==============================================================");
           
              
            
	}

}
