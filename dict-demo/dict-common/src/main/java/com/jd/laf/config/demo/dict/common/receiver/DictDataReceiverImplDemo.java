package com.jd.laf.config.demo.dict.common.receiver;

import com.jd.laf.config.Property;
import com.jd.laf.config.dict.DictDataReceiver;
import com.jd.laf.config.dict.datum.DictLine;
import com.jd.laf.config.dict.datum.DictMeta;
import com.jd.laf.config.dict.datum.DictTable;
import com.jd.laf.config.dict.datum.OperateTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
    private Map<Long, Collection<Property>> dataForUse = new HashMap<>();
    private Map<Long, Collection<Property>> dataForProcess = new HashMap<>();
    //是否是增量数据，对应的resource 打开了增量模式：useIncrementModel=true
    private boolean incrementData;
    private boolean error;
    private DictMeta.Field idField = new DictMeta.Field("id");

    @Override
    public void begin(DictTable dictTable) {
        this.incrementData = dictTable.isIncrementData();
        LOGGER.info("table:{}，incrementData:{}", dictTable.getTableName(), incrementData);
        if (!incrementData) {
            //打开增量模式后才需要判断
            //推送全量数据，清除旧数据
            dataForProcess.clear();
        }
    }

    @Override
    public void onLine(DictLine dictLine) {
        Map<DictMeta.Field, Property> line = dictLine.getLine();
        Property property = line.get(idField);
        //老版本的id值，由页面控制---是否同步网盘id
        //只要发布过一次后，都会带有id值
        Long id = property.getLong();
        if (incrementData) {
            OperateTypeEnum operateTypeEnum = dictLine.getOperateTypeEnum();
            LOGGER.info("id:{},operateType:{}, line :{}", id, operateTypeEnum, line);
            switch (operateTypeEnum) {
                case add:
                case update:
                    this.dataForProcess.put(id, line.values());
                    break;
                case delete:
                    this.dataForProcess.remove(id);
                    break;
            }
        } else {
            this.dataForProcess.put(id, line.values());
        }
    }

    @Override
    public void end(DictTable dictTable) {
        LOGGER.info("finish table error:{} has data size:{}  old datasize:{}", error, this.dataForProcess.size(), this.dataForUse.size());
        if (!error) {
            //处理成功后使用新版本数据
            Map<Long, Collection<Property>> dataForUseTemp = new HashMap<>();
            dataForUseTemp.putAll(dataForProcess);
            dataForUse = dataForUseTemp;
        }
    }

    @Override
    public void fail(DictTable dictTable) {
        error = true;
    }
}
