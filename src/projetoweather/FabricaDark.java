package projetoweather;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	public JLabel CreateLabel(String msg) {
		JLabel lb = new JLabel(msg);
        lb.setBackground(Color.BLACK);
        lb.setOpaque(true);
        lb.setForeground(Color.YELLOW);
        return lb;
	}

	@Override
	public JTextField CreateTextField(int n) {
		JTextField textField = new JTextField(n);
		
		
		return textField;
	}

	@Override
	public JTextArea CreateTextArea() {
		JTextArea textArea = new JTextArea();
		
		textArea.setEditable(false);
		
		
		
		return textArea;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public JList CreateJList() {
		JList list = new JList();
		
		
		
		return list;
	}

	@Override
	public JPanel CreatePanel(int w, int h, String title) {
		JPanel pCidade = new JPanel(new BorderLayout(w, h));
        pCidade.setForeground(Color.BLACK);
        pCidade.setBackground(Color.BLACK);
        pCidade.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
        		title, TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 15), Color.RED));
        return pCidade;
	}

}
