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

public class FabricaAcessibilidade extends FabricaElementosGraficos{

	@Override
	public JFrame CreateFrame(String msg) {
		JFrame fr = new JFrame(msg);
		fr.getContentPane().setBackground(Color.WHITE);
		return fr;
	}

	@Override
	public JTextField CreateTextField(int n) {
		JTextField textField = new JTextField(n);
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		textField.setBackground(Color.WHITE);
		textField.setForeground(Color.BLUE);
		return textField;
	}

	@Override
	public JTextArea CreateTextArea() {
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 16));
		textArea.setEditable(false);
		textArea.setBackground(Color.WHITE);
		textArea.setForeground(Color.BLUE);
		return textArea;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public JList CreateJList() {
		JList list = new JList();
		list.setFont(new Font("Arial", Font.PLAIN, 16));
		list.setBackground(Color.WHITE);
		list.setForeground(Color.BLUE);
		return list;
	}

	@Override
	public JPanel CreatePanelGrid(int w, int h, String title) {
		JPanel panel = new JPanel(new GridLayout(w, h));
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLUE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				title, TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 16), Color.BLUE));
        return panel;
	}

	@Override
	public JPanel CreatePanelBorder(int w, int h, String title) {
		JPanel panel = new JPanel(new BorderLayout(w, h));
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLUE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
				title, TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 16), Color.BLUE));
        return panel;
	}

}
