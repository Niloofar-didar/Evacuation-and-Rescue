package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qevents_log is a Querydsl query type for Qevents_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qevents_log extends com.mysema.query.sql.RelationalPathBase<Qevents_log> {

    private static final long serialVersionUID = 1374164043;

    public static final Qevents_log INSTANCE = new Qevents_log("events_log");

    public final StringPath agent = createString("agent");

    public final StringPath agent_type = createString("agent_type");

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final StringPath event_name = createString("event_name");

    public Qevents_log(String variable) {
        super(Qevents_log.class, forVariable(variable), "PUBLIC", "events_log");
        addMetadata();
    }

    public Qevents_log(String variable, String schema, String table) {
        super(Qevents_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qevents_log(Path<? extends Qevents_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "events_log");
        addMetadata();
    }

    public Qevents_log(PathMetadata<?> metadata) {
        super(Qevents_log.class, metadata, "PUBLIC", "events_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent, ColumnMetadata.named("agent").withIndex(4).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(agent_type, ColumnMetadata.named("agent_type").withIndex(3).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(date, ColumnMetadata.named("date").withIndex(2).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(event_name, ColumnMetadata.named("event_name").withIndex(1).ofType(Types.VARCHAR).withSize(255));
    }

}

