package hu.company.climbing.measure;

import hu.company.climbing.measure.models.Measurement;
import hu.company.climbing.measure.services.MeasurementCalculator;
import hu.company.climbing.measure.utils.GraphDrawer;
import hu.company.climbing.measure.utils.JsonFileReader;
import hu.company.climbing.measure.utils.Printer;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String dataPath = "src/main/resources/datas.json";
        if (args.length > 0) {
            dataPath = args[0];
        } else {
            System.out.println("No path is defined for datas.json. Default path will be used.");
        }
        JsonFileReader jsonFileReader = new JsonFileReader(new ObjectMapper());
        Printer printer = new Printer();

        Optional<Measurement> optionalMeasurement = jsonFileReader.getMeasurement(new File(dataPath));

        if (optionalMeasurement.isPresent()) {
            Measurement measurement = optionalMeasurement.get();
            MeasurementCalculator measurementCalculator = new MeasurementCalculator(measurement.getClimbingMeasurements());

            measurementCalculator.calculate();
            List<Integer> steepestAscend = measurementCalculator.getSteepestAscent();
            List<Integer> steepestDescend = measurementCalculator.getSteepestDescent();

            printer.printResultsToTheScreen(measurement, steepestAscend, steepestDescend);

            GraphDrawer graphDrawer = new GraphDrawer(measurement.getClimbingMeasurements());
            graphDrawer.createAndShowGui();
        }
    }
}
