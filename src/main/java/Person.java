import java.util.Objects;

public class Person {
    private String firstName;
    private String secondName;
    private int age = -1;
    private String location;

    public static class Builder {
        private final Person person;

        public Builder() {
            person = new Person();
        }

        public Builder setFirstName(String firstName) {     // Обязательное поле
            person.firstName = firstName;
            return this;
        }

        public Builder setSecondName(String secondName) {   // Обязательное поле
            person.secondName = secondName;
            return this;
        }

        public Builder setAge(int age) {
            if (age < 0) throw new IllegalArgumentException("Указан недопустимый возраст");
            person.age = age;
            return this;
        }

        public Builder setLocation(String location) {
            if (location == null || location.isBlank()) {
                throw new IllegalArgumentException("Поле \"Адрес\" не заполнено");
            }
            person.location = location;
            return this;
        }

        public Person build() {
            if (person.firstName == null || person.firstName.isBlank()) {
                throw new IllegalArgumentException("Поле \"Имя\" обязательно для заполнения");
            }
            if (person.secondName == null || person.secondName.isBlank()) {
                throw new IllegalArgumentException("Поле \"Фамилия\" обязательно для заполнения");
            }
            return person;
        }

    }

    private Person() {}

    public Person(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public Person(String firstName, String secondName) {
        this(firstName, secondName, -1);
    }

    public boolean hasAge() {
        return age != -1;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age += 1;
        }
    }

    public boolean hasAddress() {
        return location != null && !location.isBlank();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Builder newChildBuilder() {
        return new Builder()
                .setSecondName(secondName)
                .setAge(0)
                .setLocation(location);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(firstName, person.firstName)
                && Objects.equals(secondName, person.secondName)
                && age == person.age
                && Objects.equals(location, person.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, age, location);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                '}';
    }
}
