package part;

import java.util.*;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static Set<Person> union(Set<Person> s1, Set<Person> s2) {
        Set<Person> union = new TreeSet<>(s1);
        union.addAll(s2);
        return union;
    }

    public static Set<Person> difference(Set<Person> s1, Set<Person> s2) {
        Set<Person> diff = new TreeSet<>(s1);
        diff.removeAll(s2);
        return diff;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Person person_1 = new Person("Alice", 30);
        Person person_2 = new Person("Bob", 25);
        Set<Person> person_set = new HashSet<>();

        person_set.add(person_1);
        person_set.add(person_2);

        System.out.println(person_set);
        Person person_3 = new Person("Alice", 30);
        person_set.add(person_3);


        System.out.println(person_set);
        Person person_4 = new Person("Carli", 30);

        Set<Person> set_person_1 = new TreeSet<>(Arrays.asList(person_4,person_2, person_1));
        Set<Person> set_person_2 = new TreeSet<>(Arrays.asList(person_3, person_1));

        Set<Person> union = union(set_person_1, set_person_2);
        System.out.println(union);
        Set<Person> difference = difference(set_person_1, set_person_2);
        System.out.println(difference);

    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
