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
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		firstButton = new JButton("Please do not click the button");
		firstTextField = new JTextField("words can be type here");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}	
		
		private void setupPanel()
		{
			this.setLayout(baseLayout);
			this.add(firstButton);
			this.setBackground(Color.MAGENTA);
			this.add(firstTextField);
		}
		
		private void setupLayout()
		{
			
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
		
}
	
