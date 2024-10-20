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

public class ImportSavedMenu extends GeneralFrame {

	JButton CancelButton, PreviousButton, AddMoreButton;
	ArrayList <JButton> ButtonsArray;
	ImportSavedMenu(){
	super();
	setTitle("استكمال العملية");
	setSize(350,250);
	setLocationRelativeTo(null);
	setLayout(new BorderLayout(0,0));
	
	JPanel NorthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,15,5));
//	label:
    JLabel NorthLabel = new JLabel("تمت عملية الإدخال بنجاح، اختر العملية التالية:");
    NorthLabel.setHorizontalAlignment(JLabel.RIGHT);
    NorthLabel.setFont(ShareVar.CalibriFont15);
	NorthPanel.add(NorthLabel);
	
	AddMoreButton = new JButton("إضافة المزيد");
	PreviousButton = new JButton("الرجوع للسابق");
	CancelButton = new JButton("إغلاق البرنامج");
	ButtonsArray = new ArrayList<JButton>();
	ButtonsArray.add(AddMoreButton);
	ButtonsArray.add(PreviousButton);
	ButtonsArray.add(CancelButton);
	for(int i=0;i<ButtonsArray.size();i++) {
		ButtonsArray.get(i).setFont(ShareVar.CalibriFont15);
		ButtonsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
	}
    JPanel EastPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,40));
    EastPanel.setPreferredSize(new Dimension(180, 30)); 
	EastPanel.add(AddMoreButton);
	EastPanel.add(PreviousButton);
	JPanel WestPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,110));
	WestPanel.setPreferredSize(new Dimension(170, 30)); 
	WestPanel.add(CancelButton);
	add(NorthPanel,BorderLayout.NORTH);
	add(EastPanel,BorderLayout.EAST);
	add(WestPanel,BorderLayout.WEST);
	for(int i=0;i<ButtonsArray.size();i++) {
		ButtonsArray.get(i).addActionListener(this);
	}
	setVisible(true);
	}
	public void actionPerformed(ActionEvent aevent) {
		JButton SourceButton = (JButton)aevent.getSource();
		if(SourceButton == CancelButton) {
			System.exit(0);	
		}
		else if(SourceButton == PreviousButton) {
			new MainMenu();
			close();
		}
		else if(SourceButton == AddMoreButton) {
			close();
			new ImportedGoods();
		}
	}
}
