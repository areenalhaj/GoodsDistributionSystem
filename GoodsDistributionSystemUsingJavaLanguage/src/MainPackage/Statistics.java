package MainPackage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;

public class Statistics extends GeneralFrame{
	JButton CancelButton, MainMenuButton;
	ArrayList <JButton> ButtonsArray;
	
	public Statistics() {
		super();
		setTitle("الإحصائيات");
		setSize(400,400);
		setLocationRelativeTo(null);
		
//		>>>>>>>>>>>>>>>>>    NORTH    <<<<<<<<<<<<<<<<
		JPanel NorthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,30,10));
//		label:
	    JLabel NorthLabel = new JLabel("هنا يتم عرض الإحصائيات الخاصة بالمتجر:");
	    NorthLabel.setHorizontalAlignment(JLabel.RIGHT);
	    NorthLabel.setVerticalAlignment(JLabel.CENTER);
	    NorthLabel.setFont(ShareVar.CalibriFont15);
		NorthPanel.add(NorthLabel);

//		>>>>>>>>>>>>>>>>>    CENTER    <<<<<<<<<<<<<<<<		
//		>>>>>>>>>>>>>>>>> EAST & WEST  <<<<<<<<<<<<<<<<
		int sizeNow = ShareVar.StatisticsNames.length;
		JPanel EastPanel = new JPanel(new GridLayout(sizeNow,1,10,20));
		JPanel WestPanel = new JPanel(new GridLayout(sizeNow,1,10,20));
		EastPanel.setPreferredSize(new Dimension(230,330));
		WestPanel.setPreferredSize(new Dimension(150,330));
//		Labels Arrays
		JLabel []StatisticsNamesLabelsArray= new JLabel[3];
		JLabel []StatisticsValuesLabelsArray= new JLabel[3];
		
		for(int i=0;i<sizeNow;i++) {
			String statisticName=ShareVar.StatisticsNames[i];
			String statisticValue=""+String.format("%.2f",ShareVar.StatisticsNumberValues[i]);//format(" %.2f ",double);
			if(i<sizeNow-1)
				statisticValue="% "+statisticValue;
			else {
				statisticValue=statisticValue+" شيكل";
			}
			StatisticsNamesLabelsArray[i]=new JLabel(statisticName);
			StatisticsValuesLabelsArray[i]=new JLabel(statisticValue);

			StatisticsNamesLabelsArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			StatisticsNamesLabelsArray[i].setFont(ShareVar.CalibriFont15);
			StatisticsValuesLabelsArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			StatisticsValuesLabelsArray[i].setFont(ShareVar.CalibriFont15);
			EastPanel.add(StatisticsNamesLabelsArray[i]);
			WestPanel.add(StatisticsValuesLabelsArray[i]);
		}
		
		JPanel CenterPanel = new JPanel(new GridLayout(1,2,20,10));
		CenterPanel.setPreferredSize(new Dimension(400, 280)); 
		CenterPanel.add(WestPanel);
		CenterPanel.add(EastPanel);
		
//			>>>>>>>>>>>>>>>>>    SOUTH    <<<<<<<<<<<<<<<<
		MainMenuButton = new JButton("العودة للرئيسية");
		CancelButton = new JButton("إغلاق البرنامج");
		ButtonsArray = new ArrayList<JButton>();
		ButtonsArray.add(MainMenuButton);
		ButtonsArray.add(CancelButton);
		for(int i=0;i<ButtonsArray.size();i++) {
			ButtonsArray.get(i).setFont(ShareVar.CalibriFont15);
			ButtonsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
			ButtonsArray.get(i).addActionListener(this);
			}
		JPanel SouthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,80,40));
		SouthPanel.setPreferredSize(new Dimension(400, 100)); 
		SouthPanel.add(CancelButton);
		SouthPanel.add(MainMenuButton);
		
//		>>>>>>>>>>>>>>>>>    FRAME    <<<<<<<<<<<<<<<<
		add(NorthPanel,BorderLayout.NORTH);
		add(EastPanel,BorderLayout.EAST);
		add(WestPanel,BorderLayout.WEST);
		add(SouthPanel,BorderLayout.SOUTH);
		
//		getContentPane().validate();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent event) {
		JButton SourceButton = (JButton)event.getSource();
		if(SourceButton == CancelButton) {
			System.exit(0);	
		}
		else if(SourceButton == MainMenuButton) {
			close();
			new MainMenu();
		}
	}
	
	
//	FUNCTIONS
	
}
