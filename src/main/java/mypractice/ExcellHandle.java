package mypractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellHandle {

	public static void main(String[] args) throws Throwable {
         FileInputStream fis=new FileInputStream("D:\\MaheshWorkSpace\\MaheshMavenProject\\files\\tahsil data.xlsx");
         XSSFWorkbook workbook=new XSSFWorkbook(fis);
         XSSFSheet sheet=workbook.getSheet("Sheet1");
         int row=sheet.getLastRowNum();
         int column=sheet.getRow(0).getLastCellNum();
         for(int i=0;i<=row;i++) {
        	 XSSFRow w=sheet.getRow(i);
        	 for(int j=0;j<column;j++) {
        		 XSSFCell t=w.getCell(j);
        		 switch(t.getCellType()) {
        		 case STRING:System.out.print(t.getStringCellValue());
        		 break;
        		 case NUMERIC:System.out.print(t.getNumericCellValue());
        		 break;
        		 }
        		 System.out.print(" | ");
        	 }
        	 System.out.println();
         }
	}

}
