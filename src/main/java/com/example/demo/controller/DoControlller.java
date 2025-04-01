/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.entity.ToDo;
import com.example.demo.service.DoService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/do")
public class DoControlller {
    @Autowired
    private DoService service;
    
    @GetMapping("/get")
    public List<ToDo> getAll()
    {
      return  service.getAll();
    }
    @PostMapping("/post")
    public ToDo createRecord(@RequestBody ToDo todo)
    {
        return service.saveRecord(todo);
    }
    @PutMapping("/{id}")
    public ToDo updateRecords(@PathVariable Long id,@RequestBody ToDo todo)
    {
       return service.updateRecord(id, todo);
    }
    @DeleteMapping("/delete/{id}")
    public ToDo deleteRecords(@PathVariable Long id)
    {
        return service.deleteRecord(id);
    }
}
