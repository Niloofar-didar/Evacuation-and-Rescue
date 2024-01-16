package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qflowchart_stats_time_in_state_log is a Querydsl query type for Qflowchart_stats_time_in_state_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qflowchart_stats_time_in_state_log extends com.mysema.query.sql.RelationalPathBase<Qflowchart_stats_time_in_state_log> {

    private static final long serialVersionUID = -1251035918;

    public static final Qflowchart_stats_time_in_state_log INSTANCE = new Qflowchart_stats_time_in_state_log("flowchart_stats_time_in_state_log");

    public final StringPath activity_type = createString("activity_type");

    public final StringPath block = createString("block");

    public final StringPath block_type = createString("block_type");

    public final NumberPath<Double> max_seconds = createNumber("max_seconds", Double.class);

    public final NumberPath<Double> mean_seconds = createNumber("mean_seconds", Double.class);

    public final NumberPath<Double> min_seconds = createNumber("min_seconds", Double.class);

    public final NumberPath<Long> n_agents = createNumber("n_agents", Long.class);

    public final NumberPath<Double> total_seconds = createNumber("total_seconds", Double.class);

    public Qflowchart_stats_time_in_state_log(String variable) {
        super(Qflowchart_stats_time_in_state_log.class, forVariable(variable), "PUBLIC", "flowchart_stats_time_in_state_log");
        addMetadata();
    }

    public Qflowchart_stats_time_in_state_log(String variable, String schema, String table) {
        super(Qflowchart_stats_time_in_state_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qflowchart_stats_time_in_state_log(Path<? extends Qflowchart_stats_time_in_state_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "flowchart_stats_time_in_state_log");
        addMetadata();
    }

    public Qflowchart_stats_time_in_state_log(PathMetadata<?> metadata) {
        super(Qflowchart_stats_time_in_state_log.class, metadata, "PUBLIC", "flowchart_stats_time_in_state_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(activity_type, ColumnMetadata.named("activity_type").withIndex(3).ofType(Types.VARCHAR).withSize(20));
        addMetadata(block, ColumnMetadata.named("block").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(block_type, ColumnMetadata.named("block_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(max_seconds, ColumnMetadata.named("max_seconds").withIndex(7).ofType(Types.DOUBLE).withSize(64));
        addMetadata(mean_seconds, ColumnMetadata.named("mean_seconds").withIndex(4).ofType(Types.DOUBLE).withSize(64));
        addMetadata(min_seconds, ColumnMetadata.named("min_seconds").withIndex(6).ofType(Types.DOUBLE).withSize(64));
        addMetadata(n_agents, ColumnMetadata.named("n_agents").withIndex(8).ofType(Types.BIGINT).withSize(64));
        addMetadata(total_seconds, ColumnMetadata.named("total_seconds").withIndex(5).ofType(Types.DOUBLE).withSize(64));
    }

}

