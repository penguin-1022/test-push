package com.jd.laf.config.demo.common.bo;

/**
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/11/8
 * @since todo
 */
public class Entry2 {

    private String ip;
    private int port;

    public static Entry2 fromString(String endpoint) {
        Entry2 entry1 = new Entry2();
        try {
            String[] ss = endpoint.split(":");
            entry1.ip = ss[0];
            entry1.port = Integer.valueOf(ss[1]);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entry1;
    }

    @Override
    public String toString() {
        return "Entry2{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}
