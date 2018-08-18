package com.example.adib.test.BackEnd;

/**
 * Created by ADIB on 10/08/2018.
 */

public class Exercise {

    private String exercise_name;
    private int count;

    public Exercise(String exercise_name ,int count) {
        this.exercise_name=exercise_name;
        this.count=count;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public int getCount() {
        return count;
    }
}
