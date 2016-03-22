package com.sample.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sample.model.User;
import com.sample.service.UserService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/Users/")
public class UserRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired(required=true)
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
    public List<User> listAllUsers() {
    	return userService.getAllUsers();
    }
	
	@RequestMapping(value = "/", method = RequestMethod.POST,produces={"application/json"},consumes={"application/json"})
	public  ResponseEntity<Void> addUser(@RequestBody User usr, UriComponentsBuilder compBuilder) {
		logger.info("addUser "+ usr.toString());
		try
		{
			userService.addUser(usr);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(compBuilder.path("/Users/{id}").buildAndExpand(usr.getUserId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			logger.error("User exists with same email : " + usr.getEmailAddr()) ;
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT,produces={"application/json"},consumes={"application/json"})
	@ResponseBody 
	public Integer updateUser(@RequestBody User usr) {
		logger.info("addUser "+ usr.toString());
		
		Integer temp = null;
		if(usr.getUserId() != 0 && userService.getUser(usr.getUserId()) != null)
			temp = userService.updateUser(usr);
		else
			temp = userService.addUser(usr);
		return temp;
	}

	/*@RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces={"application/json"})
	public @ResponseBody User getUser(@PathVariable("userId") int userId) throws Exception {
		logger.info("getUser "+ userId);
		return userService.getUser(userId);
		
	}*/

	//just to show a different way of returning the response entity
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<User> getUser(@PathVariable("userId") int userId) throws Exception {
		logger.info("getUser "+ userId);
		User local = userService.getUser(userId);
		if(local == null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<User>(local, HttpStatus.OK);
	}

	//just to show a different way of returning the response entity
	@RequestMapping(value = "/{userId}", method = RequestMethod.POST)
	public ResponseEntity<User> deleteUser(@PathVariable("userId") int userId) throws Exception {
		logger.info("getUser "+ userId);
		User local = userService.getUser(userId);
		if(local == null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		
		userService.deleteUser(local);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
}
