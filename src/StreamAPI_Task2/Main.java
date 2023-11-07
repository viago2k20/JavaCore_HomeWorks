package StreamAPI_Task2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
//        persons.forEach(System.out::println);

        System.out.println();
        //Найти количество несовершеннолетних (т.е. людей младше 18 лет).
        long count = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних: " + count);

//        persons.stream()
//                .filter(x -> x.getAge() < 18)
//                .forEach(x -> System.out.println(x.getName() + ": " + x.getAge() + " years"));

//        for (Person person : persons) {
//            if (person.getAge() < 18) {
//                System.out.println(person.getName() + " " + person.getAge());
//            }
//        }
        System.out.println("*".repeat(15));

//        for (Person person : persons) {
//            if (person.getAge() >= 18 && person.getAge() <= 27) {
//                System.out.println(person.getName() + " " + person.getFamily() + " " + person.getAge());
//            }
//        }
        //Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
        List<String> result;
        result = persons.stream()
                .filter(x -> x.getAge() >= 18 && x.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
        System.out.println("*".repeat(15));

        //Получить отсортированный по фамилии список потенциально работоспособных людей с высшим образованием
        // в выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).
        List<Person> result1;
        result1 = persons.stream()
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .filter(x -> x.getAge() > 18)
                .filter(x -> (x.getSex().equals(Sex.WOMAN) && x.getAge() < 60) || (x.getSex().equals(Sex.MAN) && x.getAge() < 65))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());

        result1.forEach(System.out::println);
        System.out.println("*".repeat(15));

    }
}
