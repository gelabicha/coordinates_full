package ge.gela.coordinate_full.models;

import java.sql.Timestamp;

public record HistoryCreateModel(Double latidude, Double longitude, Integer vehId, Timestamp intime) {
}
