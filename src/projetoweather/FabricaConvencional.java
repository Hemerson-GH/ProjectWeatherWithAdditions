package projetoweather;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	public JLabel CreateLabel(String msg) {
        return new JLabel(msg);
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
	public JPanel CreatePanel(int w, int h, String title) {
		return new JPanel();
	}

}
