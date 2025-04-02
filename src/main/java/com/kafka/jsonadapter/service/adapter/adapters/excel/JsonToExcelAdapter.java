package com.kafka.jsonadapter.service.adapter.adapters.excel;

import com.kafka.jsonadapter.dtos.PersonResponseDto;
import com.kafka.jsonadapter.service.adapter.JsonAdapter;
import com.kafka.jsonadapter.dtos.PersonRequestDto;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class JsonToExcelAdapter extends JsonAdapter {

    private final String path = "src/main/resources/generatedFiles/";

    @Override
    public void writeFile(PersonRequestDto person) {
        PersonResponseDto personResponse = transform(person);
        String fileName = personResponse.getFullName().replace(" ", "_") + ".xlsx";
        String filePath = path + fileName;

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Person Data");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Full Name");
            headerRow.createCell(1).setCellValue("Birth Date");
            headerRow.createCell(2).setCellValue("Age");
            headerRow.createCell(3).setCellValue("Gender");

            Row dataRow = sheet.createRow(1);
            dataRow.createCell(0).setCellValue(personResponse.getFullName());
            dataRow.createCell(1).setCellValue(personResponse.getFormattedBirthDate());
            dataRow.createCell(2).setCellValue(personResponse.getAge());
            dataRow.createCell(3).setCellValue(personResponse.getGender().toString());

            File directory = new File("C:/output_files");
            if (!directory.exists()) {
                directory.mkdirs(); // Crear directorio si no existe
            }

            FileOutputStream fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
            fileOut.close();

            System.out.println("Archivo Excel guardado en: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error al crear archivo Excel: " + e.getMessage());
        }
    }
}
