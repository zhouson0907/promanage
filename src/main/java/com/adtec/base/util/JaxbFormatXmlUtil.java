package com.adtec.base.util;

import com.adtec.starring.element.entity.DataElement;
import com.adtec.starring.element.entity.DataElementTab;
import com.adtec.starring.element.entity.Item;
import com.adtec.starring.element.entity.ItemTab;

import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbFormatXmlUtil {

    /**
     * JavaBean转换成xml
     * 默认编码UTF-8
     * @param obj Bean对象
     * @return
     */
    public static String convertToXml(Object obj) {
        return convertToXml(obj, StandardCharsets.UTF_8);
    }


    /**
     * JavaBean转换成xml
     * @param obj
     * @param encoding
     * @return
     */
    public static String convertToXml(Object obj, Charset encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 格式化自动换行
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding.toString());
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * xml转换成JavaBean
     * @param xml
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T converyToJavaBean(String xml, Class<T> c) {
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void main(String[] args) {

        Item item1 = new Item();
        item1.setItemName("custom");
        item1.setItemDesc("获取一件事一次办事项列表输出custom数据对象");
        item1.setItemType("DataElem");
        item1.setTypeName("businessListRes_custom");
        item1.setItemDeft("");
        item1.setElemType("");
        item1.setArray("No");
        item1.setNodeType("Node");
        item1.setSecurity("");
        item1.setEnumKvp("");
        item1.setEnumName("");
        item1.setRelateItemName("");
        item1.setScopeExpr("<![CDATA[]]>");

        Item item2 = new Item();
        item2.setItemName("status");
        item2.setItemDesc("获取一件事一次办事项列表输出status数据对象");
        item2.setItemType("DataElem");
        item2.setTypeName("businessListRes_status");
        item2.setItemDeft("");
        item2.setElemType("");
        item2.setArray("No");
        item2.setNodeType("Node");
        item2.setSecurity("");
        item2.setEnumKvp("");
        item2.setEnumName("");
        item2.setRelateItemName("");
        item2.setScopeExpr("<![CDATA[]]>");

        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);

        ItemTab itemTab = new ItemTab();
        itemTab.setItem(itemList);
        itemTab.setRecNum(String.valueOf(itemList.size()));


        DataElement dataElement = new DataElement();
        dataElement.setDataType("Struct");
        dataElement.setElemName("businessListRes");
        dataElement.setElemDesc("获取一件事一次办事项列表输出数据对象");
        dataElement.setNodeClassName("未分类");
        dataElement.setNodeClassDesc("未分类");
        dataElement.setXmlNodeName("Body");
        dataElement.setItemTab(itemTab);

        DataElementTab dataElementTab = new DataElementTab();
        dataElementTab.setDataElement(dataElement);
        dataElementTab.setRecNum("1");


        String str = JaxbFormatXmlUtil.convertToXml(dataElementTab);
        str = str.replaceAll("&lt;","<");
        str = str.replaceAll("&gt;",">");
        System.out.println(str);
    }
}
