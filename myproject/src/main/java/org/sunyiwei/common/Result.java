package org.sunyiwei.common;

import java.util.List;

/**
 * =============================
 *
 * @author:sunyiwei DateTime: 2019/3/21 16:31
 * =============================
 */

public class Result {

    /**
     * code : 200
     * msg : Success
     * addiInfo : null
     * basicInfo : {"module_name":"monitor","ip_address":"0.0.0.0","udp_port":0,"addiInfo":"no additional information"}
     * data : ["http_total","httptotal","my_counter"]
     */

    private int code;
    private String msg;
    private Object addiInfo;
    private BasicInfoBean basicInfo;
    private List<String> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getAddiInfo() {
        return addiInfo;
    }

    public void setAddiInfo(Object addiInfo) {
        this.addiInfo = addiInfo;
    }

    public BasicInfoBean getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfoBean basicInfo) {
        this.basicInfo = basicInfo;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public static class BasicInfoBean {
        /**
         * module_name : monitor
         * ip_address : 0.0.0.0
         * udp_port : 0
         * addiInfo : no additional information
         */

        private String module_name;
        private String ip_address;
        private int udp_port;
        private String addiInfo;

        public String getModule_name() {
            return module_name;
        }

        public void setModule_name(String module_name) {
            this.module_name = module_name;
        }

        public String getIp_address() {
            return ip_address;
        }

        public void setIp_address(String ip_address) {
            this.ip_address = ip_address;
        }

        public int getUdp_port() {
            return udp_port;
        }

        public void setUdp_port(int udp_port) {
            this.udp_port = udp_port;
        }

        public String getAddiInfo() {
            return addiInfo;
        }

        public void setAddiInfo(String addiInfo) {
            this.addiInfo = addiInfo;
        }
    }
}
