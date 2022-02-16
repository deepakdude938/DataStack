package practicecodes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestDemo {

	public static void main(String[] args) throws IOException, ParseException {
		
		FileReader	reader = new FileReader("D:\\MaheshWorkSpace\\MaheshMavenProject\\jsonfile\\Address.json");
		
		JSONParser	jsonParser = new JSONParser();
		
		JSONObject obj=	(JSONObject) jsonParser.parse(reader);
		
		System.out.println(obj.get("__v"));
		
		
		
		 JSONObject obj1=(JSONObject) obj.get("_metadata");
		 
		 System.out.println(obj1.get("lastUpdated"));
		 
		 JSONObject obj2=(JSONObject) obj1.get("version");
		 
		 System.out.println(obj2.get("release"));
		 
JSONArray arr=(JSONArray) obj.get("definition");

System.out.println(arr.size());

JSONObject o =(JSONObject) arr.get(0);

JSONArray l=(JSONArray) o.get("definition");

JSONObject g =(JSONObject) l.get(0);

JSONObject g1 =(JSONObject) g.get("properties");

System.out.println(g1.get("fieldLength"));


for(int i=0;i<l.size();i++) {
JSONObject jh=	(JSONObject) l.get(i);
	System.out.println(jh.get("key"));
	
}



		
	}

}
