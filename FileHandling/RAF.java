import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RAF {
    public static void main(String[] args) {
        writeToFile();
        readFromFile();
        System.out.println(createFile());
    }

    private static void readFromFile() {
        try {
            RandomAccessFile file = new RandomAccessFile("file.txt", "r");
            file.seek(0);
            // System.out.println(file.read());
            System.out.println(file.readLine());
            // System.out.println(file.length());
            
            byte[] bytes = new byte[(int) file.length()];
            file.read(bytes);

            for(byte b: bytes)
                System.out.print((char)b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile() {
        try {
            RandomAccessFile file = new RandomAccessFile("file.txt", "rw");
            file.seek(file.length() + 1);
            file.writeBytes("\nHELLO");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean createFile() {
        File file = new File("./newFile.txt");
        try {
            return file.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
}