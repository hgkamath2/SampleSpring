package com.sample.myapp.test.controller;

import java.net.URI;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.sample.model.User;
 
public class UserRestControllerTest {
 
	private static final Logger logger = LoggerFactory.getLogger(UserRestControllerTest.class);

	public static final String REST_SERVICE_URI = "http://localhost:8080/myapp/Users";
    
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllUsers(){
        
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/", List.class);
         
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> obj : usersMap){
            	Iterator<Entry<String,Object>> its = obj.entrySet().iterator();
            	
            }
        }else{
            logger.debug("User dont exist");
        }
    }
     
    /* GET */
    private static void getUser(){
        logger.debug("getUser : test: ");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(REST_SERVICE_URI+"/1", User.class);
        System.out.println(user);
    }
     
    /* POST */
    private static void createUser() {
        logger.debug("addUser : test:");
        RestTemplate restTemplate = new RestTemplate();
        User localUser = new User("Parker", "Sara", "hello@sara.com" , 90);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/", localUser, User.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
 
    /* PUT */
    private static void updateUser() {
    	logger.debug("updateUser : test:");
        RestTemplate restTemplate = new RestTemplate();
        User user  = new User("Parker", "Sara", "hello@sara.com" , 90);
        user.setUserId(5);
        restTemplate.put(REST_SERVICE_URI+"/", user);
        logger.debug("addUser : test:" + user);
    }
 
    /* DELETE */
    private static void deleteUser() {
        logger.debug("deleteUser: test:");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/3");
    }
 
    public static void main(String args[]){
        listAllUsers();
        getUser();
        createUser();
        listAllUsers();
        //updateUser();
        //listAllUsers();
        //deleteUser();
        //listAllUsers();
        //listAllUsers();
    }
}
