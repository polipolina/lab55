import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;


public class CityCreator {
    FileChecker fileChecker = new FileChecker();
    Scanner sc = new Scanner(System.in);
    private Long createId(String fileName) throws IOException {
        Long id = 1L;
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            System.out.println("Строка: " + scanner.next());
            id++;
        }
        scanner.close();
        return id;
    }
    private Coordinates coordinatesConverter(String coordinates) {
        String[] coords = coordinates.split(";");
        double x = Double.parseDouble(coords[0]);
        Long y = Long.parseLong(coords[1]);
        return new Coordinates(x,y);
    }
    private Date establishmentDateConvertor(String date) {
        if (date != "") {
            String[] numbers = date.split("\\.");
            GregorianCalendar establishmentDate = new GregorianCalendar
                    (Integer.parseInt(numbers[2]),Integer.parseInt(numbers[1]), Integer.parseInt(numbers[0]));
            return establishmentDate.getTime();
        } else {
            return null;
        }
    }
    private StandardOfLiving standardOfLivingConvertor(String standardOfLiving){
        StandardOfLiving stdOfLvng=null;
        if (standardOfLiving.equals(StandardOfLiving.LOW.name())) {
            stdOfLvng=StandardOfLiving.LOW;
        }
        if (standardOfLiving.equals(StandardOfLiving.VERY_LOW.name())) {
            stdOfLvng=StandardOfLiving.VERY_LOW;
        }
        if (standardOfLiving.equals(StandardOfLiving.ULTRA_LOW.name())) {
            stdOfLvng=StandardOfLiving.ULTRA_LOW;
        }
        return stdOfLvng;
    }
    private Human humanConvertor(String human) {
        return new Human(Integer.parseInt(human));
    }

    public City createCity(String[] words,Long id) {
        ArrayList<String> checklineWords = new ArrayList<>();
        checklineWords.addAll(Arrays.asList(words));
        String name = checklineWords.get(0);
        Coordinates coordinates = coordinatesConverter(checklineWords.get(1));
        LocalDate creationDate = LocalDate.now();
        Long area = Long.parseLong(checklineWords.get(2));
        Integer population = Integer.parseInt(checklineWords.get(3));
        Long metersAboveSeaLevel = null;
        if (checklineWords.get(4) != "") {
            metersAboveSeaLevel = Long.parseLong(checklineWords.get(4));
        }
        java.util.Date establishmentDate = establishmentDateConvertor(checklineWords.get(5));
        long agglomeration = 0;//Long.parseLong(null);
        if (checklineWords.get(6) != "") {
            agglomeration = Long.parseLong(checklineWords.get(6));
        }
        StandardOfLiving standardOfLiving = standardOfLivingConvertor(checklineWords.get(7));
        Human governor = humanConvertor(checklineWords.get(8));
        return new City(id, name, coordinates, creationDate,
                area, population,
                metersAboveSeaLevel, establishmentDate, agglomeration,
        standardOfLiving, governor);

    }
    public City createCityFromStream(LinkedHashSet<City> cities){
        ArrayList<String> checklineWords = new ArrayList<String>();
        boolean nextQ = false;
        while (!nextQ) {
            System.out.println("Введите название города");
            String checkWord = sc.nextLine();
            if (!fileChecker.nameChecker(checkWord)) {
                System.out.println("Некорректное название города");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите координаты в формате X;Y");
            String checkWord = sc.nextLine();
            if (!fileChecker.coordinatesChecker(checkWord)) {
                System.out.println("Некорректные координаты");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите площадь");
            String checkWord = sc.nextLine();;
            if (!fileChecker.areaChecker(checkWord)) {
                System.out.println("Некорректная площадь");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите население");
            String checkWord = sc.nextLine();
            if (!fileChecker.populationChecker(checkWord)) {
                System.out.println("Некорректное население");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите высоту над уровнем моря(не обязательно)");
            String checkWord = sc.nextLine();
            if (!fileChecker.metersAboveSeaLevelChecker(checkWord)) {
                System.out.println("Некорректно");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите дату основания(не обязательно)");
            String checkWord = sc.nextLine();
            if (!fileChecker.establishmentDateChecker(checkWord)) {
                System.out.println("Некорректная дата");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите аггломерацию");
            String checkWord = sc.nextLine();
            if (!fileChecker.agglomerationChecker(checkWord)) {
                System.out.println("Некорректная агломерация");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите уровень жизни:\n LOW \n VERY_LOW \n ULTRA_LOW");
            String checkWord = sc.nextLine();
            if (!fileChecker.standardOfLivingChecker(checkWord)) {
                System.out.println("Некорректный уровень жизни");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите средний рост человека");
            String checkWord = sc.nextLine();
            if (!fileChecker.humanChecker(checkWord)) {
                System.out.println("Некорректный рост");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        Long id= (long) cities.size();
        String [] array =checklineWords.toArray(new String[9]);
        return createCity(array,id);
    }
    public City createCityFromStream(LinkedHashSet<City> cities,Long id){
        ArrayList<String> checklineWords = new ArrayList<String>();
        boolean nextQ = false;
        while (!nextQ) {
            System.out.println("Введите название города");
            String checkWord = sc.nextLine();
            if (!fileChecker.nameChecker(checkWord)) {
                System.out.println("Некорректное название города");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите координаты в формате X;Y");
            String checkWord = sc.nextLine();
            if (!fileChecker.coordinatesChecker(checkWord)) {
                System.out.println("Некорректные координаты");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите площадь");
            String checkWord = sc.nextLine();;
            if (!fileChecker.areaChecker(checkWord)) {
                System.out.println("Некорректная площадь");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите население");
            String checkWord = sc.nextLine();
            if (!fileChecker.populationChecker(checkWord)) {
                System.out.println("Некорректное население");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите высоту над уровнем моря(не обязательно)");
            String checkWord = sc.nextLine();
            if (!fileChecker.metersAboveSeaLevelChecker(checkWord)) {
                System.out.println("Некорректно");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите дату основания(не обязательно)");
            String checkWord = sc.nextLine();
            if (!fileChecker.establishmentDateChecker(checkWord)) {
                System.out.println("Некорректная дата");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите аггломерацию");
            String checkWord = sc.nextLine();
            if (!fileChecker.agglomerationChecker(checkWord)) {
                System.out.println("Некорректная агломерация");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите уровень жизни:\n LOW \n VERY_LOW \n ULTRA_LOW");
            String checkWord = sc.nextLine();
            if (!fileChecker.standardOfLivingChecker(checkWord)) {
                System.out.println("Некорректный уровень жизни");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        while (!nextQ) {
            System.out.println("Введите средний рост человека");
            String checkWord = sc.nextLine();
            if (!fileChecker.humanChecker(checkWord)) {
                System.out.println("Некорректный рост");
            } else {
                checklineWords.add(checkWord);
                nextQ = true;
            }
        }
        nextQ=false;
        String [] array =checklineWords.toArray(new String[9]);
        return createCity(array,id);
    }



    // собирает города и отправляет в коллекцию. Принимает файлнейм, запускает цсв сканнер, и если на
    // делает файл чек по цсв сканнеру, и если все ок, принимает рез цсв сканнера и по алгоритму
    // использует метод собрать город, отправляя в коллекцию
    public void addCitiesToCollection(String fileName, LinkedHashSet<City> cities) throws IOException {
        FileChecker fileChecker = new FileChecker();
        ArrayList<String[]> lineWords = fileChecker.scanCsv(fileName);
        if (fileChecker.invalidFileCheck(lineWords)) {
            Long id=0L;
            System.out.println("Сборщик запустился");
            for (String[] words : lineWords) {
                System.out.println(createCity(words,id).toString());
                cities.add(createCity(words,id));
                System.out.println("Элемент добавлен");
                id++;
                // цикл по датас, распаковка в коллекцию
                // метод созданий городов
            }
            // LocalDate creationDate = LocalDate.now();


        }
    }
}
