package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qresource_unit_states_raw_log is a Querydsl query type for Qresource_unit_states_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qresource_unit_states_raw_log extends com.mysema.query.sql.RelationalPathBase<Qresource_unit_states_raw_log> {

    private static final long serialVersionUID = 1166976967;

    public static final Qresource_unit_states_raw_log INSTANCE = new Qresource_unit_states_raw_log("resource_unit_states_raw_log");

    public final NumberPath<Integer> agent_id = createNumber("agent_id", Integer.class);

    public final NumberPath<Integer> pool_id = createNumber("pool_id", Integer.class);

    public final DateTimePath<java.util.Date> start_date = createDateTime("start_date", java.util.Date.class);

    public final DateTimePath<java.util.Date> stop_date = createDateTime("stop_date", java.util.Date.class);

    public final NumberPath<Integer> task_id = createNumber("task_id", Integer.class);

    public final StringPath task_type = createString("task_type");

    public final NumberPath<Integer> unit_id = createNumber("unit_id", Integer.class);

    public final StringPath usage_state = createString("usage_state");

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> RESOURCE_UNIT_STATES_AGENT_AGENT_REF = createForeignKey(agent_id, "id");

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> RESOURCE_UNIT_STATES_POOL_AGENT_REF = createForeignKey(pool_id, "id");

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> RESOURCE_UNIT_STATES_UNIT_AGENT_REF = createForeignKey(unit_id, "id");

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> RESOURCE_UNIT_STATES_TASK_AGENT_REF = createForeignKey(task_id, "id");

    public Qresource_unit_states_raw_log(String variable) {
        super(Qresource_unit_states_raw_log.class, forVariable(variable), "PUBLIC", "resource_unit_states_raw_log");
        addMetadata();
    }

    public Qresource_unit_states_raw_log(String variable, String schema, String table) {
        super(Qresource_unit_states_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qresource_unit_states_raw_log(Path<? extends Qresource_unit_states_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "resource_unit_states_raw_log");
        addMetadata();
    }

    public Qresource_unit_states_raw_log(PathMetadata<?> metadata) {
        super(Qresource_unit_states_raw_log.class, metadata, "PUBLIC", "resource_unit_states_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent_id, ColumnMetadata.named("agent_id").withIndex(5).ofType(Types.INTEGER).withSize(32));
        addMetadata(pool_id, ColumnMetadata.named("pool_id").withIndex(2).ofType(Types.INTEGER).withSize(32));
        addMetadata(start_date, ColumnMetadata.named("start_date").withIndex(7).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(stop_date, ColumnMetadata.named("stop_date").withIndex(8).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(task_id, ColumnMetadata.named("task_id").withIndex(6).ofType(Types.INTEGER).withSize(32));
        addMetadata(task_type, ColumnMetadata.named("task_type").withIndex(4).ofType(Types.VARCHAR).withSize(20));
        addMetadata(unit_id, ColumnMetadata.named("unit_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(usage_state, ColumnMetadata.named("usage_state").withIndex(3).ofType(Types.VARCHAR).withSize(20));
    }

}

