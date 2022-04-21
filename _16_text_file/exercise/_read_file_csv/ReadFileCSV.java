package _16_text_file.exercise._read_file_csv;

import java.io.*;
import java.util.List;

public class ReadFileCSV {
    private int id;
    private String code, name;

    public ReadFileCSV () {
    }

    public List<ReadFileCSV> readFile (String path, List<ReadFileCSV> list) {
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
                ReadFileCSV readFileCSV = new ReadFileCSV(Integer.parseInt(result[0]) , code , name);
                list.add(readFileCSV);
            }
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ReadFileCSV (int id , String code , String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getCode () {
        return code;
    }

    public void setCode (String code) {
        this.code = code;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Override
    public String toString () {
        return "ReadFileCSV{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
