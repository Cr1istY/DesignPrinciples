package cn.foreveryang.before.hero;

import cn.foreveryang.before.ISkill;

// 此时，我们不得不重写该接口的所有方法，即便这个方法我们不会使用
public class HouYi implements ISkill {
    @Override
    public void doArchery() {
        System.out.println("后羿射箭");
    }

    @Override
    public void doInvisible() {
    }

    @Override
    public void doSilent() {

    }

    @Override
    public void doVertigo() {

    }
}
// 这明显是我们不想要的，因为这会导致代码变得十分臃肿，难以维护
