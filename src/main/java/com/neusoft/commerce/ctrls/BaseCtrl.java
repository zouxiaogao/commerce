package com.neusoft.commerce.ctrls;

import com.neusoft.commerce.common.Result;

/**
 * @Author zqy
 * @Date 2019/07/18
 */
public class BaseCtrl {
    /**
     * 处理成功时的返回
     * @param o 返回的结果集
     * @return Result
     */
    protected Result send(Object o) {
        Result ret = new Result(o);
        return ret;
    }

    /**
     * 非正常情况的返回
     * @param code 错误码
     * @param message 错误信息
     * @return Result
     */
    protected Result send(int code, String message) {
        Result ret = new Result(code,message);
        return ret;
    }

    protected Result send( int code, String message,Object o) {
        Result ret = new Result(code,message,o);
        return ret;
    }
}
