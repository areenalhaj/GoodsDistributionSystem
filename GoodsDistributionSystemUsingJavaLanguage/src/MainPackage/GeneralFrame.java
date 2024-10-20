package MainPackage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
public class GeneralFrame extends JFrame implements ActionListener, ItemListener{

		static JFrame LoginWindow;
	public static void main(String args[]) {
		//Program starts working here:
		LoginWindow = new LoginWindow();
	}
	
	public GeneralFrame() {
		setResizable(false);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLayout(new BorderLayout(5,5));
	}
	
	public void actionPerformed(ActionEvent aevent) {
		error();
		close();
	}
	public void itemStateChanged(ItemEvent ievent) {
		error();
		close();
		
	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	
	public void error() {
		JOptionPane.showMessageDialog(null,"عذرًا، حدث خطأ إثناء إتمام العملية الأخيرة.",
				"خطأ",JOptionPane.PLAIN_MESSAGE);
	}
	public void delete(int DeleteIndex) {
		ShareVar.BranchesNumber--;
		int sizeNow = ShareVar.BranchesNumber;
		String [] names = new String[sizeNow];
		String [] locations = new String[sizeNow];
		int j=0;
		for(int i=0; i<sizeNow+1;i++) {
			if(i!=DeleteIndex) {
				names[j] = ShareVar.BranchesNamesArray[i];
				locations[j] = ShareVar.LocationsArray[i];
				j++;
			}
		}
		ShareVar.BranchesNamesArray = names;
		ShareVar.LocationsArray = locations;
		for(int i=0; i<ShareVar.BranchesNumber;i++) 
		ShareVar.BranchesInfoArray[0]=ShareVar.BranchesNamesArray;
		ShareVar.BranchesInfoArray[1]=ShareVar.LocationsArray;
	}//delete method ends
	
	public void updateBranch(int index,String name,String location) {
		ShareVar.BranchesNamesArray[index]=name;
		ShareVar.LocationsArray[index]=location;
	}
	
	public boolean checkAndUpdateStatistics(int index,double ExpQuantity,double ExpFullProfit){
		double QuantitySaved = Double.parseDouble(ShareVar.DataArray[index][1]);//Quantity before
		if(ExpQuantity > QuantitySaved || ExpQuantity<=0) {
			error();
			return false;
		}
		else {
			updateQuantity(index,ExpQuantity,QuantitySaved);
			updateProfit(index,ExpFullProfit);
			return true;
		}
	}
//		بعد التوزيع
	public void updateQuantity(int index,double ExportQuantity, double quantitySaved){
		ShareVar.DataArray[index][1]=""+(quantitySaved-ExportQuantity);
		removeFromeStatisticsNumberValues(""+(ExportQuantity));;
	}
	
	public void removeFromeStatisticsNumberValues(String quantity) {//15
		double [] doubles=getDoublesNeeded(quantity);
		doubles[3] += doubles[0];//exp
		doubles[2] -= doubles[0];//imp
		doubles[1] = doubles[3]+doubles[2];//all
		ShareVar.AllQuantity=""+doubles[1];//all
		ShareVar.ImportedQuantity=""+doubles[2];//imp
		ShareVar.ExportedQuantity=""+doubles[3];//exp
//		IMPORT %
		double importPercent = 100*(doubles[2]/doubles[1]);
		ShareVar.StatisticsNumberValues[0] = importPercent;
		ShareVar.StatisticsStringValues[0] = ""+ShareVar.StatisticsNumberValues[0];
//		EXPORT %
		double exportPercent = 100*(doubles[3]/doubles[1]);
		ShareVar.StatisticsNumberValues[1] = exportPercent;
		ShareVar.StatisticsStringValues[1] = ""+ShareVar.StatisticsNumberValues[1];
	}
//		بعد الاضافة
	public void addToStatisticsNumberValues(String quantity) {
		double [] doubles=getDoublesNeeded(quantity);
		doubles[1] += doubles[0];//all
		doubles[2] += doubles[0];//imp
		ShareVar.AllQuantity=""+doubles[1];//all
		ShareVar.ImportedQuantity=""+doubles[2];//imp
//		IMPORT %
		double importPercent = 100*(doubles[2]/doubles[1]);
		ShareVar.StatisticsNumberValues[0] = importPercent;
		ShareVar.StatisticsStringValues[0] = ""+ShareVar.StatisticsNumberValues[0];
//		EXPORT %
		double exportPercent = 100*(doubles[3]/doubles[1]);
		ShareVar.StatisticsNumberValues[1] = exportPercent;
		ShareVar.StatisticsStringValues[1] = ""+ShareVar.StatisticsNumberValues[1];
	}
	
	public double[] getDoublesNeeded(String quantity) {
		double Quantity = Double.parseDouble(quantity);
		double AllQuant = Double.parseDouble(ShareVar.AllQuantity);
		double ImportedQuant = Double.parseDouble(ShareVar.ImportedQuantity);
		double ExportedQuant = Double.parseDouble(ShareVar.ExportedQuantity);
		double []doublesArr= {Quantity,AllQuant,ImportedQuant,ExportedQuant};
		return doublesArr;
	}
	
	public void updateProfit(int index,double profit){
		ShareVar.StatisticsNumberValues[2] += profit;
		ShareVar.StatisticsStringValues[2] = ""+ShareVar.StatisticsNumberValues[2];
	}
	
}
