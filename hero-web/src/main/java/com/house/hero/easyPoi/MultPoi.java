package com.house.hero.easyPoi;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
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

import static java.nio.charset.StandardCharsets.UTF_8;

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

        //表头样式，左右上下居中
        CellStyle headerStyle = wb.createCellStyle();
//        headerStyle.setFont(headerFont);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);// 左右居中
        headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 上下居中
        headerStyle.setLocked(true);
        headerStyle.setWrapText(false);// 自动换行

        //单元格样式，左对齐 无边框
        CellStyle alignLeftNoBorderStyle = wb.createCellStyle();
//        alignLeftNoBorderStyle.setFont(contextFont);
        alignLeftNoBorderStyle.setAlignment(CellStyle.ALIGN_LEFT);// 左对齐
        alignLeftNoBorderStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 上下居中
        alignLeftNoBorderStyle.setLocked(true);
        alignLeftNoBorderStyle.setWrapText(false);// 自动换行
        alignLeftNoBorderStyle.setAlignment(CellStyle.ALIGN_LEFT);// 左对齐

        //单元格样式，右对齐
        CellStyle alignRightStyle = wb.createCellStyle();
//        alignRightStyle.setFont(contextFont);
        alignRightStyle.setAlignment(CellStyle.ALIGN_LEFT);// 左对齐
        alignRightStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 上下居中
        alignRightStyle.setLocked(true);
        alignRightStyle.setWrapText(false);// 自动换行
        alignRightStyle.setAlignment(CellStyle.ALIGN_RIGHT);// 左对齐


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
        c00.setCellStyle(headerStyle);
        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));

        // 第二行
        Row r1 = sheet.createRow(rowNum++);
        r1.setHeight((short) 500);
        String[] row_first = {"填表单位：", "", "", "", "", "", ""};
        for (int i = 0; i < row_first.length; i++) {
            Cell tempCell = r1.createCell(i);
            tempCell.setCellStyle(alignLeftNoBorderStyle);
            if (i == 0) {
                tempCell.setCellValue(row_first[i] + "测试单位");
            } else if (i == 5) {
                tempCell.setCellStyle(alignRightStyle);
                if (StringUtils.isNotBlank("年度") && StringUtils.isNotBlank("季度"))
                    tempCell.setCellValue("2019" + "年第" + "3" + "季度");
                else
                    tempCell.setCellValue(row_first[i]);
            } else {
                tempCell.setCellValue(row_first[i]);
            }
        }
        // 合并
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 4));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 5, 6));

        //输出
        wb.write(out);
        out.close();
    }
}
