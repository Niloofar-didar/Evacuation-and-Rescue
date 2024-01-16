package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagent_movement_raw_log is a Querydsl query type for Qagent_movement_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagent_movement_raw_log extends com.mysema.query.sql.RelationalPathBase<Qagent_movement_raw_log> {

    private static final long serialVersionUID = 1423303364;

    public static final Qagent_movement_raw_log INSTANCE = new Qagent_movement_raw_log("agent_movement_raw_log");

    public final NumberPath<Integer> agent_id = createNumber("agent_id", Integer.class);

    public final NumberPath<Double> speed = createNumber("speed", Double.class);

    public final DateTimePath<java.util.Date> start_date = createDateTime("start_date", java.util.Date.class);

    public final DateTimePath<java.util.Date> stop_date = createDateTime("stop_date", java.util.Date.class);

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> MOVEMENT_AGENT_REF = createForeignKey(agent_id, "id");

    public Qagent_movement_raw_log(String variable) {
        super(Qagent_movement_raw_log.class, forVariable(variable), "PUBLIC", "agent_movement_raw_log");
        addMetadata();
    }

    public Qagent_movement_raw_log(String variable, String schema, String table) {
        super(Qagent_movement_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagent_movement_raw_log(Path<? extends Qagent_movement_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agent_movement_raw_log");
        addMetadata();
    }

    public Qagent_movement_raw_log(PathMetadata<?> metadata) {
        super(Qagent_movement_raw_log.class, metadata, "PUBLIC", "agent_movement_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent_id, ColumnMetadata.named("agent_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(speed, ColumnMetadata.named("speed").withIndex(2).ofType(Types.DOUBLE).withSize(64));
        addMetadata(start_date, ColumnMetadata.named("start_date").withIndex(3).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(stop_date, ColumnMetadata.named("stop_date").withIndex(4).ofType(Types.TIMESTAMP).withSize(26));
    }

}

