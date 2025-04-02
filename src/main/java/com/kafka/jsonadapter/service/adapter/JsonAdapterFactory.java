package com.kafka.jsonadapter.service.adapter;

import com.kafka.jsonadapter.service.adapter.adapters.csv.JsonToCsvAdapter;
import com.kafka.jsonadapter.service.adapter.adapters.excel.JsonToExcelAdapter;
import com.kafka.jsonadapter.service.adapter.adapters.json.JsonToJsonAdapter;
import com.kafka.jsonadapter.service.adapter.adapters.xml.JsonToXmlAdapter;
import com.kafka.jsonadapter.commons.constants.TypeOfFile;
import com.kafka.jsonadapter.commons.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class JsonAdapterFactory {
    public static JsonAdapter getOutputFileAdapter(TypeOfFile typeOfFile) {
        switch (typeOfFile) {
            case JSON:
                return new JsonToJsonAdapter();
            case XML:
                return new JsonToXmlAdapter();
            case CSV:
                return new JsonToCsvAdapter();
            case EXCEL:
                return new JsonToExcelAdapter();
            default:
                throw new CustomException(HttpStatus.BAD_REQUEST,"Formato no soportado: " + typeOfFile);
        }
    }
}
