package _16_text_file.exercise._copy_file;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class CopyFileText {
    String filePathWrite;
    String filePathRead;

    public void readFile(){
        try {
            File file = new File(filePathRead);

            if (!file.exists()) throw new FileNotFoundException(filePathRead + " not found");

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = "";
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        }catch (FileNotFoundException ex){
            System.err.println("File not found");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void writeFile(){
        try {
            File fileWrite = new File(filePathWrite);
            File fileRead = new File(filePathRead);

            if (fileWrite.exists()) throw new FileAlreadyExistsException("File already exist");

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileWrite, true));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRead));

            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(line);
                bufferedWriter.write("\n");
            }

            bufferedReader.close();
            bufferedWriter.close();
        }catch (FileAlreadyExistsException ex){
            System.err.println("File already exist");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public CopyFileText (String filePathWrite , String filePathRead) {
        this.filePathWrite = filePathWrite;
        this.filePathRead = filePathRead;
    }

    public String getFilePathWrite () {
        return filePathWrite;
    }

    public void setFilePathWrite (String filePathWrite) {
        this.filePathWrite = filePathWrite;
    }

    public String getFilePathRead () {
        return filePathRead;
    }

    public void setFilePathRead (String filePathRead) {
        this.filePathRead = filePathRead;
    }
}
