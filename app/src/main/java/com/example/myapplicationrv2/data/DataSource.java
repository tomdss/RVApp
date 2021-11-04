package com.example.myapplicationrv2.data;

import com.example.myapplicationrv2.model.Task;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<Task> createTasksList() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("d1", true, 3));
        tasks.add(new Task("d2", false, 2));
        tasks.add(new Task("d3", true, 1));
        tasks.add(new Task("d4", false, 0));
        tasks.add(new Task("d5", true, 5));
        return tasks;
    }
}
