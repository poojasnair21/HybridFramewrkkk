package Utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem;

import java.io.FileInputStream;

public class ExcelUtility {
    private static FileInputStream excelfile;
    private static XSSFWorkbook excelworkbook;
    private static XSSFSheet excelsheet;
    private static XSSFCell excelcell;
    public static void setExcelfile(String path,String sheet)
    {
        try
        {
            excelfile = new FileInputStream(path);
            excelworkbook = new XSSFWorkbook(excelfile);
            excelsheet=excelworkbook.getSheet(sheet);
        }
    catch(Exception e)
    {
       System.out.println(e);
    }
}
public  static int getFirstRowNumber(String testCaseName)
{
    int i=0;
    int rowCount=excelsheet.getLastRowNum();
    for(i=1;i<=rowCount;i++)
    {
        if(getCellData(i,0).equalsIgnoreCase(testCaseName))
        {
            break;
        }

    }return i;
}
    public  static int getLastRowNumber(String testCaseName)
    {
        int i=0;
        int rowCount=excelsheet.getLastRowNum();
        for(i=rowCount;i>=1;i--)
        {
            if(getCellData(i,0).equalsIgnoreCase(testCaseName))
            {
                break;
            }

        }return i;
    }
public  static  String getCellData(int rowNumber,int columnNumber)
{
    String cellData=null;
    try
    {
        excelcell=excelsheet.getRow(rowNumber).getCell((columnNumber));
        cellData= excelcell.getStringCellValue();
        return  cellData;
    }
    catch (Exception e) {
        System.out.println(e);
        return "";
    }
}
public  static Object[][] getTableData(String testCaseName)
{
    int startingTestCaseRow=getFirstRowNumber(testCaseName);
    int lastTestCaseRow=getLastRowNumber(testCaseName);
    int numberOfRows=getLastRowNumber(testCaseName)-getFirstRowNumber(testCaseName)+1;
    int numberOfColumns=excelsheet.getRow(getFirstRowNumber(testCaseName)).getLastCellNum()-1;
String [][] excelData=new String[numberOfRows][numberOfColumns];

    try
    {
        int ci=0;
        while (startingTestCaseRow<=lastTestCaseRow)
        {
            int cj=0;
            for(int j=1;j<=numberOfColumns;j++,cj++)
            {
                excelData[ci][cj]=getCellData(startingTestCaseRow,j);
            }
            ci++;
            startingTestCaseRow++;
        }
    }
    catch (Exception e)
    {
        throw e;
    }
    return excelData;
}
}