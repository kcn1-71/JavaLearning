/**
 * Created by Администратор on 08.04.2016.
 */
class Incremenator extends Thread {
    private volatile boolean mIsIncrement = true;

    public void changeAction()    //Меняет действие на противоположное
    {
        mIsIncrement = !mIsIncrement;
    }

    @Override
    public void run() {
        do {
            if (!Thread.interrupted())    //Проверка на необходимость завершения
            {
                if (mIsIncrement)
                    Program3.mValue++;    //Инкремент
                else
                    Program3.mValue--;    //Декремент

                //Вывод текущего значения переменной
                System.out.print(Program3.mValue + " ");
            } else
                return;        //Завершение потока

            try {
                Thread.sleep(1000);        //Приостановка потока на 1 сек.
            } catch (InterruptedException e) {
                return;
            }
        }
        while (true);
    }
}
