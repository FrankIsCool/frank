package com.sxmaps.my.service;

/**
 * 类：定时任务
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/19
 */
public interface IScheduleService {
    /**
     * 统计每月增长的种类
     * @param
     * @return
     * @author frank(付帅)
     * @date 2021/6/19
     **/
    void kind();
    /**
     * 统计每日新增牛只情况
     * @param
     * @return
     * @author frank(付帅)
     * @date 2021/6/19
     **/
    void cowAdd();
}
