package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ArtikelImportFile {
	public static XSSFWorkbook wb;
	public static HSSFWorkbook wbh;
	public static XSSFSheet sh;
	public static HSSFSheet shh;
	public static FileInputStream f;

	public static void main(String[] args) throws IOException, InterruptedException {
	for(int row=100001;row<100000;row++) {
		int num=10000000+row;
		fileWriteExcelWithoutAffectExistingData(row,0,"ARTNUM"+num);
		fileWriteExcelWithoutAffectExistingData(row,1,generateCurrentDateAndTimeSec());
		fileWriteExcelWithoutAffectExistingData(row,2,"38260090");
		fileWriteExcelWithoutAffectExistingData(row,3,"1C233");
		fileWriteExcelWithoutAffectExistingData(row,4,"3LLA");
		fileWriteExcelWithoutAffectExistingData(row,5,"");
		fileWriteExcelWithoutAffectExistingData(row,6,"File001");
		fileWriteExcelWithoutAffectExistingData(row,7,"0");
		System.out.println(row);
	}

	}
	public static void fileWriteExcelWithoutAffectExistingData( int rowNum, int columnNum,
			String cellValue) throws IOException {
		File excelFile = new File("D:\\Project\\EXP2\\Upload Files Format\\202\\Artikle_ImportFile_15_11_23.xls");
		FileInputStream inputStream = new FileInputStream(excelFile);
		wbh = new HSSFWorkbook(inputStream);
		shh = wbh.getSheet("Sheet1");
		Row row = shh.getRow(rowNum);
		if (row == null) {
			row = shh.createRow(rowNum);
		}
		Cell cell = row.getCell(columnNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		cell.setCellValue(cellValue);
		FileOutputStream outputStream = new FileOutputStream(excelFile);
		wbh.write(outputStream);
		outputStream.close();
	}
	public static String generateCurrentDateAndTimeSec() {
		Date date = new Date();		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);		
	}
	
}
