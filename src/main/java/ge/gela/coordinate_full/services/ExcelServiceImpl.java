package ge.gela.coordinate_full.services;

import ge.gela.coordinate_full.entities.VehicleLocation;
import ge.gela.coordinate_full.entities.VehicleLocationHistory;
import ge.gela.coordinate_full.repositories.VehicleLocationHistoryRepository;
import ge.gela.coordinate_full.repositories.VehicleLocationRepository;
import ge.gela.coordinate_full.repositories.VehiclesRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelServiceImpl implements ExcelService {
   private final VehicleLocationRepository vehicleLocationRepository;
   private final VehicleServiceImpl vehicleServiceimpl;
   private final VehiclesRepository vehiclesRepository;
   private final VehicleLocationHistoryRepository vehicleLocationHistoryRepository;

      @Override
    public List<VehicleLocation> readExcelFile(InputStream inputStream) throws IOException {
        List<VehicleLocation> excelList = new ArrayList<>();
          List<String> dontFoundCars = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(inputStream)){
            Sheet sheet = workbook.getSheetAt(0);

            for(Row row : sheet){
                VehicleLocation vehicleLocation = new VehicleLocation();
                vehicleLocation.setLatitude(row.getCell(0).getNumericCellValue());
                vehicleLocation.setLongitude(row.getCell(1).getNumericCellValue());

                var carNum1 = row.getCell(2).getStringCellValue();
                var carId = vehiclesRepository.findAllByVehNum(carNum1);
                if(!carId.isEmpty()) {
                    var carId1 = carId.get(0).getVehId();

                    vehicleLocation.setVehId(carId1);

                    var history = new VehicleLocationHistory();
                    history.setLatitude(vehicleLocation.getLatitude());
                    history.setLongitude(vehicleLocation.getLongitude());
                    history.setVehId(carId1);
                    history.setIntime(LocalDateTime.now());
                    vehicleLocationHistoryRepository.save(history);
                } else
                { dontFoundCars.add(carNum1);}

                excelList.add(vehicleLocation);
            }
        }
        return excelList;
    }
    @Override
    public void saveDataToDatabase(List<VehicleLocation> ExcelList) {
            this.vehicleLocationRepository.saveAll(ExcelList);

    }


}
