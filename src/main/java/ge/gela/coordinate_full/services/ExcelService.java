package ge.gela.coordinate_full.services;

import ge.gela.coordinate_full.entities.VehicleLocation;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service

public interface ExcelService {


    List<VehicleLocation> readExcelFile(InputStream inputStream) throws IOException;

    void saveDataToDatabase(List<VehicleLocation> excelList);
}
