package com.xnjr.base.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.base.ao.ISYSDictAO;
import com.xnjr.base.api.AProcessor;
import com.xnjr.base.common.JsonUtil;
import com.xnjr.base.domain.SYSDict;
import com.xnjr.base.dto.req.XN809006Req;
import com.xnjr.base.exception.BizException;
import com.xnjr.base.exception.ParaException;
import com.xnjr.base.spring.SpringContextHolder;

/**
 * 列表查询数据字典
 * @author: xieyj 
 * @since: 2016年9月17日 下午1:50:02 
 * @history:
 */
public class XN809006 extends AProcessor {
    private ISYSDictAO sysDictAO = SpringContextHolder
        .getBean(ISYSDictAO.class);

    private XN809006Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        SYSDict condition = new SYSDict();
        condition.setType(req.getType());
        condition.setParentKey(req.getParentKey());
        condition.setDkey(req.getDkey());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISYSDictAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        return sysDictAO.querySysDictList(condition);
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN809006Req.class);
    }

}
