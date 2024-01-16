package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagent_type_elements_raw_log is a Querydsl query type for Qagent_type_elements_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagent_type_elements_raw_log extends com.mysema.query.sql.RelationalPathBase<Qagent_type_elements_raw_log> {

    private static final long serialVersionUID = -612453757;

    public static final Qagent_type_elements_raw_log INSTANCE = new Qagent_type_elements_raw_log("agent_type_elements_raw_log");

    public final NumberPath<Integer> agent_type_id = createNumber("agent_type_id", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final com.mysema.query.sql.PrimaryKey<Qagent_type_elements_raw_log> SYS_PK_10148 = createPrimaryKey(id);

    public final com.mysema.query.sql.ForeignKey<Qagent_types_raw_log> ELEMENT_TO_AGENT_TYPE_REF = createForeignKey(agent_type_id, "id");

    public final com.mysema.query.sql.ForeignKey<Qagent_type_statecharts_raw_log> _STATECHARTS_STATECHART_TO_ELEMENT_REF = createInvForeignKey(id, "statechart_id");

    public final com.mysema.query.sql.ForeignKey<Qstatechart_states_raw_log> _STATECHART_STATES_STATE_REF = createInvForeignKey(id, "state_id");

    public final com.mysema.query.sql.ForeignKey<Qstatechart_transitions_raw_log> _FROM_STATE_REF = createInvForeignKey(id, "from_state_id");

    public final com.mysema.query.sql.ForeignKey<Qstatechart_transitions_raw_log> _TRANSITION_REF = createInvForeignKey(id, "transition_id");

    public final com.mysema.query.sql.ForeignKey<Qagent_type_statecharts_raw_log> _STATECHARTS_ELEMENT_TO_ELEMENT_REF = createInvForeignKey(id, "element_id");

    public final com.mysema.query.sql.ForeignKey<Qevents_raw_log> _EVENT_REF = createInvForeignKey(id, "event_id");

    public Qagent_type_elements_raw_log(String variable) {
        super(Qagent_type_elements_raw_log.class, forVariable(variable), "PUBLIC", "agent_type_elements_raw_log");
        addMetadata();
    }

    public Qagent_type_elements_raw_log(String variable, String schema, String table) {
        super(Qagent_type_elements_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagent_type_elements_raw_log(Path<? extends Qagent_type_elements_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agent_type_elements_raw_log");
        addMetadata();
    }

    public Qagent_type_elements_raw_log(PathMetadata<?> metadata) {
        super(Qagent_type_elements_raw_log.class, metadata, "PUBLIC", "agent_type_elements_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent_type_id, ColumnMetadata.named("agent_type_id").withIndex(2).ofType(Types.INTEGER).withSize(32));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.INTEGER).withSize(32).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(3).ofType(Types.VARCHAR).withSize(255));
    }

}

