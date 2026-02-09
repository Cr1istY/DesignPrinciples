package cn.foreveryang.before;

import java.util.ArrayList;
import java.util.List;

// 在老师类中，我么初始化了学生信息，同时，提供了简单的接口
public class Teacher {
    private String name;
    private String clazz; // 班级
    private final static List<Student> studentList;

    public Teacher(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public Teacher() {
    }

    // 假设一个老师
    static {
        studentList = new ArrayList<>();
        studentList.add(new Student("张三", 10 ,589));
        studentList.add(new Student("李四", 11 ,588));
        studentList.add(new Student("王五", 12 ,590));
        studentList.add(new Student("赵六", 13 ,591));
    }

    public static List<Student> getStudentList() {
        return studentList;
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }



}
