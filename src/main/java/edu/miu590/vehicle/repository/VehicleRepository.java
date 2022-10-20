package edu.miu590.vehicle.repository;

import edu.miu590.vehicle.entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle,String> {
}
