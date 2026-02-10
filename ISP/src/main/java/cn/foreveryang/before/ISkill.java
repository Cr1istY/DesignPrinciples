package cn.foreveryang.before;

// 设计一个英雄技能接口
// 在违反接口隔离原则的情况下，会将所有技能都写在同一个接口下
public interface ISkill {
    void doArchery();

    void doInvisible();

    void doSilent();

    void doVertigo();
}
