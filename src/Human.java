import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

enum Gender {
    MAN,
    WOMAN
}

public class Human implements Serializable, Comparable<Human> {
    private String name;
    private Gender sex;
    private Integer yearBirth;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, Gender sex, Integer yearBirth, Human father, Human mother) {
        this.name = name;
        this.sex = sex;
        this.yearBirth = yearBirth;
        children = new ArrayList<>();
        this.father = father;
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        String gender = "";
        if (sex == Gender.MAN) {
            gender = "муж";
        } else {
            gender = "жен";
        }
        String res = "\n" + name + ", " + gender + ", " + yearBirth + "";
        if (father != null) {
            res = res + ", father: " + father.getName();
        }
        if (mother != null) {
            res = res + ", mother: " + mother.getName();
        }
        return res;
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }

}