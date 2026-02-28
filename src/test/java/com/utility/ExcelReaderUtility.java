package com.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {

    public static Iterator<User> readExcelFile(String fileName) {

        File xlsxFile = new File(System.getProperty("user.dir") + "/testData/" + fileName);
        XSSFWorkbook xssfWorkbook;
        XSSFSheet xssfSheet;
        Iterator<Row> rowIterator;
        List<User> userList = null;
        Row row;
        Cell emailAddressCell;
        Cell passwordCell;
        User userData;
        try {
            userList = new ArrayList<User>();
            xssfWorkbook = new XSSFWorkbook(xlsxFile);
            xssfSheet = xssfWorkbook.getSheet("LoginTestData");
            rowIterator = xssfSheet.iterator();
            rowIterator.next();
            row = rowIterator.next();
            while(rowIterator.hasNext() && !isRowEmpty(row)){
                emailAddressCell = row.getCell(0);
                passwordCell = row.getCell(1);
                System.out.println("email: "+emailAddressCell);
                System.out.println("Password: "+passwordCell);
                userData = new User(emailAddressCell.toString(), passwordCell.toString());
                userList.add(userData);
                row = rowIterator.next();
            }
            xssfWorkbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        return userList.iterator();
    }

    public static boolean isRowEmpty(Row row) {
        if (row == null) {
            return true;
        }
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK && !cell.toString().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
