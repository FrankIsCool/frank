package com.sxmaps.my.common;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 类：
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/17
 */
@Data
public class PageInfoTable<T> {
    // 当前页
    private Integer draw;
    // 总页数
    private long total;
    // 每页显示多少
    private Integer pageSize;
    // 总记录数
    private long recordsTotal;

    private long recordsFiltered;
    // 记录
    private List<T> data;

    /**
     * <p>Title: </p>
     * <p>Description: 构造函数，传入一个com.github.pagehelper.PageInfo对象</p>
     *
     * @param pageInfo
     */
    public void setPage(PageInfo pageInfo, HttpServletRequest req) {
        String draw = req.getParameter("draw");
        if(null != draw && !"".equals(draw)){
            this.setDraw(Integer.valueOf(draw));
        }
        this.setPageSize(pageInfo.getPageSize());
        this.setRecordsTotal(pageInfo.getTotal());
        this.setTotal(pageInfo.getTotal());
        this.setRecordsFiltered(pageInfo.getTotal());
        this.setData(pageInfo.getList());
    }
}
