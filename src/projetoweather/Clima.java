package projetoweather;

public class Clima {
    private double tempAtual;
    private double tempMin;
    private double tempMax;
    private double umidade;

    public Clima(double tempAtual, double tempMin, double tempMax, double umidade) {
        this.tempAtual = tempAtual;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.umidade = umidade;
    }

    public double getTempAtual() {
        return tempAtual;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public double getUmidade() {
        return umidade;
    }

    
}
