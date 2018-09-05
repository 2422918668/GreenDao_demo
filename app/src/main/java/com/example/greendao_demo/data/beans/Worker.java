package com.example.greendao_demo.data.beans;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "Student")
public class Worker {
    @Id
    Long id;
    @Property(nameInDb = "xingming")
    String name;
    @Property
    @NotNull
    String classes;
    @Transient
    String config;

    @Generated(hash = 943371386)
    public Worker(Long id, String name, @NotNull String classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
    }

    @Generated(hash = 107771754)
    public Worker() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return this.classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
