/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanagmentapp;

import com.mycompany.dao.impl.UserDaoImpl;
import com.mycompany.dao.inter.UserDaoInter;

/**
 *
 * @author anarq
 */
public class Context {

    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }
}
