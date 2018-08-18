package com.example.adib.test.BackEnd;

/**
 * Created by ADIB on 06/08/2018.
 */

public class TypeExercise {
    private int img;
    private String name;


    public TypeExercise (int image,String name){
        this.img=image;
        this.name=name;
    }

    public int getImg() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }
}
