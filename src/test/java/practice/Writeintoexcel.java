package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.time.Duration; 
import java.util.Properties; 
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook; 
import org.apache.poi.ss.usermodel.WorkbookFactory; 


public class Writeintoexcel {

	public static void main(String[] args) throws  EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		 FileInputStream fis = new FileInputStream("C:\\Users\\TEMP\\Documents\\Ninja_crm.xlsx");
				 Workbook wb = WorkbookFactory.create(fis);
				 Sheet sh= wb.getSheet("Campaign");
				 Row r = sh.getRow(1);
				 Cell c= r.createCell(5);
				 c.setCellType(CellType.STRING);
				 c.setCellValue("Divya");
				 FileOutputStream fos= new FileOutputStream("C:\\Users\\TEMP\\Documents\\Ninja_crm.xlsx");
				 
				 wb.write(fos);
				 wb.close();
	}
	

}
