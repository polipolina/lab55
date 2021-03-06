import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class FileChecker {
    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isLong(String s) throws NumberFormatException {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    protected Boolean coordinatesChecker(String coordinates) {
        boolean checker = false;
        String[] coords = coordinates.split(";");
        //System.out.println(coords.length);
        //System.out.println(isDouble(coords[0]));
        //System.out.println(isLong(coords[1]));
        if ((coords.length == 2) && (isDouble(coords[0])) && (isLong(coords[1]))
                && Double.parseDouble(coords[0])<=59)  {
            checker = true;
        } else {
           // System.out.println("Неправильные координаты");
        }
        return checker;
    }
    protected Boolean nameChecker (String name) {
        boolean check=false;
        if (!name.equals("")) {
            check=true;
        }
        return check;
}
    protected Boolean areaChecker(String area) {
        Boolean check = false;
        //System.out.println(isLong(area));

        if (isLong(area) && Long.parseLong(area) > 0) {
            check = true;
        } else {
            System.out.println("Неправильная ареа");
        }
        return check;
    }
    protected Boolean populationChecker(String population) {
        Boolean check = false;
        //System.out.println(isDigit(population));

        if (isDigit(population) && Integer.parseInt(population) > 0) {
            check = true;
        } else {
            System.out.println("Непраильная популяция");
        }
        return check;

    }
    protected Boolean metersAboveSeaLevelChecker(String mAL) {
        boolean check = false;
        if ((mAL == "") | isLong(mAL)) {
            check = true;
        } else {
            System.out.println("mAL");
        }
        return check;
    }
    protected Boolean agglomerationChecker(String agglomeration) {
        boolean check = false;
        if ((isLong(agglomeration)) | agglomeration.equals(null)) {
            check = true;
        } else {
            System.out.println("agglomeration");
        }
        return check;
    }
    protected Boolean standardOfLivingChecker(String standardOfLiving) {
        boolean check = false;
        if (standardOfLiving.equals("LOW") | standardOfLiving.equals("VERY_LOW") |
                standardOfLiving.equals("ULTRA_LOW")) {
            check = true;
        } else {
            System.out.println("StdOfLeavin");
        }
        return check;
    }
    protected Boolean humanChecker(String human) {
        boolean check = false;
        if (isDigit(human) && Integer.parseInt(human) > 0) {
            check = true;
        } else {
            System.out.println("human");
        }
        return check;
    }
    protected Boolean establishmentDateChecker(String establishmentDate) {
        String[] numbers = establishmentDate.split("\\.");
        boolean check = false;
        if ((establishmentDate=="") | ((numbers.length == 3) && (isDigit(numbers[0])) && (isDigit(numbers[1])) &&
                (isDigit(numbers[2])) && (Integer.parseInt(numbers[0]) <= 31) &&
                (Integer.parseInt(numbers[0]) >= 0) && (Integer.parseInt(numbers[1]) <= 12) &&
                (Integer.parseInt(numbers[0]) >= 0) && (Integer.parseInt(numbers[2]) <= 2021) &&
                (Integer.parseInt(numbers[2]) >= -2021))) {
            check = true;
        } else {
            System.out.println("EstDate");
        }
        return check;
    }

    public ArrayList<String[]> scanCsv(String nameFile) throws IOException {

        Path path = Paths.get(nameFile);
        Scanner scanner = new Scanner(path);
        ArrayList<String[]> lineWords = new ArrayList<>();

        //построчно считываем файл
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            lineWords.add(scanner.next().split(","));
        }
        scanner.close();
        for (String[] lines : lineWords) {
            for (String word : lines) {
                System.out.print(word + " | ");
            }
            System.out.println();
        }
        return lineWords;
    }

    public Boolean invalidFileCheck(ArrayList<String[]> lineWords) {
        Boolean check = false;
        ArrayList<String> checklineWords = new ArrayList<>(); // массив слов
        for (String[] words : lineWords) {
            // загрузили массив слов
            checklineWords.addAll(Arrays.asList(words));
            if ((checklineWords.size() != 9) || !nameChecker(checklineWords.get(0)) |
                    !coordinatesChecker(checklineWords.get(1))
                    | (!areaChecker(checklineWords.get(2)))
                    | !populationChecker(checklineWords.get(3))
                    | !metersAboveSeaLevelChecker(checklineWords.get(4)) |
                    !establishmentDateChecker(checklineWords.get(5)) |
                    !agglomerationChecker(checklineWords.get(6)) | !standardOfLivingChecker(checklineWords.get(7))
                    | !humanChecker(checklineWords.get(8))) {
                System.out.println("Данные неккоректны");
                check=false;
                break;
            } else {
                System.out.println("Данные корректны");
                check = true;
            }

            checklineWords.clear();
        }
        return check;


    }
}