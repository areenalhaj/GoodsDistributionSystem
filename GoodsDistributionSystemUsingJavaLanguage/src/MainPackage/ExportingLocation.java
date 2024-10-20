package MainPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ExportingLocation extends GeneralFrame{
	
	JButton CancelButton, PreviousButton,MainMenuButton, LocationsComboBoxButton;
	ArrayList <JButton> ButtonsArray;
	JComboBox LocationsComboBox;
	String ExportLocationsArray[]=new String[6];	
	
	public ExportingLocation() {
		super();
		setTitle("مكان التوزيع");
		setSize(350,300);
		setLocationRelativeTo(null);
		
//	 	>>>>>>>>>>>  NORTH  <<<<<<<<<<<<		
		JPanel NorthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,25,15));
//		label:
	    JLabel NorthLabel = new JLabel("اختر البضاعة التي تريد عرض تفاصيل عنها:");
	    NorthLabel.setHorizontalAlignment(JLabel.RIGHT);
	    NorthLabel.setVerticalAlignment(JLabel.CENTER);
	    NorthLabel.setFont(ShareVar.CalibriFont15);
		NorthPanel.add(NorthLabel);
		
//	 	>>>>>>>>>>>  CENTER  <<<<<<<<<<<<
		JPanel CenterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,30,20));
		CenterPanel.setPreferredSize(new Dimension(400, 30)); 
		ExportLocationsArray[0]=" - اختر اسم الفرع من هنا ";
		for(int i=1;i<ShareVar.BranchesNumber+1;i++)
			ExportLocationsArray[i] = ShareVar.BranchesNamesArray[i-1];
		LocationsComboBox = new JComboBox(ExportLocationsArray);
		LocationsComboBox.setBounds(50, 100, 90, 20);
		LocationsComboBox.setFont(ShareVar.CalibriFont14);
		CenterPanel.add(LocationsComboBox);
		LocationsComboBox.addItemListener(this);
		
//		>>>>>>>>>>>  SOUTH  <<<<<<<<<<<<
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
		
//		>>>>>>>>>>>  FRAME  <<<<<<<<<<<<
		add(NorthPanel,BorderLayout.NORTH);
		add(CenterPanel,BorderLayout.CENTER);
		add(SouthPanel,BorderLayout.SOUTH);
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
			
			String SelectedBranchName = (String)ievent.getItem();
			for(int i=0;i<ShareVar.BranchesNamesArray.length;i++) {
				if(SelectedBranchName.equals(ShareVar.BranchesNamesArray[i])) {
					close();
					new ExportGoodsToBranch(SelectedBranchName);
					break;
				}
			}
		}
	
}
