package groupProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Returning_User extends login{

	private JFrame frame;
	private JTextField username;
	private JTextField password;
	public String userNameInput, passwordInput;
	public static String[] userName_passwords;
	public static String[] usersTask;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		loadFile();
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Returning_User window = new Returning_User();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public Returning_User() {
		loadFile();
		initialize();
		ReturningUserTitle();
		usernameTextField();
		passwordTextField();
		signInBtn();
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

	public void ReturningUserTitle()
	{
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setBounds(224, 40, 115, 94);
		titleLabel.setFont(new Font("Verdana", Font.BOLD, 35));
		titleLabel.setBackground(Color.blue);
		frame.getContentPane().add(titleLabel);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}
	
	private void usernameTextField() {
		username = new JTextField();
		username.setBounds(242, 147, 166, 29);
		frame.getContentPane().add(username);
		username.setColumns(10);
	}
	
	private void passwordTextField() {
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(242, 201, 166, 29);
		frame.getContentPane().add(password);
	}
	
	private void signInBtn() {
		JButton signInBtn = new JButton("Login");
		signInBtn.setBounds(206, 275, 166, 25);
		signInBtn.addActionListener(new ActionListener() 
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
					if(CredentialsConfirmed())
					{
						//load user information
						String usersProfile = userNameInput + ".txt";
						getUsersDate(usersProfile);
					}
					else
					{
						//alert box Credentials do not match records on file
						JOptionPane.showMessageDialog(null, "Credentials entered do not match records on file. please try again ");
					
					}
				}
			}
		});
		frame.getContentPane().add(signInBtn);
	}
	

	public static void loadFile()
	{
		Scanner userLoginInformation =null;
		try 
		{
			userLoginInformation = new Scanner(new FileInputStream("user_password.txt"));
		}
		catch(IOException e)
		{
			System.out.println("Password file not found");
		}
		int count=0;
		while(userLoginInformation.hasNext())
		{
			count++;
			userLoginInformation.next();
		}
		userName_passwords = new String[count];
		userLoginInformation.close();
		try 
		{
			userLoginInformation = new Scanner(new FileInputStream("user_password.txt"));
		}
		catch(IOException e)
		{
			System.out.println("User_Password file not found");
		}
		int j=0;
		while(userLoginInformation.hasNext())
		{
			userName_passwords[j] = userLoginInformation.next();
			j++;
			
		}
		//closes file
		userLoginInformation.close();
		
	}

	private void getUsersDate(String usersProfile)
	{
		Scanner profileInformation =null;
		try 
		{
			profileInformation = new Scanner(new FileInputStream(usersProfile));
		}
		catch(IOException e)
		{
			System.out.println("Password file not found");
		}
		profileInformation.useDelimiter("~");
		int count=0;
		while(profileInformation.hasNext())
		{
			//test if the first letting in the line is M if so count++
			count++;
			String temp = profileInformation.next();
			System.out.println(temp);
		}
		
		usersTask = new String[count];
		profileInformation.close();
		try 
		{
			profileInformation = new Scanner(new FileInputStream(usersProfile));
		}
		catch(IOException e)
		{
			System.out.println("User_Password file not found");
		}
		profileInformation.useDelimiter("~");
		int j=0;
		while(profileInformation.hasNext())
		{
			usersTask[j] = profileInformation.next();
			j++;
			
		}
		
		for(int i= 0; i < usersTask.length; i++)
		{
			System.out.println(usersTask[i]);
		}
		
		//closes file
		profileInformation.close();
	}

	private void usernameLabel() {
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(114, 147, 87, 29);
		frame.getContentPane().add(lblUsername);
	}
	
	private void passwordLabel() {
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(114, 201, 87, 29);
		frame.getContentPane().add(lblPassword);
	}

	private boolean CredentialsConfirmed()
	{
		for(int i=0; i < userName_passwords.length-1; i++)
		{
			if(userName_passwords[i].equals(userNameInput) && userName_passwords[i+1].equals(passwordInput))
			{
				return true;
			}
		}
		return false;
	}
}
