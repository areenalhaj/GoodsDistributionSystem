package MainPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EditBranches extends GeneralFrame{
	
	JButton CancelButton, MainMenuButton,PreviousButton,UpdateButton;
	JTextField BranchNameField,BranchLocationField;
	ArrayList <JButton> ButtonsArray;
	String ChosenBranchName, ChosenBranchLocation;
	int index;
	public EditBranches(int i) {
		super();
		index = i;
		ChosenBranchName = ShareVar.BranchesNamesArray[index];
		ChosenBranchLocation = ShareVar.LocationsArray[index];
		setTitle("تعديل بيانات "+ChosenBranchName);
		setSize(410,350);
		setLocationRelativeTo(null);
		
//		>>>>>>>>>>>>>>>>>    NORTH    <<<<<<<<<<<<<<<<
		JPanel NorthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,30,10));
//		label:
	    JLabel NorthLabel = new JLabel("هذه معلومات "+ChosenBranchName+" متاح لك التعديل عليها:");
	    NorthLabel.setHorizontalAlignment(JLabel.RIGHT);
	    NorthLabel.setVerticalAlignment(JLabel.CENTER);
	    NorthLabel.setFont(ShareVar.CalibriFont15);
		NorthPanel.add(NorthLabel);

//		>>>>>>>>>>>>>>>>>    EAST & WEST    <<<<<<<<<<<<<<<<		
		JPanel EastPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,20,21));
		JPanel WestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,35,17));
		EastPanel.setPreferredSize(new Dimension(120,30));
		WestPanel.setPreferredSize(new Dimension(290,30));
		
		JLabel BranchNameLabel = new JLabel("اسم الفرع:");
		JLabel BranchLocationLabel = new JLabel("موقع الفرع:");
		EastPanel.add(BranchNameLabel);
		EastPanel.add(BranchLocationLabel);
		
		BranchNameField = new JTextField(ChosenBranchName);
		BranchLocationField = new JTextField(ChosenBranchLocation);
		WestPanel.add(BranchNameField);
		WestPanel.add(BranchLocationField);
		
		BranchNameField.setHorizontalAlignment(SwingConstants.RIGHT);
		BranchLocationField.setHorizontalAlignment(SwingConstants.RIGHT);
		BranchNameField.setColumns(19);
		BranchLocationField.setColumns(19);
		BranchNameField.setFont(ShareVar.CalibriFont14);
		BranchLocationField.setFont(ShareVar.CalibriFont14);
		BranchNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		BranchLocationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		BranchNameLabel.setFont(ShareVar.CalibriFont14);
		BranchLocationLabel.setFont(ShareVar.CalibriFont14);
		
		UpdateButton = new JButton("تحديث");
		PreviousButton = new JButton("السابق");
		MainMenuButton = new JButton("الرئيسية");
		CancelButton = new JButton("إلغاء");
		ButtonsArray = new ArrayList<JButton>();
		ButtonsArray.add(UpdateButton);
		ButtonsArray.add(MainMenuButton);
		ButtonsArray.add(CancelButton);
		ButtonsArray.add(PreviousButton);
		for(int j=0;j<ButtonsArray.size();j++) {
			ButtonsArray.get(j).setFont(ShareVar.CalibriFont15);
			ButtonsArray.get(j).setHorizontalAlignment(SwingConstants.RIGHT);
			ButtonsArray.get(j).addActionListener(this);}
	    
		
		
//		>>>>>>>>>>>>>>>>>    SOUTH    <<<<<<<<<<<<<<<<
		JPanel SouthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,20,40));
		SouthPanel.setPreferredSize(new Dimension(400, 100)); 
		SouthPanel.add(CancelButton);
		SouthPanel.add(MainMenuButton);
		SouthPanel.add(PreviousButton);
		SouthPanel.add(UpdateButton);
		
//		>>>>>>>>>>>>>>>>>    FRAME    <<<<<<<<<<<<<<<<
		add(NorthPanel,BorderLayout.NORTH);
		add(WestPanel,BorderLayout.WEST);
		add(EastPanel,BorderLayout.EAST);
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
		else if(SourceButton == PreviousButton) {
			close();
			new ChooseBranchToEdit();
		}
		else if(SourceButton == UpdateButton) {
			String newName = BranchNameField.getText();
			String newLocation = BranchLocationField.getText();
			int answer = JOptionPane.showConfirmDialog(null,"هل أنت متأكد أنك تريد تحديث البيانات؟");	
			if(answer==JOptionPane.YES_OPTION) {
				updateBranch(index,newName,newLocation);
				JOptionPane.showMessageDialog(null,"تم تحديث بيانات الفرع بنجاح، سوف تنتقل الآن للصفحة السابقة.",
						"تمت عملية التعديل",JOptionPane.PLAIN_MESSAGE);
				close();
				new ChooseBranchToEdit();
			}else if(answer==JOptionPane.NO_OPTION) {
				close();
				new ChooseBranchToEdit();
			}
		}
	}
	
	
}