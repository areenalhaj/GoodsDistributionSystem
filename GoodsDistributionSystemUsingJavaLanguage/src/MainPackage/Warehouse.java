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
import java.util.ArrayList;
public class Warehouse extends GeneralFrame{
	
	JComboBox GoodsComboBox;
	String GoodsNamesArray[]=new String[ShareVar.GoodsNumber];
	JButton CancelButton, MainMenuButton,PreviousButton;
	ArrayList <JButton> ButtonsArray;
	public Warehouse() {
	super();
	setTitle("البضائع المتاحة في المستودع");
	setSize(350,300);
	setLocationRelativeTo(null);
	
	JPanel NorthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,25,15));
//	label:
    JLabel NorthLabel = new JLabel("اختر البضاعة التي تريد عرض تفاصيل عنها:");
    NorthLabel.setHorizontalAlignment(JLabel.RIGHT);
    NorthLabel.setVerticalAlignment(JLabel.CENTER);
    NorthLabel.setFont(ShareVar.CalibriFont15);
	NorthPanel.add(NorthLabel);
	
	JPanel CenterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,30,20));
	CenterPanel.setPreferredSize(new Dimension(400, 30)); 
	GoodsNamesArray[0]=" - اختر اسم البضاعة من هنا ";
	for(int i=1;i<ShareVar.GoodsNumber;i++) {
		if(!ShareVar.DataArray[i][0].equals("")) {
			GoodsNamesArray[i] = ShareVar.DataArray[i][0];
			}
	}
	GoodsComboBox = new JComboBox(GoodsNamesArray);
	GoodsComboBox.setBounds(50, 100, 90, 20);
	GoodsComboBox.setFont(ShareVar.CalibriFont14);
	CenterPanel.add(GoodsComboBox);
	
	PreviousButton = new JButton("السابق");
	MainMenuButton = new JButton("العودة للرئيسية");
	CancelButton = new JButton("إغلاق البرنامج");
	ButtonsArray = new ArrayList<JButton>();
	ButtonsArray.add(PreviousButton);
	ButtonsArray.add(MainMenuButton);
	ButtonsArray.add(CancelButton);
	for(int i=0;i<ButtonsArray.size();i++) {
		ButtonsArray.get(i).setFont(ShareVar.CalibriFont15);
		ButtonsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
		ButtonsArray.get(i).addActionListener(this);
	}
	JPanel SouthPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,40));
	SouthPanel.setPreferredSize(new Dimension(400, 100)); 
	SouthPanel.add(CancelButton);
	SouthPanel.add(MainMenuButton);
	SouthPanel.add(PreviousButton);
	
	add(NorthPanel,BorderLayout.NORTH);
	add(CenterPanel,BorderLayout.CENTER);
	add(SouthPanel,BorderLayout.SOUTH);
	
	
	GoodsComboBox.addItemListener(this);
	
	setVisible(true);
	}

	public void actionPerformed(ActionEvent aevent) {
		JButton SourceButton = (JButton)aevent.getSource();
		if(SourceButton==CancelButton) {
			System.exit(0);							
		}else if(SourceButton==PreviousButton) {
			close();
			new ExportedGoods();
		}else if(SourceButton==MainMenuButton) {
			close();
			new MainMenu();
		}	
	}
	
	public void itemStateChanged(ItemEvent ievent) {
		
		String selectedGoodsName = (String)ievent.getItem();
		for(int i=0;i<ShareVar.DataArray.length;i++) {
			if(selectedGoodsName.equals(ShareVar.DataArray[i][0])) {
				close();
				new GoodsInfo(ShareVar.DataArray[i]);
				break;
			}
		}
	}
}
