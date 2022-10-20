package edu.miu590.vehicle.exceptions;

public class VehicleNotFound extends RuntimeException{

    public VehicleNotFound(String message) {
        super(message);
    }
}
