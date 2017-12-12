package Control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BancoDeDados.BancoDeDados;
import Exception.BancoDadosException;
import Exception.CidadeExistenteException;
import Exception.ControleCidadesException;
import projetoweather.Cidade;

public class ControleCidades {
	
	private BancoDeDados bancoDados = new BancoDeDados();
	
	public void cadastraCidade(Cidade cidade) throws CidadeExistenteException, BancoDadosException, ControleCidadesException{
		
		if (confereCidade(cidade.getId())) {
			throw new CidadeExistenteException(cidade.getNome(), "Cidade Já Cadastrada");
		}
		
		bancoDados.Conecta();
		
		try {
			PreparedStatement pst = bancoDados.getConnection().prepareStatement("insert into favoritos(nome_cidade, id_cidade, pais) values(?,?,?)");
			pst.setString(1, cidade.getNome());		
			pst.setInt(2, cidade.getId());		
			pst.setString(3, cidade.getPais());
			pst.execute();

		} catch (SQLException sqlex) {
			throw new ControleCidadesException("Não foi possível cadastrar essa cidade\n" + sqlex.getMessage(), "Erro Ao Cadastrar Cidade");
		} finally {
			bancoDados.Desconecta();
		}
	}
	
	public boolean removeCidade(Cidade cidade) throws BancoDadosException, ControleCidadesException{
		boolean encontrou = false;
		
		bancoDados.Conecta();
		
		try {
			PreparedStatement pst = bancoDados.getConnection().prepareStatement("DELETE from favoritos where id_cidade = ?");
			
			pst.setInt(1, cidade.getId());
			pst.execute();
			pst.close();	
			encontrou = true;
	    } catch (SQLException sqlex) {
	    	throw new ControleCidadesException("Não foi possível remover essa cidade\n" + sqlex.getMessage(), "Erro Ao Remover Cidade");
	    } finally {
			bancoDados.Desconecta();
		}
		return encontrou;
	}
	
	public List<Cidade> buscarCidade() throws BancoDadosException, ControleCidadesException{
		bancoDados.Conecta();	
		List<Cidade> cidadesEncontradas = new ArrayList<Cidade>();
		
		try {
			PreparedStatement pst = bancoDados.getConnection().prepareStatement("SELECT * FROM favoritos");
			ResultSet rs = pst.executeQuery();	
			
			while (rs.next()) {
				
				Cidade c = new Cidade(rs.getInt("id_cidade"), rs.getString("nome_cidade"), rs.getString("pais"));
				cidadesEncontradas.add(c);
			}
		} catch (SQLException sqlex) {
			throw new ControleCidadesException("Não foi possível buscar suas cidades favoritas\n" + sqlex.getMessage(), "Erro Ao Buscar Cidade");
		} finally {
			bancoDados.Desconecta();
		}
		
		return cidadesEncontradas;
	}
	
	public boolean confereCidade(int id) throws BancoDadosException, ControleCidadesException{
		bancoDados.Conecta();	
		boolean encontrei = false;
		
		try {
			PreparedStatement pst = bancoDados.getConnection().prepareStatement("SELECT * FROM favoritos WHERE id_cidade = ?");
			pst.setInt(1, id);			
			ResultSet rs = pst.executeQuery();	
			
			if (rs.next()) {	
				encontrei = true;
			}
		} catch (SQLException sqlex) {
			throw new ControleCidadesException("Não foi possível encontrar essa cidade\n" + sqlex.getMessage(), "Erro Ao Buscar Cidade");
		} finally {
			bancoDados.Desconecta();
		}
		
		return encontrei;
	}	
}
