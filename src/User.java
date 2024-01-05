import java.util.*;

public class User {
    private String name;
    private int password;
    private int bill;
    private  static Map<Integer, User> users = new HashMap<>();

  static  {
        users.put(1111, new User("Максим", 1111));
        users.put(2222, new User("Иван", 2222));
        users.put(3333, new User("Сергей", 3333));
    }

    public static void addUser(int password, String name){
      users.put(password, new User(name, password));
    }

    public User(String name, int password) {
        this.name = name;
        this.password = password;
    }

    public static void printUsers(){
        System.out.println(users.size());
        Set setUsers = users.entrySet();

        Iterator i = setUsers.iterator();

        while (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + " : ");
            System.out.println(me.getValue().toString());
        }
    }

    public static  Set getUsersKeys(){
      Set setUsers = users.keySet();
      return setUsers;
    }

    public static Map getUsers(){

        return users;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }
    @Override
    public String toString(){
      return name + " : " + "Пароль: " + password;
    }
}
