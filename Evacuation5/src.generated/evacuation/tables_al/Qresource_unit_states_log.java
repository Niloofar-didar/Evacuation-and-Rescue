package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qresource_unit_states_log is a Querydsl query type for Qresource_unit_states_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qresource_unit_states_log extends com.mysema.query.sql.RelationalPathBase<Qresource_unit_states_log> {

    private static final long serialVersionUID = -191712930;

    public static final Qresource_unit_states_log INSTANCE = new Qresource_unit_states_log("resource_unit_states_log");

    public final StringPath agent = createString("agent");

    public final StringPath agent_type = createString("agent_type");

    public final StringPath resource_pool = createString("resource_pool");

    public final DateTimePath<java.util.Date> start_date = createDateTime("start_date", java.util.Date.class);

    public final DateTimePath<java.util.Date> stop_date = createDateTime("stop_date", java.util.Date.class);

    public final StringPath task = createString("task");

    public final StringPath unit = createString("unit");

    public final StringPath unit_type = createString("unit_type");

    public final StringPath usage_state = createString("usage_state");

    public Qresource_unit_states_log(String variable) {
        super(Qresource_unit_states_log.class, forVariable(variable), "PUBLIC", "resource_unit_states_log");
        addMetadata();
    }

    public Qresource_unit_states_log(String variable, String schema, String table) {
        super(Qresource_unit_states_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qresource_unit_states_log(Path<? extends Qresource_unit_states_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "resource_unit_states_log");
        addMetadata();
    }

    public Qresource_unit_states_log(PathMetadata<?> metadata) {
        super(Qresource_unit_states_log.class, metadata, "PUBLIC", "resource_unit_states_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent, ColumnMetadata.named("agent").withIndex(7).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(agent_type, ColumnMetadata.named("agent_type").withIndex(6).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(resource_pool, ColumnMetadata.named("resource_pool").withIndex(3).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(start_date, ColumnMetadata.named("start_date").withIndex(8).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(stop_date, ColumnMetadata.named("stop_date").withIndex(9).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(task, ColumnMetadata.named("task").withIndex(5).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(unit, ColumnMetadata.named("unit").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(unit_type, ColumnMetadata.named("unit_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(usage_state, ColumnMetadata.named("usage_state").withIndex(4).ofType(Types.VARCHAR).withSize(20));
    }

}

