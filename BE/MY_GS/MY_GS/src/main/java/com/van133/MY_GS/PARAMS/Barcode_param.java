package com.van133.MY_GS.PARAMS;


import lombok.AllArgsConstructor;


public class Barcode_param {
    String BAR_CD;
    String PRDLST_NM;
    String location;
    public Barcode_param(String BAR_CD, String PRDLST_NM, String location) {
        this.BAR_CD = BAR_CD;
        this.PRDLST_NM = PRDLST_NM;
        this.location =location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBAR_CD() {
        return BAR_CD;
    }

    public void setBAR_CD(String BAR_CD) {
        this.BAR_CD = BAR_CD;
    }

    public String getPRDLST_NM() {
        return PRDLST_NM;
    }

    public void setPRDLST_NM(String PRDLST_NM) {
        this.PRDLST_NM = PRDLST_NM;
    }
}
