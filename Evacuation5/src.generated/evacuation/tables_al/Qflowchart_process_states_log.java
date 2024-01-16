package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qflowchart_process_states_log is a Querydsl query type for Qflowchart_process_states_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qflowchart_process_states_log extends com.mysema.query.sql.RelationalPathBase<Qflowchart_process_states_log> {

    private static final long serialVersionUID = -1918874509;

    public static final Qflowchart_process_states_log INSTANCE = new Qflowchart_process_states_log("flowchart_process_states_log");

    public final StringPath activity_type = createString("activity_type");

    public final StringPath agent = createString("agent");

    public final StringPath agent_type = createString("agent_type");

    public final StringPath block = createString("block");

    public final StringPath block_type = createString("block_type");

    public final DateTimePath<java.util.Date> start_date = createDateTime("start_date", java.util.Date.class);

    public final DateTimePath<java.util.Date> stop_date = createDateTime("stop_date", java.util.Date.class);

    public Qflowchart_process_states_log(String variable) {
        super(Qflowchart_process_states_log.class, forVariable(variable), "PUBLIC", "flowchart_process_states_log");
        addMetadata();
    }

    public Qflowchart_process_states_log(String variable, String schema, String table) {
        super(Qflowchart_process_states_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qflowchart_process_states_log(Path<? extends Qflowchart_process_states_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "flowchart_process_states_log");
        addMetadata();
    }

    public Qflowchart_process_states_log(PathMetadata<?> metadata) {
        super(Qflowchart_process_states_log.class, metadata, "PUBLIC", "flowchart_process_states_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(activity_type, ColumnMetadata.named("activity_type").withIndex(5).ofType(Types.VARCHAR).withSize(20));
        addMetadata(agent, ColumnMetadata.named("agent").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(agent_type, ColumnMetadata.named("agent_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(block, ColumnMetadata.named("block").withIndex(4).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(block_type, ColumnMetadata.named("block_type").withIndex(3).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(start_date, ColumnMetadata.named("start_date").withIndex(6).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(stop_date, ColumnMetadata.named("stop_date").withIndex(7).ofType(Types.TIMESTAMP).withSize(26));
    }

}

