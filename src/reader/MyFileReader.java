package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {

    public List<String> readFileLinesList(String path) {

        List<String> result = new ArrayList<>();

        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader(path));

            String line;

            while ((line = reader.readLine()) != null) {
                result.add(line);
            }


        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (reader != null) {
                    reader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return result;

    }

}
