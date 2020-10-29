package edu.ivs.frtrans.data;

import edu.ivs.frtrans.model.Drivers;
import edu.ivs.frtrans.model.Route;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Repository
public class FakeData {
    private List<Drivers> drivers = Stream.of(
            new Drivers("1", "Володимир Васильович", "0248653485", "Chernivtsi"
                    , LocalDate.of(1993, Month.JULY, 15), "старий воїн"),
            new Drivers("2", "Тарас Іванович", "1516546", "Magala"
                    , LocalDate.of(200, Month.FEBRUARY, 5), "fast"),
            new Drivers("3", "Олег Олегович", "0248653485", "Chernivtsi"
                    , LocalDate.of(2010, Month.SEPTEMBER, 23), "newbee")
    ).collect(Collectors.toList());

    public List<Drivers> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Drivers> drivers) {
        this.drivers = drivers;
    }

    private List<Route> routes = Stream.of(
            new Route("1","Чернівці - Львів","300","1"
                    ,"short")
            , new Route("2", "Чернівці - Варшава", "672"
                    ,"2", "standart")
            ,new Route("3", "Будапешт - Чернівці", "670","2"
            ,"standart")
            ,new Route("4", "Відень - Київ", "1335", "3"
            , "long")
            ,new Route("5", "Львів - Прага", "860", "2"
            , "standart")
            )
            .collect(Collectors.toList());

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}

