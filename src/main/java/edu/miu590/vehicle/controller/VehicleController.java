package edu.miu590.vehicle.controller;

import edu.miu590.vehicle.api.VehiclesApi;

import edu.miu590.vehicle.model.SearchVehicleDto;
import edu.miu590.vehicle.model.VehicleDto;
import edu.miu590.vehicle.model.VehicleRequestDto;
import edu.miu590.vehicle.services.VehicleDao;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
public class VehicleController implements VehiclesApi {

    private final VehicleDao vehicleDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleController.class);

    public VehicleController(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    @Override
    public ResponseEntity<Void> deleteVehicleById(String id) {

        vehicleDao.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<VehicleDto>> getAllVehicle() {
        return ResponseEntity.ok(vehicleDao.findAll());
    }

    @Override
    public ResponseEntity<VehicleDto> getVehicleById(String id) {

        return ResponseEntity.ok(vehicleDao.findById(id));
    }

    @Override
    public ResponseEntity<VehicleDto> saveVehicles(VehicleRequestDto vehicleRequestDto) {
        return ResponseEntity.ok(vehicleDao.save(vehicleRequestDto));
    }

    @Override
    public ResponseEntity<VehicleDto> updateVehicleById(String id, VehicleRequestDto vehicleRequestDto) {
        return ResponseEntity.ok(vehicleDao.updateById(id, vehicleRequestDto));
    }


//    @Override
//    public ResponseEntity<List<VehicleDto>> filterVehicle(SearchCarDto searchCarDto) {
//        return VehiclesApi.super.filterVehicle(searchCarDto);
//    }


    @Override
    @Retry(name = "${spring.application.name}", fallbackMethod = "callBackData")
    public ResponseEntity<List<VehicleDto>> filterVehicle(SearchVehicleDto searchVehicleDto) {
        LOGGER.info(searchVehicleDto.toString());
        return ResponseEntity.ok(vehicleDao.searchVehicleAvailability(searchVehicleDto));
    }

    public ResponseEntity<List<VehicleDto>> callBackData(SearchVehicleDto searchVehicleDto, Exception exception) {
        LOGGER.info(exception.getMessage());

        return ResponseEntity.ok(vehicleDao.findAll());
    }
}
