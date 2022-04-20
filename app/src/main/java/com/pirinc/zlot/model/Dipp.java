package com.pirinc.zlot.model;

public class Dipp {

    private String vdse;
    private String qqwqa = "-";

    public Dipp() {
    }

    public Dipp(String deep, String strDeepLink) {
        this.vdse = deep;
        this.qqwqa = strDeepLink;
    }

    public String getVdse() {
        return vdse;
    }

    public void setVdse(String vdse) {
        this.vdse = vdse;
    }

    public String getQqwqa() {
        return qqwqa;
    }

    public void setQqwqa(String qqwqa) {
        this.qqwqa = qqwqa;
    }
}
