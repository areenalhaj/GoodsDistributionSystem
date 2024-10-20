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
//import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.time.LocalDate;

// Here we should have variables among the package (for data and statistics).


public class LoginWindow extends GeneralFrame implements ActionListener {
	JTextField UsernameBox, PasswordBox;
	JButton LoginButton,CancelButton;
	int tempts = 3;
	LoginWindow(){
		super();
		setTitle("تسجيل الدخول");
		setSize(350,380);
		setLocationRelativeTo(null);
		
//		Creating Main Info:
		ShareVar.BranchesNamesArray[0]="الفرع الرئيسي جنين شارع حيفا";
		ShareVar.LocationsArray[0]="جنين";
		ShareVar.BranchesNamesArray[1]="الفرع-2 الخليل شارع الشهداء";
		ShareVar.LocationsArray[1]="الخليل";
		ShareVar.BranchesNamesArray[2]="الفرع-3 رام الله شارع الإرسال";
		ShareVar.LocationsArray[2]="رام الله";
		ShareVar.BranchesNamesArray[3]="الفرع-4 نابلس شارع سفيان";
		ShareVar.LocationsArray[3]="نابلس";
		ShareVar.BranchesNamesArray[4]="الفرع-5 القدس شارع صلاح الدين";
		ShareVar.LocationsArray[4]="القدس";
		ShareVar.BranchesNumber = ShareVar.BranchesNamesArray.length;
		ShareVar.BranchesInfoArray[0] = ShareVar.BranchesNamesArray;
		ShareVar.BranchesInfoArray[1] = ShareVar.LocationsArray;
//		DATA PRE SAVED
		double addedquantities=0;
		for(int i=1;i<5;i++) {
			ShareVar.DataArray[i][0]="سترة شتوية"+i;
			ShareVar.DataArray[i][1]=""+(15*i); //quantity
			ShareVar.DataArray[i][2]=LocalDate.now().toString();
			ShareVar.DataArray[i][3]="3"+(10*i);
			ShareVar.DataArray[i][4]="الأصفهاني";
			addedquantities += Double.parseDouble(ShareVar.DataArray[i][1]);
		}
		addToStatisticsNumberValues(""+addedquantities);
		ShareVar.GoodsNumber = 5; // INDEX FOR NEXT IMPORTING


//		>>>>>>>>>>>>>>>> NORTH <<<<<<<<<<
		ImageIcon LoginNorthImg = new ImageIcon("loginNorthImg.png");
		JLabel NorthLabel = new JLabel("مرحبًا بك، أدخل البيانات المطلوبة لتسجيل الدخول:");
		NorthLabel.setIcon(LoginNorthImg);
//		northLabel design:
		NorthLabel.setHorizontalTextPosition(JLabel.CENTER);
		NorthLabel.setVerticalTextPosition(JLabel.BOTTOM);
		NorthLabel.setVerticalAlignment(JLabel.CENTER);
		NorthLabel.setHorizontalAlignment(JLabel.CENTER);
//		>>>>>>>>> Center <<<<<<<<<<<<<
		JPanel CenterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,50,10));
		JLabel UsernameLabel = new JLabel("*اسم المستخدم:");  //("*Username:");
		UsernameBox = new JTextField(19);
		JLabel PasswordLabel = new JLabel("*كلمة المرور:");
		PasswordBox = new JPasswordField(19);
		CenterPanel.add(UsernameLabel);
		CenterPanel.add(UsernameBox);
		CenterPanel.add(PasswordLabel);
		CenterPanel.add(PasswordBox);
//		>>>>>>>>> SOUTH <<<<<<<<<<<<<
		JPanel SouthPanel = new JPanel(new GridLayout(1,2,40,10));
//		SouthRight:
		JPanel SouthRightPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING,20,10));
		JPanel SouthLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEADING,20,10));
		LoginButton = new JButton("تسجيل الدخول");
		SouthRightPanel.add(LoginButton);
		CancelButton = new JButton("إلغاء");
		SouthLeftPanel.add(CancelButton);
//		Adding them to the south panel:
		SouthPanel.add(SouthLeftPanel);
		SouthPanel.add(SouthRightPanel);
//		STYLE:
		//Font:
		NorthLabel.setFont(ShareVar.CalibriFont14);
		UsernameLabel.setFont(ShareVar.CalibriFont14);
		PasswordLabel.setFont(ShareVar.CalibriFont14);
		UsernameBox.setFont(ShareVar.CalibriFont14);
		PasswordBox.setFont(ShareVar.CalibriFont14);
		LoginButton.setFont(ShareVar.CalibriFont14);
		CancelButton.setFont(ShareVar.CalibriFont14);
//		Alignment:
		PasswordBox.setHorizontalAlignment(SwingConstants.RIGHT);
		UsernameBox.setHorizontalAlignment(SwingConstants.RIGHT);
		
		//COLORS:		
		/*
		LoginButton.setBackground(myGray);
		CancelButton.setBackground(myGray);
		LoginButton.setForeground(myWhite);
		CancelButton.setForeground(myWhite);
		getContentPane().setBackground(myWhite);
		northLabel.setOpaque(true);
		northLabel.setBackground(myWhite);
		centerPanel.setBackground(myWhite);
		southPanel.setBackground(myWhite);
		southRightPanel.setBackground(myWhite);
		southLeftPanel.setBackground(myWhite);
		*/
		
//		Adding to the frame:
		add(NorthLabel,BorderLayout.NORTH);
		add(CenterPanel,BorderLayout.CENTER);
		add(SouthPanel,BorderLayout.SOUTH);

//		Setting Listeners:
		LoginButton.addActionListener(this);
		CancelButton.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent aevent) {
		JButton SourceButton = (JButton)aevent.getSource();
		if(SourceButton == LoginButton) {
			//		LoginAction action
		try{
			String username = UsernameBox.getText();
			String password = PasswordBox.getText();
			loginOperation(username,password);
			}catch(Exception exception) {
			tempts--;
			JOptionPane.showMessageDialog(null,"عذرًا، المعلومات المدخلة غير صحيحة، تبقى لديك "+tempts+" من المحاولات.",
					"خطأ في تسجيل الدخول!:(",JOptionPane.PLAIN_MESSAGE);
			}
			}else {
			//		Cancel action
				System.exit(0);	
				}
		}

	public void loginOperation(String enteredUsername,String enteredPassword) {
		if(enteredUsername.equals("areenalhaj") && enteredPassword.equals("12345")){
			JOptionPane.showMessageDialog(null,"تمت عملية تسجيل الدخول بنجاح! سوف تنتقل الآن للصفحة الرئيسية.","أهلًا بك",JOptionPane.PLAIN_MESSAGE);
			/////////////////////////////////////notice
			setVisible(false);
			new MainMenu();
		}else{
			tempts--;
			UsernameBox.setText("");
			PasswordBox.setText("");
			if(tempts>0) {
			JOptionPane.showMessageDialog(null,"عذرًا، المعلومات المدخلة غير صحيحة، تبقى لديك "+tempts+" من المحاولات.",
					"خطأ في تسجيل الدخول!:(",JOptionPane.PLAIN_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null,"عذرًا، لا يمكنك تسجيل الدخول، لم يبق لك أي محاولات متاحة.",
						"فشل تسجيل الدخول",JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		}
	}
}
