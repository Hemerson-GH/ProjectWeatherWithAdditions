package projetoweather;

import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ConsultaClima {

    /**
     * Obtenha sua chave em: https://openweathermap.org/api
     */
    private static final String API_KEY = "0ccc6c167b3935063010b84bee8f090d";
    private static final String URL_BASE = "http://api.openweathermap.org/data/2.5/weather?";

    /**
     * Consulta o clima (temperatura atual, mínima e máxima, bem como a umidade) de uma 
     * determinada cidade. Para isso, utiliza a API OpenWeatherMap (https://openweathermap.org/api)
     * 
     * @param id Identificador da cidade para a qual o clima será consultado. 
     * @return Um objeto contendo as informações sobre o clima da cidade.
     * @throws Exception Exceção gerada devido a falhas de comunicação com a API OpenWeatherMap.
     */
    public static Clima consultarClima(int id) throws Exception {
        JsonReader ler = null;
        try {
            URL urlConsulta = new URL(URL_BASE + "id=" + id + "&units=metric&appid=" + API_KEY);
            ler = Json.createReader(urlConsulta.openStream());
            JsonObject dado = ler.readObject();

            Clima clima = new Clima(
                    dado.getJsonObject("main").getJsonNumber("temp").doubleValue(),
                    dado.getJsonObject("main").getJsonNumber("temp_min").doubleValue(),
                    dado.getJsonObject("main").getJsonNumber("temp_max").doubleValue(),
                    dado.getJsonObject("main").getJsonNumber("humidity").doubleValue()
            );
            return clima;
        } finally {
            if (ler != null) {
                ler.close();
            }
        }
    }

}
