package com.howtodoinjava.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.Login;
import com.howtodoinjava.demo.repository.LoginRepository;
 
@Service
public class LoginService {
     
    @Autowired
    LoginRepository repository;
     
    public List<Login> getAllHomes()
    {
        List<Login> homeList = repository.findAll();
         
        if(homeList.size() > 0) {
            return homeList;
        } else {
            return new ArrayList<Login>();
        }
    }
     
    public Login findByUsernameAndPassword(String username,String password) throws RecordNotFoundException
    {
        Login user = repository.findByUsernameAndPassWord(username,password);
         
       return user;
    }
     
    public Login createOrUpdateHome(Login entity) throws RecordNotFoundException
    {
//        Optional<HomeEntity> home = repository.findById(entity.getId());
//         
//        if(home.isPresent())
//        {
//            HomeEntity newEntity = home.get();
//            newEntity.setEmail(entity.getEmail());
//            newEntity.setFirstName(entity.getFirstName());
//            newEntity.setLastName(entity.getLastName());
// 
//            newEntity = repository.save(newEntity);
//             
//            return newEntity;
//        } else {
            entity = repository.save(entity);
             
            return entity;
//        }
    }
     
    public void deleteHomeById(Long id) throws RecordNotFoundException
    {
        Optional<Login> home = repository.findById(id);
         
        if(home.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No home record exist for given id");
        }
    }
}