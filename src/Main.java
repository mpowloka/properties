import reader.MyFileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        MyFileReader reader = new MyFileReader();

        List<String> fileLines = reader.readFileLinesList("C:\\Users\\mpowloka\\Workspace\\properties\\data.properties");

        System.out.println(getPropertiesList(fileLines));

        System.out.println(getPropertiesMap(fileLines));

        String[] properties = getPropertiesArray(fileLines);
        for(String propertyValue : properties) {
            System.out.println(propertyValue);
        }

    }

    private static List<String> getPropertiesList(List<String> lines) {
        List<String> result = new ArrayList<>();

        for(String line : lines) {

            int indexOfEqualitySign = line.indexOf('=');
            String propertyValue = line.substring(indexOfEqualitySign + 1);

            result.add(propertyValue);

        }

        return result;
    }

    private static String[] getPropertiesArray(List<String> lines) {

        String[] result = new String[lines.size()];

        for(int i = 0; i < lines.size(); i++) {

            int indexOfEqualitySign = lines.get(i).indexOf('=');
            String propertyValue = lines.get(i).substring(indexOfEqualitySign + 1);

            result[i] = propertyValue;

        }

        return result;
    }

    private static Map<String, String> getPropertiesMap(List<String> lines) {

        Map<String, String> result = new HashMap<>();

        for(String line : lines) {

            int indexOfEqualitySign = line.indexOf('=');

            String propertyName = line.substring(0, indexOfEqualitySign);
            String propertyValue = line.substring(indexOfEqualitySign + 1);

            result.put(propertyName, propertyValue);

        }

        return result;
    }

}
