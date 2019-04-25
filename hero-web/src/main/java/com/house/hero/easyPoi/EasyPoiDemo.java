package com.house.hero.easyPoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.house.hero.common.bean.User;
import com.house.hero.mapper.UserMapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/25
 * @ Description：简单的Excel导出
 * @ throws
 */
@Controller
public class EasyPoiDemo {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/exportExcel")
    @ResponseBody
    public void exportStuInfoExcel(HttpServletResponse response){
        downExcel(response);
    }

    public void downExcel(HttpServletResponse response){

        List<User> list = userMapper.selectByExample(null);
        //指定列表标题和工作表名称
        ExportParams params = new ExportParams("Excel信息","sheet名称");
        Workbook workbook = ExcelExportUtil.exportExcel(params,User.class,list);
        response.setHeader("content-Type","application/vnd.ms-excel");
        response.setHeader("Content-Disposition","attachment;filename="+System.currentTimeMillis()+".xls");
        response.setCharacterEncoding("UTF-8");
        try {
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
