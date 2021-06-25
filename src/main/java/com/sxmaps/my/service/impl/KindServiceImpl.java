package com.sxmaps.my.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxmaps.my.mapper.KindMapper;
import com.sxmaps.my.model.Kind;
import com.sxmaps.my.service.IKindService;
import com.sxmaps.my.vo.req.kind.ReqKindCreateVO;
import com.sxmaps.my.vo.req.kind.ReqKindListVO;
import com.sxmaps.my.vo.resp.kind.RespKindAllVO;
import com.sxmaps.my.vo.resp.kind.RespKindVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 类：种类
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/10
 */
@Service
public class KindServiceImpl implements IKindService {
    @Resource
    KindMapper kindMapper;

    @Override
    public PageInfo<RespKindVO> getKinds(ReqKindListVO vo) {
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        return new PageInfo<>(kindMapper.getKinds(vo));
    }

    @Override
    public Integer addKinds(ReqKindCreateVO vo) {
        Kind kind = new Kind();
        kind.setKindName(vo.getKindName());
        kind.setCreateTime(new Date());
        return kindMapper.insert(kind);
    }

    @Override
    public List<RespKindAllVO> getKindsAll() {
        return kindMapper.getKindsAll();
    }
}
