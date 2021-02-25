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
    public String peopleGetApi(){
        JSONObject object = people.getTableData();
        return object.toJSONString();
    }

    //Used to
    @RequestMapping(value = "/api/db/people", method = RequestMethod.POST, consumes = "text/plain")
    public String peoplePostApi(@RequestBody String payload){
        String statuscode = people.addPersonFromString(payload);
        return statuscode;
    }

}
