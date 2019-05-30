package lab1.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ParseInfo {
    private double totalTime;
    private double totalParseTime;

    private double totalObjects;

    public ParseInfo(double totalTime, double totalParseTime, double totalObjects) {
        this.totalTime = totalTime;
        this.totalParseTime = totalParseTime;
        this.totalObjects = totalObjects;
    }
}
