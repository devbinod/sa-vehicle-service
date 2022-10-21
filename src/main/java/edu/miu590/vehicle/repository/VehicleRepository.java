package edu.miu590.vehicle.repository;

import edu.miu590.vehicle.entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle,String> {
    List<Vehicle> findByIdNotIn(List<String> vehicleIdList);
}
