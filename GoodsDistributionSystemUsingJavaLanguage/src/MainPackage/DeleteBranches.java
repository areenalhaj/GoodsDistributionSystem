package MainPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
 import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DeleteBranches extends GeneralFrame {

	static JCheckBox[] checkboxSerif;
	JComboBox<String> BranchesComboBox;
	JButton CancelButton, MainMenuButton, DeleteButton;
	ArrayList<JButton> ButtonsArray;
	String[] BranchesNamesArray = new String[ShareVar.BranchesNumber + 1];

	public DeleteBranches() {
		super();
		setTitle("حذف فروع");
		setSize(340, 250);
		setLocationRelativeTo(null);

		// >>>>>>>>>>>>>>>>> NORTH <<<<<<<<<<<<<<<<
		JPanel NorthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING, 30, 10));
		// label:
		JLabel NorthLabel = new JLabel("اختر الفرع الذي تريد حذفه:");
		NorthLabel.setHorizontalAlignment(JLabel.RIGHT);
		NorthLabel.setVerticalAlignment(JLabel.CENTER);
		NorthLabel.setFont(ShareVar.CalibriFont15);
		NorthPanel.add(NorthLabel);

		// >>>>>>>>>>>>>>>>> CENTER <<<<<<<<<<<<<<<<
		JPanel CenterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 20));
		CenterPanel.setPreferredSize(new Dimension(400, 30));
		BranchesNamesArray[0] = " - اختر اسم الفرع من هنا ";
		for (int i = 0; i < ShareVar.BranchesNumber; i++) {
			BranchesNamesArray[i + 1] = ShareVar.BranchesNamesArray[i];
		}
		BranchesComboBox = new JComboBox(BranchesNamesArray);
		BranchesComboBox.setBounds(50, 100, 90, 20);
		BranchesComboBox.setFont(ShareVar.CalibriFont14);
		DeleteButton = new JButton("حذف");
		MainMenuButton = new JButton("العودة للرئيسية");
		CancelButton = new JButton("إلغاء");

		ButtonsArray = new ArrayList<JButton>();
		ButtonsArray.add(DeleteButton);
		ButtonsArray.add(MainMenuButton);
		ButtonsArray.add(CancelButton);
		for (int i = 0; i < ButtonsArray.size(); i++) {
			ButtonsArray.get(i).setFont(ShareVar.CalibriFont15);
			ButtonsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
			ButtonsArray.get(i).addActionListener(this);
		}
		CenterPanel.add(BranchesComboBox);

		// >>>>>>>>>>>>>>>>> SOUTH <<<<<<<<<<<<<<<<
		JPanel SouthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 40));
		SouthPanel.setPreferredSize(new Dimension(400, 100));
		SouthPanel.add(CancelButton);
		SouthPanel.add(MainMenuButton);
		SouthPanel.add(DeleteButton);

		// >>>>>>>>>>>>>>>>> FRAME <<<<<<<<<<<<<<<<
		add(NorthPanel, BorderLayout.NORTH);
		add(CenterPanel, BorderLayout.CENTER);
		add(SouthPanel, BorderLayout.SOUTH);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent aevent) {
		JButton SourceButton = (JButton) aevent.getSource();
		if (SourceButton == CancelButton) {
			System.exit(0);
		} else if (SourceButton == MainMenuButton) {
			close();
			new MainMenu();
		} else if (SourceButton == DeleteButton) {
			String DeleteBranch = BranchesComboBox.getSelectedItem().toString();
			int DeleteIndex = BranchesComboBox.getSelectedIndex() - 1;
			if (!DeleteBranch.equals(BranchesNamesArray[0])) {
				int answer = JOptionPane.showConfirmDialog(null, "هل أنت متأكد من حذف " + DeleteBranch + "؟");
				if (answer == JOptionPane.YES_OPTION) {
					delete(DeleteIndex);
					JOptionPane.showMessageDialog(null, "تم حذف الفرع بنجاح، سوف تنتقل الآن للصفحة الرئيسية.",
							"تمت عملية الحذف", JOptionPane.PLAIN_MESSAGE);
					close();
					new MainMenu();
				}
			}
		}
	}
}
