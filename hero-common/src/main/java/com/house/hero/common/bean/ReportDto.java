package com.house.hero.common.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/28
 * @ Description：表格 数据接收类
 * @ throws
 */
@Data
@Accessors(chain = true)
public class ReportDto {

    /**
     * 名称
     */
    private String tbdwTxt;
    /**
     * 登记人数
     */
    private String ldrkdjs;
    /**
     * 办证总人数
     */
    private String jzzbzzs;
    /**
     * 办证率（%）
     */
    private String jzzbzl;
    /**
     * 登记户数(户)
     */
    private String czfwdjhs;
    /**
     * 签订数（份）
     */
    private String zazrsqds;
    /**
     * 备注
     */
    private String remark;
}
