package projetoweather;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BancoDeDados.BancoDeDados;
import Control.ControleCidades;
import Exception.BancoDadosException;
import Exception.CidadeExistenteException;
import Exception.ControleCidadesException;

public class TelaPrincipal {

	private FabricaElementosGraficos fabrica;
    private JFrame janela;
    private JTextField tfBuscarCidade;
    @SuppressWarnings("rawtypes")
	private JList lstCidades, lstFavoritos;
    private JTextArea taClima;
    private JScrollPane favScroller;
    private BancoDeDados bancoDDados = new BancoDeDados();
    private ControleCidades cc = new ControleCidades();
    private List<Cidade> favoritas = new ArrayList<Cidade>();

    private GerenciadorCidades gCidades;

	private TelaPrincipal() {
		
    	try {
			bancoDDados.Conecta();
		} catch (BancoDadosException dbe) {
			JOptionPane.showMessageDialog(null, dbe.getMessage(), dbe.getTitulo(), JOptionPane.ERROR_MESSAGE);
		}
    	
        gCidades = new GerenciadorCidades();
        
        String[] themes = {"Convencional", "Dark", "Acessibilidade"};
        String s = (String)JOptionPane.showInputDialog(null, "Escolha o tema desejado:\n",
                   "Temas", JOptionPane.PLAIN_MESSAGE, null, themes, "Convencional");
        
        if (s == null) {
			System.exit(1);
		} else if (s.equals("Convencional")) {
			fabrica = new FabricaConvencional();
		} else if (s.equals("Dark")) {
			fabrica = new FabricaDark();
		} else if (s.equals("Acessibilidade")) {
			fabrica = new FabricaAcessibilidade();
		}
        
        
//        janela = new JFrame("Projeto Weather");
        janela = fabrica.CreateFrame("Project Weather - Tema " + s);
        
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setLayout(new BorderLayout());
        construirComponentes();
        definirEvento();
        janela.pack();
    }

    private void atualizarClima(Cidade cidade) {
        try {
            Clima clima = cidade.getClima();
            taClima.setText("");
            taClima.append("Temperatura: " + clima.getTempAtual() + "ºC\n");
            taClima.append("Mánima: " + clima.getTempMin() + "ºC\n");
            taClima.append("Máxima: " + clima.getTempMax() + "ºC\n");
            taClima.append("Umidade relativa do ar: " + clima.getUmidade()+ "%");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar dados da cidade!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void definirEvento() {
    	
        tfBuscarCidade.addKeyListener(new KeyAdapter() {
            @SuppressWarnings("unchecked")
			@Override
            public void keyTyped(KeyEvent e) {
                if (tfBuscarCidade.getText().length() >= 3) {
                    lstCidades.setListData(
                            gCidades.buscarCidades(tfBuscarCidade.getText()).toArray());
                }
            }
        });
        
        lstCidades.addListSelectionListener(new ListSelectionListener() {
			@Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    atualizarClima((Cidade) lstCidades.getSelectedValue());
                }                
            }
        });
        
        lstFavoritos.addListSelectionListener(new ListSelectionListener() {
			@Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                	atualizarClima((Cidade) lstFavoritos.getSelectedValue());
                }	
            }
        });
        
        lstCidades.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					try {
						cc.cadastraCidade((Cidade) lstCidades.getSelectedValue());
						favoritas = cc.buscarCidade();
						lstFavoritos.setListData(favoritas.toArray());
					} catch (BancoDadosException dbe) {
						JOptionPane.showMessageDialog(null, dbe.getMessage(), dbe.getTitulo(), JOptionPane.ERROR_MESSAGE);
					} catch (CidadeExistenteException cee) {
						JOptionPane.showMessageDialog(null, cee.getMessage(), cee.getTitulo(), JOptionPane.ERROR_MESSAGE);
					} catch (ControleCidadesException cce) {
						JOptionPane.showMessageDialog(null, cce.getMessage(), cce.getTitulo(), JOptionPane.ERROR_MESSAGE);
					} 

				}
			}
        });
        
        lstFavoritos.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {						
					try {
						
						Cidade c = (Cidade) lstFavoritos.getSelectedValue();
						cc.removeCidade(c);
						favoritas = cc.buscarCidade();
						lstFavoritos.setListData(favoritas.toArray());
						JOptionPane.showMessageDialog(null, "Cidade removida com sucesso");
						
					} catch (BancoDadosException dbe) {
						JOptionPane.showMessageDialog(null, dbe.getMessage(), dbe.getTitulo(), JOptionPane.ERROR_MESSAGE);
					} catch (ControleCidadesException cce) {
						JOptionPane.showMessageDialog(null, cce.getMessage(), cce.getTitulo(), JOptionPane.ERROR_MESSAGE);
					} 
				}
			}
        });
    }

    @SuppressWarnings("unchecked")
	private void construirComponentes() {
        tfBuscarCidade = fabrica.CreateTextField(30); // fabrica . Createtextfield

        lstCidades = fabrica.CreateJList(); 
        lstCidades.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
        JScrollPane lstScroller = new JScrollPane(lstCidades);
        lstScroller.setPreferredSize(new Dimension(250, 150));

        JPanel pCidade = fabrica.CreatePanel(5, 5, "Selecione a Cidade");
        pCidade.add(tfBuscarCidade, BorderLayout.PAGE_START);
        pCidade.add(lstScroller, BorderLayout.CENTER);

        taClima = fabrica.CreateTextArea();
        //taClima.setEditable(false);

        JScrollPane taScroller = new JScrollPane(taClima);
        taScroller.setPreferredSize(new Dimension(250, 80));

        JPanel pClima = fabrica.CreatePanel(1, 1, "Clima");
        //pClima.setBorder(BorderFactory.createTitledBorder("Clima"));
        pClima.add(taScroller, BorderLayout.PAGE_END);
        
        try {
			favoritas = cc.buscarCidade();
    	} catch (BancoDadosException dbe) {
			JOptionPane.showMessageDialog(null, dbe.getMessage(), dbe.getTitulo(), JOptionPane.ERROR_MESSAGE);
		} catch (ControleCidadesException cce) {
			JOptionPane.showMessageDialog(null, cce.getMessage(), cce.getTitulo(), JOptionPane.ERROR_MESSAGE);
		} 
        
        lstFavoritos = fabrica.CreateJList(); 
        lstFavoritos.setListData(favoritas.toArray());
        lstFavoritos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        favScroller = new JScrollPane(lstFavoritos);
        favScroller.setPreferredSize(new Dimension(250, 80));

        JPanel pFavorites = fabrica.CreatePanel(1, 1, "Favoritos");
       // pFavorites.setBorder(BorderFactory.createTitledBorder("Favoritos"));
        pFavorites.add(favScroller, BorderLayout.CENTER);
        
        janela.getContentPane().add(pCidade, BorderLayout.PAGE_START);
        janela.getContentPane().add(pClima, BorderLayout.CENTER);
        janela.getContentPane().add(pFavorites, BorderLayout.PAGE_END);
    }

    private void exibir() {
        janela.setVisible(true);
    }

    public static void main(String[] args) {    	
    	new TelaPrincipal().exibir();
    }

}
