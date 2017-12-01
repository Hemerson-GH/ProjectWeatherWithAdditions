package BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDados {
	
//	public Statement stm;
//	public ResultSet rs;
	private Connection connection;
	private String driver = "org.postgresql.Driver";
	private String caminho = "jdbc:postgresql://localhost:5433/ProjectWeather";
	private String usuario = "postgres";
	private String senha = "seagate01";

	public void Conecta(){
		try {
			System.setProperty("jdbc.Drivers", driver);
			setConnection(DriverManager.getConnection(caminho, usuario, senha));
//			JOptionPane.showMessageDialog(null, "Conexão efetuada com Sucesso");
		} catch (SQLException ex){
//			JOptionPane.showMessageDialog(null, "Falha na conexão ao Banco De Dados:\n " + ex.getMessage());
			ex.getMessage();
		}
	}

	public void Desconecta(){
		try {
			getConnection().close();
//			JOptionPane.showMessageDialog(null, "Desconectado com Sucesso");
		} catch (SQLException ex){
//			JOptionPane.showMessageDialog(null, "Falha na desconexão ao Banco De Dados:\n " + ex.getMessage());
			ex.getMessage();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}	
}
