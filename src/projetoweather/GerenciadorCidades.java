package projetoweather;

import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class GerenciadorCidades {

    private static final String ARQ_CIDADES = "cidades.json";

    private List<Cidade> cidades;

    public GerenciadorCidades() {
        carregarCidades();
    }

    private void carregarCidades() {
        cidades = new ArrayList<Cidade>();
        JsonReader ler = Json.createReader(getClass().getResourceAsStream(ARQ_CIDADES));
        JsonArray dados = ler.readObject().getJsonArray("cidades");

        for (JsonObject dado : dados.getValuesAs(JsonObject.class)) {
            cidades.add(new Cidade(
                    dado.getInt("_id"),
                    dado.getString("name"),
                    dado.getString("country")));
        }

        ler.close();
    }
    
    public List<Cidade> buscarCidades(String nomeCidade) {
        List<Cidade> cidadesEncontradas = new ArrayList<Cidade>();
        for(Cidade c : cidades) {
            if (c.getNome().contains(nomeCidade)) {
                cidadesEncontradas.add(c);
            }
        }        
        return cidadesEncontradas;
    }
    
    public Cidade validaCidade(String nomeCidade) {
        Cidade cidadesEncontrada = null;
        for(Cidade c : cidades) {
        	
            if (c.getNome().contains(nomeCidade)) {
                cidadesEncontrada = new Cidade(c.getId(), c.getNome(), c.getPais());
            }
            if (c.getNome().contains("Lavr")) {
            	System.out.println(c.getNome());
            }
        }       
        return cidadesEncontrada;
    }
    
}
