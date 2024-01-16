package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qflowchart_process_states_raw_log is a Querydsl query type for Qflowchart_process_states_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qflowchart_process_states_raw_log extends com.mysema.query.sql.RelationalPathBase<Qflowchart_process_states_raw_log> {

    private static final long serialVersionUID = 427733084;

    public static final Qflowchart_process_states_raw_log INSTANCE = new Qflowchart_process_states_raw_log("flowchart_process_states_raw_log");

    public final StringPath activity_type = createString("activity_type");

    public final NumberPath<Integer> agent_id = createNumber("agent_id", Integer.class);

    public final NumberPath<Integer> block_id = createNumber("block_id", Integer.class);

    public final DateTimePath<java.util.Date> start_date = createDateTime("start_date", java.util.Date.class);

    public final DateTimePath<java.util.Date> stop_date = createDateTime("stop_date", java.util.Date.class);

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> FLOWCHART_PROCESS_STATES_ENTITY_AGENT_REF = createForeignKey(agent_id, "id");

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> FLOWCHART_PROCESS_STATES_BLOCK_AGENT_REF = createForeignKey(block_id, "id");

    public Qflowchart_process_states_raw_log(String variable) {
        super(Qflowchart_process_states_raw_log.class, forVariable(variable), "PUBLIC", "flowchart_process_states_raw_log");
        addMetadata();
    }

    public Qflowchart_process_states_raw_log(String variable, String schema, String table) {
        super(Qflowchart_process_states_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qflowchart_process_states_raw_log(Path<? extends Qflowchart_process_states_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "flowchart_process_states_raw_log");
        addMetadata();
    }

    public Qflowchart_process_states_raw_log(PathMetadata<?> metadata) {
        super(Qflowchart_process_states_raw_log.class, metadata, "PUBLIC", "flowchart_process_states_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(activity_type, ColumnMetadata.named("activity_type").withIndex(3).ofType(Types.VARCHAR).withSize(20));
        addMetadata(agent_id, ColumnMetadata.named("agent_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(block_id, ColumnMetadata.named("block_id").withIndex(2).ofType(Types.INTEGER).withSize(32));
        addMetadata(start_date, ColumnMetadata.named("start_date").withIndex(4).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(stop_date, ColumnMetadata.named("stop_date").withIndex(5).ofType(Types.TIMESTAMP).withSize(26));
    }

}

