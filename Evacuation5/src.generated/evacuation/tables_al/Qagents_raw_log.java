package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagents_raw_log is a Querydsl query type for Qagents_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagents_raw_log extends com.mysema.query.sql.RelationalPathBase<Qagents_raw_log> {

    private static final long serialVersionUID = -515226583;

    public static final Qagents_raw_log INSTANCE = new Qagents_raw_log("agents_raw_log");

    public final NumberPath<Integer> agent_type_id = createNumber("agent_type_id", Integer.class);

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final com.mysema.query.sql.PrimaryKey<Qagents_raw_log> SYS_PK_10138 = createPrimaryKey(id);

    public final com.mysema.query.sql.ForeignKey<Qagent_types_raw_log> AGENT_TYPE_REF = createForeignKey(agent_type_id, "id");

    public final com.mysema.query.sql.ForeignKey<Qstatechart_transitions_raw_log> _STATECHART_AGENT_REF = createInvForeignKey(id, "agent_id");

    public final com.mysema.query.sql.ForeignKey<Qflowchart_process_states_raw_log> _FLOWCHART_PROCESS_STATES_BLOCK_AGENT_REF = createInvForeignKey(id, "block_id");

    public final com.mysema.query.sql.ForeignKey<Qresource_unit_states_raw_log> _RESOURCE_UNIT_STATES_UNIT_AGENT_REF = createInvForeignKey(id, "unit_id");

    public final com.mysema.query.sql.ForeignKey<Qagent_elements_raw_log> _ELEMENT_TO_AGENT_REF = createInvForeignKey(id, "agent_id");

    public final com.mysema.query.sql.ForeignKey<Qstatistics_raw_log> _STATISTICS_AGENT_REF = createInvForeignKey(id, "agent_id");

    public final com.mysema.query.sql.ForeignKey<Qflowchart_entries_raw_log> _FLOWCHART_ENTRIES_BLOCK_AGENT_REF = createInvForeignKey(id, "block_id");

    public final com.mysema.query.sql.ForeignKey<Qstatechart_states_raw_log> _STATECHART_STATES_AGENT_REF = createInvForeignKey(id, "agent_id");

    public final com.mysema.query.sql.ForeignKey<Qflowchart_process_states_raw_log> _FLOWCHART_PROCESS_STATES_ENTITY_AGENT_REF = createInvForeignKey(id, "agent_id");

    public final com.mysema.query.sql.ForeignKey<Qfluid_units_raw_log> _FLUID_UNITS_BLOCK_AGENT_REF = createInvForeignKey(id, "block_id");

    public final com.mysema.query.sql.ForeignKey<Qresource_pool_utilization_raw_log> _RESOURCE_POOL_UTILIZATION_POOL_AGENT_REF = createInvForeignKey(id, "pool_id");

    public final com.mysema.query.sql.ForeignKey<Qdestroyed_agents_raw_log> _DESTROYED_AGENT_REF = createInvForeignKey(id, "agent_id");

    public final com.mysema.query.sql.ForeignKey<Qresource_unit_states_raw_log> _RESOURCE_UNIT_STATES_AGENT_AGENT_REF = createInvForeignKey(id, "agent_id");

    public final com.mysema.query.sql.ForeignKey<Qagent_movement_raw_log> _MOVEMENT_AGENT_REF = createInvForeignKey(id, "agent_id");

    public final com.mysema.query.sql.ForeignKey<Qresource_unit_states_raw_log> _RESOURCE_UNIT_STATES_POOL_AGENT_REF = createInvForeignKey(id, "pool_id");

    public final com.mysema.query.sql.ForeignKey<Qflowchart_entries_raw_log> _FLOWCHART_ENTRIES_ENTITY_AGENT_REF = createInvForeignKey(id, "agent_id");

    public final com.mysema.query.sql.ForeignKey<Qagent_messages_raw_log> _MESSAGES_AGENT_REF = createInvForeignKey(id, "agent_id");

    public final com.mysema.query.sql.ForeignKey<Qresource_unit_states_raw_log> _RESOURCE_UNIT_STATES_TASK_AGENT_REF = createInvForeignKey(id, "task_id");

    public final com.mysema.query.sql.ForeignKey<Qtrace_raw_log> _TRACE_LOG_AGENT_REF = createInvForeignKey(id, "agent_id");

    public final com.mysema.query.sql.ForeignKey<Qresource_unit_utilization_raw_log> _RESOURCE_UNIT_UTILIZATION_UNIT_AGENT_REF = createInvForeignKey(id, "unit_id");

    public final com.mysema.query.sql.ForeignKey<Qfluid_storages_raw_log> _FLUID_STORAGES_BLOCK_AGENT_REF = createInvForeignKey(id, "block_id");

    public final com.mysema.query.sql.ForeignKey<Qagent_messages_raw_log> _MESSAGES_SENDER_AGENT_REF = createInvForeignKey(id, "sender_id");

    public final com.mysema.query.sql.ForeignKey<Qresource_unit_utilization_raw_log> _RESOURCE_UNIT_UTILIZATION_POOL_AGENT_REF = createInvForeignKey(id, "pool_id");

    public final com.mysema.query.sql.ForeignKey<Qfluid_utilization_raw_log> _FLUID_UTILIZATION_BLOCK_AGENT_REF = createInvForeignKey(id, "block_id");

    public final com.mysema.query.sql.ForeignKey<Qfluid_rates_raw_log> _FLUID_RATES_BLOCK_AGENT_REF = createInvForeignKey(id, "block_id");

    public final com.mysema.query.sql.ForeignKey<Qagent_parameters_raw_log> _AGENT_PARAMETERS_AGENT_REF = createInvForeignKey(id, "agent_id");

    public Qagents_raw_log(String variable) {
        super(Qagents_raw_log.class, forVariable(variable), "PUBLIC", "agents_raw_log");
        addMetadata();
    }

    public Qagents_raw_log(String variable, String schema, String table) {
        super(Qagents_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagents_raw_log(Path<? extends Qagents_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agents_raw_log");
        addMetadata();
    }

    public Qagents_raw_log(PathMetadata<?> metadata) {
        super(Qagents_raw_log.class, metadata, "PUBLIC", "agents_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent_type_id, ColumnMetadata.named("agent_type_id").withIndex(2).ofType(Types.INTEGER).withSize(32));
        addMetadata(date, ColumnMetadata.named("date").withIndex(4).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.INTEGER).withSize(32).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(3).ofType(Types.VARCHAR).withSize(255));
    }

}

