<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Calculator</title>
</head>
<body> 
   <h1> Simple Calculator</h1>
   <form action="calculator.jsp" method="post">
   
      <label for="num1">Number 1:</label>
      <input type ="number" id ="num1" name="num1" required>
      <br><br>
      <label for="num2">Number 2:</label>
      <input type ="number" id ="num2" name="num2" required>
      <br><br>
      <label for="operation">Operation:</label>
      <select id="operation" name="operation" required>
      <option value="" disabled selected>Select an operation</option>
      <option value="add">Addition</option>
      <option value="subract">Subtraction</option>
      <option value="multiply">Multiplication</option>
      <option value="divide">Division</option>
      </select>
      <br><br>
      <button type="submit">Calculate</button>
   </form>
   
   <%
   
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String operation = request.getParameter("operation");
        if(num1!=null && num2!=null && operation!=null){
        	double number1 = Double.parseDouble(num1);
        	double number2 = Double.parseDouble(num2);
        	double result =0;
        	
        	switch(operation){
        	case "add":
        		result = number1+number2;
        	    break;
        	case "subract":
        		result = number1-number2;
        		break;
        	case "multiply":
        		result = number1*number2;
        		break;
        	case "divide":
        	     if(number2!=0){
        	    	 result = number1/number2;
        	    	 
        	     }
        	     else{
        	    	 out.println("<p style='color: red;'>Division by zero is not allowed</p>");
        	    	 return;
        	     }
        	     break;
        	}
        	out.println("<h2>Result: " +result + "</h2>");
        }
   
   
   
   %>

</body>
</html>