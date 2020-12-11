package hu.company.climbing.measure.utils;

import hu.company.climbing.measure.models.Measurement;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class JsonFileReader {
    private ObjectMapper objectMapper;

    public JsonFileReader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Optional<Measurement> getMeasurement(File readedFile) {
        Optional<Measurement> measurement;
        try {
            measurement = Optional.of(objectMapper.readValue(readedFile, Measurement.class));
        } catch (IOException e) {
            measurement = Optional.empty();
            System.out.println("File not found, check your given path");
        }
        return measurement;
    }
}
