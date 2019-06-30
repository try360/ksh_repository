package study;

import java.util.HashMap;
import java.util.Map;

public class MapMap{

	static Map<String,String> map= new HashMap<String,String>();
	
	
public static void main(String[] args) {
	
	
	map.put("key 1", "value1");
	map.put("key 2", "value2");
	map.put("key 3", "value3");

	
System.out.println(map.get("key 1"));
System.out.println(" map size   :  "+ map.size());	
System.out.println();



}
}
