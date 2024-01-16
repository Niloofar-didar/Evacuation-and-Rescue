package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagent_statechart_stats_log is a Querydsl query type for Qagent_statechart_stats_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagent_statechart_stats_log extends com.mysema.query.sql.RelationalPathBase<Qagent_statechart_stats_log> {

    private static final long serialVersionUID = 1980670969;

    public static final Qagent_statechart_stats_log INSTANCE = new Qagent_statechart_stats_log("agent_statechart_stats_log");

    public final StringPath agent = createString("agent");

    public final StringPath agent_type = createString("agent_type");

    public final NumberPath<Double> mean_seconds = createNumber("mean_seconds", Double.class);

    public final NumberPath<Long> n_entries = createNumber("n_entries", Long.class);

    public final StringPath state = createString("state");

    public final StringPath statechart = createString("statechart");

    public final NumberPath<Double> total_seconds = createNumber("total_seconds", Double.class);

    public Qagent_statechart_stats_log(String variable) {
        super(Qagent_statechart_stats_log.class, forVariable(variable), "PUBLIC", "agent_statechart_stats_log");
        addMetadata();
    }

    public Qagent_statechart_stats_log(String variable, String schema, String table) {
        super(Qagent_statechart_stats_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagent_statechart_stats_log(Path<? extends Qagent_statechart_stats_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agent_statechart_stats_log");
        addMetadata();
    }

    public Qagent_statechart_stats_log(PathMetadata<?> metadata) {
        super(Qagent_statechart_stats_log.class, metadata, "PUBLIC", "agent_statechart_stats_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent, ColumnMetadata.named("agent").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(agent_type, ColumnMetadata.named("agent_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(mean_seconds, ColumnMetadata.named("mean_seconds").withIndex(5).ofType(Types.DOUBLE).withSize(64));
        addMetadata(n_entries, ColumnMetadata.named("n_entries").withIndex(7).ofType(Types.BIGINT).withSize(64));
        addMetadata(state, ColumnMetadata.named("state").withIndex(4).ofType(Types.VARCHAR).withSize(255));
        addMetadata(statechart, ColumnMetadata.named("statechart").withIndex(3).ofType(Types.VARCHAR).withSize(255));
        addMetadata(total_seconds, ColumnMetadata.named("total_seconds").withIndex(6).ofType(Types.DOUBLE).withSize(64));
    }

}

