package com.house.hero.poi;

import com.house.hero.common.bean.ReportDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
@Controller
@RequestMapping("/export")
public class MultPoi {

    @ResponseBody
    @RequestMapping(value = "/exportExcel")
    public void exportStuInfoExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //输出流
        response.setContentType("application/vnd.ms-excel");
        // 文件名
        String fileName = "报表名称.xls";

        // 处理文件名包含特殊字符出现的乱码问题
        String userAgent = request.getHeader("User-Agent");
        if (StringUtils.isNotBlank(userAgent)) {
            userAgent = userAgent.toLowerCase();
            if (userAgent.contains("msie") || userAgent.contains("trident") || userAgent.contains("edge")) {
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {
                fileName = new String(fileName.getBytes(UTF_8), StandardCharsets.ISO_8859_1);
            }
        }
        response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + "\"");
        OutputStream out = response.getOutputStream();


        // 创建excel文件对象(开始)
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建sheet
        Sheet sheet = wb.createSheet("sheetName");

        // 行号
        int rowNum = 0;
        //设置列宽
        for (int i = 0; i < 7; i++) {
            sheet.setColumnWidth(i, 6000);
        }

        //第一行
        Row r0 = sheet.createRow(rowNum++);
        r0.setHeight((short) 800);
        Cell c00 = r0.createCell(0);
        c00.setCellValue("Excel导出");
        c00.setCellStyle(StyleUtil.headerStyle(wb));//设置表头单元格样式
        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));

        // 第二行
        Row r1 = sheet.createRow(rowNum++);
        r1.setHeight((short) 500);
        String[] row_first = {"填表单位：", "", "", "", "", "", ""};
        for (int i = 0; i < row_first.length; i++) {
            Cell tempCell = r1.createCell(i);
            tempCell.setCellStyle(StyleUtil.alignLeftNoBorderStyle(wb));//单元格样式，左对齐 无边框
            if (i == 0) {
                tempCell.setCellValue(row_first[i] + "测试单位");
            } else if (i == 5) {
                tempCell.setCellStyle(StyleUtil.alignRightStyle(wb));//单元格样式，右对齐
                if (StringUtils.isNotBlank("年度") && StringUtils.isNotBlank("季度")) {
                    tempCell.setCellValue("2019" + "年第" + "3" + "季度");
                } else {
                    tempCell.setCellValue(row_first[i]);
                }
            } else {
                tempCell.setCellValue(row_first[i]);
            }
        }
        // 合并
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 4));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 5, 6));

        //第三行
        Row r2 = sheet.createRow(rowNum++);
        r2.setHeight((short) 700);
        String[] row_second = {"名称", "人数情况", "", "", "登记情况", "", "备注"};
        for (int i = 0; i < row_second.length; i++) {
            Cell tempCell = r2.createCell(i);
            tempCell.setCellValue(row_second[i]);
            tempCell.setCellStyle(StyleUtil.commonStyle(wb));//单元格样式，左右上下居中 边框
        }
        // 合并
        sheet.addMergedRegion(new CellRangeAddress(2, 3, 0, 0));
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 3));
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 4, 5));
        sheet.addMergedRegion(new CellRangeAddress(2, 3, 6, 6));

        //第四行
        Row r3 = sheet.createRow(rowNum++);
        r3.setHeight((short) 700);
        String[] row_third = {"", "登记数(人)", "办证总数(人)", "办证率(%)", "登记户数(户)", "签订数(份)", ""};
        for (int i = 0; i < row_third.length; i++) {
            Cell tempCell = r3.createCell(i);
            tempCell.setCellValue(row_third[i]);
            tempCell.setCellStyle(StyleUtil.commonWrapStyle(wb));//单元格样式，左右上下居中 边框
        }

        //造数据
        List<ReportDto> list = new ArrayList<>();
        ReportDto reportDto1 =
                new ReportDto().setTbdwTxt("名称1").setLdrkdjs("8").setJzzbzzs("10").setJzzbzl("80%").setCzfwdjhs("10").setZazrsqds("5").setRemark("备注1");
        ReportDto reportDto2 =
                new ReportDto().setTbdwTxt("名称2").setLdrkdjs("8").setJzzbzzs("10").setJzzbzl("80%").setCzfwdjhs("10").setZazrsqds("5").setRemark("备注2");
        ReportDto reportDto3 =
                new ReportDto().setTbdwTxt("合计").setLdrkdjs("16").setJzzbzzs("20").setJzzbzl("").setCzfwdjhs("20").setZazrsqds("10").setRemark("");
        list.add(reportDto1);
        list.add(reportDto2);
        list.add(reportDto3);

        //循环每一行
        for (ReportDto excelData : list) {
            Row tempRow = sheet.createRow(rowNum++);
            tempRow.setHeight((short) 500);
            // 循环单元格填入数据
            for (int j = 0; j < 7; j++) {
                Cell tempCell = tempRow.createCell(j);
                tempCell.setCellStyle(StyleUtil.commonStyle(wb));
                String tempValue;
                if (j == 0) {
                    // 名称
                    tempValue = excelData.getTbdwTxt();
                } else if (j == 1) {
                    // 登记数（人）
                    tempValue = excelData.getLdrkdjs();
                } else if (j == 2) {
                    // 办证总数（人）
                    tempValue = excelData.getJzzbzzs();
                } else if (j == 3) {
                    // 办证率（%）
                    tempValue = StringUtils.isNotBlank(excelData.getJzzbzl()) ? excelData.getJzzbzl() + "%" : "";
                } else if (j == 4) {
                    // 登记户数（户）
                    tempValue = excelData.getCzfwdjhs();
                } else if (j == 5) {
                    // 签订数（份）
                    tempValue = excelData.getZazrsqds();
                } else {
                    // 备注
                    tempValue = excelData.getRemark();
                }
                tempCell.setCellValue(tempValue);
            }
        }

        // 注释行(第八行)
        Row remark = sheet.createRow(rowNum++);
        remark.setHeight((short) 500);
        String[] row_remark = {"注：表中的“办证率=办证总数÷登记数×100%”", "", "", "", "", "", ""};
        for (int i = 0; i < row_remark.length; i++) {
            Cell tempCell = remark.createCell(i);
            if (i == 0) {
                tempCell.setCellStyle(StyleUtil.alignLeftStyle(wb));
            } else {
                tempCell.setCellStyle(StyleUtil.commonStyle(wb));
            }
            tempCell.setCellValue(row_remark[i]);
        }
        int remarkRowNum = list.size() + 4;
        // 合并
        sheet.addMergedRegion(new CellRangeAddress(remarkRowNum, remarkRowNum, 0, 6));

        // 尾行
        Row foot = sheet.createRow(rowNum++);
        foot.setHeight((short) 500);
        String[] row_foot = {"审核人：", "", "填表人：", "", "填表时间：", "", ""};
        for (int i = 0; i < row_foot.length; i++) {
            Cell tempCell = foot.createCell(i);
            tempCell.setCellStyle(StyleUtil.alignLeftNoBorderStyle(wb));
            if (i == 0) {
                tempCell.setCellValue(row_foot[i] + "张三");
            } else if (i == 2) {
                tempCell.setCellValue(row_foot[i] + "李四");
            } else if (i == 4) {
                tempCell.setCellValue(row_foot[i] + new Date());
            } else {
                tempCell.setCellValue(row_foot[i]);
            }
        }
        int footRowNum = list.size() + 5;
        // 合并
        sheet.addMergedRegion(new CellRangeAddress(footRowNum, footRowNum, 0, 1));
        sheet.addMergedRegion(new CellRangeAddress(footRowNum, footRowNum, 2, 3));
        sheet.addMergedRegion(new CellRangeAddress(footRowNum, footRowNum, 4, 6));

        //导出
        try {
            if (null != out) {
                wb.write(out);
                out.close();
            }
        } catch (Exception e) {
            log.error("excel文档导出错误-异常信息：", e);
        }
    }
}
