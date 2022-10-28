package car;

import java.util.Objects;

public class CargoCar extends Transport implements CompetingTransport{
    public CargoCar(String brand, String model, float engineVolume) {
        super(brand, model, engineVolume);
    }

    public void startMoving(){
        System.out.println("Загрузить груз на старте");
        System.out.println("Начать движение");
    };

    public void stopMoving(){
        System.out.println("Завершить движение");
        System.out.println("Разгрузить груз на финише");
    };

    public void pitStop(){
        System.out.println("Водитель грузовика останавливается");
        System.out.println("Проверка давления в шинах и кргуговой обход грузовика на предмет неполадок");
        System.out.println("Водитель грузовика трогается");
    }
    public void bestCircleTime(){
        System.out.println("Запросить информацию со спутника");
    }
    public void maximumSpeed(){
        System.out.println("Запросить информацию со спутника по максимальной скорости");
    }

    public void checkDriverLicense (DriverC driver ){
        for (Driver.DriverCategory value : Driver.DriverCategory.values()) {
            if (value.getName() == driver.getDriverCategory()) {
                System.out.println("Проверка прав для водителя: " + driver.getFullName() + " прошла успешно!");
                return;
            }
        }
        throw new IllegalArgumentException("Указанный тип прав не существует");
    }

    @Override
    public String toString() {
        return "CargoCar{" +
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
