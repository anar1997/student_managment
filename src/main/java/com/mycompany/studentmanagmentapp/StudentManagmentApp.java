/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.studentmanagmentapp;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import java.util.List;

/**
 *
 * @author anarq
 */
public class StudentManagmentApp {

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao = Context.instanceUserDao();
//        List<User> list = userDao.getAll();
//        System.out.println("list=" + list);
//sil prosesi
//        userDao.removeUser(1);
//update prosesi     
//        User u = userDao.getById(1);
//        u.setName("Eldar");
//
//        userDao.updateUser(u);
//add prosesi
        User u = new User(0, "AbdulQadir", "Vahidov", 1);
        userDao.addUser(u);
        System.out.println(userDao.getAll());
    }
}
