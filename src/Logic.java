import java.util.Scanner;

public class Logic {
    Scanner sc = new Scanner(System.in);
    User activeUser;

    public void start() {
        System.out.println("Вы пытаетесь зайти в банкомат. Пожалуйста авторизируйтесь или зарегистрируйтесь!");
        System.out.println("Введте 'reg' для регистрации или нажмите Enter для входа");
        if (sc.nextLine().equals("reg")) {
            registration();
        } else signIn();
        menu();
    }

    private void registration() {
        System.out.println("Введите логин для регистрации:");
        String login = sc.nextLine();
        System.out.println("И еще пароль:");
        int password = sc.nextInt();

        User.addUser(password, login);
        activeUser = (User) User.getUsers().get(password);
        System.out.println("Вы успешно зарегистрировались");
    }

    private void signIn() {
        System.out.println("Для авторицаии введите пароль");
        int password = sc.nextInt();
        activeUser = (User) User.getUsers().get(password);
        if (User.getUsers().containsKey(password)) {
            System.out.println(activeUser.getName() + " авторизовался");
        } else {
            System.out.println("Введите пароль еще раз");
            signIn();
        }
    }

    private void menu() {
        System.out.println("1. Пополнить баланс");
        System.out.println("2. Снять средства");
        System.out.println("3. Узнать баланс");
        System.out.println("4. Выйти");
        switch (sc.nextInt()) {
            case 1:
                replenish();
                break;
            case 2:
                takeOff();
                break;
            case 3:
                balanceInfo();
                break;
            case 4:
                logout();
                break;
            default:
                System.out.println("Данной операции не существует");
        }
    }

    private void replenish(){
        System.out.println("Введите сумму на которую хотите пополнить");
        activeUser.setBill(sc.nextInt());
        System.out.println("Спасибо за пополнение");
        System.out.println();
        menu();
    }

    private void takeOff(){
        System.out.println("Введите сумму которую хотите обналичить");
        activeUser.setBill(activeUser.getBill() - sc.nextInt());
        System.out.println("Спасибо, что пользуетесь банкоматом");
        System.out.println();
        menu();

    }

    private void balanceInfo(){
        System.out.println("На вашем счете сейчас: " + activeUser.getBill());
        System.out.println();
        menu();
    }

    private void logout(){
        System.out.print("Выход ");
        for(int i = 0; i < 3; i++){
            System.out.print('.');
            System.out.println();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
            activeUser = null;
        start();
    }
}
