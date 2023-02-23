import java.io.*;
import java.util.Collections;
import java.util.Scanner;

public class Service implements Writable, Serializable {
    private Family family;

    public Service(Family family) {
        this.family = family;
    }

    public void addPerson(Human human) {
        family.add(human);

    }

    public void searchMember() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scan.nextLine();
        Human serch = family.search(name);
        System.out.println(serch);
    }

    public void createPerson() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scan.nextLine();
        System.out.println("Пол (ж - женский/ м - мужской): ");
        String genderStr = scan.nextLine();
        Gender sex;
        if (genderStr.contains("ж")) {
            sex = Gender.WOMAN;
        } else {
            sex = Gender.MAN;
        }
        System.out.println("Год рождения: ");
        int yearBirth = Integer.parseInt(scan.nextLine());
        System.out.println("Имя отца: ");
        String fatherStr = scan.nextLine();
        Human father = family.search(fatherStr);
        System.out.println(father);
        System.out.println("Имя матери: ");
        String motherStr = scan.nextLine();
        Human mother = family.search(motherStr);
        addPerson(new Human(name, sex, yearBirth, father, mother));
    }

    public void sortByName() {
        Collections.sort(family.getMembers());
    }

    public void sortByYearBirth() {
        Collections.sort(family.getMembers(), new HumanComparatorYearBirth());
    }

    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tree.out"))) {
            oos.writeObject(serializable);
            System.out.println("Saved");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Family read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tree.out"))) {
            return (Family) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}