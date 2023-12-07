package ge.gela.coordinate_full.services;

import ge.gela.coordinate_full.entities.VehicleLocation;
import ge.gela.coordinate_full.repositories.VehicleLocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleLocationServiceImpl implements VehicleLocationService {
    public final VehicleLocationRepository vehicleLocationRepository;

    @Override
    public List<VehicleLocation> findAllByVehId(Integer vehId) {
        return vehicleLocationRepository.findAllByVehId(vehId);
    }

    @Override
    public void vehicleLocationAdd(Double latitude1, Double longitude1, Integer carId2) {
        VehicleLocation vehicleLocation = new VehicleLocation();
        vehicleLocation.setLatitude(latitude1);
        vehicleLocation.setLongitude(longitude1);
        vehicleLocation.setVehId(carId2);

        vehicleLocationRepository.save(vehicleLocation);
    }

    @Override
    public List<VehicleLocation> getVehicleLocation() {
        return vehicleLocationRepository.findAll();
    }
    @Override
    public Double distanceCal(Double latitude1, Double latitude, Double longitude1, Double longitude) {

        {
            longitude1 = Math.toRadians(longitude1);
            longitude = Math.toRadians(longitude);
            latitude1 = Math.toRadians(latitude1);
            latitude = Math.toRadians(latitude);

            double dlon = longitude - longitude1;
            double dlat = latitude - latitude1;
            double a = Math.pow(Math.sin(dlat / 2), 2)
                    + Math.cos(latitude1) * Math.cos(latitude)
                    * Math.pow(Math.sin(dlon / 2), 2);

            double c = 2 * Math.asin(Math.sqrt(a));

            double r = 6371;

            return (c * r);
        }
    }

}
