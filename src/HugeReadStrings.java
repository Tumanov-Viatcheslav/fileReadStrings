import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HugeReadStrings {

    private static void printToFile(List<String> stringList, String fileName) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : stringList) {
                output.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printToFile(String string, String fileName) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(fileName))) {
            output.write(string);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<String> readFromFile() {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = input.readLine()) != null) {
                stringList.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return stringList;
    }

    private static List<String> getUniqueNames(List<String> stringList) {
        HashSet<String> uniqueNames = new HashSet<>(stringList);
        return uniqueNames.stream().toList();
    }

    private static int getNumberOfVP(List<String> stringList) {
        int counter = 0;
        for (String line : stringList) {
            if (line.equals("Вася Пупкин"))
                counter++;
        }
        return counter;
    }

    private static int getNumberOfFirstP(List<String> stringList) {
        int counter = 0;
        for (String line : stringList) {
            if (line.startsWith("Вася"))
                counter++;
        }
        return counter;
    }

    private static List<String> getShortStrings(List<String> stringList) {
        List<String> shortStrings = new ArrayList<>();
        for (String line : stringList) {
            if (line.length() < 15)
                shortStrings.add(line);
        }
        return shortStrings;
    }

    private static List<String> getSortedStringList(List<String> stringList) {
        List<String> sortedStrings = new ArrayList<>(stringList);
        sortedStrings.sort(String::compareTo);
        return sortedStrings;
    }
    private static List<String> replaceV(List<String> stringList) {
        List<String> vStrings = new ArrayList<>();
        for (String line : stringList) {
            vStrings.add(line.replace('В', 'V'));
        }
        return vStrings;
    }

    public static void main(String[] args) {
        List<String> stringList = readFromFile(), test1, test4, test5, test6;
        String fileName = "output", fileType = ".txt";
        int test2, test3;
        test1 = getUniqueNames(stringList);
        test2 = getNumberOfVP(stringList);
        test3 = getNumberOfFirstP(stringList);
        test4 = getShortStrings(stringList);
        test5 = getSortedStringList(test4);
        test6 = replaceV(stringList);

        printToFile(test1, fileName + "1" + fileType);
        printToFile(String.valueOf(test2), fileName + "2" + fileType);
        printToFile(String.valueOf(test3), fileName + "3" + fileType);
        printToFile(test4, fileName + "4" + fileType);
        printToFile(test5, fileName + "5" + fileType);
        printToFile(test6, fileName + "6" + fileType);
    }
}