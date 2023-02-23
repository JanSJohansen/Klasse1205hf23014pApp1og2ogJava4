package dk.tec.jaj.example1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dk.tec.jaj.AnalyzeRequest;


//@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{	
		PrintWriter out = response.getWriter();
		//out.print("ContextPath: " + request.getContextPath());
		//out.print("<br/>ServletPath: " + request.getServletPath());
		//out.print("<br/>Her kommer PathInfo: " + request.getPathInfo());
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		switch(analyze.getLevel())
		{
		case MatchElevId:
			out.print("Match på Elev og id: " + analyze.getId());
			break;
		case MatchElev:
			out.print("Match på Elev");
			break;
		case MatchNo:
			out.print("No Match");
		}		
	}
}




