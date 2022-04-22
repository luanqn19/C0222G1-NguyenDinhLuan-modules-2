package _17_binary_file.exercise.copy_binary_file;

public class TestExcution {
    public static void main (String[] args) {
        String fileSource = "src\\_17_binary_file\\exercise\\copy_binary_file\\source-file.dat";
        String targetFile = "src\\_17_binary_file\\exercise\\copy_binary_file\\target-file.dat";
        CopyBinaryFile copyBinaryFile = new CopyBinaryFile(fileSource, targetFile);
        copyBinaryFile.copyFile();
    }
}
