package com.house.hero.easyPoi.excelImport;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.house.hero.common.bean.Employee;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author User
 * Excel数据导入到数据库
 */
@RestController
@RequestMapping("/import")
public class ExcelImportDemo {


    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelImportDemo.class);
    /**
     * easyPoi 超简单导入
     * @param file
     */
    @RequestMapping("/excel")
    public void importExcel(MultipartFile file) {

        if (file == null) {
            System.out.println("请选择模板!");
        }
        ImportParams params = new ImportParams();

        try {
            if (file != null) {
                List<Employee> list = ExcelImportUtil.importExcel(file.getInputStream(), Employee.class, params);
                System.out.println(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Poi导入
     * @param file
     */
    @RequestMapping("/poi/importExcel")
    public void poiImportExcel(MultipartFile file) throws IOException {

        List<Employee> employeeList = getObjInputStream(file.getInputStream(), file.getOriginalFilename());
        System.out.println(employeeList);
    }
    /**
     * 使用POI完成文件的读取
     * @param inputStream
     * @param originalFilename
     * @return
     */
    private List<Employee> getObjInputStream(InputStream inputStream, String originalFilename) {

        List<Employee> resultDto = new ArrayList<>();

        Workbook workbook = null;
        try {

            try {
                if (originalFilename.matches("^.+\\.(?i)(xls)$")) {
                    workbook = new HSSFWorkbook(inputStream);
                } else if (originalFilename.matches("^.+\\.(?i)(xlsx)$")) {
                    workbook = WorkbookFactory.create(inputStream);
                } else {
                    System.out.println("文件格式错误");
                }
            } catch (IOException e) {
                LOGGER.error("order.import.error,原因:{}", e);
            }

                Employee employee = new Employee();
                Sheet sheet = workbook.getSheetAt(0);
                //最后一行的行号
                int lastRowNum = sheet.getLastRowNum();
            for (int rowNm = 1; rowNm <= lastRowNum; rowNm++) {

                //获取第某行的数据(从rowNm开始)
                Row row = sheet.getRow(rowNm);

                //第一行第一列数据
                double firstStringCellValue = row.getCell(0).getNumericCellValue();
                employee.setAge((int) firstStringCellValue);
                //第一行第二列数据
                String secondStringCellValue = row.getCell(1).getStringCellValue();
                employee.setName(secondStringCellValue);
                //第一行第三列数据
                double numericCellValue = row.getCell(2).getNumericCellValue();
                employee.setSalary(numericCellValue);

                //封装对象集合
                resultDto.add(employee);
            }
        } catch (Exception e) {
            LOGGER.error("导入失败,原因:{}", e);
        }
        return resultDto;
    }

}
