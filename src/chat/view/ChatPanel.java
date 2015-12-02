package chat.view;

import javax.swing.*;

import chat.controller.ChatController;

import java.awt.Color;
import java.awt.event.*;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton submitButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private JTextField typingField;
	private JLabel promptLabel;
	private JTextArea chatArea;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		submitButton = new JButton("click the button");
		firstTextField = new JTextField("words can be type here", 20);
		chatArea = new JTextArea(10,30);
		promptLabel = new JLabel("Chat with me");
		typingField = new JTextField("asda");
		
		setupPanel();
		setupLayout();
		setupListeners();
	
	}	
		
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 143, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -50, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, this);
	}
	
	private void setupPanel()
		{
			this.setLayout(baseLayout);
			this.setBackground(Color.MAGENTA);
			this.add(firstTextField);
			this.add(chatArea);
			this.add(submitButton);
			this.add(promptLabel);
			typingField.setToolTipText("Type here for the chatbot");
			chatArea.setEnabled(false);
			
			
		}
		
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = firstTextField.getText(); //grab user typed answer
				chatArea.append("\nUser: " + userText); //display info
				firstTextField.setText(""); //send text to chatBot
				String response = baseController.userToChatBot(userText); //chat will process
				chatArea.append("\nChatBot: " + response); //display the response
			}
		});
	}
		
	public JTextField getTextField()
	{
		return typingField;
	}
	
}
	
