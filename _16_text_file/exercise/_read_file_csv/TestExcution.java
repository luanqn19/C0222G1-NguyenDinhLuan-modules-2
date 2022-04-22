package _16_text_file.exercise._read_file_csv;

import java.util.ArrayList;
import java.util.List;

public class TestExcution {
    private static final String filePath = "src\\_16_text_file\\exercise\\_read_file_csv\\file.csv";
    public static void main (String[] args) {
        List<Country> list = new ArrayList<>();
        ReadFileCSV readFileCSV = new ReadFileCSV();
        list = readFileCSV.readFile(filePath, list);

        for (Country item : list){
            System.out.println(item);
        }
    }
}
