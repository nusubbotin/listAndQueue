package car;

import java.util.Objects;

public class DriverD <T extends Bus> extends Driver {
    private final char driverCategory = 'D';

    public DriverD(String fullName, int experience) {
        super(DriverCategory.D.getName(), fullName, experience);
    }

    public void toRule(T bus){
        System.out.println("Проверить закртыие дверей и педаль в пол");

        bus.pitStop();
        bus.bestCircleTime();
        bus.maximumSpeed();
    }

    public char getDriverCategory() {
        return driverCategory;
    }

    @Override
    public String toString() {
        return "DriverD{" +
                "driverCategory=" + driverCategory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DriverD<?> driverD = (DriverD<?>) o;
        return driverCategory == driverD.driverCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), driverCategory);
    }
}
