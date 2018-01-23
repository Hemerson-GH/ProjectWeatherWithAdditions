package projetoweather;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FabricaConvencional extends FabricaElementosGraficos{

	@Override
	public JFrame CriarFrame(String msg) {
		JFrame fr = new JFrame(msg);
		return fr;
	}

	@Override
	public JLabel CriarLabel(String msg) {
		JLabel lbl = new JLabel(msg);
        return lbl;
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
