package com.van133.MY_GS.MODEL;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document("COMPANY")
public class COMPANY {
    @Id
    String ID;
    String Cname;

}
