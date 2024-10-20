package MainPackage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ImportedGoods extends GeneralFrame{
	JButton CancelButton, MainMenuButton,EnterAndSaveButton;
	JTextField ProductNameField, QuantityField, DateField, PriceField, ImportingLocationField;
	ArrayList <JLabel> LabelsArray;
	ArrayList <JTextField> TextFieldsArray;
	JComboBox GoodsComboBox;
	String LocationsBoxListArray[]=new String[6];
	ArrayList<JButton> ButtonsArray;
	public ImportedGoods() {
//		Frame:
		super();
		setTitle("البضائع المستوردة");
		setSize(410,360);
		setLocationRelativeTo(null);
		
//		>>>>>>>>>>>   NORTH   <<<<<<<<<<<
		JPanel NorthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,20,15));
//		label:
	    JLabel NorthLabel = new JLabel("أدخل البيانات في الحقول الخاصة بها:");
	    NorthLabel.setHorizontalAlignment(JLabel.RIGHT);
	    NorthLabel.setVerticalAlignment(JLabel.CENTER);
	    NorthLabel.setFont(ShareVar.CalibriFont15);
		NorthPanel.add(NorthLabel);

//		>>>>>>>>>>>  EAST & WEST  <<<<<<<<<<<<<<
		JPanel EastPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,20,21));
		JPanel WestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,35,17));
		EastPanel.setPreferredSize(new Dimension(120,30));
		WestPanel.setPreferredSize(new Dimension(290,30));
//		Labels & Fields Creating:
		JLabel ProductNameLabel = new JLabel("اسم/رقم المنتج:");
		JLabel QuantityLabel = new JLabel("الكمية (صندوق):");
		JLabel DateLabel = new JLabel("التاريخ:");
		JLabel PriceLabel = new JLabel("تكلفة الصندوق:");
		JLabel ImportingLocationLabel = new JLabel("مكان الاستيراد:");
		ProductNameField = new JTextField("");
		QuantityField = new JTextField("0");
		DateField = new JTextField(LocalDate.now().toString());
		PriceField = new JTextField("00.00");
		ImportingLocationField = new JTextField("-");
//Storing inside an ArrayLists:
		LabelsArray = new ArrayList <JLabel>();
		{	LabelsArray.add(ProductNameLabel);
			LabelsArray.add(QuantityLabel);
			LabelsArray.add(DateLabel);
			LabelsArray.add(PriceLabel);
			LabelsArray.add(ImportingLocationLabel);
			}
		TextFieldsArray = new ArrayList<JTextField>();
		{	TextFieldsArray.add(ProductNameField);
			TextFieldsArray.add(QuantityField);
			TextFieldsArray.add(DateField);
			TextFieldsArray.add(PriceField);
			TextFieldsArray.add(ImportingLocationField);
			}
//		Alignments of text fields:
		for(int i=0;i<TextFieldsArray.size();i++) {
			TextFieldsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
			TextFieldsArray.get(i).setColumns(19);
			TextFieldsArray.get(i).setFont(ShareVar.CalibriFont14);
			LabelsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
			LabelsArray.get(i).setFont(ShareVar.CalibriFont14);
		}
//		Adding items to East and West Panels:
		for(int i=0;i<LabelsArray.size();i++) {
			EastPanel.add(LabelsArray.get(i));
		}
		for(int i=0;i<TextFieldsArray.size();i++) {
			WestPanel.add(TextFieldsArray.get(i));
		}
		
//		>>>>>>>>>>>>   SOUTH   <<<<<<<<<<<<<
		//Leading alignment contains : CancelButton
	    JPanel SouthPanel = new JPanel(new GridLayout(1,2,0,10));
//		SouthRight:
		JPanel SouthRightPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,15,10));
		JPanel SouthLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEADING,15,10));
		EnterAndSaveButton = new JButton("إدخال");
		SouthRightPanel.add(EnterAndSaveButton);
		CancelButton = new JButton("إلغاء");
		MainMenuButton = new JButton("العودة للرئيسية");
		SouthLeftPanel.add(CancelButton);
		SouthLeftPanel.add(MainMenuButton);
		ButtonsArray = new ArrayList<JButton>();
		ButtonsArray.add(EnterAndSaveButton);
		ButtonsArray.add(CancelButton);
		ButtonsArray.add(MainMenuButton);
		for(int i=0;i<ButtonsArray.size();i++) {
			ButtonsArray.get(i).setFont(ShareVar.CalibriFont14);
			ButtonsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
			ButtonsArray.get(i).addActionListener(this);
		}
//		Adding them to the south panel:
		SouthPanel.add(SouthLeftPanel);
		SouthPanel.add(SouthRightPanel);		
//		>>>>>>>>>>  FRAME  <<<<<<<<<<<<<
		add(NorthPanel,BorderLayout.NORTH);
	    add(WestPanel,BorderLayout.WEST);
	    add(EastPanel,BorderLayout.EAST);
		add(SouthPanel,BorderLayout.SOUTH);
		getContentPane().validate();
	    setVisible(true);
	}
	
	public void actionPerformed(ActionEvent aevent) {
		JButton SourceButton = (JButton)aevent.getSource();
		if(SourceButton == CancelButton) {
			System.exit(0);	
		}else if(SourceButton == MainMenuButton) {
			close();
			new MainMenu();
		}else if(SourceButton == EnterAndSaveButton){
			for(int i=0;i<TextFieldsArray.size();i++) {
				String boxData=TextFieldsArray.get(i).getText().toString();
				ShareVar.SingleDataRow[i]=boxData;
				}
			if(!ShareVar.SingleDataRow[0].equals("")) {//empty
				saveData();
				close();
				new ImportSavedMenu();
			}else{
				error();
			}
		}
	}
	
	public void saveData() {
//		Save Data entered into a multi dimentions array
		try {
			String []DataRow = ShareVar.SingleDataRow.clone();;
			ShareVar.DataArray[ShareVar.GoodsNumber] = DataRow;
			ShareVar.GoodsNumber++;
		}catch(Exception ex) {
			error();
		}
	}
}
