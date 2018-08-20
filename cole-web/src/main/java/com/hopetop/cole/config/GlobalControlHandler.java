/**
 *
 */
package com.hopetop.cole.config;

import com.hopetop.cole.common.exception.ErrorException;
import com.hopetop.cole.common.exception.WarnException;
import com.hopetop.cole.common.response.BaseResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobalControlHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalControlHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        BaseResponse response = BaseResponse.instanceErr();
        //捕获服务地址找不到情况，转化为标准json返回
        //2018.7.21测试有BUG，停用
//        if (e instanceof NoHandlerFoundException) {
//            response.setMsgCode(ColeMessage.NOT_FIND.getCode());
//        } else
        if (e instanceof WarnException) {
            response.setMsgCode(((WarnException) e).getCode());
            // 记录错误信息);
            logger.warn("warning:" + e.getMessage());
        } else if (e instanceof ErrorException) {
            response.setMsgCode(((ErrorException) e).getCode());
            logger.error("error:" + ExceptionUtils.getStackTrace(e));
        } else {
            logger.error("error:" + ExceptionUtils.getStackTrace(e));
        }
        response.setMsg(e.getMessage());
        return response;
    }

    //可以增加其他返回值获取等，以后看情况增加
}
