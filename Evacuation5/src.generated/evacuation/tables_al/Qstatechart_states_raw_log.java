package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qstatechart_states_raw_log is a Querydsl query type for Qstatechart_states_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qstatechart_states_raw_log extends com.mysema.query.sql.RelationalPathBase<Qstatechart_states_raw_log> {

    private static final long serialVersionUID = 1553745205;

    public static final Qstatechart_states_raw_log INSTANCE = new Qstatechart_states_raw_log("statechart_states_raw_log");

    public final NumberPath<Integer> agent_id = createNumber("agent_id", Integer.class);

    public final DateTimePath<java.util.Date> entry_date = createDateTime("entry_date", java.util.Date.class);

    public final DateTimePath<java.util.Date> exit_date = createDateTime("exit_date", java.util.Date.class);

    public final NumberPath<Integer> state_id = createNumber("state_id", Integer.class);

    public final com.mysema.query.sql.ForeignKey<Qagent_type_elements_raw_log> STATECHART_STATES_STATE_REF = createForeignKey(state_id, "id");

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> STATECHART_STATES_AGENT_REF = createForeignKey(agent_id, "id");

    public Qstatechart_states_raw_log(String variable) {
        super(Qstatechart_states_raw_log.class, forVariable(variable), "PUBLIC", "statechart_states_raw_log");
        addMetadata();
    }

    public Qstatechart_states_raw_log(String variable, String schema, String table) {
        super(Qstatechart_states_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qstatechart_states_raw_log(Path<? extends Qstatechart_states_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "statechart_states_raw_log");
        addMetadata();
    }

    public Qstatechart_states_raw_log(PathMetadata<?> metadata) {
        super(Qstatechart_states_raw_log.class, metadata, "PUBLIC", "statechart_states_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent_id, ColumnMetadata.named("agent_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(entry_date, ColumnMetadata.named("entry_date").withIndex(3).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(exit_date, ColumnMetadata.named("exit_date").withIndex(4).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(state_id, ColumnMetadata.named("state_id").withIndex(2).ofType(Types.INTEGER).withSize(32));
    }

}

