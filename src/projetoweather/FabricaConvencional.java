package projetoweather;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FabricaConvencional extends FabricaElementosGraficos{

	@Override
	public JFrame CreateFrame(String msg) {
		return new JFrame(msg);
	}

	@Override
	public JTextField CreateTextField(int n) {
		return new JTextField(n);
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
		return new JList();
	}

	@Override
	public JPanel CreatePanelGrid(int w, int h, String title) {
		JPanel panel = new JPanel(new GridLayout(w, h));
		panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
	}

	@Override
	public JPanel CreatePanelBorder(int w, int h, String title) {
		JPanel panel = new JPanel(new BorderLayout(w, h));
		panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
	}

}
