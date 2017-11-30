package projetoweather;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
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

public class TelaPrincipal {

    private JFrame janela;
    private JTextField tfBuscarCidade;
    @SuppressWarnings("rawtypes")
	private JList lstCidades, lstFavoritos;
    private JTextArea taClima;
    JScrollPane favScroller;
    BancoDeDados bd = new BancoDeDados();
    ControleCidades cc = new ControleCidades();
    List<Cidade> favoritas = new ArrayList<Cidade>();

    private GerenciadorCidades gCidades;

	private TelaPrincipal() {
    	bd.Conecta();		
        gCidades = new GerenciadorCidades();
        janela = new JFrame("Projeto Weather");
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
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao acessar dados da cidade!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
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
					
					Cidade c = (Cidade) lstCidades.getSelectedValue();
					boolean taks = cc.confereCidade(c.getId());
					
					if (taks == false) {	
						cc.cadastraCidade((Cidade) lstCidades.getSelectedValue());
						favoritas = cc.buscarCidade();
						lstFavoritos.setListData(favoritas.toArray());
					} else {
						JOptionPane.showMessageDialog(null, "Cidade ja cadastrada");
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
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Não foi possível remover a cidade desejada");
						System.out.println(e2);
					}		
				}
			}
        });
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void construirComponentes() {
        tfBuscarCidade = new JTextField(30);

        lstCidades = new JList();
        lstCidades.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
        JScrollPane lstScroller = new JScrollPane(lstCidades);
        lstScroller.setPreferredSize(new Dimension(250, 150));

        JPanel pCidade = new JPanel(new BorderLayout(5, 5));
        pCidade.setBorder(BorderFactory.createTitledBorder("Selecionar Cidade"));
        pCidade.add(tfBuscarCidade, BorderLayout.PAGE_START);
        pCidade.add(lstScroller, BorderLayout.CENTER);

        taClima = new JTextArea();
        taClima.setEditable(false);

        JScrollPane taScroller = new JScrollPane(taClima);
        taScroller.setPreferredSize(new Dimension(250, 80));

        JPanel pClima = new JPanel(new GridLayout(1, 1));
        pClima.setBorder(BorderFactory.createTitledBorder("Clima"));
        pClima.add(taScroller, BorderLayout.PAGE_END);
        
        favoritas = cc.buscarCidade();
        
        lstFavoritos = new JList();
        lstFavoritos.setListData(favoritas.toArray());
        lstFavoritos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        favScroller = new JScrollPane(lstFavoritos);
        favScroller.setPreferredSize(new Dimension(250, 80));

        JPanel pFavorites = new JPanel(new GridLayout(1, 1));
        pFavorites.setBorder(BorderFactory.createTitledBorder("Favoritos"));
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
