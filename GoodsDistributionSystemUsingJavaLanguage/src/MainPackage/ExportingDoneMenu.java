package MainPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ExportingDoneMenu extends GeneralFrame{
	String BranchNameVar;
	JButton CancelButton, PreviousButton, MainMenuButton, AddMoreButton;
	ArrayList <JButton> ButtonsArray;
	ExportingDoneMenu(String BranchName){
		super();
		setTitle("تمت عملية التوزيع بنجاح");
		setSize(350,250);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(0,0));
		
	//	 >>>>>>>>>>>  NORTH  <<<<<<<<<<<<
		BranchNameVar=BranchName;
		JPanel NorthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,15,5));
	//	label:
	    JLabel NorthLabel = new JLabel("تمت عملية التوزيع بنجاح، اختر العملية التالية:");
	    NorthLabel.setHorizontalAlignment(JLabel.RIGHT);
	    NorthLabel.setFont(ShareVar.CalibriFont15);
		NorthPanel.add(NorthLabel);
		
//		>>>>>>>>>>>  EAST & WEST  <<<<<<<<<<<<
		AddMoreButton = new JButton("توزيع المزيد للفرع");
		PreviousButton = new JButton("السابق (اختيار فرع)");
		MainMenuButton = new JButton("الصفحة الرئيسية");
		CancelButton = new JButton("إغلاق البرنامج");
		ButtonsArray = new ArrayList<JButton>();
		ButtonsArray.add(AddMoreButton);
		ButtonsArray.add(PreviousButton);
		ButtonsArray.add(MainMenuButton);
		ButtonsArray.add(CancelButton);
		for(int i=0;i<ButtonsArray.size();i++) {
			ButtonsArray.get(i).setFont(ShareVar.CalibriFont15);
			ButtonsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
		}
	    JPanel EastPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,40));
	    EastPanel.setPreferredSize(new Dimension(180, 30)); 
		EastPanel.add(AddMoreButton);
		EastPanel.add(PreviousButton);
		JPanel WestPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,40));
		WestPanel.setPreferredSize(new Dimension(170, 30)); 
		WestPanel.add(MainMenuButton);
		WestPanel.add(CancelButton);
		for(int i=0;i<ButtonsArray.size();i++) {
			ButtonsArray.get(i).addActionListener(this);
		}
//	 >>>>>>>>>>>  FRAME  <<<<<<<<<<<<
		add(NorthPanel,BorderLayout.NORTH);
		add(EastPanel,BorderLayout.EAST);
		add(WestPanel,BorderLayout.WEST);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent aevent) {
		JButton SourceButton = (JButton)aevent.getSource();
		if(SourceButton == CancelButton) {
			System.exit(0);	
		}
		else if(SourceButton == MainMenuButton) {
			new MainMenu();
			close();
		}
		else if(SourceButton == PreviousButton) {
			new ExportingLocation();
			close();
		}
		else if(SourceButton == AddMoreButton) {
			close();
			new ExportGoodsToBranch(BranchNameVar);
		}
	}
}
