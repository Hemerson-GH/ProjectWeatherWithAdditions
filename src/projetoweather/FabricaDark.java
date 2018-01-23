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

	@Override
	public JPanel CriarPanel() {
		JPanel pCidade = new JPanel(new BorderLayout(5, 5));
        pCidade.setForeground(Color.BLACK);
        pCidade.setBackground(Color.BLACK);
        pCidade.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
        		"Selecione a Cidade", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 15), Color.RED));
        return pCidade;
	}

}
