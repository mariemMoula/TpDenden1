//Organizing the code into packages
package com.moulaMariem.servlets;

import java.io.IOException;
import java.io.PrintWriter;
//Importing LoginDao  to use it to verify the users 
import com.moulaMariem.dao.LoginDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//This class is extending HttpServlet which means it handles HTTP requests.
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//FirstServlet, it's mapped to the URL pattern /servlet1
    public FirstServlet() {
        super();
    }

//This servlet overrides the doPost method to handle POST requests.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Setting the response type  and printing it out using the PrintWriter class
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter(); 
	    //Retrieving the username and password parameters from the request using request.getParameter("username")
	    //and request.getParameter("userpass")
	    String n=request.getParameter("username");  
	    String p=request.getParameter("userpass");  
	    //Validating Logi using   the validate method of the LoginDao class to validate the provided
	    //username and password
	    
	    if(LoginDao.validate(n, p)){  
	    	//If the validation is successful (LoginDao.validate(n, p) returns true), 
	    	//it forwards the request to servlet2 using a RequestDispatcher.
	    	
	        RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
	        rd.forward(request,response);  
	    }  
	    else{  
	    	
	    	//If the validation fails, it outputs an error message ("Sorry username or password error") 
	    	//and includes the index.html page using a RequestDispatcher.
	    	
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request,response);  
	    }  
	     //Ensure proper resource management by 
	    //closing the PrintWriter (out.close()) after use 
	    out.close();  
	    }  
	  
	}


