package _16_text_file.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FindMaxInFile {
    private static final String FILE_PATH_WRITE = "C:\\Users\\Dinh Luan\\IdeaProjects\\Modules-2\\src\\_16_text_file\\practice\\NewFileMax.txt";
    private static final String FILE_PATH_READ = "C:\\Users\\Dinh Luan\\IdeaProjects\\Modules-2\\src\\_16_text_file\\practice\\file.txt";

    public static List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) throw new FileNotFoundException("File not found!");

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = "";

            while ((line = reader.readLine()) != null){
                numbers.add(Integer.parseInt(line));
            }
            reader.close();
        }catch (FileNotFoundException ex){
            System.err.println("File not found");
        }catch (IOException ex){
            System.err.println("Line null");
        }
        return numbers;
    }

    public static void writeFile(String filePath, int max){
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Max: " + max);
            bufferedWriter.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (Integer number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }

    public static void main (String[] args) {
        List<Integer> numbers = readFile(FILE_PATH_READ);
        int max = findMax(numbers);

        writeFile(FILE_PATH_WRITE, max);
    }
}
