package car;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Transport <M extends Mechanic> {

    public enum CarCategory {
        B('B', "Легковые автомобили"), C('C', "Грузовой трансорт"), D('D', "Пассажирский транспорт");

        private char code;
        private String name;

        CarCategory(char code, String name) {
            this.code = code;
            this.name = name;
        }

        public char getCode() {
            return code;
        }
        public String getName() {
            return name;
        }
    }

    protected String brand;
    protected String model;
    protected float engineVolume;

    private int mechanicsLimit;

    private CarCategory carCategory;

    private ArrayList<Driver> drivers = new ArrayList<>();

    private ArrayList<Sponsor> sponsors = new ArrayList<>();

    private ArrayList<Mechanic> mechanics = new ArrayList<>();

    public Transport(String brand, String model, float engineVolume, int mechanicsLimit, CarCategory carCategory) {
        setBrand(brand);
        setModel(model);
        setEngineVolume(engineVolume);
        setMechanicsLimit(mechanicsLimit);
        this.carCategory = carCategory;
    }

    protected abstract void startMoving();

    protected abstract void stopMoving();

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }


    public float getEngineVolume() {
        return engineVolume;
    }

    public int getMechanicsLimit() {
        return mechanicsLimit;
    }

    public CarCategory getCarCategory() {
        return carCategory;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public ArrayList<Sponsor> getSponsors() {
        return sponsors;
    }

    public ArrayList<Mechanic> getMechanics() {
        return mechanics;
    }

    public void addMechanic(M mechanic) {
       if (!this.getMechanics().contains(mechanic) ) {
            if (getMechanics().size() >= mechanicsLimit) {
                throw new IllegalArgumentException("Превышен лимит Механиков.");
            }
            this.getMechanics().add(mechanic);
        }
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("Не задана Модель");
        }else {
            this.brand = brand;
        }
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Не задана Марка");
        }else {
            this.model = model;
        }
    }

    public void setEngineVolume(float engineVolume) {
        if (engineVolume <= 0) {
            throw new IllegalArgumentException("Объем двиготеля должен быть положительным целым числом");
        }else {
            this.engineVolume = engineVolume;
        }
    }

    public void setMechanicsLimit(int mechanicsLimit) {
        if (mechanicsLimit <= 0) {
            throw new IllegalArgumentException("Число механиков должен быть положительным целым числом");
        }else {
            this.mechanicsLimit = mechanicsLimit;
        }
    }

    public void checkDriverLicense (Driver driver ){
        System.out.println("По умолчанию проверка водительских прав не требуется");
    }

    @Override
    public String toString() {
        return "brand = " + brand + ", model = " + model + ", engineVolume = " + engineVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Float.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }
}
