package chat.controller;

import java.io.FileWriter;
import java.io.*;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class IOController 
{
	public static String saveFile(String textToSave)
	{
		String fileName = "Saved Chat File - ";
		fileName += Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		fileName += ":" + Calendar.getInstance().get(Calendar.MINUTE);
		fileName += ".txt";
		FileWriter chatWriter;
		try
		{
			chatWriter = new FileWriter(fileName);
			chatWriter.write("this is the " + fileName + "\n");
			chatWriter.write(textToSave);
			chatWriter.close();
			JOptionPane.showMessageDialog(null, "file saved as: " + fileName);
		}
		catch (IOException ioError)
		{
			JOptionPane.showMessageDialog(null, ioError.getMessage());
		}
		
		return fileName;
	}
}
