package com.jd.laf.config.demo.dict.common.receiver;

import com.jd.laf.config.Property;
import com.jd.laf.config.dict.DictDataReceiver;
import com.jd.laf.config.dict.datum.DictLine;
import com.jd.laf.config.dict.datum.DictMeta;
import com.jd.laf.config.dict.datum.DictTable;
import com.jd.laf.config.dict.datum.OperateTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:ronggangping@jd.com>ronggangping</a>
 * @date 2023/1/4
 * @since todo
 */
public class DictDataReceiverImplDemo implements DictDataReceiver {
    private static Logger LOGGER = LoggerFactory.getLogger(DictDataReceiverImplDemo.class);
    private Map<Long, Collection<Property>> data = new HashMap<>();
    private List<Collection<Property>> properties = new ArrayList<>();
    //是否是增量数据，对应的resource 打开了增量模式：useIncrementModel=true
    private boolean incrementData;
    private DictMeta.Field idField = new DictMeta.Field("id");

    @Override
    public void begin(DictTable dictTable) {
        boolean incrementData = dictTable.isIncrementData();
        if (incrementData) {//打开了增量模式才需要判断，
            this.incrementData = incrementData;
            LOGGER.info("table:{}，begin increment data", dictTable.getTableName());
        } else {
            LOGGER.info("table:{}，begin all data", dictTable.getTableName());
            data.clear();
            properties.clear();
        }
    }

    @Override
    public void onLine(DictLine dictLine) {
        Map<DictMeta.Field, Property> line = dictLine.getLine();
        Property property = line.get(idField);
        if (property == null) {
            //老版本的id值，由页面控制---是否同步网盘id
            //只要发布过一次后，都会带有id值
            properties.add(line.values());
            return;
        }
        Long id = property.getLong();
        if (incrementData) {
            OperateTypeEnum operateTypeEnum = dictLine.getOperateTypeEnum();
            LOGGER.info("id:{},operateType:{}, line :{}", id, operateTypeEnum, line);
            switch (operateTypeEnum) {
                case add:
                case update:
                    this.data.put(id, line.values());
                    break;
                case delete:
                    this.data.remove(id);
                    break;
            }
        } else {
            this.data.put(id, line.values());
        }
    }

    @Override
    public void end(DictTable dictTable) {
        LOGGER.info("finish table has data size:{}  old datasize:{}", this.data.size(), this.properties.size());
    }

    @Override
    public void fail(DictTable dictTable) {

    }
}
