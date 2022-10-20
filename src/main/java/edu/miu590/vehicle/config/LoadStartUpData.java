package edu.miu590.vehicle.config;


import edu.miu590.vehicle.model.VehicleRequestDto;

import edu.miu590.vehicle.services.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Component
public class LoadStartUpData implements CommandLineRunner {

    @Autowired
    private VehicleDao vehicleDao;


    @Override
    public void run(String... args) throws Exception {


        List<VehicleRequestDto> vehicleDtos = List.of(
                VehicleRequestDto.builder().brand("Audi").model("A3").color("black").description("Audi A3 model").pricePerDay(BigDecimal.valueOf(150)).purchaseDate(LocalDate.of(2015, 10, 1)).vin(Math.round(2)).build(),
                VehicleRequestDto.builder().brand("BMW").model("4 Series").color("black").description("BMW 4 Series model").pricePerDay(BigDecimal.valueOf(200)).purchaseDate(LocalDate.of(2020, 12, 1)).vin(123).build(),
                VehicleRequestDto.builder().brand("Ford").model("F250 Super Duty Regular Cab").color("silver").description("F250 Super Duty Regular Cab").pricePerDay(BigDecimal.valueOf(200)).purchaseDate(LocalDate.of(2014, 9, 1)).vin(Math.round(2)).build(),
                VehicleRequestDto.builder().brand("Freightliner").model("Sprinter 1500 Cargo").color("white").description("Sprinter 1500 Cargo").pricePerDay(BigDecimal.valueOf(350)).purchaseDate(LocalDate.of(2014, 6, 1)).vin(Math.round(2)).build(),
                VehicleRequestDto.builder().brand("Freightliner").model("Sprinter 3500 Cargo").color("black").description("Audi A3 model").pricePerDay(BigDecimal.valueOf(150)).purchaseDate(LocalDate.of(2015, 10, 1)).vin(Math.round(2)).build(),
                VehicleRequestDto.builder().brand("Honda").model("CR-V").color("black").description("ASUV").pricePerDay(BigDecimal.valueOf(88)).purchaseDate(LocalDate.of(2015, 10, 1)).vin(Math.round(22)).build(),
                VehicleRequestDto.builder().brand("Honda").model("Ridgeline").color("black").description("Honda Ridgeline").pricePerDay(BigDecimal.valueOf(90)).purchaseDate(LocalDate.of(2015, 10, 1)).vin(Math.round(22)).build(),
                VehicleRequestDto.builder().brand("Hyundai").model("Kona Electric").color("red").description("Honda Ridgeline").pricePerDay(BigDecimal.valueOf(208)).purchaseDate(LocalDate.of(2015, 10, 1)).vin(Math.round(212)).build(),
                VehicleRequestDto.builder().brand("Hyundai").model("Sonata").color("black").description("Audi A3 model").pricePerDay(BigDecimal.valueOf(19)).purchaseDate(LocalDate.of(2015, 10, 1)).vin(Math.round(122)).build(),
                VehicleRequestDto.builder().brand("INFINITI").model("Q50").color("black").description("Sedan").pricePerDay(BigDecimal.valueOf(200)).purchaseDate(LocalDate.of(2015, 10, 1)).vin(Math.round(1222)).build(),
                VehicleRequestDto.builder().brand("Toyota").model("Yaris Hatchback").color("black").description("Toyota Audi Yaris Hatchback").pricePerDay(BigDecimal.valueOf(111)).purchaseDate(LocalDate.of(2009, 10, 1)).vin(Math.round(1223)).build(),
                VehicleRequestDto.builder().brand("Volkswagen").model("Jetta").color("black").description("Jetta Volkswagen model").pricePerDay(BigDecimal.valueOf(232)).purchaseDate(LocalDate.of(2005, 10, 1)).vin(Math.round(12222)).build(),
                VehicleRequestDto.builder().brand("Volkswagen").model("Tiguan").color("black").description("Volkswagen  Tiguan model").pricePerDay(BigDecimal.valueOf(22)).purchaseDate(LocalDate.of(2015, 10, 1)).vin(Math.round(1222)).build(),
                VehicleRequestDto.builder().brand("Volvo").model("S60").color("black").description("Volv A3 model").pricePerDay(BigDecimal.valueOf(434)).purchaseDate(LocalDate.of(2015, 10, 1)).vin(Math.round(1222)).build()


        );

        vehicleDtos.stream().forEach(it -> vehicleDao.save(it));

    }
}
