package _16_text_file.practice;

import java.io.*;

public class CalculateSumInFile {
    public static void readFileText(String filePath){
        try {
            File file = new File(filePath);

            if (!file.exists()) throw new FileNotFoundException(filePath + " not found");

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = "";
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            };

            reader.close();
            System.out.printf("Sum: %d", sum);
        }catch (Exception ex){
            System.err.println("File not found");
        }
    }
    public static void main (String[] args) {
        readFileText("C:\\Users\\Dinh Luan\\IdeaProjects\\Modules-2\\src\\_16_text_file\\practice\\file.txt");
    }
}
