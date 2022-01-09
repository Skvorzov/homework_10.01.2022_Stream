import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileUtils {
    public static File createFile(String name) throws IOException {
        File file = new File(name);
        file.createNewFile();
        return file;
    }

    public static File createDirectory(String name) throws IOException {
        File directory = new File(name);
        directory.mkdir();
        return directory;
    }

    public static File createFileInDir(String fileName, String dirName) throws IOException {
        File file = new File(dirName, fileName);
        file.createNewFile();
        return file;
    }

    public static void writeToFile(String text, File file) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(text);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
        }
    }

    public static void copyInfo(File fileName1, File fileName2) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName2);
            fileWriter.write(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
        }
    }

    public static void addInfoToNotEmptyFile(String text, File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String check = reader.readLine();
        if (check != null) {
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(file, true);
                fileWriter.append(text);
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fileWriter.close();
            }
        }
    }

    public static void downloadImage(String url, String fileName) {
        try (InputStream in = URI.create(url).toURL().openStream()) {
            Files.copy(in, Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean exists(String name) throws IOException {
        File file = new File(name);
        return file.exists();
    }

    public static boolean fileRightExtensionCheck(File file) throws Exception {
        String name = file.getName();
        if (name.endsWith("png") || name.endsWith("jpg") || name.endsWith("jpeg")) {
            return true;
        }
        throw new Exception("downloaded file is not image");
    }
}