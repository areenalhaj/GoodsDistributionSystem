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

public class ExportedGoods extends GeneralFrame{
	
	JButton CancelButton, MainMenuButton, ViewWarehouseButton, ExportingLocationButton;
	ArrayList <JButton> ButtonsArray;
	
	public ExportedGoods() {
		super();
		setTitle("البضائع المصدرة إلى الأفرع");
		setSize(340,300);
		setLocationRelativeTo(null);
		
//		>>>>>>>>>>>>>>>>>    NORTH    <<<<<<<<<<<<<<<<
		JPanel NorthPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,25,15));
//		label:
	    JLabel NorthLabel = new JLabel("اختر العملية التي تريد تنفيذها:");
	    NorthLabel.setHorizontalAlignment(JLabel.RIGHT);
	    NorthLabel.setVerticalAlignment(JLabel.CENTER);
	    NorthLabel.setFont(ShareVar.CalibriFont15);
		NorthPanel.add(NorthLabel);
		
//		>>>>>>>>>>>>>>>>>    CENTER    <<<<<<<<<<<<<<<<		
		ExportingLocationButton = new JButton("مكان التوزيع");
		ViewWarehouseButton = new JButton("عرض البضائع المتاحة في المستودع الرئيسي");
		MainMenuButton = new JButton("العودة للرئيسية");
		CancelButton = new JButton("إغلاق البرنامج");
		ButtonsArray = new ArrayList<JButton>();
		ButtonsArray.add(ExportingLocationButton);
		ButtonsArray.add(ViewWarehouseButton);
		ButtonsArray.add(MainMenuButton);
		ButtonsArray.add(CancelButton);
		for(int i=0;i<ButtonsArray.size();i++) {
			ButtonsArray.get(i).setFont(ShareVar.CalibriFont15);
			ButtonsArray.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
			ButtonsArray.get(i).addActionListener(this);
		}
		
		JPanel CenterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,30,20));
		CenterPanel.setPreferredSize(new Dimension(400, 30)); 
	    CenterPanel.add(ViewWarehouseButton);
	    CenterPanel.add(ExportingLocationButton);
	    
//		>>>>>>>>>>>>>>>>>    SOUTH    <<<<<<<<<<<<<<<<
		JPanel SouthPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,30,40));
		SouthPanel.setPreferredSize(new Dimension(400, 100)); 
		SouthPanel.add(CancelButton);
		SouthPanel.add(MainMenuButton);
		
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
		else if(SourceButton == ViewWarehouseButton) {
			close();
			new Warehouse();
		}
		else if(SourceButton == ExportingLocationButton) {
			close();
			new ExportingLocation();
		}
	}
}
