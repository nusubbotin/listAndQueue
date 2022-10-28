package car;

import java.util.Objects;

public class DriverB<T extends Car> extends Driver{

    public DriverB(String fullName, int experience) {
        super(DriverCategory.B.getName(), fullName, experience);
    }

    public void toRule(T car){
        System.out.println("Как обычно - включаем драйв и педаль в пол");

        car.pitStop();
        car.bestCircleTime();
        car.maximumSpeed();
    }

    public char getDriverCategory() {
        return driverCategory;
    }

    @Override
    public String toString() {
        return "DriverB{" +
                "driverCategory=" + driverCategory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DriverB<?> driverB = (DriverB<?>) o;
        return driverCategory == driverB.driverCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), driverCategory);
    }
}
