package car;

import java.util.Objects;

public abstract class Transport {
    protected String brand;
    protected String model;
    protected float engineVolume;

    public Transport(String brand, String model, float engineVolume) {
        setBrand(brand);
        setModel(model);
        setEngineVolume(engineVolume);
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
