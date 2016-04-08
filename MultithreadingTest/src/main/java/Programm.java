/**
 * Created by Администратор on 08.04.2016.
 */
class Program {
    public static void main(String[] args) {
        //Создание потока
        Thread myThready = new Thread(new Runnable() {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                System.out.println("Привет из побочного потока!");
            }
        });
        myThready.start();    //Запуск потока
        System.out.println("Главный поток завершён...");
    }
}
