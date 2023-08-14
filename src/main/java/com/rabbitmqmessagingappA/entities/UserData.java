package com.rabbitmqmessagingappA.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "userdata")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "id")
    private int id;

    @Column(name = "api_name")
    private String apiName;

    @Column(name = "createdate")
    private LocalDateTime createDate;

    @Column(name = "json_data")
    private String jsonData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
