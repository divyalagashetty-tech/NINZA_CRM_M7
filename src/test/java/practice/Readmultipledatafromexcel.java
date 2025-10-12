package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readmultipledatafromexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream ("C:\\Users\\TEMP\\Documents\\readmultiple.xlsx");
		Workbook wb= 	WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Practice");
       int rowCount = sh.getLastRowNum();
       for(int row=1;row<=rowCount; row++) {
    	   String productID = sh.getRow(row).getCell(0).getStringCellValue();
    	   String productName =sh.getRow(row).getCell(1).getStringCellValue();
    	   System.out.println(productID+"-->"+productName);
    	   
       }
	}

}
