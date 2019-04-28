package com.house.hero.easyPoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.house.hero.common.bean.EasyPOIModel;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/25
 * @ Description：
 * @ throws
 */
@SuppressWarnings("UnusedAssignment")
@Controller
@RequestMapping("/template")
public class PoiTemplateDemo {

    @RequestMapping(value = "/exportExcel")
    @ResponseBody
    public void exportStuInfoExcel(HttpServletResponse response) throws Exception {

        int count = 0;

        EasyPOIModel goods1 = new EasyPOIModel(count++, "语文", "jack", "男", 9);
        EasyPOIModel goods2 = new EasyPOIModel(count++, "数学", "rose", "女", 10);
        EasyPOIModel goods3 = new EasyPOIModel(count++, "英语", "liLei", "男", 11);
        EasyPOIModel goods4 = new EasyPOIModel(count++, "历史", "huYiFei", "女", 12);

        List<EasyPOIModel> goodsList = new ArrayList<>();
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        goodsList.add(goods4);

        // 获取导出excel指定模版，第二个参数true代表显示一个Excel中的所有 sheet
        TemplateExportParams params = new TemplateExportParams("easyPOIExample.xlsx", true);
        Map<String, Object> mapData = new HashMap<>();

        //map属性(合计属性)
        mapData.put("date", "2014-12-25");
        mapData.put("money", 2000000.00);
        //list数据
        mapData.put("list", goodsList);//导出list集合

        try {
            // 简单模板导出方法
            Workbook book = ExcelExportUtil.exportExcel(params, mapData);
            //下载方法
            export(response, book, "商品信息");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * export导出请求头设置
     *
     * @ param response
     * @ param workbook
     * @ param fileName
     * @ throws Exception
     */
    private static void export(HttpServletResponse response, Workbook workbook, String fileName) throws Exception {
        response.reset();
        response.setContentType("application/x-msdownload");
        fileName = fileName + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("gb2312"), StandardCharsets.ISO_8859_1) + ".xls");
        ServletOutputStream outStream = null;
        try {
            outStream = response.getOutputStream();
            workbook.write(outStream);
        } finally {
            assert outStream != null;
            outStream.close();
        }
    }
}
