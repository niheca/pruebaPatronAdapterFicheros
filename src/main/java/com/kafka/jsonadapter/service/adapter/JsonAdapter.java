package com.kafka.jsonadapter.service.adapter;

import com.kafka.jsonadapter.commons.constants.GenderType;
import com.kafka.jsonadapter.dtos.PersonRequestDto;
import com.kafka.jsonadapter.dtos.PersonResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class JsonAdapter {

    public abstract void writeFile(PersonRequestDto person);

    protected PersonResponseDto transform(PersonRequestDto request) {
        PersonResponseDto response = new PersonResponseDto();

        // 1. Juntar nombre y apellido
        response.setFullName(request.getName() + " " + request.getLastName());

        // 2. Formatear fecha de nacimiento (dd/MM/yyyy → yyyy-MM-dd)
        response.setFormattedBirthDate(formatBirthDate(request.getBirthDate()));

        // 3. Calcular edad
        response.setAge(calculateAge(request.getBirthDate()));

        // 4. Convertir GenderType a M, F, X
        response.setGender(mapGender(request.getGender()));

        return response;
    }

    protected void saveToFile(String content, String fullName, String extension , String path) {
        String fileName = fullName.replace(" ", "_") + "." + extension; // Reemplazar espacios por guiones bajos

        try {
            File directory = new File(path);
            if (!directory.exists()) {
                directory.mkdirs(); // Crear directorio si no existe
            }
            File file = new File(directory, fileName);

            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();

            System.out.println("Archivo guardado exitosamente en: " + path);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el archivo: " + e.getMessage());
        }
    }

    private String formatBirthDate(Date birthDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(birthDate);
    }

    private int calculateAge(Date birthDate) {
        Calendar birthCal = Calendar.getInstance();
        birthCal.setTime(birthDate);

        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);

        // Ajuste si aún no ha cumplido años este año
        if (today.get(Calendar.DAY_OF_YEAR) < birthCal.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }

    private String mapGender(GenderType gender) {
        if (gender == GenderType.MALE) return "M";
        if (gender == GenderType.FEMALE) return "F";
        return "X"; // OTHER
    }


}
