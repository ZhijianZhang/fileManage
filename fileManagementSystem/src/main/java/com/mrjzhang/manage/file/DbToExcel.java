package com.mrjzhang.manage.file;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import com.mrjzhang.bean.Element;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
/**
 *数据库中的数据向外输出excel
 *
 */
public class DbToExcel {

  public void outDbToExcel(String fileName, List results) {
    try {
      // 创建可写入的Excel工作簿
      //以fileName为文件名来创建一个Workbook
      WritableWorkbook wwb = Workbook.createWorkbook(new File(fileName));

      // 创建工作表
      WritableSheet ws = wwb.createSheet("parabolarBlade", 0);
      //要插入到的Excel表格的行号，默认从0开始
      Label labelName= new Label(0, 0, "name");
      Label labelscore= new Label(1, 0, "score");
      Label labelPicture =new Label(2,0,"picture");
      Label labelCurve= new Label(3, 0, "curve");

      ws.addCell(labelName);
      ws.addCell(labelscore);
      ws.addCell(labelPicture);
      ws.addCell(labelCurve);

      Iterator it = results.iterator();

      int i=0;
      while(it.hasNext()){
        Element obj = (Element) it.next();
         //System.out.println("name:"+(obj).getName()+"\n"+"score:"+(obj).getScore());

        Label labelName_i= new Label(0, i+1, (obj).getName());
        Label labelscore_i= new Label(1, i+1, Double.toString((obj).getScore()));
        Label labelPicture_i= new Label(2, i+1, (obj).getPicture());
        Label labelCurve_i= new Label(3, i+1, (obj).getCurve());

        ws.addCell(labelName_i);
        ws.addCell(labelscore_i);
        ws.addCell(labelPicture_i);
        ws.addCell(labelCurve_i);

        System.out.println(i);
        i++;

      }

      //写进文档
      wwb.write();
      // 关闭Excel工作簿对象
      wwb.close();

      System.out.println("关闭Excel工作簿对象");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}