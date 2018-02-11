package io.github.deepaksood619.khatriapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by deepak on 02/02/18.
 */

@Entity
public class User {
    @PrimaryKey
    @NonNull
    private String name;
    private String one;
    private String two;
    private String three;
    private String four;
    private String five;
    private String six;
    private String seven;

    // Getters and setters are ignored for brevity,
    // but they're required for Room to work.

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public void setName(String name) {
        this.name = name;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public String getFive() {
        return five;
    }

    public void setFive(String five) {
        this.five = five;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public String getSeven() {
        return seven;
    }

    public void setSeven(String seven) {
        this.seven = seven;
    }

    @Override
    public String toString() {
        return "name=" + name + '\n' +
                "11.5=" + one + '\n' +
                "10.5=" + two + '\n' +
                "9.5=" + three + '\n' +
                "8.5=" + four + '\n' +
                "7.5=" + five + '\n' +
                "6.5=" + six + '\n' +
                "5.5=" + seven;
    }
}

