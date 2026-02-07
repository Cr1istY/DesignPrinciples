package cn.foreveryang.after.impl;

import cn.foreveryang.after.IVideoUserService;

public class NormalVideoUserService implements IVideoUserService {
    @Override
    public void resolution() {
        System.out.println("普通用户分辨率 为720P");
    }

    @Override
    public void adDuration() {
        System.out.println("普通用户广告时长为5秒");
    }
}
