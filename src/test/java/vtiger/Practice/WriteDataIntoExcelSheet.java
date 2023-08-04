package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		// Step 1: Load the file in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		// Step 2: Create a workbook for the file loaded
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: Create sheet 
		Sheet sh = wb.createSheet("TrialNow");
		
		//Step 4: create row
		Row rw = sh.createRow(4);
		
		//Step 5: create cel
		Cell ce = rw.createCell(3);
		
		//Step 6: set the value into cell
		ce.setCellValue("Spider Man");
		
		//Step 7: Open the file in java write format
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 8: call the write method
		wb.write(fos);
		System.out.println("data added");
		
		//Step 9: close the work book
		wb.close();
		System.out.println("workbook closed");
		
		
		
		
		
		
		

	}

}
