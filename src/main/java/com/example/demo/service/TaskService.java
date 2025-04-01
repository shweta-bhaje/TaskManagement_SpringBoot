/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chira
 */
@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;
    
    public List<Task> getAll()
    {
      return repository.findAll();
    }
    public Task saveRecord(Task task)
    {
        return repository.save(task);
    }
    
    public Task findById(Long id)
    {
        Optional<Task> op = repository.findById(id);
    
        if(op.isPresent())
        {
            Task get = op.get();
            return get;
        }
       return null;
    }
    
    public Task updateTask(Long id,Task task)
    {
        task.setId(id);
       return repository.save(task);
    }
//    public Task updateRecord(Long id, Task task){
//        Task t = findById(id);
//        if(t!=null)
//        {
//            t.setTitle(task.getTitle());
//            t.setDescription(task.getDescription());
//            t.setPriority(task.getPriority());
//            t.setDeadLine(task.getDeadLine());
//            t.setCompleted(task.isCompleted());
//            repository.save(t);
//            
//        }
//            return t;
//}
//    
    
    
    public Task deleteRecord(Long id)
    {
        Task task = findById(id);
        if(task!=null)
        {
            repository.deleteById(id);
        }
        return task;
    }
}