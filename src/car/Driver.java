package car;

import java.util.Objects;

public abstract class Driver implements DriverInterface{

    protected char driverCategory;
    private String fullName;
    private int experience;


    protected enum DriverCategory {
        B('B'), C('C'), D('D');

        private char driverCategory;

        private char name;

        DriverCategory(char name) {
            this.name = name;
        }

        public char getName() {
            return name;
        }
    }

    public char getDriverCategory() {
        return driverCategory;
    }

    public String getFullName() {
        return fullName;
    }

    public int getExperience() {
        return experience;
    }

    public Driver(char driverCategory, String fullName, int experience) {
        this.driverCategory = driverCategory;
        this.fullName = fullName;
        this.experience = experience;
    }

    public void startMoving(){
        System.out.println("Начать движение");
    }

    public void stopMoving(){
        System.out.println("Завершить гонку");
    }

    public void carRefuel(){
        System.out.println("Заправить машину");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return experience == driver.experience && Objects.equals(fullName, driver.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, experience);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverCategory=" + driverCategory +
                ", fullName='" + fullName + '\'' +
                ", experience=" + experience +
                '}';
    }
}
