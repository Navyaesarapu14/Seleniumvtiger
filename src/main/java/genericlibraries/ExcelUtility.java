package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Table.Cell;
//This is ExcelUtility
public class ExcelUtility {
	private Workbook workbook;
	private DataFormatter df;
	private String excelpath;
	public void excelInitialization(String excelPath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelPath);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
		}catch(EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		}
	public String readFromExcel(String sheetName, int rowNum, int cellNum) {
		df = new DataFormatter();
		return df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
	}
	public Map<String,String> readFromExcel(String sheetName, String expectedTestName){
	Map<String,String> map = new HashMap<String, String>();
		df = new DataFormatter();
		Sheet sheet = workbook.getSheet(sheetName);
		for(int i = 0;i <= sheet.getLastRowNum(); i++) {
			if(df.formatCellValue(sheet.getRow(i)).equals(expectedTestName)) {
				for(int j = i; j <= sheet.getLastRowNum();j++) {
					map.put(df.formatCellValue(sheet.getRow(j).getCell(2)),df.formatCellValue(sheet.getRow(j).getCell(3)));
					if(df.formatCellValue(sheet.getRow(j).getCell(2)).equals("####"))
						break;
				}
				break;
				}
			}
		return map;
		}
	public void writeToExcel(String sheetName, String expectedTestName) {
		Sheet sheet = workbook.getSheet(sheetName);
		for(int i = 0;i <= sheet.getLastRowNum(); i++) {
			if(df.formatCellValue(sheet.getRow(i)).equals(expectedTestName)) {	
				Cell cell = sheet.getRow(i).createCell(4);
				cell.setCellValue(status);
				break;
			}
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(excelPath);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
	/**
	 * This method is used to close excel
	 */

