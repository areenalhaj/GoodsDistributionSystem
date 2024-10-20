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

public class OurBranches extends GeneralFrame{
	
	JButton CancelButton, MainMenuButton, ViewBranchesButton, DeleteBranchesButton, EditBranchesButton;
	ArrayList <JButton> ButtonsArray;
	
	public OurBranches() {
		super();
		setTitle("فروعنا");
		setSize(340,350);
		setLocationRelativeTo(null);
		
//		>>>>>>>>>>>>>>>>>    NORTH    <<<<<<<<<<<<<<<<
		JPanel NorthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,30,10));
//		label:
	    JLabel NorthLabel = new JLabel("اختر العملية التي تريد تنفيذها على الفروع:");
	    NorthLabel.setHorizontalAlignment(JLabel.RIGHT);
	    NorthLabel.setVerticalAlignment(JLabel.CENTER);
	    NorthLabel.setFont(ShareVar.CalibriFont15);
		NorthPanel.add(NorthLabel);
		
//		>>>>>>>>>>>>>>>>>    CENTER    <<<<<<<<<<<<<<<<		
		JPanel CenterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,40,24));
		CenterPanel.setPreferredSize(new Dimension(200, 30)); 
		ViewBranchesButton = new JButton("عرض جميع الفروع");
		EditBranchesButton = new JButton("تعديل معلومات الفروع");
		DeleteBranchesButton = new JButton("حذف فروع");
		MainMenuButton = new JButton("العودة للرئيسية");
		CancelButton = new JButton("إغلاق البرنامج");
		ButtonsArray = new ArrayList<JButton>();
		ButtonsArray.add(ViewBranchesButton);
		ButtonsArray.add(EditBranchesButton);
		ButtonsArray.add(DeleteBranchesButton);
		ButtonsArray.add(MainMenuButton);
		ButtonsArray.add(CancelButton);
		for(int i=0;i<ButtonsArray.size();i++) {
			ButtonsArray.get(i).setFont(ShareVar.CalibriFont15);
			ButtonsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
			ButtonsArray.get(i).addActionListener(this);}
	    CenterPanel.add(ViewBranchesButton);
	    CenterPanel.add(EditBranchesButton);
	    CenterPanel.add(DeleteBranchesButton);

//		>>>>>>>>>>>>>>>>>    SOUTH    <<<<<<<<<<<<<<<<
		JPanel SouthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,30,40));
		SouthPanel.setPreferredSize(new Dimension(400, 100)); 
		SouthPanel.add(CancelButton);
		SouthPanel.add(MainMenuButton);
		
//		>>>>>>>>>>>>>>>>>    FRAME    <<<<<<<<<<<<<<<<
		add(NorthPanel,BorderLayout.NORTH);
		add(CenterPanel,BorderLayout.CENTER);
		add(SouthPanel,BorderLayout.SOUTH);
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
		else if(SourceButton == ViewBranchesButton) {
			close();
			new ViewBranches();
		}
		else if(SourceButton == EditBranchesButton) {
			close();
			new ChooseBranchToEdit();
		}
		else if(SourceButton == DeleteBranchesButton) {
			close();
			new DeleteBranches();
		}
	}
}
