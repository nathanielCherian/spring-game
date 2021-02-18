package com.example.project.api;

import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BitcoinAPI {

    //tester
    public static void main(String[] args) {
        System.out.println(makeGETRequest("https://blockchain.info/rawtx/3492e0ec39cfc64d1478b1463498f4b4805dc26b51831da989127ef6d5eb1a53"));
        System.out.println(getTransactionHex("3492e0ec39cfc64d1478b1463498f4b4805dc26b51831da989127ef6d5eb1a53"));

    }


    private static String makeGETRequest(String url){

        String response = "";

        try{
            URL site = new URL(url);
            URLConnection connection = site.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while((inputLine=in.readLine()) != null){
                response += inputLine + "\n";
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  response;
    }

    public static String getTransactionHex(String txid){
        String url = "https://blockchain.info/rawtx/" + txid + "?format=hex";
        JSONObject object = new JSONObject();
        object.put("hex", makeGETRequest(url));
        return object.toJSONString();
    }

    public static String getBlockHex(Long blockheight){
        String url = "https://blockchain.info/rawblock/"+blockheight+"?format=hex";
        return makeGETRequest(url);
    }

    public static String apiResponse(){
        return "{'hello':'there'}";
    }
}
