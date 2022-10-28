package car;

import java.util.Objects;

public class DriverC <T extends CargoCar> extends Driver {

    public DriverC(String fullName, int experience) {
        super(DriverCategory.C.getName(), fullName, experience);
    }

    public void toRule(T cargoCar){
        System.out.println("Прогреть двиготель, пару нажать педаль в пол и поехали");

        cargoCar.pitStop();
        cargoCar.bestCircleTime();
        cargoCar.maximumSpeed();
    }

    public char getDriverCategory() {
        return driverCategory;
    }

    @Override
    public String toString() {
        return "DriverC{" +
                "driverCategory=" + driverCategory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DriverC<?> driverC = (DriverC<?>) o;
        return driverCategory == driverC.driverCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), driverCategory);
    }
}
