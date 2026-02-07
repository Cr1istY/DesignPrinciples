package cn.foreveryang.after.impl;

import cn.foreveryang.after.IVideoUserService;

public class VipVideoUserService implements IVideoUserService {
    @Override
    public void resolution() {
        System.out.println("VIP用户分辨率 为1080P");
    }

    @Override
    public void adDuration() {
        System.out.println("VIP用户广告时长为0秒");
    }
}
