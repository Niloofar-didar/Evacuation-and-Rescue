package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagent_movement_log is a Querydsl query type for Qagent_movement_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagent_movement_log extends com.mysema.query.sql.RelationalPathBase<Qagent_movement_log> {

    private static final long serialVersionUID = -805244197;

    public static final Qagent_movement_log INSTANCE = new Qagent_movement_log("agent_movement_log");

    public final StringPath agent = createString("agent");

    public final NumberPath<Double> speed = createNumber("speed", Double.class);

    public final DateTimePath<java.util.Date> start_date = createDateTime("start_date", java.util.Date.class);

    public final DateTimePath<java.util.Date> stop_date = createDateTime("stop_date", java.util.Date.class);

    public final StringPath type = createString("type");

    public Qagent_movement_log(String variable) {
        super(Qagent_movement_log.class, forVariable(variable), "PUBLIC", "agent_movement_log");
        addMetadata();
    }

    public Qagent_movement_log(String variable, String schema, String table) {
        super(Qagent_movement_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagent_movement_log(Path<? extends Qagent_movement_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agent_movement_log");
        addMetadata();
    }

    public Qagent_movement_log(PathMetadata<?> metadata) {
        super(Qagent_movement_log.class, metadata, "PUBLIC", "agent_movement_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent, ColumnMetadata.named("agent").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(speed, ColumnMetadata.named("speed").withIndex(3).ofType(Types.DOUBLE).withSize(64));
        addMetadata(start_date, ColumnMetadata.named("start_date").withIndex(4).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(stop_date, ColumnMetadata.named("stop_date").withIndex(5).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(type, ColumnMetadata.named("type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
    }

}

