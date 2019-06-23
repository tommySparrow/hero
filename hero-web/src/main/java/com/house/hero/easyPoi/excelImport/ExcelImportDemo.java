package com.house.hero.easyPoi.excelImport;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.house.hero.common.bean.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author User
 * Excel数据导入到数据库
 */
@RestController
@RequestMapping("/import")
public class ExcelImportDemo {

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
}
