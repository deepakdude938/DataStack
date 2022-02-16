package practicecodes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandle {

	public static void main(String[] args) throws Throwable {
         
		FileInputStream fis = new FileInputStream("D:\\MaheshWorkSpace\\MaheshMavenProject\\files\\tahsil data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);//b in workbook is small and rgument is must
		
		XSSFSheet sheet = workbook.getSheet("Sheet3");//get sheet at specific no//remember
		
		int row = sheet.getLastRowNum();
		int clmn=sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<=row;i++) {
			XSSFRow w=sheet.getRow(i);
			
			for(int j=0;j<clmn;j++) {
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
