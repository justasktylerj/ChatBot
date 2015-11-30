package chat.view;

import javax.swing.*;
import chat.controller.ChatController;
import java.awt.Color;
import java.awt.event.*;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private JButton submitButton;
	private JTextField typingField;
	private JLabel promptLabel;
	private JTextArea chatArea;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		firstButton = new JButton("Please do not click the button");
		firstTextField = new JTextField("words can be type here");
		chatArea = new JTextArea();
		submitButton = new JButton();
		promptLabel = new JLabel();
		typingField = new JTextField();
		setupPanel();
		setupLayout();
		setupListeners();
	}	
		
	private void setupLayout()
	{
		
	}
	
	private void setupPanel()
		{
			this.setLayout(baseLayout);
			this.setBackground(Color.MAGENTA);
			this.add(firstTextField);
			this.add(chatArea);
			this.add(submitButton);
			this.add(promptLabel);
			typingField.setToolTipText("type here for the chatbot");
			chatArea.setEnabled(false);
			
		}
		
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
					firstTextField.setText("Much Wow, this is the most amazing click event ever! WOW");
			}
		});
	}
		
	public JTextField getTextField()
	{
		return typingField;
	}
	
}
	
