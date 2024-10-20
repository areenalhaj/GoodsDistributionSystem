package MainPackage;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;

public class ShareVar{
	static Font CalibriFont15 = new Font("calibri",Font.BOLD,15);
	static Font CalibriFont14 = new Font("calibri",Font.BOLD,14);
	static Font CalibriFont12 = new Font("calibri",Font.BOLD,12);
	static Color MyWhite = Color.WHITE;
	static Color MyGray = Color.GRAY;
	
	static String StatisticsNames[] = {"نسبة الاستيراد","نسبة التصدير للفروع","صافي الربح المتوقع"};
	static String AllQuantity = "0";
	static String ExportedQuantity = "0";
	static String ImportedQuantity = "0";
	static double StatisticsNumberValues[] = {0,0,0};      //sum, sub, sumprofit
	static String StatisticsStringValues[] = {"0.0","0.0","0.0"};//sum, sub, sumprofit
	
	static String[] BranchesNamesArray=new String[5];
	static String[] LocationsArray=new String[5];
	static String[][] BranchesInfoArray=new String[2][5];//For all info
	static int BranchesNumber = 5;
	static String SingleBranchRow[]= new String[2]; //name,location
	
	static String[][] DataArray=new String[21][5];//name,quantity,date,price,location
	static int GoodsNumber = 0; //next good index to add
	static String SingleDataRow[]= new String[5];   //name,quantity,date,price,location
	
}