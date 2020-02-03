package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @tag: DataStructure
 * @author: mhp
 * @createDate: 2020/2/2
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1416926;
        System.out.println(((Double)c).hashCode());

        String s = "mmmm";
        System.out.println(s.hashCode());

        System.out.println(Integer.MAX_VALUE+1);

        Student student = new Student(3,2,"mm","amma");
        System.out.println(student.hashCode());

        Set<Student> set = new HashSet<>();
        set.add(student);


        Map<Student,Integer> map = new HashMap<>(0);
        map.put(student,100);

        Student student1 = new Student(3,2,"MM","AMMA");

        set.add(student1);
        System.out.println(student.equals(student1));
    }

}
