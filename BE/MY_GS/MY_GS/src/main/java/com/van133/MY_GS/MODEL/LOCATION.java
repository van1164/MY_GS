package com.van133.MY_GS.MODEL;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@Document(collection = "Location")
public class LOCATION {
    String Cid;
    String BAR_CD;
    String location;

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getBAR_CD() {
        return BAR_CD;
    }

    public void setBAR_CD(String BAR_CD) {
        this.BAR_CD = BAR_CD;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
