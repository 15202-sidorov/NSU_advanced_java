package lab1.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@Data
@EqualsAndHashCode(callSuper=false)
public class Relation extends OSMObject {
    private ArrayList<Member> members;

    @Data
    public static class Member {
        private String type;

        private int ref;

        private String role;
    }
}
