package projetoweather;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FabricaAcessibilidade extends FabricaElementosGraficos{

	@Override
	public JFrame CreateFrame(String msg) {
		JFrame fr = new JFrame(msg);
		fr.getContentPane().setBackground(Color.LIGHT_GRAY);
		return fr;
	}

	@Override
	public JLabel CreateLabel(String msg) {
		JLabel lb = new JLabel(msg);
        lb.setBackground(Color.CYAN); // change
        lb.setOpaque(true);// change
        lb.setForeground(Color.BLACK);// change
        return lb;
	}

	@Override
	public JTextField CreateTextField(int n) {
		
		return null;
	}

	@Override
	public JTextArea CreateTextArea() {
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public JList CreateJList() {
		return null;
	}

	@Override
	public JPanel CreatePanel(int w, int h, String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
