/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.inter.AbstractDao;
import static com.mycompany.dao.inter.AbstractDao.connect;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anarq
 */
public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from student");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int teacher_id = rs.getInt("teacher_id");
                result.add(new User(id, name, surname, teacher_id));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c=connect();){
            PreparedStatement stmt = c.prepareStatement("insert into student(name,surname,teacher_id), values(?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setInt(3, u.getTeacher_id());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User u) {
        try ( Connection c = connect();) {
            PreparedStatement stmt = c.prepareStatement("update student set name=?, surname=? where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setInt(3, u.getTeacher_id());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            return stmt.execute("delete from student where id=1");
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
//

    @Override
    public User getById(int userId) {
        User result = null;
        try ( Connection c = connect();) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from student where id=" + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int teacher_id = rs.getInt("teacher_id");
                result = (new User(id, name, surname, teacher_id));
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
