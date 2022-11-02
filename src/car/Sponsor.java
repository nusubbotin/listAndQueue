package car;

import java.util.Objects;

public class Sponsor <T extends Transport> {
    public enum SponsorType {UL("Юридическое лицо"), FL("Физическое лицо");
        private String typeName;

        SponsorType(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }
    }
    private String name;
    private SponsorType sponsorType;
    private float amount;

    public Sponsor(String name, SponsorType sponsorType, float amount) {
        this.name = name;
        this.sponsorType = sponsorType;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public SponsorType getSponsorType() {
        return sponsorType;
    }

    public float getAmount() {
        return amount;
    }

    public void sponsorCar(T car, int sponsorValue){
        if (amount >= sponsorValue){
            System.out.println("Cпонсора "+ name + "(" + sponsorType.getTypeName() +")  спонсировал на сумму: " + sponsorValue + " ТС: "+ car.getModel());
            amount -= sponsorValue;
            car.getSponsors().add(this);
        }else {
            System.out.println("У спонсора "+ name + "(" + sponsorType.getTypeName() +")  нехватает денег. Остаток средств: " + amount);
        }
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "name='" + name + '\'' +
                ", sponsorType=" + sponsorType +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor<?> sponsor = (Sponsor<?>) o;
        return Float.compare(sponsor.amount, amount) == 0 && Objects.equals(name, sponsor.name) && sponsorType == sponsor.sponsorType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sponsorType, amount);
    }
}
