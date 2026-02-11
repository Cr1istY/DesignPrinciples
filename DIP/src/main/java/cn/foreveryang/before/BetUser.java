package cn.foreveryang.before;

// 假设一个抽奖场景
// 这些抽奖场景的规则会随着业务的不断发展而调整
// 该类为我们初次抽奖活动搭建的场景，查看这个系统是否有良好的扩展性和可维护性
public class BetUser {
    private String name;
    private int userWeight; // 用户权重

    public BetUser(String name, int userWeight) {
        this.name = name;
        this.userWeight = userWeight;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(int userWeight) {
        this.userWeight = userWeight;
    }
}
// 上类就是一个普通的对象类，包括了用户姓名和相应的权重