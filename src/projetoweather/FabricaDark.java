package projetoweather;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class FabricaDark extends FabricaElementosGraficos{
	
	@Override
	public JFrame CreateFrame(String msg) {
		JFrame fr = new JFrame(msg);
		fr.getContentPane().setBackground(Color.black);
		return fr;
	}

	@Override
	public JTextField CreateTextField(int n) {
		JTextField textField = new JTextField(n);
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setBackground(Color.DARK_GRAY);
		textField.setForeground(Color.RED);
		return textField;
	}

	@Override
	public JTextArea CreateTextArea() {
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setForeground(Color.RED);
		return textArea;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public JList CreateJList() {
		JList list = new JList();
		list.setFont(new Font("Arial", Font.PLAIN, 14));
		list.setBackground(Color.DARK_GRAY);
		list.setForeground(Color.RED);
		return list;
	}

	@Override
	public JPanel CreatePanelGrid(int w, int h, String title) {
		JPanel panel = new JPanel(new GridLayout(w, h));
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.BLACK);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				title, TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 14), Color.RED));
        return panel;
	}

	@Override
	public JPanel CreatePanelBorder(int w, int h, String title) {
		JPanel panel = new JPanel(new BorderLayout(w, h));
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.BLACK);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				title, TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 14), Color.RED));
        return panel;
	}
}
