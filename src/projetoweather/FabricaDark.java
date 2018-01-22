package projetoweather;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FabricaDark extends FabricaElementosGraficos{
	
	@Override
	public JFrame CriarFrame(String msg) {
		JFrame fr = new JFrame(msg);
		fr.getContentPane().setBackground(Color.black);
		return fr;
	}

	@Override
	public JLabel CriarLabel(String msg) {
		JLabel lb = new JLabel(msg);
        lb.setBackground(Color.BLACK);
        lb.setOpaque(true);
        lb.setForeground(Color.YELLOW);
        return lb;
	}

	@Override
	public JTextField CriarTextField(String msg) {
		
		return null;
	}

	@Override
	public JTextArea CriarTextArea(String msg) {
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public JList CriarJList(String msg) {
		return null;
	}

}
