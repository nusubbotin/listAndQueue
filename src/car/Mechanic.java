package car;

import java.util.ArrayList;
import java.util.Objects;

public class Mechanic <T extends Transport> {
    private String name;
    private String surname;

    private String companyName;

    private ArrayList<Transport.CarCategory> carCategories = new ArrayList<>();

    public Mechanic(String name, String surname, String companyName) {
        this.name = name;
        this.surname = surname;
        this.companyName = companyName;
    }

    public ArrayList<Transport.CarCategory> getCarCategories() {
        return carCategories;
    }

    private void checkSkils(T auto){
        if (!this.getCarCategories().contains(auto.getCarCategory())) {
            throw new IllegalArgumentException("Механик " + this.name + " не может ремонтировать ТС категории " + auto.getCarCategory().getName());
        }
    }
    public void maintenanceTransport(T auto){
        checkSkils(auto);
        System.out.println("Механик " + this.name + " провел ТО автомобиля " + auto.getModel());
        auto.addMechanic(this);
    }

    public void fixTransport(T auto){
        checkSkils(auto);
        System.out.println("Механик " + this.name + " починил автомобиль " + auto.getModel());
        auto.addMechanic(this);
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", companyName='" + companyName + '\'' +
                ", carCategories=" + carCategories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic<?> mechanic = (Mechanic<?>) o;
        return Objects.equals(name, mechanic.name) && Objects.equals(surname, mechanic.surname) && Objects.equals(companyName, mechanic.companyName) && Objects.equals(carCategories, mechanic.carCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, companyName, carCategories);
    }
}
