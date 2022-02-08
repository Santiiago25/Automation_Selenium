package com.projectExcel.pom;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFile {

    //Primer metodo que nos permite leer el excel ,fila por fila y cada una de las celdas
    // filepath: donde estara guardado el excel, sheetName: nombre de la hoja de excel
    public void readExcel(String filepath, String sheetName) throws IOException {
        File file = new File(filepath);

        FileInputStream inputStream = new FileInputStream(file);

        //creamos el objeto donde guardamos el fichero de excel
        XSSFWorkbook newworkbook = new XSSFWorkbook(inputStream);

        XSSFSheet newSheet = newworkbook.getSheet(sheetName);

        //para contar las filas
        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

        for (int i = 0; i < rowCount; i++){
            XSSFRow row = newSheet.getRow(i);

            for (int j = 0; j < row.getLastCellNum(); j++){
                System.out.println(row.getCell(j).getStringCellValue() + "||" );
            }
        }
    }

    //Segundo metodo que permite leer una celda especifica
    public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {
        File file = new File(filepath);

        FileInputStream inputStream = new FileInputStream(file);

        //creamos el objeto donde guardamos el fichero de excel
        XSSFWorkbook newworkbook = new XSSFWorkbook(inputStream);

        XSSFSheet newSheet = newworkbook.getSheet(sheetName);

        XSSFRow row = newSheet.getRow(rowNumber);

        XSSFCell cell = row.getCell(cellNumber);

        return cell.getStringCellValue();
    }

}
