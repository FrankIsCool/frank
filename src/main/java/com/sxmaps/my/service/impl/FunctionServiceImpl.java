package com.sxmaps.my.service.impl;

import com.sxmaps.my.enums.FunctionTypeEnum;
import com.sxmaps.my.enums.StateEnum;
import com.sxmaps.my.mapper.FuncMapper;
import com.sxmaps.my.mapper.UsersFuncMapper;
import com.sxmaps.my.model.Func;
import com.sxmaps.my.service.IFunctionService;
import com.sxmaps.my.vo.req.function.ReqFunctionCreateVO;
import com.sxmaps.my.vo.req.function.ReqFunctionDelVO;
import com.sxmaps.my.vo.resp.function.RespFunctionTreeVO;
import com.sxmaps.my.vo.resp.function.RespFunctionsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 类：功能
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/25
 */
@Service
public class FunctionServiceImpl implements IFunctionService {

    @Resource
    FuncMapper funcMapper;

    @Resource
    UsersFuncMapper usersFuncMapper;
    @Override
    public RespFunctionTreeVO getAllFunctions() {
        RespFunctionTreeVO treeVO = funcMapper.getSystem("系统",FunctionTypeEnum.FUNCTIONTYPE_3.getState());
        treeVO = getFunctionsTree(treeVO);
        return treeVO;
    }

    @Override
    public Integer addFunctions(ReqFunctionCreateVO vo) {
        Func fatherFunction = funcMapper.selectByPrimaryKey(vo.getFatherUid());
        Func func = new Func();
        func.setCreateTime(new Date());
        func.setDel(StateEnum.NOTDEL.getState().byteValue());
        func.setFatherUid(vo.getFatherUid());
        func.setRemark(vo.getRemark());
        func.setFunctionName(vo.getFunctionName());
        func.setFunctionPath(vo.getFunctionPath());
        func.setFunctionSn(vo.getFunctionSn());
        func.setFunctionType(vo.getFunctionType().byteValue());
        func.setFunllName(fatherFunction.getFunllName()+"/"+vo.getFunctionName());
        func.setFatherUid(vo.getFatherUid());
        return funcMapper.insert(func);
    }

    @Override
    public Integer delFunctions(ReqFunctionDelVO vo) {
        Func fatherFunction = funcMapper.selectByPrimaryKey(vo.getFunctionUid());
        fatherFunction.setDel(StateEnum.DEL.getState().byteValue());
        return funcMapper.updateByPrimaryKey(fatherFunction);
    }

    @Override
    public List<RespFunctionsVO> getFunctions(Long userUid) {
        return usersFuncMapper.getFunctions(userUid);
    }

    private RespFunctionTreeVO getFunctionsTree(RespFunctionTreeVO treeVO) {
        List<RespFunctionTreeVO> functionTreeVOS = funcMapper.getFunctionsOrPage(treeVO.getFunctionUid(),null);
        if (null != functionTreeVOS && functionTreeVOS.size() > 0) {
            for (RespFunctionTreeVO functionTreeVO : functionTreeVOS) {
                getFunctionsTree(functionTreeVO);
            }
            treeVO.setChildTree(functionTreeVOS);
        }
        return treeVO;
    }

}
