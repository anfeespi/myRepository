package co.edu.unbosque.EntreColPlusFileReader.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	public static void main(String[] args) {
		readExcel("src/main/java/co/edu/unbosque/EntreColPlusFileReader/files/Nomina.xlsx");
	}
	private static void readExcel(String file) {
		try {
			XSSFWorkbook myFile = new XSSFWorkbook(new FileInputStream(file));
			for (int s = 0; s < 2; s++) {
				XSSFSheet sheet = myFile.getSheetAt(1);
				
				XSSFCell cell;
				XSSFRow row;
				
				String table = "";
				if(s == 0) table = "empleados";
				else table = "bonos";
				for (int i = 1; i < sheet.getLastRowNum(); i++) {
					row = sheet.getRow(i);
						
		
					for (int j = 0; j < row.getLastCellNum(); j++) {
						cell = row.getCell(j);
						System.out.println("col"+cell.toString());
					}
					System.out.print(")");
					System.out.println("");
				}
			}
			
			} catch (Exception e) {
				System.out.println("Falla en la lectura del excel");
			e.printStackTrace();
		}
	}
}
