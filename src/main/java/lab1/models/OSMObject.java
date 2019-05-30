package lab1.models;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLHStoreType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@TypeDef(name = "hstore", typeClass = PostgreSQLHStoreType.class)
public class OSMObject {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private Long version;

    @Column
    private Timestamp timestamp;

    @Column
    private Long changeset;

    @Column
    private Long uid;

    @Column
    private String username;

    @Type(type = "hstore")
    @Column(columnDefinition = "hstore")
    private Map<String, String> tags;

    public boolean setBaseAttribute(String value, String attributeName) {
        switch(attributeName) {
            case "id":
                this.setId(Long.parseLong(value));
                break;
            case "version":
                this.setVersion(Long.parseLong(value));
                break;
            case "timestamp":
                this.setTimestamp(this.readTimestamp(value));
                break;
            case "changeset":
                this.setChangeset(Long.parseLong(value));
                break;
            case "uid":
                this.setUid(Long.parseLong(value));
                break;
            case "user":
                this.setUsername(value);
                break;
            default:
                return false;
        }

        return true;
    }

    private Timestamp readTimestamp(String data) {
        StringBuilder timestampBuilder = new StringBuilder();

        for (int i = 0; i < data.length() - 1; i++) {
            char curSymbol = data.charAt(i);

            if (curSymbol == 'T') {
                timestampBuilder.append(' ');
                continue;
            }

            timestampBuilder.append(curSymbol);
        }

        return Timestamp.valueOf(timestampBuilder.toString());
    }
}
