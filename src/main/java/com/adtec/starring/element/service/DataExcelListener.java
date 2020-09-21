package com.adtec.starring.element.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.adtec.starring.element.entity.DataExcel;
import com.alibaba.excel.EasyExcel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;


public class DataExcelListener extends AnalysisEventListener<DataExcel> {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<DataExcel> list = new ArrayList<>();

    @Override
    public void invoke(DataExcel data, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
//        if (list.size() >= BATCH_COUNT) {
//            // 存储完成清理 list
//            list.clear();
//        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        LOGGER.info("所有数据解析完成！");
    }


    public static void main(String[] args) {
        String fileName = "G:\\武汉开发\\湖南建行\\外联平台\\03、系统设计\\概要设计\\内部接口文档\\demo.xlsx";

        // 逐行读取
//        EasyExcel.read(fileName,DataExcel.class,new DataExcelListener()).sheet().headRowNumber(3).doRead();

        // 全量读取也可以不指定class，返回一个list，然后读取第一个sheet 同步读取会自动finish
        List<Map<Integer, String>> listMap = EasyExcel.read(fileName).sheet().doReadSync();

        for (Map<Integer, String> data : listMap) {
//             返回每条数据的键值对 表示所在的列 和所在列的值
            System.out.println(JSON.toJSONString(data));
        }
        for (int i = 0; i < listMap.size(); i++) {
            System.out.println("第" + i + "行");

            // 获取交易头部信息
            if (i == 0) {
                String tranName = listMap.get(i).get(0);
                String tranCode = listMap.get(i).get(1);
                String xmlBody = listMap.get(i).get(2);
                String elementDes = listMap.get(i).get(3);
                System.out.println("交易名：" + tranName + " 交易码：" + tranCode + "XMl标签:" + xmlBody + "请求对象描述：" + elementDes);
            }

            // 获取交易字段信息
            if (i > 1 ){
                String enName = listMap.get(i).get(0);
                String zhName = listMap.get(i).get(1);
                String dataType = listMap.get(i).get(2);
                String length = listMap.get(i).get(3);
                String required = listMap.get(i).get(4);
                String remarks = listMap.get(i).get(5);
                System.out.println(enName + zhName + dataType + length);
            }

        }

        // 按照表头全部读取
//        List<DataExcel> list = EasyExcel.read(fileName)
//                .head(DataExcel.class)
//                .headRowNumber(3)
//                .sheet()
//                .doReadSync();
//        list.forEach(dataExcel -> {
//            System.out.println(JSON.toJSON(dataExcel));
//        });
    }
}
