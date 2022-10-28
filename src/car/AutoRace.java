package car;

import java.util.ArrayList;
public class AutoRace <T extends Transport & CompetingTransport, D extends DriverInterface>{
    private ArrayList<T> cars = new ArrayList<>(10);

    private ArrayList<T> drivers = new ArrayList<>();

    private ArrayList<Sponsor> sponsors = new ArrayList<>();

    private ArrayList<Mechanic> mechanics = new ArrayList<>();

    public ArrayList<T> getCars() {
        return cars;
    }

    public ArrayList<T> getDrivers(){
        return drivers;
    }

    public ArrayList<Sponsor> getSponsors() {
        return sponsors;
    }

    public ArrayList<Mechanic> getMechanics() {
        return mechanics;
    }
}
