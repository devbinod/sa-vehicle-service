package edu.miu590.vehicle.controller;

import edu.miu590.vehicle.api.VehiclesApi;

import edu.miu590.vehicle.model.SearchVehicleDto;
import edu.miu590.vehicle.model.VehicleDto;
import edu.miu590.vehicle.model.VehicleRequestDto;
import edu.miu590.vehicle.services.VehicleDao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController implements VehiclesApi {

    private final VehicleDao vehicleDao;

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
        return ResponseEntity.ok(vehicleDao.updateById(id,vehicleRequestDto));
    }


//    @Override
//    public ResponseEntity<List<VehicleDto>> filterVehicle(SearchCarDto searchCarDto) {
//        return VehiclesApi.super.filterVehicle(searchCarDto);
//    }


    @Override
    public ResponseEntity<List<VehicleDto>> filterVehicle(SearchVehicleDto searchVehicleDto) {
        return ResponseEntity.ok(vehicleDao.searchVehicleAvailability(searchVehicleDto));
    }
}
