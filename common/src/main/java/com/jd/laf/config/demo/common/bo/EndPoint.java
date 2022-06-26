package com.jd.laf.config.demo.common.bo;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/6/26
 * @since todo
 */
public class EndPoint {
    private String ip;
    private int port;

    public EndPoint(){
    }

    public EndPoint(String endpoint) {
        try {
            String[] ss = endpoint.split(":");
            this.ip = ss[0];
            this.port = Integer.valueOf(ss[1]);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "EndPoint{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}
