package com.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
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

        File xlsxFile = new File(System.getProperty("user.dir") + "\\testData\\" + fileName);
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
            while(rowIterator.hasNext()){
                row = rowIterator.next();
                emailAddressCell = row.getCell(0);
                passwordCell = row.getCell(1);
                userData = new User(emailAddressCell.toString(), passwordCell.toString());
                userList.add(userData);
            }
            xssfWorkbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        return userList.iterator();
    }

}
