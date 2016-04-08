/**
 * Created by Администратор on 08.04.2016.
 */
public class Program2 {
    static AffableThread mSecondThread;

    public static void main(String[] args) {
        mSecondThread = new AffableThread();    //Создание потока
        mSecondThread.start();                    //Запуск потока
        System.out.println("Главный поток завершён...");
    }
}
