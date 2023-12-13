package pageFactory;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fs;
	static FileOutputStream fout;
//	static XSSFDataFormat format;

	HashMap<String, String> dataSheet;
	int count = 0;

	public static HashMap<String, String> storeValues = new HashMap<>();

	// It will read all given sheet and get in List<map>; List count the rows and
	// map key(header) value(Cell)
	public static List<HashMap<String, String>> readExcelSheet(String fileName,String sheetName) {
	String sFile = System.getProperty("user.dir") + "//src//test//resources//"+fileName + ".xlsx";
	int emptyCells = 0;
	
	//create Java List to store Hashmaps
	List<HashMap<String, String>> excelData=	new ArrayList();
	try {
	if(fout!=null) {
	fout.close();
	}
	
	fs = new FileInputStream(sFile);
	XSSFWorkbook wb= new XSSFWorkbook(fs);
	XSSFSheet sheet = wb.getSheet(sheetName);
	
	//catch header row, so that you can use it as Key for your hashmap
	Row HeaderRow = sheet.getRow(0);

	//System.out.println(sheet.getPhysicalNumberOfRows() +" No of Rows");
	for (int r = 1; r < sheet.getPhysicalNumberOfRows(); r++) {
	Row CurrentRow = sheet.getRow(r);
	
	//each row of data is stored in new hashmap
	HashMap<String, String> currentRowMap = new HashMap<>();
	//Adding 0 location
	if(r==1) {
	
	excelData.add(currentRowMap);
	}
	//emptyCells = CurrentRow. getPhysicalNumberOfCellsO);
	//System.out.println(CurrentRow.getLastCellNum() + " cells");
	emptyCells = CurrentRow. getLastCellNum();
	
	for (int c = 0; c < emptyCells; c++) {
	Cell CurrentCell = CurrentRow.getCell(c);

	if (CurrentCell == null && HeaderRow.getCell(c).getStringCellValue() != null) {
	currentRowMap.put(HeaderRow.getCell(c).getStringCellValue(), "");
	//emptyCellst;
	}

	//System.out.print(CurrentCell.getstringCellValue() + "It");
	else if (CurrentCell.getCellType() == CellType.STRING) 
	{
	currentRowMap.put(HeaderRow.getCell(c).getStringCellValue(), CurrentCell.getStringCellValue());
	}
	else if (CurrentCell.getCellType() == CellType.BLANK) {
	currentRowMap.put(HeaderRow.getCell(c).getStringCellValue(), String.valueOf(CurrentCell.getStringCellValue()));
	}
	// i.e hashmap<key, value> = <row(0)column(c), row(1)column(c)>
	else if (CurrentCell.getCellType() == CellType.NUMERIC) {
	currentRowMap.put(HeaderRow.getCell(c).getStringCellValue(), String.valueOf(CurrentCell.getNumericCellValue()));
	}
	else if (CurrentCell.getCellType() == CellType.ERROR) {
	
	CurrentCell.setCellType(CellType.STRING);
	currentRowMap.put(HeaderRow.getCell(c).getStringCellValue(), CurrentCell.getStringCellValue());
	}
	}

	excelData.add(currentRowMap);
	}
	fs.close();
	}
	catch (Exception e) {
	e.printStackTrace();}
	return excelData;
	}

}
