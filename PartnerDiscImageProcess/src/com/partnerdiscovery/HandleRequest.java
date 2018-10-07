package com.partnerdiscovery;

import java.io.IOException;
import java.net.HttpURLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is the method that interfaces with the client and calls the different Image processing calls
 */
@WebServlet("/HandleRequest")
public class HandleRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String url = request.getParameter("imgUrl");
		HttpSession session = request.getSession();
		// Validate URl is well formed and then pass it on to the Image Processing modules
		if(ValidationUtility.ValidateURL(url)) {
			
			// initially save the copy of the image, in the current working directory
			// and then pass it on to the web service to do the OCR and get the raw text from the image
			ImageProcess.saveImageFromUrl(url, "temp.jpg");
			HttpCodeWithResponse result = ImageProcess.ProcessTextFromImage("temp.jpg");
			
			// Parse the response and appropriately choose the response
			if(result.responseCode == HttpURLConnection.HTTP_OK) {
				request.setAttribute("TextValue",result.response);
				request.getRequestDispatcher("index.jsp").forward(request, response);				
				session.setAttribute("url", url);
			}
			else{
				// This statement mostly comes into the picture during the processing of the image
				session.setAttribute("url", url);
				session.setAttribute("error", result.response);
				response.sendRedirect("Error.jsp");
			}

		}
		else {
			// THis code gets executed when the URL is not properly formed.
			session.setAttribute("url", url);
			session.setAttribute("error", "The url specified is not a properly formed url");
			response.sendRedirect("Error.jsp");
		}
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
	}
}
