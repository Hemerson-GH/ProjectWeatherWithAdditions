package projetoweather;

public class Cidade {
    private int id;
    private String nome;
    private String pais;
    
    public Cidade(int id, String nome, String pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }
    
    public Clima getClima() throws Exception {
        return ConsultaClima.consultarClima(id);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }
    
    @Override
    public String toString() {
        return nome + "/" + pais;
    }
}
