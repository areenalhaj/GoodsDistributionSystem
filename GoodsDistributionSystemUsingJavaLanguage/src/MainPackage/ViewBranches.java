package MainPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ViewBranches extends GeneralFrame{
	
	JButton CancelButton, MainMenuButton, PreviousButton, ViewBranchesButton, DeleteBranchesButton, EditBranchesButton;
	ArrayList <JButton> ButtonsArray;
	JLabel []BranchesNamesLabelsArray;
	JLabel []BranchesLocationsLabelsArray;
	int height;
	public ViewBranches() {
		super();
		setTitle("عرض جميع الفروع");
		height = 430;
//		For new row or deleting row >>>> height+-=45;
		setSize(400,height);
		setLocationRelativeTo(null);

//		>>>>>>>>>>>>>>>>>    NORTH    <<<<<<<<<<<<<<<<
		JPanel NorthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,30,10));
//		label:
	    JLabel NorthLabel = new JLabel("هذه قائمة الفروع التابعة للمتجر:");
	    NorthLabel.setHorizontalAlignment(JLabel.RIGHT);
	    NorthLabel.setVerticalAlignment(JLabel.CENTER);
	    NorthLabel.setFont(ShareVar.CalibriFont15);
		NorthPanel.add(NorthLabel);

//		>>>>>>>>>>>>>>>>>    CENTER    <<<<<<<<<<<<<<<<		
//		>>>>>>>>>>>>>>>>> EAST & WEST  <<<<<<<<<<<<<<<<
		int numberOfBranchesNow = ShareVar.BranchesNumber;
		JPanel EastPanel = new JPanel(new GridLayout(numberOfBranchesNow,1,10,20));
		JPanel WestPanel = new JPanel(new GridLayout(numberOfBranchesNow,1,10,20));
		EastPanel.setPreferredSize(new Dimension(230,height-100));
		WestPanel.setPreferredSize(new Dimension(150,height-100));
		
		int sizeNow = ShareVar.BranchesNumber;
		BranchesNamesLabelsArray = new JLabel[sizeNow];
		BranchesLocationsLabelsArray = new JLabel[sizeNow];
		for(int i=0;i<BranchesNamesLabelsArray.length;i++) {
			String BranchName = ShareVar.BranchesNamesArray[i];
			String BranchLocation = ShareVar.LocationsArray[i];
			BranchesNamesLabelsArray[i]=new JLabel(BranchName);
			BranchesLocationsLabelsArray[i]=new JLabel(BranchLocation);
			BranchesNamesLabelsArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			BranchesLocationsLabelsArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			BranchesNamesLabelsArray[i].setFont(ShareVar.CalibriFont15);
			BranchesLocationsLabelsArray[i].setFont(ShareVar.CalibriFont15);
			EastPanel.add(BranchesNamesLabelsArray[i]);
			WestPanel.add(BranchesLocationsLabelsArray[i]);
		}
		
		JPanel CenterPanel = new JPanel(new GridLayout(1,2,20,10));
		CenterPanel.setPreferredSize(new Dimension(400, height-150)); 
		CenterPanel.add(WestPanel);
		CenterPanel.add(EastPanel);
		
//		>>>>>>>>>>>>>>>>>    SOUTH    <<<<<<<<<<<<<<<<
		PreviousButton = new JButton("السابق");
		MainMenuButton = new JButton("العودة للرئيسية");
		CancelButton = new JButton("إغلاق البرنامج");
		ButtonsArray = new ArrayList<JButton>();
		ButtonsArray.add(MainMenuButton);
		ButtonsArray.add(CancelButton);
		ButtonsArray.add(PreviousButton);
		for(int i=0;i<ButtonsArray.size();i++) {
			ButtonsArray.get(i).setFont(ShareVar.CalibriFont15);
			ButtonsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
			ButtonsArray.get(i).addActionListener(this);
			}
		JPanel SouthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,20,40));
		SouthPanel.setPreferredSize(new Dimension(400, 100)); 
		SouthPanel.add(CancelButton);
		SouthPanel.add(MainMenuButton);
		SouthPanel.add(PreviousButton);
		
//		>>>>>>>>>>>>>>>>>    FRAME    <<<<<<<<<<<<<<<<
		add(NorthPanel,BorderLayout.NORTH);
		add(EastPanel,BorderLayout.EAST);
		add(WestPanel,BorderLayout.WEST);
		add(SouthPanel,BorderLayout.SOUTH);
		
		getContentPane().validate();
		setVisible(true);

	}
	
	public void actionPerformed(ActionEvent aevent) {
		JButton SourceButton = (JButton)aevent.getSource();
		if(SourceButton == CancelButton) {
			System.exit(0);	
		}
		else if(SourceButton == MainMenuButton) {
			close();
			new MainMenu();
		}
		else if(SourceButton == PreviousButton) {
			close();
			new OurBranches();
		}
	}
}
