package MainPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ExportGoodsToBranch extends GeneralFrame{
	
	JTextField ProductNameField, QuantityField, DateField, ProfitField,ImportingLocationField;
	ArrayList <JLabel> LabelsArray;
	ArrayList <JTextField> TextFieldsArray;
	JButton CancelButton, SubmitButton, PreviousButton, MainMenuButton, LocationsComboBoxButton;
	ArrayList <JButton> ButtonsArray;
	JComboBox GoodsComboBox;
	String ExportLocationsArray[]=new String[6];
	String GoodsNamesArray[]=new String[ShareVar.GoodsNumber];
	String BranchNameVar;
	
	public ExportGoodsToBranch(String BranchName) {
		super();
		setTitle("توزيع بضاعة إلى "+BranchName);
		setSize(440,400);
		setLocationRelativeTo(null);
		BranchNameVar = BranchName;
//		>>>>>>>>>>>>    NORTH     <<<<<<<<<<<<<
		JPanel NorthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,25,15));
//		label:
	    JLabel NorthLabel = new JLabel("أدخل معلومات البضاعة التي تريد توزيعها إلى "+BranchName+":");
	    NorthLabel.setHorizontalAlignment(JLabel.RIGHT);
	    NorthLabel.setVerticalAlignment(JLabel.CENTER);
	    NorthLabel.setFont(ShareVar.CalibriFont15);
		NorthPanel.add(NorthLabel);
		
//		>>>>>>>>>>>>    EAST & WEST     <<<<<<<<<<<<<
		JPanel EastPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,20,21));
		JPanel WestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,35,17));
		EastPanel.setPreferredSize(new Dimension(140,30));
		WestPanel.setPreferredSize(new Dimension(290,30));
//		Labels & Fields Creating:
		JLabel ProductNameLabel = new JLabel("اسم/رقم المنتج:");
		JLabel QuantityLabel = new JLabel("الكمية (صندوق):");
		JLabel DateLabel = new JLabel("التاريخ:");
		JLabel ProfitLabel = new JLabel("المبلغ المتوقع ربحه (شيكل):");
		GoodsNamesArray[0]=" - اختر اسم البضاعة من هنا ";
		for(int i=1;i<ShareVar.GoodsNumber;i++)
			GoodsNamesArray[i] = ShareVar.DataArray[i][0];
		GoodsComboBox = new JComboBox(GoodsNamesArray);		
		QuantityField = new JTextField("0"); //    LIMITED BY THE QUANTITY IN THE WAREHOUSE
		DateField = new JTextField(LocalDate.now().toString());
		ProfitField = new JTextField("00.00");
//Storing inside an ArrayLists:
		LabelsArray = new ArrayList <JLabel>();
		{
			LabelsArray.add(ProductNameLabel);
			LabelsArray.add(QuantityLabel);
			LabelsArray.add(DateLabel);
			LabelsArray.add(ProfitLabel);
			}
		TextFieldsArray = new ArrayList<JTextField>();
		{
			TextFieldsArray.add(QuantityField);
			TextFieldsArray.add(DateField);
			TextFieldsArray.add(ProfitField);
			}
//		Alignments,size, & font of text fields, labels, & combobox:
		for(int i=0;i<TextFieldsArray.size();i++) {
			LabelsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
			TextFieldsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
			GoodsComboBox.setAlignmentX(SwingConstants.RIGHT);
			TextFieldsArray.get(i).setColumns(19);
			GoodsComboBox.setBounds(50, 100, 90, 20);
			GoodsComboBox.setFont(ShareVar.CalibriFont14);
			TextFieldsArray.get(i).setFont(ShareVar.CalibriFont14);
			LabelsArray.get(i).setFont(ShareVar.CalibriFont14);
		}
//		Adding items to East and West Panels:
		WestPanel.add(GoodsComboBox);
		for(int i=0;i<LabelsArray.size();i++) {
			EastPanel.add(LabelsArray.get(i));
		}
		for(int i=0;i<TextFieldsArray.size();i++) {
			WestPanel.add(TextFieldsArray.get(i));
		}
		
//		>>>>>>>>>>     SOUTH     <<<<<<<<<<<<<<<<<<<
		PreviousButton = new JButton("السابق");
		MainMenuButton = new JButton("العودة للرئيسية");
		CancelButton = new JButton("إلغاء");
		SubmitButton = new JButton("توزيع");
		ButtonsArray = new ArrayList<JButton>();
		ButtonsArray.add(PreviousButton);
		ButtonsArray.add(MainMenuButton);
		ButtonsArray.add(CancelButton);
		ButtonsArray.add(SubmitButton);
		for(int i=0;i<ButtonsArray.size();i++) {
			ButtonsArray.get(i).setFont(ShareVar.CalibriFont15);
			ButtonsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
			ButtonsArray.get(i).addActionListener(this);
		}
		JPanel SouthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,25,40));
		SouthPanel.setPreferredSize(new Dimension(400, 100)); 
		SouthPanel.add(CancelButton);
		SouthPanel.add(MainMenuButton);
		SouthPanel.add(PreviousButton);
		SouthPanel.add(SubmitButton);		
		
//		>>>>>>>>>>     FRAME     <<<<<<<<<<<<<<<<<<<
		add(NorthPanel,BorderLayout.NORTH);
		add(WestPanel,BorderLayout.WEST);
		add(EastPanel,BorderLayout.EAST);
		add(SouthPanel,BorderLayout.SOUTH);
		setVisible(true);
	}
//	>>>>>>>>>>     ACTION EVENT    <<<<<<<<<<<<<<<<<<<
	public void actionPerformed(ActionEvent aevent) {
		JButton SourceButton = (JButton)aevent.getSource();
		if(SourceButton==CancelButton) {
			System.exit(0);					
		}else if(SourceButton == SubmitButton) {
			try {
				int index = GoodsComboBox.getSelectedIndex();//check index
				double ExpQuantity =Double.parseDouble(QuantityField.getText());
				double ExpFullProfit =Double.parseDouble(ProfitField.getText());
				if(!checkAndUpdateStatistics(index,ExpQuantity, ExpFullProfit));
				else {
					close();
					new ExportingDoneMenu(BranchNameVar);
				}
			}
			catch(Exception e) {
				error();
			}
		}else if(SourceButton==PreviousButton) {
			close();
			new ExportingLocation();
		}else if(SourceButton==MainMenuButton) {
			close();
			new MainMenu();
		}
	}
}
