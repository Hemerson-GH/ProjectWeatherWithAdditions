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
	public JFrame CriarFrame(String msg) {
		JFrame fr = new JFrame(msg);
		fr.getContentPane().setBackground(Color.LIGHT_GRAY);
		return fr;
	}

	@Override
	public JLabel CriarLabel(String msg) {
		JLabel lb = new JLabel(msg);
        lb.setBackground(Color.CYAN); // change
        lb.setOpaque(true);// change
        lb.setForeground(Color.BLACK);// change
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

	@Override
	public JPanel CriarPanel() {
		// TODO Auto-generated method stub
		return null;
	}

}
