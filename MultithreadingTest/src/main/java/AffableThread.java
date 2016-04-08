/**
 * Created by Администратор on 08.04.2016.
 */
public class AffableThread extends Thread{
    @Override
    public void run(){
        System.out.println("Привет из побочного потока!");
    }
}
