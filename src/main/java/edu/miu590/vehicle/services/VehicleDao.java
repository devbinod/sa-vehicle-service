package edu.miu590.vehicle.services;

import edu.miu590.vehicle.entity.Vehicle;
import edu.miu590.vehicle.model.SearchVehicleDto;
import edu.miu590.vehicle.model.VehicleDto;
import edu.miu590.vehicle.model.VehicleRequestDto;

import java.util.List;

public interface VehicleDao {

    VehicleDto save(VehicleRequestDto vehicleRequestDto);

    List<VehicleDto> findAll();

    void deleteById(String id);

    VehicleDto findById(String id);

    VehicleDto updateById(String id,VehicleRequestDto vehicleRequestDto);

    List<VehicleDto> searchVehicleAvailability(SearchVehicleDto searchVehicleDto);
}
