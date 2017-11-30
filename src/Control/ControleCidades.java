package Control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BancoDeDados.BancoDeDados;
import projetoweather.Cidade;

public class ControleCidades {
	
	BancoDeDados bancoDados = new BancoDeDados();
	
	public void cadastraCidade(Cidade cidade){
		bancoDados.Conecta();
		
		try {
			PreparedStatement pst = bancoDados.connection.prepareStatement("insert into favoritos(nome_cidade, id_cidade, pasi) values(?,?,?)");
			pst.setString(1, cidade.getNome());		
			pst.setInt(2, cidade.getId());		
			pst.setString(3, cidade.getPais());
			pst.execute();
//			JOptionPane.showMessageDialog(null, "Salvo Com Sucesso");
		} catch (SQLException ex) {
//			JOptionPane.showMessageDialog(null, "Erro Ao Salvar Dado: \n " + ex);
			ex.printStackTrace();
		}
		
		bancoDados.Desconecta();
	}
	
	public boolean removeCidade(Cidade cidade){
		boolean encontrou = false;
		bancoDados.Conecta();
		
		try {
			PreparedStatement pst = bancoDados.connection.prepareStatement("DELETE from favoritos where id_cidade = ?");
			
			pst.setInt(1, cidade.getId());
			pst.execute();
			pst.close();	
			encontrou = true;
	    } catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		bancoDados.Desconecta();
		return encontrou;
	}
	
	public List<Cidade> buscarCidade(){
		bancoDados.Conecta();	
		List<Cidade> cidadesEncontradas = new ArrayList<Cidade>();
		
		try {
			PreparedStatement pst = bancoDados.connection.prepareStatement("SELECT * FROM favoritos Where id = '" + 0 + "'");
			ResultSet rs = pst.executeQuery();	
			
			while (rs.next()) {
				
				Cidade c = new Cidade(rs.getInt("id_cidade"), rs.getString("nome_cidade"), rs.getString("pasi"));
				cidadesEncontradas.add(c);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		bancoDados.Desconecta();
		return cidadesEncontradas;
	}
	
	public boolean confereCidade(int id){
		bancoDados.Conecta();	
		boolean encontrei = false;
		
		try {
			PreparedStatement pst = bancoDados.connection.prepareStatement("SELECT * FROM favoritos Where id_cidade = '" + id +"'");
			ResultSet rs = pst.executeQuery();	
			
			while (rs.next()) {	
				encontrei = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		bancoDados.Desconecta();
		return encontrei;
	}	
}
