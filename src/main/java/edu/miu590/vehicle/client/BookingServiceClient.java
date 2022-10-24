package edu.miu590.vehicle.client;


import edu.miu590.vehicle.model.SearchVehicleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "${booking.service.feign.name}", url = "${booking.service.feign.url}")
public interface BookingServiceClient {

    @PutMapping("/search")
    List<String> searchBookingByDate(SearchVehicleDto searchVehicleDto);

}
