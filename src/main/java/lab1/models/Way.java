package lab1.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@Data
@EqualsAndHashCode(callSuper=false)
public class Way extends OSMObject {
    private ArrayList<Integer> nodes;
}
