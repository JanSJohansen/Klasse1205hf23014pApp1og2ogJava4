package dk.tec.jaj.example2;

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
import dk.tec.jaj.Elev;


//@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{	
		PrintWriter out = response.getWriter();
		
		ObjectMapper mapper = new ObjectMapper();
		
		Elev elev1 = new Elev(1000, "Christian Dam", "Slagter");
		Elev elev2 = new Elev(1001, "Christian Lüdeking", "Programmør");
		Elev elev3 = new Elev(1002, "Adam", "Gadefejer ferie");
		ArrayList<Elev> elever = new ArrayList<Elev>();
		elever.add(elev1);
		elever.add(elev2);
		elever.add(elev3);
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		switch(analyze.getLevel())
		{
		case MatchElevId:
			out.print("Match på Elev og id: " + analyze.getId() + "<br/>");
			
			out.print(mapper.writeValueAsString(elever.get(analyze.getId())));
			break;
		case MatchElev:
			//out.print("Match på Elev");
			String json = mapper.writeValueAsString(elever);
			out.print(json);
			break;
		case MatchNo:
			out.print("No Match");
		}		
	}
}




