package groupProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class New_User extends login{

	private JFrame frame;
	private JTextField username;
	private JTextField password;
	public String userNameInput, passwordInput;

	/** Launch the application. */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					New_User window = new New_User();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public New_User() {
		initialize();
		NewUserTitle();
		 usernameTextField();
		 passwordTextField();
		 signupButton();
		 usernameLabel();
		 passwordLabel();
		 returnButton();
	}
	
	public void returnButton()
	{
		JButton btnNewUser = new JButton("Go Back");
		btnNewUser.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewUser.setBounds(12, 40, 138, 49);
		btnNewUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				//creates menu window sets it to visible and sets the location and size of the menu window
				//frame.dispose();
				new login();
				frame.dispose();
				
				
				
		}
		});
		frame.getContentPane().add(btnNewUser);
	}

	public void NewUserTitle()
	{
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setBounds(224, 40, 115, 94);
		titleLabel.setFont(new Font("Verdana", Font.BOLD, 35));
		titleLabel.setBackground(Color.blue);
		frame.getContentPane().add(titleLabel);
	}
	
	private void usernameTextField()
	{
		username = new JTextField();
		username.setBounds(224, 140, 116, 22);
		frame.getContentPane().add(username);
		username.setColumns(10);
	}
	
	private void passwordTextField()
	{
		password = new JTextField();
		password.setBounds(224, 190, 116, 22);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
	}
	
	private void signupButton()
	{
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(242, 239, 97, 25);
		frame.getContentPane().add(btnSignUp);
		btnSignUp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				passwordInput = password.getText().trim();
				userNameInput = username.getText().trim();
				if(passwordInput.equals("") || userNameInput.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Both username and password must be filled in.");
				}
				else
				{
					if(UsernameExist())
					{
						JOptionPane.showMessageDialog(null, "Username is already taken. Enter a new username. ");
					}
					else
					{
						amendCredentials();
						createUserFile();
					}
				}
			}
		});
	}
	
	private void usernameLabel()
	{
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(116, 143, 84, 16);
		frame.getContentPane().add(lblUsername);
	}
	
	private void passwordLabel()
	{
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(116, 193, 84, 16);
		frame.getContentPane().add(lblPassword);
	}
	
	/**Initialize the contents of the frame.*/
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}
	
	private void amendCredentials()
	{
		String newInfo = userNameInput + " " + passwordInput; 
		FileWriter fw = null;
		
		try {
			File file = new File("user_password.txt");
			//if file exist then it will write a new line then the info
			//if it doesn't exist then it will create file and now write a new line
            if(file.exists()){
            	fw = new FileWriter(file, true);
            	 fw.append(System.getProperty("line.separator"));
			}
            else
            {
            	fw = new FileWriter(file, true);
            }
            fw.append(newInfo);
            fw.flush();
            fw.close();
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
	}
	
	private void createUserFile()
	{
		String newFile = userNameInput + ".txt"; 
		FileWriter fw = null;
		
		try {
			File file = new File(newFile);
			fw = new FileWriter(file, true);
            fw.close();
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
	}

	private boolean UsernameExist()
	{
		Scanner checkForUsername =null;
		try 
		{
			checkForUsername = new Scanner(new FileInputStream("user_password.txt"));
		}
		catch(IOException e)
		{
			System.out.println("User_Password file not found");
		}
		
		while(checkForUsername.hasNext())
		{
			if(userNameInput.equals(checkForUsername.next()))
			{
				//closes file
				checkForUsername.close();
				return true;
			}
			checkForUsername.next();
			
		}
		//closes file
		checkForUsername.close();
		return false;
	}

}
