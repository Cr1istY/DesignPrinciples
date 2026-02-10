package cn.foreveryang.after.hero;

import cn.foreveryang.after.skill.IArchery;
import cn.foreveryang.after.skill.ISilent;

public class HouYi implements IArchery, ISilent {

    @Override
    public void doArchery() {
        System.out.println("后羿射箭");
    }

    @Override
    public void doSilent() {
        System.out.println("沉默");
    }
}
// 此时，我们将臃肿的ISkill接口类中的方法拆分成了单独的接口
// 后羿只需要实现他需要的接口即可
// 实现了接口隔离原则