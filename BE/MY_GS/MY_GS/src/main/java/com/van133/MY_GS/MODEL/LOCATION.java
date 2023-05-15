package com.van133.MY_GS.MODEL;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "Location")
public class LOCATION {
    String Cid;
    String BAR_CD;
    String location;

}
