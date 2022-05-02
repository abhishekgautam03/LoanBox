package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static int getNumberOfRow(String file,String sheetname) throws IOException  
	{  

		FileInputStream fis=new FileInputStream(file);  
		//constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
		Workbook wb=new XSSFWorkbook(fis);  
		Sheet sheet = null;    
		int sheets = wb.getNumberOfSheets(); // get sheets
		for (int i = 0; i < sheets; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase(sheetname)) {
				sheet = wb.getSheetAt(i);
			}
		}
		return sheet.getPhysicalNumberOfRows();            
	} 
	public static int getNumberOfColumn(String file,String sheetname,int row) throws IOException  {  

		FileInputStream fis=new FileInputStream(file);  
		//constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
		Workbook wb=new XSSFWorkbook(fis);  
		//Sheet sheet=wb.getSheetAt(1);   //getting the XSSFSheet object at given index  
		Sheet sheet = null;    
		int sheets = wb.getNumberOfSheets(); // get sheets
		for (int i = 0; i < sheets; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase(sheetname)) {
				sheet = wb.getSheetAt(i);
			}
		}
		return sheet.getRow(row).getPhysicalNumberOfCells();
	}
	public static String readCellData(String filepath,String sheetname,int row, int column) throws IOException {  
		String value="";       
		FileInputStream fis=new FileInputStream(filepath);  
		//constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
		Workbook wb=new XSSFWorkbook(fis);  
		Sheet sheet = null;    
		int sheets = wb.getNumberOfSheets(); // get sheets
		for (int i = 0; i < sheets; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase(sheetname)) {
				sheet = wb.getSheetAt(i);
			}
		}
		Row rowvalue=sheet.getRow(row); //returns the logical row  
		Cell cell=rowvalue.getCell(column); //getting the cell representing the given column  
		if (cell.getCellType() == CellType.STRING) {
			value=cell.getStringCellValue();						
		} else {
			value=NumberToTextConverter.toText(cell.getNumericCellValue());								
		}
		return value;            
	} 
	public static void writeSheetData(String filepath,String sheetname,Map<String, Object[]> data) throws IOException  
	{  

		FileInputStream fis=new FileInputStream(filepath);  
		//constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
		Workbook wb=new XSSFWorkbook(fis);  
		Sheet sheet = null;    
		int sheets = wb.getNumberOfSheets(); // get sheets
		for (int i = 0; i < sheets; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase(sheetname)) {
				sheet = wb.getSheetAt(i);
			}
		}
		//Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset)
		{
			Row row = sheet.createRow(rownum++);
			Object [] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr)
			{
				Cell cell = row.createCell(cellnum++);
				if(obj instanceof String)
					cell.setCellValue((String)obj);
				else if(obj instanceof Integer)
					cell.setCellValue((Integer)obj);
			}
		}
		try
		{
			//Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File(filepath));
			wb.write(out);
			out.close();
			//		System.out.println(sheetname+" written successfully on disk.");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
public static void writSpecificCellData(String filepath,String sheetname,int row, int column,Object data) throws IOException {
	FileInputStream fis=new FileInputStream(filepath);  
	
	Workbook wb=new XSSFWorkbook(fis);  
	Sheet sheet = null;    
	int sheets = wb.getNumberOfSheets(); // get sheets
	for (int i = 0; i < sheets; i++) {
		if (wb.getSheetName(i).equalsIgnoreCase(sheetname)) {
			sheet = wb.getSheetAt(i);
		}
	}
	//int rowCount = sheet.getLastRowNum();
//	System.out.println("last    "+row +"  "+column +" "+data);
	Row row1 = sheet.createRow(row);
	Cell cell = row1.createCell(column);
	 if (data instanceof String) {
         cell.setCellValue((String) data);
     } else if (data instanceof Integer) {
         cell.setCellValue((Integer) data);
     }
	
	fis.close();
	FileOutputStream outputStream = new FileOutputStream(filepath);
	wb.write(outputStream);
	wb.close();
    outputStream.close();
   // System.out.println("write data");
}
public static void writSpecificCell(String filepath,String sheetname,int row, int column) throws IOException {
	
}

}
