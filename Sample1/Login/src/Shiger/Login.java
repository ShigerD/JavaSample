package Shiger;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame implements ActionListener{
	JButton login =new JButton("login:");
	JButton exit =new JButton("exit:");
	JLabel name=new JLabel("name:");
	JLabel psd =new JLabel("psd:");
	JTextField jName=new JTextField(10);
	JPasswordField jPassword=new JPasswordField(10);
	/*
	 * 
	 */
	public Login(){
		JPanel jp=new JPanel();
		JPanel jp1=new JPanel();
		jp.setLayout(new GridLayout(3,2));
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		psd.setHorizontalAlignment(SwingConstants.RIGHT);
		
		jp.add(name); jp.add(jName);jp.add(psd);
		jp.add(jPassword);jp.add(login);jp.add(exit);
		
		login.addActionListener(this);
		exit.addActionListener(this);
		
		this.add(jp, BorderLayout.CENTER);
		//set windows title ,size ,visual,
		this.setTitle("Login Window");
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==exit){
			int i=JOptionPane.showConfirmDialog(
					null,"enture to exit?","Yes",JOptionPane.YES_NO_OPTION);
			if(i==JOptionPane.YES_OPTION){
				
				System.exit(0);
			}
		}else{
			if(String.valueOf(jPassword.getPassword()).equals("admin")&&
					jName.getText().equals("admin")){
				JOptionPane.showMessageDialog(null, "Welcome");
			}else {
				JOptionPane.showMessageDialog(null, "name or psd error!Try again~~");
				jName.setText("");
				jPassword.setText("");
			}
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Login();
	}

}
