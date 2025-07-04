/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author chira
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDo {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private boolean completed;
}
