package cn.foreveryang.after;

import java.util.HashMap;
import java.util.Map;

public class Principal {
    private final Teacher teacher = new Teacher("张老师", "3年级1班");
    public Map<String, Object> queryClazzInfo(String clazzId) {
        // 在这里，我们直接让校长管理老师即可
        int stuCount = teacher.clazzStudentCount();
        double totalScore = teacher.clazzTotalScore();
        double avgScore = teacher.clazzAverageScore();

        Map<String, Object> clazzInfo = new HashMap<>();
        clazzInfo.put("班主任", teacher.getName());
        clazzInfo.put("班级", teacher.getClazz());
        clazzInfo.put("学生人数", stuCount);
        clazzInfo.put("班级总分", totalScore);
        clazzInfo.put("班级平均分", avgScore);
        return clazzInfo;
    }

//    public double clazzTotalScore() {
//        double totalScore = 0;
//        for (Student student : Teacher.getStudentList()) {
//            totalScore += student.getGrade();
//        }
//        return totalScore;
//    }
//
//    public double clazzAverageScore() {
//        double totalScore = clazzTotalScore();
//        return totalScore / clazzStudentCount();
//    }
//
//
//    public int clazzStudentCount() {
//        return Teacher.getStudentList().size();
//    }
}
