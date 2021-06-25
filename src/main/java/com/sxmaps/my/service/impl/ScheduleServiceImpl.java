package com.sxmaps.my.service.impl;

import com.sxmaps.my.mapper.CowMapper;
import com.sxmaps.my.mapper.FarmersMapper;
import com.sxmaps.my.mapper.KindCollectMapper;
import com.sxmaps.my.mapper.KindMapper;
import com.sxmaps.my.model.Farmers;
import com.sxmaps.my.model.Kind;
import com.sxmaps.my.model.KindCollect;
import com.sxmaps.my.service.IScheduleService;
import com.sxmaps.my.utils.DateUtil;
import com.sxmaps.my.vo.resp.cow.RespCowCollectVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 类：定时任务
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/19
 */
@Service
public class ScheduleServiceImpl implements IScheduleService {

    @Resource
    CowMapper cowMapper;

    @Resource
    KindMapper kindMapper;

    @Resource
    FarmersMapper farmersMapper;

    @Resource
    KindCollectMapper kindCollectMapper;

    @Override
    public void kind() {
        String lastTime = DateUtil.getDateForMonth(DateUtil.FORMAT_DATE, 1)+" 00:00:00";
        List<Farmers> farmers = farmersMapper.getFarmersAll(lastTime);
        if(null == farmers || farmers.size()<1){
            return;
        }
        List<Kind> kinds = kindMapper.selectAll();
        if(null == kinds || kinds.size()<1){
            return;
        }
        List<Long> farmerUids = farmers.stream().map(Farmers::getUid).collect(Collectors.toList());
        List<Long> kindUids = kinds.stream().map(Kind::getUid).collect(Collectors.toList());
        List<RespCowCollectVO> cowCountCollect = cowMapper.getCowCountCollect(farmerUids,kindUids, lastTime);
        Map<String,Integer> map = new HashMap();
        cowCountCollect.stream().forEach(cowCount->{
            map.put(cowCount.getFarmersUid()+"&"+cowCount.getKindUid(),cowCount.getNum());
        });
        Date date = DateUtil.toDate(lastTime, DateUtil.FORMAT_DATE);
        List<KindCollect> kindCollects = new ArrayList<>();
        farmers.stream().forEach(farmer -> {
            kinds.stream().forEach(kind -> {
                KindCollect kindCollect  = new KindCollect();
                kindCollect.setKindUid(kind.getUid());
                kindCollect.setFarmersUid(farmer.getUid());
                kindCollect.setCreateTime(new Date());
                kindCollect.setCollectDate(date);
                kindCollect.setNum(0);
                String key = farmer.getUid()+"&"+kind.getUid();
                if(map.containsKey(key)){
                    kindCollect.setNum(map.get(key));
                }
                kindCollects.add(kindCollect);
            });
        });
        kindCollectMapper.insertList(kindCollects);
    }
}
