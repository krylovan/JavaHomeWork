package com.pb.krylov.hw11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Ira", new ArrayList<String>(), "Pavlograd", LocalDate.of(2000, 5, 2)));
        persons.get(0).addPhone("11111");
        persons.add(new Person("Andrew", new ArrayList<String>(), "Pavlograd", LocalDate.of(20084, 5, 2)));
        persons.get(1).addPhone("561");
        persons.get(1).addPhone("61");
        persons.add(new Person("Ivan", Arrays.asList("201","202","203"), "Dnipro", LocalDate.of(2001, 11, 22)));
        ObjectMapper mapper = new ObjectMapper();
        // pretty printing (json с отступами)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // для работы с полями типа LocalDate
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());

        // для работы с полями типа LocalDateTime
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module);


        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Телефонная книга");
            System.out.println("1. добавление элемента");
            System.out.println("2. удаление элемента");
            System.out.println("3. поиск элементов");
            System.out.println("4. сортировка по указанному полю");
            System.out.println("5. редактирование элемента");
            System.out.println("6. запись в файл всех данных");
            System.out.println("7. чтение из файла всех данных");

            System.out.println("0. Выход");

            String option = scan.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Добавление элемента ");
                    Person p=createRecord();
                    persons.add(p);
                    break;
                case "2":
                    System.out.println("Удаление элемента " );
                    printWithIndex(persons);
                    System.out.println("Введите индекс удаляемого элемента(0-i): ");
                    int i = Integer.parseInt(scan.nextLine());
                    persons.remove(i);
                    printWithIndex(persons);
                    break;
                case "3":
                    System.out.println("Введите имя для поиска: ");
                    String fName = scan.nextLine();
                    persons.stream().filter(l->l.getName().equals(fName)).forEach(System.out::println);
//                    for (Person fp: persons) {
//                        if (fp.getName().equals(fName)) {
//                            persons.indexOf(fp);
//                            System.out.println("["+persons.indexOf(fp)+"]"+fp);
//                        }
//                    }
                    break;
                case "4":
                    System.out.println("Сортировка " );
                    System.out.println("Сортировка 0-по дате рождения, 1- по дате редактирования иначе по имени: ");
                    int sort = Integer.parseInt(scan.nextLine());
                    if (sort==0){
                        persons.stream().sorted((p1, p2) -> p1.getDateOfBirth().compareTo(p2.getDateOfBirth())).forEach(System.out::println);
                    } else if (sort == 1){
                        persons.stream().sorted((p1, p2) -> p1.getDateTimeEdit().compareTo(p2.getDateTimeEdit())).forEach(System.out::println);
                    } else
                        persons.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).forEach(System.out::println);


//                    if (sort==0) {
//                        Collections.sort(persons, new Person.PersonTimeComparator());
//                    }else {
//                        Collections.sort(persons);
//                    }
//                    printWithIndex(persons);
                    break;
                case "5":
                    System.out.println("Редактирование элемента " );
                    printWithIndex(persons);
                    System.out.println("Введите индекс редактируемого элемента(0-i): ");
                    i = Integer.parseInt(scan.nextLine());
                    editRecord(persons.get(i));
                    printWithIndex(persons);
                    break;
                case "6":
                    System.out.println("Запись Json ");
                    try {
                        mapper.writeValue(new File("persons.json"),persons);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    String personsJson = mapper.writeValueAsString(persons);
                    System.out.println(personsJson);
                    break;
                case "7":
                    System.out.println("Чтение Json ");
                    List<Person> persons2 = mapper.readValue(new File("persons.json"), new TypeReference<List<Person>>() {});
                    System.out.println(persons2.get(0).getClass().getName());
                    persons=persons2;
                    printWithIndex(persons);



                    break;




                case "0":
                    System.out.println("Возврат");
                    return;
                default:
                    System.out.println("Ошибочный выбор меню!");
            }
        }





    }



    private static void printWithIndex(List<Person> arrayList ) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(i+" "+arrayList.get(i));
        }
    }

        private static Person createRecord() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = scan.nextLine();

        List<String> cphones = new ArrayList<>();
        System.out.println("Input phone: ");
        String phone = scan.nextLine();
        cphones.add(phone);

        System.out.println("Input city: ");
        String city = scan.nextLine();

        System.out.println("Input dateOfBirth (yyyy-mm-dd): ");
        LocalDate dOB = LocalDate.parse(scan.nextLine());
        return new Person(name,cphones,city,dOB);

    }
    private static void editRecord(Person p) {

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Изменяем запись: " + p);
            System.out.println("1. Имя");
            System.out.println("2. Добавить телефон");
            System.out.println("3. Удалить телефон");
            System.out.println("4. Изменяем телефон");
            System.out.println("5. Город");
            System.out.println("0. Выход");

            String option = scan.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Input name: ");
                    String name = scan.nextLine();
                    p.setName(name);
                    break;
                case "2":
                    System.out.println("Добавить телефон: " + p.getPhones());
                    System.out.println("Введите новый номер: ");
                    String aphone = scan.nextLine();
                    p.addPhone(aphone);
                    break;
                case "3":
                    System.out.println("Удалить телефон: " + p.getPhones());
                    System.out.println("Введите индекс номера(0-i): ");
                    int i = scan.nextInt();
                    p.removePhone(i);
                    break;
                case "4":
                    System.out.println("Изменяем телефоны: " + p.getPhones());
                    System.out.println("Введите индекс номера(0-i): ");
                    i = Integer.parseInt(scan.nextLine());

                    System.out.println("Введите новый номер: ");
                    String ephone = scan.nextLine();
                    p.editPhone(i,ephone);
                    break;
                case "5":
                    System.out.println("Введите город: ");
                    String city = scan.nextLine();
                    p.setCity(city);
                case "0":
                    System.out.println("Возврат");
                    return;
                default:
                    System.out.println("Ошибочный выбор меню!");
            }
        }

    }
}
