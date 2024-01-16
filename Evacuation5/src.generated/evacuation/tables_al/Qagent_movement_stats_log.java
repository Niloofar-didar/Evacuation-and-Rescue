package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagent_movement_stats_log is a Querydsl query type for Qagent_movement_stats_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagent_movement_stats_log extends com.mysema.query.sql.RelationalPathBase<Qagent_movement_stats_log> {

    private static final long serialVersionUID = 1498100219;

    public static final Qagent_movement_stats_log INSTANCE = new Qagent_movement_stats_log("agent_movement_stats_log");

    public final StringPath agent = createString("agent");

    public final NumberPath<Double> avg_speed_mps = createNumber("avg_speed_mps", Double.class);

    public final NumberPath<Double> total_meters = createNumber("total_meters", Double.class);

    public final NumberPath<Double> total_seconds = createNumber("total_seconds", Double.class);

    public final StringPath type = createString("type");

    public Qagent_movement_stats_log(String variable) {
        super(Qagent_movement_stats_log.class, forVariable(variable), "PUBLIC", "agent_movement_stats_log");
        addMetadata();
    }

    public Qagent_movement_stats_log(String variable, String schema, String table) {
        super(Qagent_movement_stats_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagent_movement_stats_log(Path<? extends Qagent_movement_stats_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agent_movement_stats_log");
        addMetadata();
    }

    public Qagent_movement_stats_log(PathMetadata<?> metadata) {
        super(Qagent_movement_stats_log.class, metadata, "PUBLIC", "agent_movement_stats_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent, ColumnMetadata.named("agent").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(avg_speed_mps, ColumnMetadata.named("avg_speed_mps").withIndex(5).ofType(Types.DOUBLE).withSize(64));
        addMetadata(total_meters, ColumnMetadata.named("total_meters").withIndex(3).ofType(Types.DOUBLE).withSize(64));
        addMetadata(total_seconds, ColumnMetadata.named("total_seconds").withIndex(4).ofType(Types.DOUBLE).withSize(64));
        addMetadata(type, ColumnMetadata.named("type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
    }

}

