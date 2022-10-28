package car;

import java.util.ArrayList;

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
}
