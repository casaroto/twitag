package com.clomoso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TextWeightWS {
	
	protected Map<String, String> chamarWSRelevancia(String url) {
		Map<String, String>	mapResult = new HashMap<String, String>();
		//String	link = "http://api.semantichacker.com/4kzsff26/concept?uri=http%3a%2f%2fwww.distrowatch.org";
		String	link = "http://api.semantichacker.com/4kzsff26/concept?uri=http%3a%2f%2f"+ url;
		
		try {
			URL urlLink = new URL(link);
			URLConnection ucon = urlLink.openConnection();			
		
			InputStream is = ucon.getInputStream();
			
			mapResult = processarWSRelevancia(is);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mapResult;
		
	}
	
	protected Map<String, String> processarWSRelevancia(InputStream in) {
		Map<String, String>	mapResult = new HashMap<String, String>();
		
		  try {
			  			
			  
//			  	printXML(in);
			  
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(in);
				
				doc.getDocumentElement().normalize();

				NodeList nList = doc.getElementsByTagName("concept");
				
				String key = "";
				String value = "";
				
				for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				   Node nNode = nList.item(temp);
				   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
				      Element eElement = (Element) nNode;		 
				      
				      key = getTagValue2("concept", eElement, "label");
				      value = getTagValue2("concept", eElement, "weight");
				      				      
				      mapResult.put(key, value);
				   }
				}
			  } catch (Exception e) {
				e.printStackTrace();
			  }
		  
		  return mapResult;
		
	}
	

	
	private static String getTagValue2(String sTag, Element eElement, String attr) {

	 
		return eElement.getAttribute(attr);
	  }	
	
	
	private void printXML(InputStream in){
		
		InputStreamReader reader = new InputStreamReader(in);
		
		BufferedReader bf = new BufferedReader(reader);
		
		String s = null;
		
		try {
			while( (s = bf.readLine()) != null ){
				System.out.println(s);
			}

			reader.close();
			//in.close();
			//in = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}