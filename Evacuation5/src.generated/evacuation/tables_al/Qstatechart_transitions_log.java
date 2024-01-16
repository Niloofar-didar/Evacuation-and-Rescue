package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qstatechart_transitions_log is a Querydsl query type for Qstatechart_transitions_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qstatechart_transitions_log extends com.mysema.query.sql.RelationalPathBase<Qstatechart_transitions_log> {

    private static final long serialVersionUID = -1853374946;

    public static final Qstatechart_transitions_log INSTANCE = new Qstatechart_transitions_log("statechart_transitions_log");

    public final StringPath agent = createString("agent");

    public final StringPath agent_type = createString("agent_type");

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final StringPath from_state = createString("from_state");

    public final StringPath transition = createString("transition");

    public Qstatechart_transitions_log(String variable) {
        super(Qstatechart_transitions_log.class, forVariable(variable), "PUBLIC", "statechart_transitions_log");
        addMetadata();
    }

    public Qstatechart_transitions_log(String variable, String schema, String table) {
        super(Qstatechart_transitions_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qstatechart_transitions_log(Path<? extends Qstatechart_transitions_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "statechart_transitions_log");
        addMetadata();
    }

    public Qstatechart_transitions_log(PathMetadata<?> metadata) {
        super(Qstatechart_transitions_log.class, metadata, "PUBLIC", "statechart_transitions_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent, ColumnMetadata.named("agent").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(agent_type, ColumnMetadata.named("agent_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(date, ColumnMetadata.named("date").withIndex(5).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(from_state, ColumnMetadata.named("from_state").withIndex(4).ofType(Types.VARCHAR).withSize(255));
        addMetadata(transition, ColumnMetadata.named("transition").withIndex(3).ofType(Types.VARCHAR).withSize(255));
    }

}

