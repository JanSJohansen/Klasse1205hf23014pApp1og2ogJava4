package dk.tec.jaj.example3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import dk.tec.jaj.AnalyzeRequest;
import dk.tec.jaj.DBTool;
import dk.tec.jaj.Elev;


//@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{	
		PrintWriter out = response.getWriter();
		
		ObjectMapper mapper = new ObjectMapper();
		
		DBTool dbTool = new DBTool();
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		
		switch(analyze.getLevel())
		{
		case MatchElevId:
			out.print("Match på Elev og id: " + analyze.getId() + "<br/>");
			
			Elev elev = dbTool.getElevById(analyze.getId());
			
			out.print(mapper.writeValueAsString(elev));
			break;
		case MatchElev:
			out.print("Match på Elev");
			
			break;
		case MatchNo:
			out.print("No Match");
		}		
	}
}




