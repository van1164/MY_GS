package com.van133.MY_GS.BARCODE;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.van133.MY_GS.MODEL.BAR;
import com.van133.MY_GS.PARAMS.Barcode_param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@CrossOrigin("localhost:3000")
public class BarcodeController {
    @Autowired
    MongoTemplate mongoTemplate;
    @ResponseBody
    @GetMapping ("search_barcode")
    public Barcode_param Search(String barcode) throws JsonProcessingException {
        Criteria criteria = new Criteria("BAR_CD");
        criteria.is(barcode);
        Query query = new Query(criteria);
        System.out.println(barcode);
        BAR temp = mongoTemplate.findOne(query,BAR.class,"Barcode");
        if (temp==null){
            return new Barcode_param("xxxxx","xxxx");
        }
        Barcode_param result = new Barcode_param(temp.getBAR_CD(),temp.getPRDLST_NM());
        return result;

    }
}
