package car;

import java.util.Objects;

public class Car extends Transport implements CompetingTransport  {
    public Car(String brand, String model, float engineVolume) {
        super(brand, model, engineVolume);
    }

    public void startMoving(){
        System.out.println("Прогреть двиготель - проехать 3 разогравочных круга");
        System.out.println("Стартовать по фигналу");
    };

    public void stopMoving(){
        System.out.println("пересечь черту ФИНИШ на последнем круге");
    };

    public void pitStop(){
        System.out.println("Гонщик останавливается");
        System.out.println("Команда меняет шины, делает дозаправку");
        System.out.println("Гонщие выезжает на трек");
    }
    public void bestCircleTime(){
        System.out.println("Запросить информацию у диспетчера гонки");
    }
    public void maximumSpeed(){
        System.out.println("Запросить информацию у диспетчера гонки по максимальной скорости");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                '}';
    }

    public void checkDriverLicense (DriverB driver ){
        for (Driver.DriverCategory value : Driver.DriverCategory.values()) {
            if (value.getName() == driver.getDriverCategory()) {
                System.out.println("Проверка прав для водителя: " + driver.getFullName() + " прошла успешно!");
                return;
            }
        }
        throw new IllegalArgumentException("Указанный тип прав не существует");
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
