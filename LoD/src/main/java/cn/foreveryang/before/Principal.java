package cn.foreveryang.before;

import java.util.HashMap;
import java.util.Map;

// 我们通过校长管理所有学生，而老师只提供了非常简单的信息。
// 当然，这可以查询到结果
// 但是，这显然违反了迪米特法则
// 因为，校长需要通过for循环，了解所有学生的信息
// 相当于，你让校长亲自去管理每个班级的学生，这不符合常识
public class Principal {
    private final Teacher teacher = new Teacher("张老师", "3年级1班");
    public Map<String, Object> queryClazzInfo(String clazzId) {
        int stuCount = clazzStudentCount();
        double totalScore = clazzTotalScore();
        double avgScore = clazzAverageScore();

        Map<String, Object> clazzInfo = new HashMap<>();
        clazzInfo.put("班主任", teacher.getName());
        clazzInfo.put("班级", teacher.getClazz());
        clazzInfo.put("学生人数", stuCount);
        clazzInfo.put("班级总分", totalScore);
        clazzInfo.put("班级平均分", avgScore);
        return clazzInfo;
    }

    public double clazzTotalScore() {
        double totalScore = 0;
        for (Student student : Teacher.getStudentList()) {
            totalScore += student.getGrade();
        }
        return totalScore;
    }

    public double clazzAverageScore() {
        double totalScore = clazzTotalScore();
        return totalScore / clazzStudentCount();
    }


    public int clazzStudentCount() {
        return Teacher.getStudentList().size();
    }
}
