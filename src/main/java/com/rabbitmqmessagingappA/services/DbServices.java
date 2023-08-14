package com.rabbitmqmessagingappA.services;

import com.rabbitmqmessagingappA.entities.UserData;
import com.rabbitmqmessagingappA.repositories.DbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbServices {
    @Autowired
    public DbRepository dbRepository;

    public void saveTheEntity(UserData saveData){
        dbRepository.save(saveData);
    }
}
