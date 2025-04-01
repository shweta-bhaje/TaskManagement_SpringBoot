/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entity.ToDo;
import com.example.demo.repository.DoList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chira
 */
@Service
public class DoService  {
    @Autowired
    private DoList repository;
    
     public List<ToDo> getAll()
    {
      return repository.findAll();
    }
     
      public ToDo saveRecord(ToDo todo)
    {
        return repository.save(todo);
    }
      public ToDo findById(Long id)
    {
        Optional<ToDo> op = repository.findById(id);
    
        if(op.isPresent())
        {
            ToDo get = op.get();
            return get;
        }
       return null;
    }  
      
       public ToDo updateRecord(Long id, ToDo task){
        ToDo t = findById(id);
        if(t!=null)
        {
            t.setTitle(task.getTitle());        
            t.setCompleted(task.isCompleted());
            repository.save(t);
            
        }
            return t;
}
        public ToDo deleteRecord(Long id)
    {
        ToDo task = findById(id);
        if(task!=null)
        {
            repository.deleteById(id);
        }
        return task;
    }
}
