package com.example.project;

import com.example.project.api.BitcoinAPI;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
