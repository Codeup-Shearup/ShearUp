package com.codeup.shearup.services;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class MGSample {
    private static final String YOUR_DOMAIN_NAME = "sandbox881e8ecc8f9b4e43b69496a976054a22.mailgun.org";
//    private static final String API_KEY = MAILGUN_KEY;

    public static void main(String[] args) {

        try{
            JsonNode jsonNode =  sendSimpleMessage();
            System.out.println(jsonNode.toString());
        } catch (UnirestException e){
            e.printStackTrace();
        }
    }

    public static JsonNode sendSimpleMessage() throws UnirestException {
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + YOUR_DOMAIN_NAME + "/messages")
//			    .basicAuth("api", API_KEY)
                .queryString("from", "Excited User shearup.services@gmail.com")
                .queryString("to", "mgarrison.sa@gmail.com")
                .queryString("subject", "Hello World")
                .queryString("text", "testing")
                .asJson();
        return request.getBody();
    }
}

//https://vitalflux.com/integrate-mailgun-spring-boot-java-app/