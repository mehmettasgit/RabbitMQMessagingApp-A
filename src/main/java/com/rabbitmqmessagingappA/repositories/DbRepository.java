package com.rabbitmqmessagingappA.repositories;

import com.rabbitmqmessagingappA.entities.UserData;
import org.springframework.data.repository.CrudRepository;

public interface DbRepository extends CrudRepository<UserData, Long> {
}
