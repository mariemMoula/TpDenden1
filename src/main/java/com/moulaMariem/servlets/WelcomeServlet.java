//Orgaizing the code in packlages 
package com.moulaMariem.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//This class is extending HttpServlet which means it handles HTTP requests.
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//WelcomeServlet, it's mapped to the URL pattern /servlet2
//This is the constructor for the WelcomeServlet class. 
	//It invokes the constructor of the superclass (HttpServlet) using super().
    public WelcomeServlet() {
        super();
    }
  //This servlet overrides the doPost method to handle POST requests.

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set the content type of the response to "text/html" ==html content.
			response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		    //trieving the value of the parameter named "username" from the request      
		    String n=request.getParameter("username");  
		    //it s written in the html content to the response stream
		    out.print("Welcome "+n);  
		     //closing the PrintWriter, releasing any resources associated with it.
		    out.close();  
		    }  
	}


//The WelcomeServlet's doPost method is responsible for handling actions that occur after a successful login.
//t's invoked after a successful login by the FirstServlet