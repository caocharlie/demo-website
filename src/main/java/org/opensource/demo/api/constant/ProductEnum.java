package org.opensource.demo.api.constant;

/**
 * @ClassName: TODO
 * @Description: TODO
 * @author caoshuo@163.com  
 * @date 2017年12月1日 下午6:32:32
 * @since V1.0
 */

public enum ProductEnum {

	HP_KBGL("HP_KBGL", "口碑管理"),
	RMS_SYGL("RMS_SYGL", "收益管理"),
	HY_PMSGL("HY_PMSGL", "酒店PMS管理"),
	RZT_JYFWZL("RZT_JYFWZL", "交易服务直连");

    private String value;
    private String desc;

    ProductEnum(String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

	public String getValue() {
		return value;
	}
	public String getDesc() {
		return desc;
	}

}