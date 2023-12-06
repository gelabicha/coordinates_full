package ge.gela.coordinate_full.controllers;

import ge.gela.coordinate_full.entities.VehicleLocation;
import ge.gela.coordinate_full.repositories.VehicleLocationHistoryRepository;
import ge.gela.coordinate_full.repositories.VehicleLocationRepository;
import ge.gela.coordinate_full.repositories.VehiclesRepository;
import ge.gela.coordinate_full.services.VehicleLocationHistoryService;
import ge.gela.coordinate_full.services.VehicleLocationService;
import ge.gela.coordinate_full.services.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("newvehicle")
public class NewVehicleRequestController {
    private final VehiclesRepository vehiclesRepository;
    private final VehicleService vehicleService;
    private final VehicleLocationRepository vehicleLocationRepository;
    private final VehicleLocationService vehicleLocationService;
    private final VehicleLocationHistoryRepository vehicleLocationHistoryRepository;
    private final VehicleLocationHistoryService vehicleLocationHistoryService;

    /**
     * იღებს მონაცემებს და
     * ეძებს მიღებული ნომრით მანქანას,
     * ანახლებს და ამატებს მანქანის მდებარეობას.
     * .
     *
     * @param latitude1
     * @param longitude1
     * @param carNum1
     */
    @GetMapping("vehicle")
    @ResponseBody
    public void NewVehicle(@RequestBody Double latitude1, @RequestBody Double longitude1, @RequestBody String carNum1) {
        /*
         * მიღებჯლი ნომრით ვეძებთ მანქანას,
         * ვიღებთ მოძებნილი მანქანის იდს,
         * იდ-ით ვეძებთ ლოკაციის ცხრილში,
         * თუ მოიძებნა ვანახლებთ კორდინატებს,
         * თუ არ მოიძებნა ვამატებთ როგორც ახალს,        *
         * თუ არ მოიძებნა - ვისვრით შეცდომას.        *
         * */
        var carNum = vehiclesRepository.findAllByVehNum(carNum1);
        if (!carNum.isEmpty()) {
            var carId2 = carNum.get(0).getVehId();
            var vehId1 = vehicleLocationRepository.findALLbyVehId(carId2);
            if (!vehId1.isEmpty()) {
                var vehId3 = vehId1.get(0);
                vehId3.setLatitude(latitude1);
                vehId3.setLongitude(longitude1);
                vehicleLocationRepository.save(vehId3);

                vehicleLocationHistoryService.vehicleHistoryCreateNew(latitude1, longitude1, carId2);
            } else {

                vehicleLocationService.vehicleLocationAdd(latitude1, longitude1, carId2);
            }

        } else {
            throw new RuntimeException("dont found car");
        }

    }

    /**
     * გვიბრუნებს მოცემულ კორდინატთან არსებულ მანქანებს
     *
     * @param latitude1
     * @param longitude1
     * @return
     */
    @GetMapping("calc")
    public List<?> calculated(Double latitude1, Double longitude1) {
        List<VehicleLocation> vehicleLocationList = vehicleLocationService.getVehicleLocation();
        for (VehicleLocation vehicleLocation : vehicleLocationList) {
            Double distance = vehicleLocationService.distanceCal(latitude1, vehicleLocation.getLatitude(), longitude1, vehicleLocation.getLongitude());
            vehicleLocation.setDistance(distance);
        }
        vehicleLocationList.sort(Comparator.comparingDouble(VehicleLocation::getDistance));
        return vehicleLocationList;
    }

}
