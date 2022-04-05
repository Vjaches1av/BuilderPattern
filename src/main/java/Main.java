public class Main {

    public static void main(String[] args) {
        Person mom = new Person.Builder()
                .setFirstName("Мария")
                .setSecondName("Бабкина")
                .setAge(39)
                .setLocation("Москва")
                .build();
        System.out.println(mom);

        mom.happyBirthday();
        System.out.println(mom);

        mom.setLocation("Санкт-Петербург");
        System.out.println(mom);


        Person son = mom.newChildBuilder()
                .setFirstName("Боб")
                .build();
        System.out.println(son);

        son.happyBirthday();
        System.out.println(son);


        Person person = new Person.Builder()
                .setFirstName("FirstName")
                .setSecondName("SecondName")
                .build();
        System.out.println(person);
        person.happyBirthday();
        System.out.println(person);

        Person person1 = new Person.Builder()
                .setFirstName("FirstName")
                .setSecondName("SecondName")
                .setAge(-100)
                .build();
        System.out.println(person1);

        Person spy = new Person.Builder()
                .build();
        System.out.println(spy);
    }
}
