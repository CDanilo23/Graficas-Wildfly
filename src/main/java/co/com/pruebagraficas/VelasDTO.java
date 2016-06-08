/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.pruebagraficas;

/**
 *
 * @author cristian.ordonez
 */
public class VelasDTO {

    private String vela;
    private double open;
    private double close;
    private double minimo;
    private double maximo;

    public VelasDTO(String vela, String open, String maximo, String minimo, String close) {
        this.vela = vela;
        this.open = Double.valueOf(open);
        this.maximo = Double.valueOf(maximo);
        this.minimo = Double.valueOf(minimo);
        this.close = Double.valueOf(close);
    }

    public String getVela() {
        return vela;
    }

    public void setVela(String vela) {
        this.vela = vela;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getMinimo() {
        return minimo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public void setMaximo(double maximo) {
        this.maximo = maximo;
    }
}
