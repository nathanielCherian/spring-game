package com.example.project;

import com.example.project.People.People;
import com.example.project.api.BitcoinAPI;
import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class MainRESTController {

    //get transaction data
    @RequestMapping(value = "/api/transaction/{txid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String transactionApi(@PathVariable String txid){
        return BitcoinAPI.getTransactionHex(txid);
    }

    //get block data
    @RequestMapping(value = "/api/block/{blockheight}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String blockAPI(@PathVariable Long blockheight){
        return BitcoinAPI.getBlockHex(blockheight);
    }



    private People people = new People();

    //used to get and query data
    @RequestMapping(value = "/api/db/people", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String peopleGetAPI(){
        JSONObject object = people.getTableData();
        return object.toJSONString();
    }

    //Used to CD
    @RequestMapping(value = "/api/db/people", method = RequestMethod.POST, consumes = "text/plain")
    public String peoplePostAPI(@RequestBody String payload){
        String statuscode = people.parseJSON(payload);
        return statuscode;
    }

    //used to get and query data
    @RequestMapping(value = "/api/db/relationships", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String relationshipGetAPI(){
        JSONObject object = people.getTableDataRelationship();
        return object.toJSONString();
    }

    //Used to CD
    @RequestMapping(value = "/api/db/relationships", method = RequestMethod.POST, consumes = "text/plain")
    public String relationshipPostAPI(@RequestBody String payload){
        String statuscode = people.parseJSON(payload);
        return statuscode;
    }


}
