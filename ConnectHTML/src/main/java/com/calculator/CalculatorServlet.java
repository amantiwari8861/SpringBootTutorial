package com.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		response.getWriter().append("Your Form Submitted Succesfully msg by doGet!!");
		PrintWriter out = response.getWriter();
		int num1 = Integer.parseInt(request.getParameter("n1"));
		int num2 = Integer.parseInt(request.getParameter("n2"));
		String op = request.getParameter("operation");
		int result=0;
		if(op.equals("+"))
		{
			result=num1+num2;
		}
		else if(op.equals("-"))
		{
			result=num1-num2;
		}
		else if(op.equals("*"))
		{
			result=num1*num2;
		}
		else if(op.equals("/"))
		{
			result=num1/num2;
		}
		else {
			out.print("<span style='color:red;'>invalid operation!!!</span>");
		}
		
		out.print("<h1>the result of "+num1+op+num2+"="+result+"</h1>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("hello i am doPost<br>");
		doGet(request,response);
	}

}
