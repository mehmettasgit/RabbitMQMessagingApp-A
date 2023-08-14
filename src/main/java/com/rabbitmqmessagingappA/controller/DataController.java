package com.rabbitmqmessagingappA.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rabbitmqmessagingappA.entities.UserData;
import com.rabbitmqmessagingappA.gettingreply.GettingReply;
import com.rabbitmqmessagingappA.services.DbServices;
import com.rabbitmqmessagingappA.services.RabbitMQServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DataController {
    @Autowired
    private DbServices dbServices;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RabbitMQServices rabbitMqService;

    @Autowired
    private GettingReply gettingReply;


    @PostMapping(value = "/SendData")
    public ResponseEntity<String> SendData(@RequestBody String data) {

        JsonObject jsonObject = JsonParser.parseString(data).getAsJsonObject();
        String userid = jsonObject.get("userid").getAsString();
        String name = jsonObject.get("name").getAsString();
        String surname = jsonObject.get("surname").getAsString();
        String email = jsonObject.get("email").getAsString();

        String password = jsonObject.get("password").getAsString();
        String encryptedPassword = bCryptPasswordEncoder.encode(password);
        jsonObject.addProperty("password", "******");

        jsonObject.addProperty("api_name", "/SendData");
        jsonObject.addProperty("createdate", LocalDateTime.now().toString());

        UserData newData = new UserData();
        newData.setJsonData(jsonObject.toString());
        newData.setApiName(jsonObject.get("api_name").getAsString());
        newData.setCreateDate(LocalDateTime.parse(jsonObject.get("createdate").getAsString()));

        dbServices.saveTheEntity(newData);
        System.out.print("Data is saved to userdata table \n");
        rabbitMqService.sendMessage(newData);

        String response = gettingReply.getLastResponseMessage();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
