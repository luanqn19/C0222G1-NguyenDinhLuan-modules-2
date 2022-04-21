package _16_text_file.exercise._copy_file;

public class TestExcution {
    public static void main (String[] args) {
        String fileWrite = "src\\_16_text_file\\exercise\\_copy_file\\copy-file.txt";
        String fileRead = "src\\_16_text_file\\exercise\\_copy_file\\file.txt";
        CopyFileText copyFileText = new CopyFileText(fileWrite, fileRead);

        copyFileText.readFile();

        copyFileText.writeFile();
    }
}
