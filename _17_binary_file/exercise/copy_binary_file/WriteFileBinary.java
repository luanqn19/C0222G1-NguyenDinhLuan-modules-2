package _17_binary_file.exercise.copy_binary_file;

import java.io.*;
import java.util.Date;

public class WriteFileBinary implements Serializable {
    private static final long serialVersionUID = -266706354210367639L;
    private String str = "Lorem ipsum dolor sit amet consectetur adipiscing elit " +
            "Cras odio nisi tempor non elementum ut sollicitudin sit amet tellus " +
            "Ut vitae egestas mi in rhoncus nisl Nullam in elit felis " +
            "Proin erat libero interdum nec neque eget eleifend pulvinar justo";

    public void writeFile(){
        try {
            File file = new File("src\\_17_binary_file\\exercise\\copy_binary_file\\source-file.dat");
            String filePathAbs = file.getAbsolutePath();

            FileOutputStream fileWriter = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fileWriter);

            //Write file path
            oos.writeObject(filePathAbs);
            //Write date time creat
            oos.writeObject(new Date());
            //Write datatype
            oos.writeUTF("String: ");
            //Write content
            oos.writeObject(str);

            oos.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Success...");
    }
}
