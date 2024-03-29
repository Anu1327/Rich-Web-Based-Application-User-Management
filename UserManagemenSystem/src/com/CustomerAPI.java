package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerAPI
 */
@WebServlet("/CustomerAPI")
    public class CustomerAPI extends HttpServlet {
	
    
	Customer customerObj = new Customer();
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String output = customerObj.insertCustomer(request.getParameter("customerIdentity"), 
			    request.getParameter("customerName"), 
				request.getParameter("customerEmail"), 
				request.getParameter("customerAddress")); 
				
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		 Map paras = getParasMap(request); 
		 
		 String output = customerObj.updateCustomer(paras.get("hidcustomerIdentitySave").toString(),
		                 paras.get("customerIdentity").toString(), 
		                 paras.get("customerName").toString(), 
		                 paras.get("customerEmail").toString(), 
		                 paras.get("customerAddress").toString()); 
		 
		 System.out.print(output);
		
		 response.getWriter().write(output);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		 Map paras = getParasMap(request); 
//		System.out.print(paras.get("customerIdentity").toString());
		 
		 String output = customerObj.deleteCustomer(paras.get("customerID").toString()); 
		 
		 response.getWriter().write(output);
		// TODO Auto-generated method stub
	}
	private static Map getParasMap(HttpServletRequest request) 
	{ 
	 
		Map<String, String> map = new HashMap<String, String>(); 
	try
	 { 
	      
		Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
	    String queryString = scanner.hasNext() ? 
	                         scanner.useDelimiter("\\A").next() : ""; 
	    scanner.close(); 
	    
	    String[] params = queryString.split("&"); 
	    for (String param : params) 
	   { 
	    String[] p = param.split("=");
	    map.put(p[0], p[1]); 
	   } 
	 } 
	catch (Exception e) 
	 { 
	 } 
	return map; 
	}
	
}
	


