package ru.lesson.lessons;
import java.util.*;


/**
 * Created by Администратор on 08.04.2016.
 */
public class UserRunner {

    public static void main(String[] args){
        List<User> users0 = new ArrayList<User>();
        users0.add(new User("1","first"));
        users0.add(new User("1","first"));
        users0.add(new User("2","second"));

        for (User user : users0) {
            System.out.println(user);
        }
        System.out.println();

        List<User> users1 = new LinkedList<User>();
        users1.add(new User("1","first"));
        users1.add(new User("1","first"));
        users1.add(new User("2","second"));

        for (User user : users1) {
            System.out.println(user);
        }
        System.out.println();

        Set<User> users2 = new HashSet<User>();
        users2.add(new User("1","first"));
        users2.add(new User("1","first"));
        users2.add(new User("2","second"));

        for (User user : users2) {
            System.out.println(user);
        }
        System.out.println();

        Map<String,User> users3 = new HashMap();
        users3.put("1", new User("1","first"));
        users3.put("1", new User("1","first"));
        users3.put("2", new User("2","second"));

        for (Map.Entry<String,User> user : users3.entrySet()) {
            System.out.println(user);
        }
        System.out.println();
    }

}
