import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Collection<People> peoples = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN)
        );

        List<People> militaryMan = peoples.stream()
                .filter(x -> x.getSex() == Sex.MAN)
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() < 27)
                .collect(Collectors.toList());
        System.out.println(militaryMan);

        Double averageMenAge = peoples.stream()
                .filter(x -> x.getSex() == Sex.MAN)
                .mapToInt(x -> x.getAge())
                .average()
                .getAsDouble();
        System.out.println(averageMenAge);

        long manWorker = peoples.stream()
                .filter(x -> x.getSex() == Sex.MAN)
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() < 65)
                .count();

        long womanWorker = peoples.stream()
                .filter(x -> x.getSex() == Sex.WOMEN)
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() < 60)
                .count();

        System.out.println(manWorker + womanWorker);
    }
}
