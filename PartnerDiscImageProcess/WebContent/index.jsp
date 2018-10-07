<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Partner Discovery via Image Processing</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="textboxform">
<div id ="title">
<h1>Partner Discovery via Image Processing</h1> </div>
<div id="inform">
      <form action = "HandleRequest" method = "GET">
         Image To Process: <input style="height:40px;width:400px;" type = "text" name = "imgUrl">
   <div id="button">
         <input style="height:70px;width:100px;" type = "submit" value = "Submit" /></div>
      </form>
      </div>
   
   <br>
   <div id="result">
  <textarea name="output" style="font-size:20px;width:70%;height:30%" rows="20">${TextValue}</textarea>
  </div>

</div>
</body>
</html>