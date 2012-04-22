package com.clomoso;


import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TwittagServlet
 */
public class TwittagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TextWeightWS data = new TextWeightWS();

	/**
     * Default constructor. 
     */
    public TwittagServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request, response);
	}

	
	/**
	 * @throws TwitterException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		OutputStream os = response.getOutputStream();
		
		OutputStreamWriter osw = new OutputStreamWriter(os);
			
		
		try {
//			TwitReader twreader = new TwitReader();
//			String user = request.getParameter("user");
//			String textoLimpo2 = twreader.readTwits(user, request);
		

			
			TextWeightWS textWeightWS = new TextWeightWS();
			
			Map<String, String> mapResult = textWeightWS.chamarWSRelevancia("www.cnn.com");
			
			JSONResult jsonResult = new JSONResult();
			
			jsonResult.writePairValueJSON(osw, mapResult);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		osw.flush();		
		osw.close();
		
	}


	

	
	
}
