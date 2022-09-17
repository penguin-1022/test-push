package com.jd.laf.config.demo.predict.transformer;

import com.jd.laf.binding.converter.Conversion;
import com.jd.laf.binding.converter.Transformer;
import com.jd.laf.config.demo.predict.User;
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
public class CustomizeTransformer implements Transformer {
    /**
     * 转换器逻辑
     * @param conversion 转换对象
     * @return
     * @throws Exception
     */
    @Override
    public Object execute(Conversion conversion) throws Exception {
        String value = conversion.source.toString();
        User user = new User();
        String[] vv = value.split(",");
        user.setName(vv[0]);
        user.setAge(Integer.valueOf(vv[1]));
        return user;
    }

    /**
     * 根据类型判断
     * @param sourceType 源类型
     * @param targetType 目标类型
     * @return
     */
    @Override
    public boolean support(Class<?> sourceType, Class<?> targetType) {
        return true;
    }

    /**
     * 返回值代表这个转换器身份的注解.
     * @return
     */
    @Override
    public Class<?> annotation() {
        return CustomizeValueParser.class;
    }
}
