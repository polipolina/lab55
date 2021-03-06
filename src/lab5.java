import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Scanner;

class lab5 { // логика проекта
    public static void main(String[] args) throws IOException {
        LinkedHashSet<City> cities = new LinkedHashSet<>();
        Commander commander = new Commander();
        Scanner sc = new Scanner(System.in);
        CityCreator cityCreator = new CityCreator();
        try {
            cityCreator.addCitiesToCollection("test.csv", cities);
            final Date initTime=new Date();
            System.out.println(cities);
            System.out.println("Запуск консоли произведен");
            String command = "";

            while (!command.equals("exit")) {
                System.out.println("Введите комманду:");
                command = commander.readLine(sc.nextLine(), cities,initTime,"Collectia.csv");
                if (!command.equals("exit")) {
                    System.out.println(command); }
            }
            System.out.println("Работа завершена");
        }
        catch (NoSuchFileException e) {
            System.out.println("Файла не существует");
            FileOutputStream fileOutputStream = new FileOutputStream("test.csv");
            cityCreator.addCitiesToCollection("test.csv", cities);
            final Date initTime=new Date();
            System.out.println(cities);
            System.out.println("Запуск консоли произведен");
            String command = "";

            while (!command.equals("exit")) {
                System.out.println("Введите комманду:");
                command = commander.readLine(sc.nextLine(), cities,initTime,"Collectia.csv");
                if (!command.equals("exit")) {
                    System.out.println(command); }
            }
            System.out.println("Работа завершена");
        }

        }

        }
