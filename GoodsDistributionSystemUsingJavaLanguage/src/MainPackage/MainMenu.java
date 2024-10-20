package MainPackage;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;


public class MainMenu extends GeneralFrame{
	
	JButton LogoutButton, CancelButton, ImportedGoodsButton, ExportedGoodsButton, BranchesButton, StatisticsButton;
	
	//Constructor: 
	public MainMenu() {
		super();
		setTitle("الرئيسية");
		setSize(400,400);
		setLocationRelativeTo(null);

	    
	    JPanel NorthPanel= new JPanel(new FlowLayout(FlowLayout.TRAILING,15,5));
//		label:
	    JLabel NorthLabelWelcome = new JLabel("مرحبًا بك في الصفحة الرئيسية لنظام توزيع البضائع الخاص بالمتجر");
	    JLabel NorthLabelChoose = new JLabel("يمكنك اختيار العملية التي تريد إجراءها من الأزرار التالية:");
//	    Label Alignment:
	    NorthLabelWelcome.setHorizontalAlignment(JLabel.CENTER);
		NorthLabelChoose.setHorizontalAlignment(JLabel.CENTER);
		NorthLabelWelcome.setVerticalAlignment(JLabel.CENTER);
		NorthLabelChoose.setVerticalAlignment(JLabel.CENTER);
//	    Label Font
		NorthLabelWelcome.setFont(ShareVar.CalibriFont15);
	    NorthLabelChoose.setFont(ShareVar.CalibriFont15);
//	    Adding items to the north panel:
	    NorthPanel.setPreferredSize(new Dimension(350, 50)); 
	    NorthPanel.add(NorthLabelWelcome);
	    NorthPanel.add(NorthLabelChoose);
	    
	    //4 buttons 2 buttons on the eastPanel, and 2 on the westPanel 
//	    East Panel
	    JPanel EastPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,20,40));
	    EastPanel.setPreferredSize(new Dimension(200, 30)); 
	    ImportedGoodsButton = new JButton("البضائع المستوردة");
	    ExportedGoodsButton = new JButton("البضائع المصدرة إلى الأفرع");
//	    Font:
	    ImportedGoodsButton.setFont(ShareVar.CalibriFont15);
	    ExportedGoodsButton.setFont(ShareVar.CalibriFont15);
	    EastPanel.add(ImportedGoodsButton);
	    EastPanel.add(ExportedGoodsButton);
	    
//	    West Panel
	    JPanel WestPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,30,40));
	    WestPanel.setPreferredSize(new Dimension(200, 30)); 
	    BranchesButton = new JButton("فروعنا");
	    StatisticsButton = new JButton("الإحصائيات");
//	    Font:
	    BranchesButton.setFont(ShareVar.CalibriFont15);
	    StatisticsButton.setFont(ShareVar.CalibriFont15);

	    WestPanel.add(BranchesButton);
	    WestPanel.add(StatisticsButton);
	    //Leading alignment contains : CancelButton
	    JPanel SouthPanel = new JPanel(new FlowLayout(FlowLayout.LEADING,100,10));
		SouthPanel.setPreferredSize(new Dimension(400, 100)); 
	    CancelButton = new JButton("إلغاء");
	    LogoutButton = new JButton("تسجيل الخروج");
		CancelButton.setFont(ShareVar.CalibriFont14);
		LogoutButton.setFont(ShareVar.CalibriFont14);
	    SouthPanel.add(CancelButton);
	    SouthPanel.add(LogoutButton);
	    
	    add(NorthPanel, BorderLayout.NORTH);
	    add(SouthPanel, BorderLayout.SOUTH);
	    add(EastPanel, BorderLayout.EAST);
	    add(WestPanel, BorderLayout.WEST);
	    
	    CancelButton.addActionListener(this);
	    LogoutButton.addActionListener(this);
	    ImportedGoodsButton.addActionListener(this);
	    ExportedGoodsButton.addActionListener(this);
	    BranchesButton.addActionListener(this);
	    StatisticsButton.addActionListener(this);
	    
	    
	    setVisible(true);
	}
	public void actionPerformed(ActionEvent aevent) {
		JButton SourceButton = (JButton)aevent.getSource();
		if(SourceButton == CancelButton) {
			System.exit(0);	
		}else if(SourceButton == ImportedGoodsButton){
			new ImportedGoods();
			close();
		}else if(SourceButton == ExportedGoodsButton) {
			new ExportedGoods();
			close();
		}else if(SourceButton == BranchesButton) {
			new OurBranches();
			close();
		}else if(SourceButton == StatisticsButton) {
			new Statistics();
			close();
		}else if(SourceButton == LogoutButton) {
			LoginWindow.setVisible(true);;
			close();
		}
			
	}
}

