import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        // создаем два файла.
        File test1 = FileUtils.createFile("test1");
        File test2 = FileUtils.createFile("test2");
        // записываем текст в первый файл.
        FileUtils.writeToFile("Hello world!", test1);
        // копируем текст из первого файла во второй файл.
        FileUtils.copyInfo(test1, test2);
        // добавляем в файл новый текст без замены старого, если он не пустой.
        FileUtils.addInfoToNotEmptyFile("\nNew text", test1);


        // создаем файл с расширением .сsv в директории output, в который записываем данные в виде таблицы.
        FileUtils.createDirectory("output");
        File result = FileUtils.createFileInDir("result.csv", "output");
        FileUtils.writeToFile("name, age, sex\nВася, 22, мужчина\nМарина, 23, женщина\nПетя, 69, мужчина\nДима, 13, мужчина", result);


        // Скачиваем картинку по ссылке.
        FileUtils.downloadImage("https://upload.wikimedia.org/wikipedia/ru/thumb/7/78/Trollface.svg/1200px-Trollface.svg.png", "testImage.jpg");

        // Проверяем сущестувет ли файл после скачивания.
        System.out.println(FileUtils.exists("testImage.jpg"));

        // Проверяем правильное ли у файла расширение.
        File extensionTest = new File("testImage.jpg");
        System.out.println(FileUtils.fileRightExtensionCheck(extensionTest));
    }
}