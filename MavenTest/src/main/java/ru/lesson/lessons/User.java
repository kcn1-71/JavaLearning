package ru.lesson.lessons;

/**
 * Created by Администратор on 08.04.2016.
 */
public class User {

    private String id;
    private String name;

    User(String id, String name){
        this.id=id;
        this.name=name;
    }

    String getId(){
        return this.id;
    }

    String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        return name != null ? name.equals(user.name) : user.name == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
