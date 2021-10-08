package com.sxmaps.my.vo.resp.cow;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class RespCowAddVO {
    /**
     * 牧场uid
     */
    private Long farmersUid;

    /**
     * 新增数
     */
    private Integer num;
}