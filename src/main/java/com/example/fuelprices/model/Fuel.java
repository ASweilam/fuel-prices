package com.example.fuelprices.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Fuel {

    @JsonProperty("Date")
    private String date;

    @JsonProperty("ULSP_Price")
    private Double ulspPrice;

    @JsonProperty("ULSD_Price")
    private Double ulsdPrice;

    @JsonProperty("ULSP_Rate")
    private Double ulspRate;

    @JsonProperty("ULSD_Rate")
    private Double ulsdRate;

    @JsonProperty("ULSP_VatRate")
    private Double ulspVat;

    @JsonProperty("ULSD_VatRate")
    private Double ulsdVat;

    public Fuel() {
    }

    public Fuel(String date, Double ulspPrice, Double ulsdPrice, Double ulspRate, Double ulsdRate, Double ulspVat, Double ulsdVat) {
        this.date = date;
        this.ulspPrice = ulspPrice;
        this.ulsdPrice = ulsdPrice;
        this.ulspRate = ulspRate;
        this.ulsdRate = ulsdRate;
        this.ulspVat = ulspVat;
        this.ulsdVat = ulsdVat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date ;
    }

    public Double getUlspPrice() {
        return ulspPrice;
    }

    public void setUlspPrice(Double ulspPrice) {
        this.ulspPrice = ulspPrice;
    }

    public Double getUlsdPrice() {
        return ulsdPrice;
    }

    public void setUlsdPrice(Double ulsdPrice) {
        this.ulsdPrice = ulsdPrice;
    }

    public Double getUlspRate() {
        return ulspRate;
    }

    public void setUlspRate(Double ulspRate) {
        this.ulspRate = ulspRate;
    }

    public Double getUlsdRate() {
        return ulsdRate;
    }

    public void setUlsdRate(Double ulsdRate) {
        this.ulsdRate = ulsdRate;
    }

    public Double getUlspVat() {
        return ulspVat;
    }

    public void setUlspVat(Double ulspVat) {
        this.ulspVat = ulspVat;
    }

    public Double getUlsdVat() {
        return ulsdVat;
    }

    public void setUlsdVat(Double ulsdVat) {
        this.ulsdVat = ulsdVat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fuel)) return false;
        Fuel fuel = (Fuel) o;
        return Objects.equals(getDate(), fuel.getDate()) &&
                Objects.equals(getUlspPrice(), fuel.getUlspPrice()) &&
                Objects.equals(getUlsdPrice(), fuel.getUlsdPrice()) &&
                Objects.equals(getUlspRate(), fuel.getUlspRate()) &&
                Objects.equals(getUlsdRate(), fuel.getUlsdRate()) &&
                Objects.equals(getUlspVat(), fuel.getUlspVat()) &&
                Objects.equals(getUlsdVat(), fuel.getUlsdVat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getUlspPrice(), getUlsdPrice(), getUlspRate(), getUlsdRate(), getUlspVat(), getUlsdVat());
    }

    @Override
    public String toString() {
        return "Fuel{" +
                "date='" + date + '\'' +
                ", ulspPrice=" + ulspPrice +
                ", ulsdPrice=" + ulsdPrice +
                ", ulspRate=" + ulspRate +
                ", ulsdRate=" + ulsdRate +
                ", ulspVat=" + ulspVat +
                ", ulsdVat=" + ulsdVat +
                '}';
    }
}
