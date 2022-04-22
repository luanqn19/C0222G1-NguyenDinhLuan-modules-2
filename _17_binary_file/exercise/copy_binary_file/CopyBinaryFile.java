package _17_binary_file.exercise.copy_binary_file;

import java.io.*;
import java.util.Date;

public class CopyBinaryFile implements Serializable {
    private static final long serialVersionUID = -266706354210367639L;
    private String filePathSource;
    private String filePathCopy;
    private String str;

    public CopyBinaryFile (String filePathSource , String filePathCopy) {
        this.filePathSource = filePathSource;
        this.filePathCopy = filePathCopy;
    }

    public void copyFile(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.filePathSource));
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.filePathCopy))){

            //Read file path
            String filePath = (String) ois.readObject();
            oos.writeObject(filePath);

            //Read date time
            Date date = (Date) ois.readObject();
            oos.writeObject(date);

            //Read datatype
            String datatypeName = ois.readUTF();
            oos.writeObject(datatypeName);

            //Read content
            this.str = (String) ois.readObject();
            oos.writeObject(str);

            System.out.println(filePath);
            System.out.println(date);
            System.out.println(datatypeName);
            System.out.println(this.str);

        }catch (IOException | ClassNotFoundException e){
            System.err.println();
        }
    }
}
