package com.db.except;

import java.io.IOException;
import java.util.*;

public class Club {

    private int minAge;
//    private Person[] people;
    private List<Person> people;
    private int noPeople;
    private Object TreeSet;

    public Club(int minAge) {
        this.minAge = minAge;
//        people = new Person[100];
        people = new LinkedList();
        noPeople = 0;
    }

    public void join(Person person) throws Exception { // throws Exception TODO
        if (person.getAge() < 0) {
            throw new IOException("Age cannot be negative");
        }
        if (person.getAge() < this.minAge) {
            throw new AgeException(person.getAge(), person.getName());
        }
        System.out.println("Current no of people: " + noPeople);
//        people[noPeople++] = person;
        people.add(person);
    }

    public static void main(String args[]) {
        Club club = new Club(18);
        try {
            club.join(club.new Person("Vasile", 27));
            club.join(club.new Person("Ionel", 27));
            club.join(club.new Person("Gigel", 28));
            club.join(club.new Person("Popescu", 29));
            club.join(club.new Person("Popescu", 30));
            club.join(club.new Person("Mihaela", 27));

            Set<Person> set = club.toTreeSet();
            System.out.println("No of people in set: " + set.size());

            Iterator<Person> personIt = set.iterator();
            while(personIt.hasNext()) {
                System.out.println("Person in set: " + personIt.next() + ", ");
            }

            List<Club.Person> anotherList = new ArrayList<>(club.people);
            anotherList.sort(new PersonNameLengthComparator());
            System.out.println("Sorted list: ");
            for (int i = 0; i < anotherList.size(); i++) {
                System.out.println(anotherList.get(i));
            }


            System.out.println("Club: " + club);
        } catch(AgeException e) {
            System.out.println("AgeException: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch(Exception e) {
            System.out.println("Other exception: " + e.getMessage());
        }


//        try {
//            club.join(club.new Person("Gigel", 17));
//            System.out.println("Club: " + club);
//        } catch(AgeException e) {
//            System.out.println("AgeException: " + e.getMessage());
//        }
//        try {
//            club.join(club.new Person("Popescu", 23));
//            System.out.println("Club: " + club);
//        } catch(AgeException e) {
//            System.out.println("AgeException: " + e.getMessage());
//        }

//        finally {
//            System.out.println("S-au verificat toate persoanele");
//        }
    }

    class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Club{" +
//                "people=" + Arrays.toString(people) +
                "people=" + this.<Person>print(new ArrayList<>(people)) +
                ", noPeople=" + noPeople +
                '}';
    }

    public <P> String print(ArrayList<P> objects) {
        StringBuilder sb = new StringBuilder();
//        String s = "";
        for (int i = 0 ; i < objects.size(); i++) {
            sb.append(objects.get(i)).append(", ");
//            s += objects.get(i) + ", ";
        }
//        return s;
        return sb.toString();
    }

    public <P extends Person> Set<P> toTreeSet() {
//        Set<P> set = new TreeSet(new PersonComparator());
        Set<P> set = new TreeSet(new PersonNameComparator());
        set.addAll(new ArrayList(people));
        return set;
    }


    public <T extends Set> T setOfPeople(Collection collection, Class<T> type) {
//        return new TreeSet<>(collection);
        return type.cast(collection);
    }

}

