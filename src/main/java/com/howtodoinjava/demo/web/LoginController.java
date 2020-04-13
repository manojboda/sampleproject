package com.howtodoinjava.demo.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.Login;
import com.howtodoinjava.demo.service.LoginService;
 
@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController
{
    @Autowired
    LoginService service;
 
    @GetMapping
    public ResponseEntity<?> doLogin(@RequestParam("username") String username,@RequestParam("password") String password) throws RecordNotFoundException {
        Login user = service.findByUsernameAndPassword(username,password);
        if(user==null) {
        	 return new ResponseEntity<String>("please check usernamse and password", new HttpHeaders(), HttpStatus.OK);

        }
        return new ResponseEntity<Login>(user, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<Login> createOrUpdateHome(@RequestBody Login home)
                                                    throws RecordNotFoundException {
        Login updated = service.createOrUpdateHome(home);
        return new ResponseEntity<Login>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
   
}