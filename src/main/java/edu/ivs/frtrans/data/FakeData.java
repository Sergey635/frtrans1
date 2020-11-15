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
            new Drivers( "Амросій Петро Васильович", "0956734545", "Чернівці",
                    "10"),
            new Drivers("Васильков Анатолій Володимирович", "0667899810",
                    "Чернівці","7.5"),
            new Drivers("Миколайчук Сергій Сергійович", "0508731656",
                    "Чернівці","2"),
            new Drivers("Оріс Дмитро Іванович", "0501322390","3",
                    "3"),
            new Drivers("Соломін Андрій Алікович ", "0958993347", "4.5",
                    "4.5"),
            new Drivers("Унгурян Олександр Іванович", "0663581221", "3",
                    "3"),
            new Drivers("Фрунзе Михайло Юрійович", "0993721688", "8",
                    "8")
            ).collect(Collectors.toList());

    public List<Drivers> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Drivers> drivers) {
        this.drivers = drivers;
    }

    private List<Route> routes = Stream.of(
            new Route("Чернівці – Новодністровськ","219","1"
                    ,"qqq","1950")
            , new Route("Чернівці – Могилів-Подільський", "201", "1"
                    ,"qq", "2375")
            ,new Route("Чернівці – Київ", "512", "1","qq"
            ,"4500")
            ,new Route("Чернівці – Херсон", "755", "1", "qq"
            , "5250")
            ,new Route("Чернівці – Одеса", "682", "1", "qq"
            , "4825"),
            new Route("Чернівці – Кишинів", "334", "1", "qq"
                    , "3250"),
            new Route("Чернівці – Ясси", "233", "1", "qq"
                    , "2500"),
            new Route("Чернівці – Мінськ", "804", "1", "qq"
                    , "7150"),
            new Route("Чернівці – Варшава", "672", "1", "qq"
                    , "4900")
            )
            .collect(Collectors.toList());

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}

