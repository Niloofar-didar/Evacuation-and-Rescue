package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagent_statechart_states_log is a Querydsl query type for Qagent_statechart_states_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagent_statechart_states_log extends com.mysema.query.sql.RelationalPathBase<Qagent_statechart_states_log> {

    private static final long serialVersionUID = 888530386;

    public static final Qagent_statechart_states_log INSTANCE = new Qagent_statechart_states_log("agent_statechart_states_log");

    public final StringPath agent = createString("agent");

    public final StringPath agent_type = createString("agent_type");

    public final DateTimePath<java.util.Date> entry_date = createDateTime("entry_date", java.util.Date.class);

    public final DateTimePath<java.util.Date> exit_date = createDateTime("exit_date", java.util.Date.class);

    public final StringPath state = createString("state");

    public final StringPath statechart = createString("statechart");

    public Qagent_statechart_states_log(String variable) {
        super(Qagent_statechart_states_log.class, forVariable(variable), "PUBLIC", "agent_statechart_states_log");
        addMetadata();
    }

    public Qagent_statechart_states_log(String variable, String schema, String table) {
        super(Qagent_statechart_states_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagent_statechart_states_log(Path<? extends Qagent_statechart_states_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agent_statechart_states_log");
        addMetadata();
    }

    public Qagent_statechart_states_log(PathMetadata<?> metadata) {
        super(Qagent_statechart_states_log.class, metadata, "PUBLIC", "agent_statechart_states_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent, ColumnMetadata.named("agent").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(agent_type, ColumnMetadata.named("agent_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(entry_date, ColumnMetadata.named("entry_date").withIndex(5).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(exit_date, ColumnMetadata.named("exit_date").withIndex(6).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(state, ColumnMetadata.named("state").withIndex(4).ofType(Types.VARCHAR).withSize(255));
        addMetadata(statechart, ColumnMetadata.named("statechart").withIndex(3).ofType(Types.VARCHAR).withSize(255));
    }

}

