package com.pirinc.zlot.model;

public class ConnPG {

    private String dae;
    private String bgayw;
    private String nhsa;
    private String asdw;

    public ConnPG() {
    }

    public ConnPG(String status, String url, String fbToken, String fbId) {
        this.dae = status;
        this.bgayw = url;
        this.nhsa = fbToken;
        this.asdw = fbId;
    }

    public String getDae() {
        return dae;
    }

    public void setDae(String dae) {
        this.dae = dae;
    }

    public String getBgayw() {
        return bgayw;
    }

    public void setBgayw(String bgayw) {
        this.bgayw = bgayw;
    }

    public String getNhsa() {
        return nhsa;
    }

    public void setNhsa(String nhsa) {
        this.nhsa = nhsa;
    }

    public String getAsdw() {
        return asdw;
    }

    public void setAsdw(String asdw) {
        this.asdw = asdw;
    }
}
