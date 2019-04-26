package com.house.hero.easyPoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/26
 * @ Description：
 * @ throws
 */
@Controller
@RequestMapping("/dyn")
public class DynamicPOIDemo {

    @RequestMapping(value = "/exportExcel")
    @ResponseBody
    public void exportStuInfoExcel() {

        try {
            //头部信息
            List<ExcelExportEntity> colList = new ArrayList<>();
            ExcelExportEntity colEntity = new ExcelExportEntity("商品名称", "title");
            colEntity.setNeedMerge(true);
            colList.add(colEntity);

            colEntity = new ExcelExportEntity("供应商", "supplier");
            colEntity.setNeedMerge(true);
            colList.add(colEntity);

            ExcelExportEntity deliColGroup = new ExcelExportEntity("得力", "deli");
            List<ExcelExportEntity> deliColList = new ArrayList<>();
            deliColList.add(new ExcelExportEntity("市场价", "orgPrice"));
            deliColList.add(new ExcelExportEntity("专区价", "salePrice"));
            deliColGroup.setList(deliColList);
            colList.add(deliColGroup);

            ExcelExportEntity jdColGroup = new ExcelExportEntity("京东", "jd");
            List<ExcelExportEntity> jdColList = new ArrayList<>();
            jdColList.add(new ExcelExportEntity("市场价", "orgPrice"));
            jdColList.add(new ExcelExportEntity("专区价", "salePrice"));
            jdColGroup.setList(jdColList);
            colList.add(jdColGroup);
            //头部信息

            //表格内容
            List<Map<String, Object>> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Map<String, Object> valMap = new HashMap<>();
                valMap.put("title", "名称." + i);
                valMap.put("supplier", "供应商." + i);

                List<Map<String, Object>> deliDetailList = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    Map<String, Object> deliValMap = new HashMap<>();
                    deliValMap.put("orgPrice", "得力.市场价." + j);
                    deliValMap.put("salePrice", "得力.专区价." + j);
                    deliDetailList.add(deliValMap);
                }
                valMap.put("deli", deliDetailList);

                List<Map<String, Object>> jdDetailList = new ArrayList<>();
                for (int j = 0; j < 2; j++) {
                    Map<String, Object> jdValMap = new HashMap<>();
                    jdValMap.put("orgPrice", "京东.市场价." + j);
                    jdValMap.put("salePrice", "京东.专区价." + j);
                    jdDetailList.add(jdValMap);
                }
                valMap.put("jd", jdDetailList);
                list.add(valMap);
            }
            //表格内容

            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("价格分析表", "数据"), colList,
                    list);
            FileOutputStream fos = new FileOutputStream("D:/价格分析表.xls");
            workbook.write(fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
