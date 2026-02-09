package cn.foreveryang.before;

// 假设在一个学校场景
// 校长需要管理老师和学生的各种信息
public class Student {
    private String name;
    private int rank; // 排名
    private double grade; // 总分

    public Student(String name, int rank, double grade) {
        this.name = name;
        this.rank = rank;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
