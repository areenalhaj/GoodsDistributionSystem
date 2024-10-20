package MainPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GoodsInfo extends GeneralFrame{
	JButton CancelButton, PreviousButton, MainMenuButton;
	ArrayList <JButton> ButtonsArray;
	JLabel ProductNameField, QuantityField, DateField, PriceField,ImportingLocationField;
	ArrayList <JLabel> LabelsArray;
	ArrayList <JLabel> FieldsDataArray;
	public GoodsInfo(String []ChosenGoodData) {
		super();
		setTitle("تفاصيل معلومات البضاعة");
		setSize(400,400);
		setLocationRelativeTo(null);
		
//		>>>>>>>>>>>>>>>>>    NORTH    <<<<<<<<<<<<<<<<
		JPanel NorthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,15,5));
//		label:
	    JLabel NorthLabel = new JLabel("هذه المعلومات المسجلة للبضاعة في قاعدة البيانات:");
	    NorthLabel.setHorizontalAlignment(JLabel.RIGHT);
	    NorthLabel.setVerticalAlignment(JLabel.CENTER);
	    NorthLabel.setFont(ShareVar.CalibriFont15);
		NorthPanel.add(NorthLabel);
		
//		>>>>>>>>>>>>>>>>>    EAST & WEST    <<<<<<<<<<<<<<<<
		JPanel EastPanel = new JPanel(new GridLayout(5,1,10,20));
		JPanel WestPanel = new JPanel(new GridLayout(5,1,10,20));
		EastPanel.setPreferredSize(new Dimension(150,250));
		WestPanel.setPreferredSize(new Dimension(200,250));
//		Labels & Fields Creating:
		JLabel ProductNameLabel = new JLabel("اسم/رقم المنتج:");
		JLabel QuantityLabel = new JLabel("الكمية (صندوق):");
		JLabel DateLabel = new JLabel("التاريخ:");
		JLabel PriceLabel = new JLabel("التكلفة (شيكل):");
		JLabel ImportingLocationLabel = new JLabel("مكان الاستيراد:");
		
		ProductNameField = new JLabel(ChosenGoodData[0]);
		QuantityField = new JLabel(ChosenGoodData[1]);
		DateField = new JLabel(ChosenGoodData[2]);
		PriceField = new JLabel(ChosenGoodData[3]);
		ImportingLocationField = new JLabel(ChosenGoodData[4]);
//Storing inside an ArrayLists:
		LabelsArray = new ArrayList <JLabel>();
		{	LabelsArray.add(ProductNameLabel);
			LabelsArray.add(QuantityLabel);
			LabelsArray.add(DateLabel);
			LabelsArray.add(PriceLabel);
			LabelsArray.add(ImportingLocationLabel);}
		FieldsDataArray = new ArrayList<JLabel>();
		{	FieldsDataArray.add(ProductNameField);
			FieldsDataArray.add(QuantityField);
			FieldsDataArray.add(DateField);
			FieldsDataArray.add(PriceField);
			FieldsDataArray.add(ImportingLocationField);
			}
//		Alignments of text fields:
		for(int i=0;i<LabelsArray.size();i++) {
			FieldsDataArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
			LabelsArray.get(i).setHorizontalAlignment(SwingConstants.CENTER);			
			FieldsDataArray.get(i).setFont(ShareVar.CalibriFont14);
			LabelsArray.get(i).setFont(ShareVar.CalibriFont14);
		}
		
//		Adding items to East and West Panels:
		for(int i=0;i<LabelsArray.size();i++) {
			EastPanel.add(LabelsArray.get(i));
			WestPanel.add(FieldsDataArray.get(i));
		}
		
//		>>>>>>>>>>>>>>>>>    SOUTH    <<<<<<<<<<<<<<<<
		//		Add edit data button
		PreviousButton = new JButton("السابق");
		CancelButton = new JButton("إغلاق البرنامج");
		MainMenuButton = new JButton("العودة للرئيسية");
		ButtonsArray = new ArrayList<JButton>();
		ButtonsArray.add(PreviousButton);
		ButtonsArray.add(CancelButton);
		ButtonsArray.add(MainMenuButton);
		for(int i=0;i<ButtonsArray.size();i++) {
			ButtonsArray.get(i).setFont(ShareVar.CalibriFont15);
			ButtonsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
			ButtonsArray.get(i).addActionListener(this);
		}
		JPanel SouthPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,25,40));
		SouthPanel.setPreferredSize(new Dimension(400, 100)); 
		SouthPanel.add(CancelButton);
		SouthPanel.add(MainMenuButton);
		SouthPanel.add(PreviousButton);
		
//		>>>>>>>>>>>>>>>>>    FRAME    <<<<<<<<<<<<<<<<
		add(NorthPanel,BorderLayout.NORTH);
		add(EastPanel,BorderLayout.EAST);
		add(WestPanel,BorderLayout.WEST);
		add(SouthPanel,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent aevent) {
		JButton SourceButton = (JButton)aevent.getSource();
		if(SourceButton==CancelButton) {
			System.exit(0);							
		}else if(SourceButton==PreviousButton) {
			close();
			new Warehouse();
		}else if(SourceButton==MainMenuButton) {
			close();
			new MainMenu();
		}	
	}
}
