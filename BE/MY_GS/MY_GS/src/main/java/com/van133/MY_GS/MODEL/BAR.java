package com.van133.MY_GS.MODEL;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@Document(collection = "Barcode")
public class BAR {
    String BAR_CD;
    String PRDLST_NM;

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
