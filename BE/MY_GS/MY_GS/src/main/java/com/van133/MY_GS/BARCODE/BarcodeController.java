package com.van133.MY_GS.BARCODE;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.van133.MY_GS.MODEL.BAR;
import com.van133.MY_GS.MODEL.LOCATION;
import com.van133.MY_GS.PARAMS.Barcode_param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
    @GetMapping ("update_location")
    public Integer Update(String barcode, String company,String location) throws JsonProcessingException {
        Criteria criteria = new Criteria("BAR_CD");
        criteria.is(barcode);
        Query query = new Query(criteria);
        BAR temp = mongoTemplate.findOne(query,BAR.class,"Barcode");
        if (temp==null){
            return -1; //없음
        }
        else{
            Query find_company = new Query(new Criteria("Id").is(company));
            Query find_item = new Query(new Criteria("BAR_CD").is(barcode).andOperator(new Criteria("Cid").is(company)));
            Update update = new Update();
            update.set("location",location);
            mongoTemplate.updateFirst(find_item,update,LOCATION.class);
            return 1; //성공

        }


    }

    @ResponseBody
    @GetMapping ("search_barcode")
    public Barcode_param Search(String barcode, String Cid) throws JsonProcessingException {
        Criteria criteria = new Criteria("BAR_CD");
        criteria.is(barcode);
        Query query = new Query(criteria);
        System.out.println(barcode);
        BAR temp = mongoTemplate.findOne(query,BAR.class,"Barcode");
        if (temp==null){
            return new Barcode_param("xxxxx","xxxx","test");
        }
        Query find_item = new Query(new Criteria("BAR_CD").is(barcode).andOperator(new Criteria("Cid").is(Cid)));
        LOCATION loc = mongoTemplate.findOne(find_item,LOCATION.class);
        Barcode_param result = new Barcode_param(temp.getBAR_CD(),temp.getPRDLST_NM(),loc.getLocation());
        return result;

    }

    @ResponseBody
    @GetMapping ("add_barcode")
    public Integer Add(String barcode, String name) throws JsonProcessingException {
        Criteria criteria = new Criteria("BAR_CD");
        criteria.is(barcode);
        Query query = new Query(criteria);
        BAR temp = mongoTemplate.findOne(query,BAR.class,"Barcode");
        if (temp==null){
            BAR new_bar = new BAR(barcode,name);
            mongoTemplate.insert(new_bar);
            return 1; //넣기 성공.
        }
        else{
            return -1; //이미있음
        }

    }

}
