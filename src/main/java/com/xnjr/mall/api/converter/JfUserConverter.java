/**
 * @Title JfUserConverter.java 
 * @Package com.xnjr.mall.api.converter 
 * @Description 
 * @author xieyj  
 * @date 2016年7月26日 上午11:41:54 
 * @version V1.0   
 */
package com.xnjr.mall.api.converter;

import com.xnjr.mall.dto.req.XN602600Req;
import com.xnjr.mall.dto.req.XN805042Req;

/** 
 * @author: xieyj 
 * @since: 2016年7月26日 上午11:41:54 
 * @history:
 */
public class JfUserConverter {

    // 入驻
    public static XN805042Req converter(XN602600Req req) {
        XN805042Req resultReq = new XN805042Req();
        resultReq.setLoginName(req.getLoginName());
        resultReq.setMobile(req.getMobile());
        resultReq.setIdKind(req.getIdKind());
        resultReq.setIdNo(req.getIdNo());
        resultReq.setRealName(req.getRealName());
        resultReq.setUserReferee(req.getUserReferee());
        resultReq.setPdf(req.getPdf());
        return resultReq;
    }
}
