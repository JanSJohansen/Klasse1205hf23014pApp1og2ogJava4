package dk.tec.jaj;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalyzeRequest 
{
	MatchEnum level;
	int id;
	
	public MatchEnum getLevel() {
		return level;
	}

	public int getId() {
		return id;
	}
	
	public AnalyzeRequest(String pathInfo)
	{
		Matcher matcher = Pattern.compile("/Elev/([0-9]+)").matcher(pathInfo);
		
		if(matcher.find())
		{
			level = MatchEnum.MatchElevId;
			id = Integer.parseInt(matcher.group(1));
		}
		else
		{
			matcher = Pattern.compile("/Elev/").matcher(pathInfo);
			if(matcher.find())
			{
				level = MatchEnum.MatchElev;
			}
			else {
				level = MatchEnum.MatchNo;
			}
		}	
	}
}
