package com.jd.laf.config.demo.predict;

import com.jd.laf.binding.converter.PredictOperator;
import com.jd.laf.config.demo.predict.annotations.CustomizeValueParser;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/8/3
 * @since todo
 */
public class CustomizePredictOperator implements PredictOperator {
    @Override
    public Class<?> operate(Object value) {
        //根据实际情况判断 value 什么情况下使用哪种注解对应的转换器
        if (value.toString() != null) {
            return CustomizeValueParser.class;
        }
        return null;
    }
}
