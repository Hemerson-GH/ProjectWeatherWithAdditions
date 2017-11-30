package BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDeDados {
	
	public Statement stm;
	public ResultSet rs;
	public Connection connection;
	private String driver = "org.postgresql.Driver";
	private String caminho = "jdbc:postgresql://localhost:5433/ProjectWeather";
	private String usuario = "postgres";
	private String senha = "seagate01";

	public void Conecta(){
		try {
			System.setProperty("jdbc.Drivers", driver);
			connection = DriverManager.getConnection(caminho, usuario, senha);
//			JOptionPane.showMessageDialog(null, "Conex�o efetuada com Sucesso");
		} catch (SQLException ex){
//			JOptionPane.showMessageDialog(null, "Falha na conex�o ao Banco De Dados:\n " + ex.getMessage());
			ex.getMessage();
		}
	}

	public void Desconecta(){
		try {
			connection.close();
//			JOptionPane.showMessageDialog(null, "Desconectado com Sucesso");
		} catch (SQLException ex){
//			JOptionPane.showMessageDialog(null, "Falha na desconex�o ao Banco De Dados:\n " + ex.getMessage());
			ex.getMessage();
		}
	}	
}
