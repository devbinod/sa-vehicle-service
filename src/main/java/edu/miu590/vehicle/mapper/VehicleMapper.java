package edu.miu590.vehicle.mapper;


import edu.miu590.vehicle.entity.Vehicle;
import edu.miu590.vehicle.model.VehicleDto;
import edu.miu590.vehicle.model.VehicleRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleMapper {

    VehicleDto toDto(Vehicle vehicle);
    Vehicle toEntity(VehicleRequestDto vehicleRequestDto);

    List<VehicleDto> toDtoList(List<Vehicle> vehicleList);

    List<Vehicle> toEntityList(List<VehicleRequestDto> vehicleRequestDtoList);
}
