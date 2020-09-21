package com.adtec.starring.element.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


@Data
public class DataExcel {

    @ExcelProperty("英文名称")
    private String enName;

    @ExcelProperty("中文名称")
    private String zhName;

    @ExcelProperty("数据类型")
    private String dataType;

    @ExcelProperty("长度")
    private String length;

    @ExcelProperty("是否必输")
    private String required;

    @ExcelProperty("备注")
    private String remarks;


}
