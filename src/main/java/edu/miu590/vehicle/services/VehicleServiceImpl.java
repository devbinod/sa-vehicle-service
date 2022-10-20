package edu.miu590.vehicle.services;

import edu.miu590.vehicle.entity.Vehicle;
import edu.miu590.vehicle.exceptions.VehicleNotFound;
import edu.miu590.vehicle.mapper.VehicleMapper;
import edu.miu590.vehicle.model.VehicleDto;
import edu.miu590.vehicle.model.VehicleRequestDto;
import edu.miu590.vehicle.repository.VehicleRepository;
import edu.miu590.vehicle.util.AppUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleDao {


    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public VehicleDto save(VehicleRequestDto vehicleRequestDto) {
        return convertToDto(createOrSave(null, vehicleRequestDto));
    }

    @Override
    public List<VehicleDto> findAll() {

        return vehicleMapper.toDtoList(vehicleRepository.findAll());
    }

    @Override
    public void deleteById(String id) {
        vehicleRepository.delete(getVehicleById(id));

    }

    @Override
    public VehicleDto findById(String id) {
        return convertToDto(getVehicleById(id));
    }

    @Override
    public VehicleDto updateById(String id, VehicleRequestDto vehicleRequestDto) {
        getVehicleById(id);
        return convertToDto(createOrSave(id, vehicleRequestDto));
    }


    private Vehicle getVehicleById(String id) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isEmpty()) throw new VehicleNotFound("Vehicle Not found with id" + id);
        return optionalVehicle.get();
    }

    private Vehicle createOrSave(String id, VehicleRequestDto vehicleRequestDto) {

        Vehicle vehicle = vehicleMapper.toEntity(vehicleRequestDto);
        if (id == null) {
            vehicle.setUserId(AppUtil.getCurrentUser());
        }else {
            vehicle.setId(id);
        }
        return vehicleRepository.save(vehicle);

    }

    private VehicleDto convertToDto(Vehicle vehicle) {
        return vehicleMapper.toDto(vehicle);
    }
}
