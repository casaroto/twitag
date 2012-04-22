package com.clomoso;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class TwitReader {

	
	public String readTwits(String user, HttpServletRequest request)
			throws TwitterException {

		// The factory instance is re-useable and thread safe.
		Twitter twitter = new TwitterFactory().getInstance();		
		
		Query query = new Query("from:"+ user);
		QueryResult result = twitter.search(query);
		StringBuffer sb = new  StringBuffer();
		for (Tweet tweet : result.getTweets()) {
		    sb.append(tweet.getText() + " ");
		}
		
		String textoLimpo = sb.toString() ;
		String textoLimpo2 = "";
		
		Map<String, String> map = new HashMap<String, String>();
		StringTokenizer st = new StringTokenizer(textoLimpo, " ");
		
		int count = 0;
		while(st.hasMoreTokens()){
			
			map.put("" + count, " " + st.nextToken() + " ");
			count++;
		}
		
		Map<String, String> mapFinal = new HashMap<String, String>();
		Map<String, String> mapLinks = new HashMap<String, String>();
		
		int count2 = 0;
		int countLinks = 0;
		for(int i =0;i < map.size();i++){
			
			String value = (String) map.get("" + i);
			
			if (value != null && value.indexOf("@") < 0){
				value = value.trim();
				if (value.indexOf("#")==0){
					value = value.substring(value.indexOf("#")+1);
				}
				if (value.indexOf("#")==0){
					value = value.substring(value.indexOf("#")+1);
				}
				
				if(!value.trim().equals("RT") && value.indexOf("http://") < 0){
					mapFinal.put("" + count2, value );		    		
					count2++;
				}		
				
				if(!value.trim().equals("RT") && value.indexOf("http://") >= 0){
					mapLinks.put("" + countLinks, value );		    		
					countLinks++;
				}				    		
				
			}
		}
		
		for(int i =0;i < mapFinal.size();i++){
			
			String value = (String) mapFinal.get("" + i);
			textoLimpo2 = textoLimpo2 + value + " ";
		}


		//textoLimpo2 = readLinks(mapLinks);   // TODO readLinks
		
		return textoLimpo2;
	}
	
	
	
	protected String readLinks(Map mapLinks, HttpServletRequest  request) {
		String result = "";
	
		
		try {
			HttpSession s = request.getSession();
			
			if(mapLinks.size() > 0){
			
				// TODO ler todos os links
				//String value = (String) mapLinks.get("2");
				//System.out.println(value);				
				
				result = filtraTextoWebPage("http://default-environment-wbnei3jqiz.elasticbeanstalk.com/content.jsp");
				
				// TODO enviar texto para url que pode ser lida externamente
				//s.setAttribute("content", lerWebPage(value));
				
			}

			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return result;
		
	}	
	
	protected String lerWebPage(String urlString) {
		String result = "";
		//String	link = "http://api.semantichacker.com/4kzsff26/concept?uri=http%3a%2f%2fwww.distrowatch.org";
		String link =  urlString;
		StringBuffer sb = new StringBuffer();
		
		try {
			URL url = new URL(link);
			URLConnection ucon = url.openConnection();
			
			
			InputStream is1 = ucon.getInputStream();
			InputStreamReader ir = new InputStreamReader(is1);
			BufferedReader bf = new BufferedReader(ir);
			
			String s = "";
			
			while ((s = bf.readLine()) != null){
				sb.append(s);
			}

			InputStream is = ucon.getInputStream();
			
			is.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return sb.toString();
		
	}

	protected String filtraTextoWebPage(String urlString) {
		String result = "";
		String link = "http://api.semantichacker.com/4kzsff26/filter/web?uri=" + urlString;					
		
		try {
			URL url = new URL(link);
			URLConnection ucon = url.openConnection();
			
			InputStream is1 = ucon.getInputStream();
			InputStreamReader ir = new InputStreamReader(is1);
			BufferedReader bf = new BufferedReader(ir);
			
			String s = "";
			StringBuffer sb = new StringBuffer();
			while ((s = bf.readLine()) != null){
				sb.append(s);
			}

			is1.close();
			
			InputStream is = ucon.getInputStream();
			
			//processWsFilter  // TODO 
			
			is.close();
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
		return result;
		
	}
		
	protected String processWsFilter(InputStream inputStream) {
		String result = "";
		
		  try {

				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(inputStream);
				
				doc.getDocumentElement().normalize();
		
				NodeList nList = doc.getElementsByTagName("filterResponse");				
				
				for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				   Node nNode = nList.item(temp);
				   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
				      Element eElement = (Element) nNode;				      
				      result = getTagValue("filteredText", eElement);

				   }
				}
			  } catch (Exception e) {
				e.printStackTrace();
			  }
		  
		  return result;
		
	}	
	
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	 
	    Node nValue = (Node) nlList.item(0);
	 
		return nValue.getNodeValue();
	}
	
}
