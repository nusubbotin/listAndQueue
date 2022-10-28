package car;

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
            amount -= sponsorValue;
            car.getSponsors().add(this);
        }else {
            System.out.println("У спонсора "+ name + "(" + sponsorType.getTypeName() +")  нехватает денег. Остаток средств: " + amount);
        }
    }
}
