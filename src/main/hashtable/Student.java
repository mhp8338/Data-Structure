package hashtable;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/2/2
 * @description:
 */
public class Student {
    int grade;
    int cls;
    String firstName;
    String lastName;

    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int B = 31;
        int hash = 0;
        hash = hash * B + ((Integer) grade).hashCode();
        hash = hash * B + ((Integer) cls).hashCode();
        hash = hash * B + firstName.hashCode();
        hash = hash * B + lastName.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != getClass()) {
            return false;
        }
        Student another = (Student) obj;
        return this.grade == another.grade
                && this.cls == another.cls
                && this.lastName.toLowerCase().equals(another.lastName.toLowerCase())
                && this.firstName.toLowerCase().equals(another.firstName.toLowerCase());

    }
}
