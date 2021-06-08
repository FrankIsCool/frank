package com.sxmaps.mms.mapper;

import java.util.List;

import com.sxmaps.mms.common.CommonMapper;
import com.sxmaps.mms.model.MmsTrackReservation;
import com.sxmaps.mms.vo.TrackReservationVO;
import com.sxmaps.mms.vo.resp.RespTrackReservationVO;

public interface MmsTrackReservationMapper extends CommonMapper<MmsTrackReservation> {

	List<RespTrackReservationVO> qryInfoTrackReservation(TrackReservationVO trackReservationVo);
}