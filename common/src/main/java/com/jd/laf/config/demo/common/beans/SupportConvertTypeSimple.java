package com.jd.laf.config.demo.common.beans;

import com.jd.laf.binding.annotation.JsonConverter;
import com.jd.laf.config.demo.common.bo.*;
import com.jd.laf.config.spring.annotation.LafValue;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/11/8
 * @since todo
 */
public class SupportConvertTypeSimple {

    @LafValue("convert.key1")
    private int key1;
    @LafValue("convert.key2")
    private Integer key2;
    @LafValue("convert.key3")
    private long key3;
    @LafValue("convert.key4")
    private Long key4;
    @LafValue("convert.key5")
    private float key5;
    @LafValue("convert.key6")
    private Float key6;
    @LafValue("convert.key7")
    private double key7;
    @LafValue("convert.key8")
    private Double key8;
    @LafValue("convert.key9")
    private boolean key9;
    @LafValue("convert.key10")
    private Boolean key10;
    @LafValue("convert.key11")
    private AtomicInteger key11;
    @LafValue("convert.key12")
    private AtomicLong key12;
    @LafValue("convert.key13")
    private AtomicBoolean key13;
    @LafValue("convert.key14")
    private char key14;
    @LafValue("convert.key15")
    private Class key15;
    @LafValue("convert.key16")
    private URL key16;
    @LafValue("convert.key17")
    private URI key17;
    @LafValue("convert.key18")
    private Date key18;
    @LafValue("convert.key19")
    private File key19;
    @LafValue("convert.key20")
    private Color key20;
    @LafValue("convert.key21")
    private Entry1 key21;
    @LafValue("convert.key22")
    private Entry2 key22;
    @LafValue("convert.key23")
    private EndPoint key23;

    //字符串逗号分隔，数组元素支持上述的类型转换
    @LafValue("convert.key24")
    private int[] key24;

    //字符串逗号分隔，集合元素支持上述的类型转换
    @LafValue("convert.key25")
    private List<Integer> key25;

    @LafValue("convert.key26")
    @JsonConverter(isSupportGeneric = true)//isSupportGeneric 默认值是 false， 表示不支持泛型
    private Map<String, List<User>> key26;
    @LafValue("convert.key27")
    private Duration key27;

    @Override
    public String toString() {
        return "SupportConvertTypeSimple{" +
                "key1=" + key1 +
                ", key2=" + key2 +
                ", key3=" + key3 +
                ", key4=" + key4 +
                ", key5=" + key5 +
                ", key6=" + key6 +
                ", key7=" + key7 +
                ", key8=" + key8 +
                ", key9=" + key9 +
                ", key10=" + key10 +
                ", key11=" + key11 +
                ", key12=" + key12 +
                ", key13=" + key13 +
                ", key14=" + key14 +
                ", key15=" + key15 +
                ", key16=" + key16 +
                ", key17=" + key17 +
                ", key18=" + key18 +
                ", key19=" + key19 +
                ", key20=" + key20 +
                ", key21=" + key21 +
                ", key22=" + key22 +
                ", key23=" + key23 +
                ", key24=" + Arrays.toString(key24) +
                ", key25=" + key25 +
                ", key26=" + key26 +
                ", key27=" + key27 +
                '}';
    }
}
