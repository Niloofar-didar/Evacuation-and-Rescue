package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qevents_raw_log is a Querydsl query type for Qevents_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qevents_raw_log extends com.mysema.query.sql.RelationalPathBase<Qevents_raw_log> {

    private static final long serialVersionUID = 1651428404;

    public static final Qevents_raw_log INSTANCE = new Qevents_raw_log("events_raw_log");

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final NumberPath<Integer> event_id = createNumber("event_id", Integer.class);

    public final com.mysema.query.sql.ForeignKey<Qagent_type_elements_raw_log> EVENT_REF = createForeignKey(event_id, "id");

    public Qevents_raw_log(String variable) {
        super(Qevents_raw_log.class, forVariable(variable), "PUBLIC", "events_raw_log");
        addMetadata();
    }

    public Qevents_raw_log(String variable, String schema, String table) {
        super(Qevents_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qevents_raw_log(Path<? extends Qevents_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "events_raw_log");
        addMetadata();
    }

    public Qevents_raw_log(PathMetadata<?> metadata) {
        super(Qevents_raw_log.class, metadata, "PUBLIC", "events_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(date, ColumnMetadata.named("date").withIndex(2).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(event_id, ColumnMetadata.named("event_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
    }

}

