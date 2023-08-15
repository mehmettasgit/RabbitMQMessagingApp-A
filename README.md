# RabbitMQMessagingApp-A
In this project, RabbitMqMessagingApp-A project was communicated with RabbitMqMessagingapp-B.
![RabbitMQMessaging](https://github.com/mehmettasgit/RabbitMQMessagingApp-A/assets/57155501/ac88805f-fd22-4e42-8d18-84c93d294c77)

RabbitMqMessagingApp-A did get json data from Postman and saved it to table "userdata".
Example Json Data:
{
  "userid":"5",
  "name": "Alex",
  "surname": "Brown",
  "password": "112233",
  "email": "alex.brown@example.com"
}

When I saved this data, I used  BCryptPasswordEncoder class from springframework to hide password.
As result data was saved like below:

![UserData](https://github.com/mehmettasgit/RabbitMQMessagingApp-A/assets/57155501/e425eba2-810e-4866-88e3-8efbe86087f2)

RabbitMqMessagingapp-B project received data from RabbitMq and saved it to another table is called "received_data".
However, I wanted to add each data to each column. You can also notice that the apiname and createdate was add to RabbitMq message which came from Project A :).

![ReceivedData](https://github.com/mehmettasgit/RabbitMQMessagingApp-A/assets/57155501/321966a1-6012-44f4-8b3c-2cb5dce8ec77)

Finally, RabbitMqMessagingapp-B project replied that RabbitMqA with different queue and said to Postman that: 
String responseMessage = "Data is received by RabbitMqMessagingApp-A & B Project.\nAll data are saved to db for each project.\nThis message came from RabbitMqMesaaingApp-B Project via RabbitMQ. ";

![PostmanSaved](https://github.com/mehmettasgit/RabbitMQMessagingApp-A/assets/57155501/fd72ff25-f697-4b73-b4f6-b2462a142be6)


