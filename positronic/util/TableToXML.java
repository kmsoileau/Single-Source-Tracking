package positronic.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TableToXML
{
	public static void main(String[] args) throws IOException
	{
		/*Object[][] table=new Object[][]{
				{"Column1","Column2","Column3","Column4","Column5","Column6"},
				{"49","48","47","45","36"},
				{"34","12","67","78","34"},
				{"49","48","47","45","36"},
				{"34","12","67","78","34","89"},
				{"49","48","47","45","36"},
				{"34","12","1956","78","34"},
				{"49","48","47","45","36"},
				{"34","12","67","78","34"}
		};*/
		
		Object[][] table=new Object[][]{
				{"Product","Aisle"},
				{"Adhesives","7"},
				{"Air Filters","28"},
				{"Air Tools","12"},
				{"Area Rugs","3"},
				{"Attic Fans","18"},
				{"Attic Stairs","18"},
				{"Axes","45"},
				{"Bath Vanity Base Cabinets","30"},
				{"Bath Fans","28"},
				{"Bath Hardware","27"},
				{"Blinds (Custom)","35"},
				{"Blinds (Mini)","35"},
				{"Blowers","44"},
				{"Bookcases","3"},
				{"Brushes","7"},
				{"Cabinet Hardware","11"},
				{"Cabinets","34"},
				{"Carpet","3"},
				{"Carpet Pads","3"},
				{"Caulk","7"},
				{"Ceiling Fans","38"},
				{"Ceramic Tools","4"},
				{"Chandeliers","38"},
				{"Child Safety","11"},
				{"Cleaners","42"},
				{"Closet Organizers","35"},
				{"Concrete","12"},
				{"Copper Pipe","10"},
				{"Datacom","39"},
				{"Deck Parts","27"},
				{"Dimmers","39"},
				{"Door Chimes","40"},
				{"Door Hardware","11"},
				{"Doors (All Types)","26,27"},
				{"Drywall","27"},
				{"Edgers","46"},
				{"Electrical Boxes","40"},
				{"Electrical Fittings","40"},
				{"Electrical Panels","48"},
				{"Electrical Tools","40"},
				{"Extension Cords","41"},
				{"Fan Accessories","38"},
				{"Faucet Repair","29"},
				{"Faucets","31"},
				{"Flooring (Laminate)","5"},
				{"Flooring (Pergo)","5"},
				{"Flooring (Wood)","6"},
				{"Garage Door Openers","14"},
				{"Grills & Accessories","43"},
				{"Grout & Sealer","6"},
				{"Gutters","18"},
				{"Hedgers","41"},
				{"Hose Repair","44"},
				{"Hoses","44"},
				{"Insulation","20"},
				{"Irrigation","10"},
				{"Jetted Tubs","30"},
				{"Ladders","11"},
				{"Lamps","38"},
				{"Levels","13"},
				{"Light Bulbs","1"},
				{"Lighting (Exterior)","41"},
				{"Lighting (Security)","2"},
				{"Lighting (Shop)","41"},
				{"Lighting (Vanity)","37"},
				{"Lock Sets","11"},
				{"Lumber","15,16,23,24"},
				{"Measuring Tapes","13"},
				{"Melamine","15"},
				{"Mops & Brooms","42"},
				{"Mower Parts","47"},
				{"Mowers","47"},
				{"Nails, Nuts & Bolts","14"},
				{"Paint (Interior & Exterior)","9"},
				{"Paint Sprayers","9"},
				{"Paneling","24"},
				{"Phone Accessories","39"},
				{"Picture Hangers","11"},
				{"Plywood","15"},
				{"Plywood (Cut)","15"},
				{"Pneumatic Nailer","12"},
				{"Primers","8"},
				{"Pruning","46"},
				{"PVC Fittings & Pipe","10"},
				{"Roll Shades","35"},
				{"Roofing & Shingles","18"},
				{"Rope & Chain","14"},
				{"Sandpaper","7"},
				{"Shelving (Metal & Wire)","35"},
				{"Shovels","45"},
				{"Showers","30"},
				{"Sinks","32"},
				{"Smoke Detectors","39"},
				{"Spas","30"},
				{"Sponges","42"},
				{"Spray Paint","8"},
				{"Sprinklers","44"},
				{"Storage","35"},
				{"Storage Cabinets","35"},
				{"Timers","39"},
				{"Toilet Seats","30"},
				{"Toilet Repair","29"},
				{"Toilets","30"},
				{"Trim & Moulding","17"},
				{"Trimmers","45"},
				{"Utility Tubs","30"},
				{"Wall Plates","39"},
				{"Wallpaper","34"},
				{"Water Heaters","28"},
				{"Weather Proofing","11"},
				{"Wet Saw","5"},
				{"Wet/Dry Vacs","14"},
				{"Whirlpools","30"},
				{"Windows","26,27"},
				{"Wire & Wire Moulding","40"},
				{"Wrenches","13"}
				};
		
		toXML("Data",table,"D:\\stuff.xml");
	}
	
	public static String prepString(String s)
	{
		s.replaceAll("&","&amp;");
		s.replaceAll(" ","&nbsp;");
		s.replaceAll("#","_Number$");
		s.replaceAll("%","_PerCent$");
		s.replaceAll("/","$");
		s.replaceAll("'","&apos;");
		s.replaceAll("\"","&quot;");
		s.replaceAll("<","&lt;");
		s.replaceAll(">","&gt;");
		
		//s.replaceAll("","_Box$");
		
		if(s.substring(0,1).indexOf("0123456789/")!=-1)
			s ="$".concat(s);
		
		return s;
	}
	
	public static void toXML(String tableName, Object[][] table, File outputFile) throws IOException
	{
		String[] header=new String[table.length];
		tableName=prepString(tableName);
		FileWriter fow=new FileWriter(outputFile);
		//fow.write("<?xml-stylesheet type=\"text/xsl\" href=\"" + tableName + ".xsl\"?>\n");
		fow.write("<" + tableName + ">\n");
		for(int i=0;i<table.length;i++)
		{
			for(int j=0;j<table[i].length;j++)
			{
				if(i==0)
					header[j] = prepString(table[i][j].toString().trim());
				if(i!=0 && j==0 && table[i][0]!="")
					fow.write("\t<Item>\n");
				if(table[i][j]!="")
				{
					if(i!=0)
						fow.write("\t\t<" + header[j] + ">" + table[i][j].toString().trim().replaceAll("&","&amp;")/*.replaceAll("","_Box$")*/ + "</" + header[j] + ">\n");
				}
			}
			if(i!=0 && table[i][0]!="") 
				fow.write("\t</Item>\n");
		}
		fow.write("</" + tableName + ">\n");
		fow.close();
	}

	public static void toXML(String tableName, Object[][] table, String outputFile) throws IOException
	{
		toXML(tableName,table,new File(outputFile));
	}
}