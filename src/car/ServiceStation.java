package car;

import java.util.ArrayDeque;
import java.util.Queue;

public class ServiceStation <T extends Transport> {
    private Queue<T> autoQueue= new ArrayDeque<>(1);

    public Queue<T> getAutoQueue() {
        return autoQueue;
    }

    public void pushAuto(T auto){
        if (!(auto.getClass() == Car.class || auto.getClass() == CargoCar.class)) {
            throw new IllegalArgumentException("На станции техобслуживания обслуживаюся только Легковой транспорт и Грузовой транспорт");
        }

        try {
            System.out.println("Автомобиль " + auto.getModel() + " встал в очередь на техобслуживание");
            autoQueue.offer(auto);
            System.out.println("autoQueue.size() = " + autoQueue.size());
        }catch (IllegalStateException e){
            throw new IllegalArgumentException("На Станции техобслуживания превышена очередь машин ожидающих ремонт");
        }
    }

    public void popAuto(){
        T auto = autoQueue.poll();
        if (auto != null) {
            System.out.println("Проведено техобслуживание автомобиля " + auto.getModel());
        }else {
            System.out.println("На станции нет машин для обслуживания");
        }
    }
}
