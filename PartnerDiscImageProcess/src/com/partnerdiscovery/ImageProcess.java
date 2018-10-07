package com.partnerdiscovery;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.json.JSONArray;
import org.json.JSONObject;

//import org.json.simple.parser.ParseException;

//@SuppressWarnings("deprecation")
public class ImageProcess {

	// Read the iamge from the url into an image in the working directory
	public static void saveImageFromUrl(String url, String file)  throws IOException{
		URL imgUrl = new URL(url);
		InputStream is = imgUrl.openStream();
	    OutputStream os = new FileOutputStream(file);

	    byte[] b = new byte[2048];
	    int length;

	    while ((length = is.read(b)) != -1) {
	        os.write(b, 0, length);
	    }

	    is.close();
	    os.close();  
		
	}
	
	public static HttpCodeWithResponse ProcessTextFromImage(String file)  throws IOException {
		
		// License code and link to the OCR service
		String license_code = "62A4D266-CC0B-442C-BE38-39F260D5DCB7";
		String user_name =  "rohith116";
		String ocrURL = "http://www.ocrwebservice.com/restservices/processDocument?gettext=true";
		
		//Bytes from the string
		byte[] fileContent = Files.readAllBytes(Paths.get(file));
		
		// Call the web service for OCRing the image
		URL url = new URL(ocrURL);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		
		//Set Request property
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((user_name + ":" + license_code).getBytes()));
		connection.setRequestProperty("Content-Type", "application/json");	
		connection.setRequestProperty("Content-Length", Integer.toString(fileContent.length));
		
		OutputStream stream = connection.getOutputStream();

		// Post Request
		stream.write(fileContent);
		stream.close();
		
		//check response code for response
		int httpCode = connection.getResponseCode();

		HttpCodeWithResponse response;
		
		if (httpCode == HttpURLConnection.HTTP_OK)
		{
			// Get response stream and pass it onto the JSON Object from where we can get the response
			String jsonResponse = GetResponseToString(connection.getInputStream());
	
			JSONObject jsonObj = new JSONObject(jsonResponse);
			JSONArray text= (JSONArray)jsonObj.get("OCRText");
			StringBuilder retStr = new StringBuilder();
		    for(int i=0; i<text.length(); i++){
		    	retStr.append(" "+ text.get(i));
		    }

		    connection.disconnect();
		    response = new HttpCodeWithResponse(httpCode, retStr.toString());
		    return response;
			
		}
		else if (httpCode == HttpURLConnection.HTTP_UNAUTHORIZED)
		{
			connection.disconnect();
			
			response = new HttpCodeWithResponse(httpCode, "OCR Error Message: Unauthorizied request");
			return response;
		}
		else
		{
			// Error occurred
			String jsonResponse = GetResponseToString(connection.getErrorStream());
			JSONObject jsonObj = new JSONObject(jsonResponse);
			connection.disconnect();
			response = new HttpCodeWithResponse(httpCode, "Error Message: " + jsonObj.get("ErrorMessage"));
		    return response;
		}			
	}
	
	private static String GetResponseToString(InputStream inputStream) throws IOException
	{
		InputStreamReader responseStream  = new InputStreamReader(inputStream);
		
        BufferedReader br = new BufferedReader(responseStream);
        StringBuffer strBuff = new StringBuffer();
        String s;
        while ( ( s = br.readLine() ) != null ) {
            strBuff.append(s);
        }
		
        return strBuff.toString();
	}
	
}
