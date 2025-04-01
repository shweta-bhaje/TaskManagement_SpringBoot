/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chira
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService service;
    @GetMapping("/get")
    public List<Task> getAll()
    {
       return service.getAll();
    }
    @PostMapping("/save")
    public Task createTask(@RequestBody Task task)
    {
       return service.saveRecord(task);
    }
    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id)
    {
       return  service.findById(id);
    }
    @PutMapping("/{id}")
    public Task  updateToDo(@PathVariable Long id,@RequestBody Task task)
    {
        Task updateTask = service.updateTask(id, task);
        return updateTask;
    }
    @DeleteMapping("/{id}")
    public Task deleteRecord(@PathVariable Long id)
    {
       return service.deleteRecord(id);
    }
}
