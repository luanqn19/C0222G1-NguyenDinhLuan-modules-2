package _16_text_file.exercise._read_file_csv;

import java.io.*;
import java.util.List;

public class ReadFileCSV {

    public ReadFileCSV () {
    }

    public List<Country> readFile (String path , List<Country> list) {

        try {
            String[][] results = new String[8][];
            File file = new File(path);

            if (! file.exists()) throw new FileNotFoundException("File not found");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String toSplit = "";
            for (int i = 0 ; i < results.length ; i++) {
                int j = 0;
                toSplit = bufferedReader.readLine();

                results[i] = new String[3];

                while (j < 3) {
                    results[i][j] = toSplit.split(",")[j];
                    j++;
                }
            }

            for (String[] result : results) {
                String code = result[1].substring(1 , result[1].lastIndexOf("\""));
                String name = result[2].substring(1 , result[2].lastIndexOf("\""));
                Country country = new Country(Integer.parseInt(result[0]) , code , name);
                list.add(country);
            }
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
