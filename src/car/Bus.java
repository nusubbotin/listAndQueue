package car;

import java.util.Objects;

public class Bus extends Transport implements CompetingTransport  {

    public Bus(String brand, String model, float engineVolume) {
        super(brand, model, engineVolume);
    }

    public void startMoving(){
        System.out.println("Посадить пассажиров");
        System.out.println("Начать движение");
    };

    public void stopMoving(){
        System.out.println("Завершить движение");
        System.out.println("Высадить пасажиров");
    };

    public void pitStop(){
        System.out.println("Водитель автобуса открыл двери чтобы посажиры сходили в туалет");
        System.out.println("Автобус заправился");
        System.out.println("Водитель автобуса закрыл двери и тронулся");
    }
    public void bestCircleTime(){
        System.out.println("Запросить информацию у логиса");
    }
    public void maximumSpeed(){
        System.out.println("Запросить информацию у логиса по максимальной скорости");
    }

    @Override
    public String toString() {
        return "Bus{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}
