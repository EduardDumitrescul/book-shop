package org.example.data.entities;

import org.example.data.Cloneable;

public class UserEntity implements Cloneable {
    public int id;
    public String username;
    public String password;

    public UserEntity(int id, String username, String password) {
        this.id  = id;
        this.username = username;
        this.password = password;
    }

    public UserEntity(UserEntity obj) {
        this.id = obj.id;
        this.username = obj.username;
        this.password = obj.password;
    }


    @Override
    public Cloneable clone() {
        return new UserEntity(this);
    }

    public void setId(int id) {
        this.id = id;
    }
}
