import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class Commander {
    public City findIdCity(Long id, LinkedHashSet<City> cities) {
        City delCity = null;
        for (City city : cities) {
            if (city.getId().equals(id)) {
                delCity = city;
            }
        }
        return delCity;
    }

    public String readLine(String command, LinkedHashSet<City> cities, Date date, String fileName) throws IOException {
        String[] commands = command.split(" ");
        Scanner sc = new Scanner(System.in);
        FileChecker fileChecker = new FileChecker();
        CityCreator cityCreator = new CityCreator();
        ArrayList<String> arrayOfCommands = new ArrayList<>();
        ArrayList<String> historyOfCommands = new ArrayList<>();
        arrayOfCommands.addAll(Arrays.asList(commands));
        String answer = "Вы ввели пустую строку";
        if (arrayOfCommands.size() == 1) {
            switch (arrayOfCommands.get(0)) {
                case ("exit"):
                    answer = "exit";
                    break;
                case ("help"):
                    answer = "Список возможных команд лялялялляля";
                    break;
                case ("show"):
                    answer = cities.toString();
                    break;
                case ("add"):
                    cities.add(cityCreator.createCityFromStream(cities));
                    answer = "Город добавлен";
                case ("info"):
                    answer="Коллекция типа LinkedHashSet\nДата инициализации:"+date+"\nКоличество элементов" +
                            " "+cities.size();
                    break;
                case ("clear"):
                    cities.clear();
                    answer="Коллекция очищена";
                case ("save"):
                    String newWrite="";
                    for (City city : cities){
                        newWrite+=city.toString2()+"\n";
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                    fileOutputStream.write(newWrite.getBytes());
                    fileOutputStream.close();
                    answer="Файл сохранён";
                    break;


                default:
                    answer = "Неверная команда";
            }
        }
        if (arrayOfCommands.size() == 2) {
            if ((arrayOfCommands.get(0).equals("update")) && FileChecker.isLong(arrayOfCommands.get(1))) {
                cities.remove(findIdCity(Long.parseLong(arrayOfCommands.get(1)), cities));
                cities.add(cityCreator.createCityFromStream(cities, Long.parseLong(arrayOfCommands.get(1))));
                answer = "Город обновлен";
            }
            if ((arrayOfCommands.get(0).equals("remove_by_id")) && FileChecker.isLong(arrayOfCommands.get(1))) {
                cities.remove(findIdCity(Long.parseLong(arrayOfCommands.get(1)), cities));
                answer = "Город удалён";
            }

        }
        return answer;
    }
}

