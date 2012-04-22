package com.clomoso;

import java.util.Map;
import java.io.OutputStreamWriter;

import org.json.JSONException;
import org.json.JSONWriter;

public class JSONResult {

	
	public void writePairValueJSON(OutputStreamWriter writer, Map<String, String> mapInput){
		
		
		JSONWriter jsw = new JSONWriter(writer);
		
		try {
			
			jsw.array();
			
			for(String key: mapInput.keySet()){					
					jsw.object()
					 .key(key)
					 .value(mapInput.get(key))
					 .endObject();
			}
			
			jsw.endArray();
						
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	
}
