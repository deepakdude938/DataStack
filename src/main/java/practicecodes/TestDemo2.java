package practicecodes;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TestDemo2 {

	public static void main(String[] args) throws Throwable {
FileReader	reader = new FileReader("D:\\MaheshWorkSpace\\MaheshMavenProject\\jsonfile\\Address.json");
		
		JSONParser parser= new JSONParser();
		JSONObject object=(JSONObject)parser.parse(reader);
		
		System.out.println(object.get("app"));
		System.out.println(object.get("name"));
		
		JSONObject object1=(JSONObject)object.get("_metadata");
				
		JSONArray arr=(JSONArray)object.get("definition");
		JSONObject obj=(JSONObject)arr.get(0);
		JSONArray obj1=(JSONArray)obj.get("definition");
		JSONObject obj2=(JSONObject) obj1.get(0);
		System.out.println(obj2.get("type"));
		JSONObject obj3=(JSONObject)obj2.get("properties");
		System.out.println(obj3.get("dataPath"));
	}

}
