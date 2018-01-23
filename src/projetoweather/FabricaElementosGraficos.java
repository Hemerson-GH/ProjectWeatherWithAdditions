package projetoweather;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class FabricaElementosGraficos {
	
	public abstract JFrame CreateFrame(String msg);	
	public abstract JPanel CreatePanelGrid(int w, int h, String title);
	public abstract JPanel CreatePanelBorder(int w, int h, String title);	
    public abstract JTextField CreateTextField(int n);    
    public abstract JTextArea CreateTextArea();    
    @SuppressWarnings("rawtypes")
	public abstract JList CreateJList();    

}
