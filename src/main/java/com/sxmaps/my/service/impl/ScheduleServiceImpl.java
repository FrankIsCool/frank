package com.sxmaps.my.service.impl;

import com.franks.util.date.DateProperties;
import com.franks.util.date.DateUtil;
import com.franks.util.date.StrDateUtil;
import com.sxmaps.my.mapper.*;
import com.sxmaps.my.model.Farmers;
import com.sxmaps.my.model.Kind;
import com.sxmaps.my.model.KindCollect;
import com.sxmaps.my.model.StatisticsAdd;
import com.sxmaps.my.service.IScheduleService;
import com.sxmaps.my.vo.resp.cow.RespCowAddVO;
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

    @Resource
    CowIllLogMapper cowIllLogMapper;

    @Resource
    CowFetationLogMapper cowFetationLogMapper;

    @Resource
    CowDieLogMapper cowDieLogMapper;

    @Resource
    StatisticsAddMapper statisticsAddMapper;

    @Override
    public void kind() {
        String lastTime = StrDateUtil.getDate(DateProperties.DATE_YEAR_MONTH_DAY)+" 00:00:00";
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
        Date date = StrDateUtil.toDate(lastTime, DateProperties.DATE_1_ALL);
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

    @Override
    public void cowAdd() {
        Date yesterday = DateUtil.addDay(-1);
        String lastTime = DateUtil.toStr(yesterday,DateProperties.DATE_YEAR_MONTH_DAY);
        List<Farmers> farmers = farmersMapper.getFarmersAll(lastTime+" 00:00:00");
        if(null == farmers || farmers.size()<1){
            return;
        }
        List<RespCowAddVO> ills = cowIllLogMapper.statisticsIll(lastTime);
        List<RespCowAddVO> cures = cowIllLogMapper.statisticsCure(lastTime);
        Map<Long, Integer> illMap = ills.stream().collect(Collectors.toMap(RespCowAddVO::getFarmersUid, RespCowAddVO::getNum));
        Map<Long, Integer> cureMap = cures.stream().collect(Collectors.toMap(RespCowAddVO::getFarmersUid, RespCowAddVO::getNum));

        List<RespCowAddVO> fetations = cowFetationLogMapper.statisticsFetation(lastTime);
        List<RespCowAddVO> childbirths = cowFetationLogMapper.statisticsChildbirth(lastTime);
        Map<Long, Integer> fetationsMap = fetations.stream().collect(Collectors.toMap(RespCowAddVO::getFarmersUid, RespCowAddVO::getNum));
        Map<Long, Integer> childbirthsMap = childbirths.stream().collect(Collectors.toMap(RespCowAddVO::getFarmersUid, RespCowAddVO::getNum));

        List<RespCowAddVO> dies = cowDieLogMapper.statisticsDie(lastTime);
        Map<Long, Integer> diesMap = dies.stream().collect(Collectors.toMap(RespCowAddVO::getFarmersUid, RespCowAddVO::getNum));

        List<StatisticsAdd> adds = farmers.stream().map(farmer -> {
            StatisticsAdd add = new StatisticsAdd();
            add.setFarmersUid(farmer.getUid());
            add.setDateTime(yesterday);
            add.setAddIll(0);
            add.setAddCure(0);
            add.setAddFetation(0);
            add.setAddBirth(0);
            add.setAddDie(0);

            add.setAddBuy(0);
            if(illMap.containsKey(add.getFarmersUid())){
                add.setAddIll(illMap.get(add.getFarmersUid()));
            }
            if(cureMap.containsKey(add.getFarmersUid())){
                add.setAddCure(cureMap.get(add.getFarmersUid()));
            }
            if(fetationsMap.containsKey(add.getFarmersUid())){
                add.setAddFetation(fetationsMap.get(add.getFarmersUid()));
            }
            if(childbirthsMap.containsKey(add.getFarmersUid())){
                add.setAddBirth(childbirthsMap.get(add.getFarmersUid()));
            }
            if(diesMap.containsKey(add.getFarmersUid())){
                add.setAddDie(diesMap.get(add.getFarmersUid()));
            }
           return add;
        }).collect(Collectors.toList());
        statisticsAddMapper.insertList(adds);
    }
}
