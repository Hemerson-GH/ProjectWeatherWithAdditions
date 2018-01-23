package projetoweather;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class FabricaElementosGraficos {
	
	public abstract JFrame CriarFrame(String msg);	
	public abstract JPanel CriarPanel();	
    public abstract JLabel CriarLabel(String msg);    
    public abstract JTextField CriarTextField(String msg);    
    public abstract JTextArea CriarTextArea(String msg);    
    @SuppressWarnings("rawtypes")
	public abstract JList CriarJList(String msg);    

}
