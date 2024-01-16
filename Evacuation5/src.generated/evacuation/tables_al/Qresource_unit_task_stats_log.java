package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qresource_unit_task_stats_log is a Querydsl query type for Qresource_unit_task_stats_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qresource_unit_task_stats_log extends com.mysema.query.sql.RelationalPathBase<Qresource_unit_task_stats_log> {

    private static final long serialVersionUID = 718281665;

    public static final Qresource_unit_task_stats_log INSTANCE = new Qresource_unit_task_stats_log("resource_unit_task_stats_log");

    public final NumberPath<Double> mean_seconds = createNumber("mean_seconds", Double.class);

    public final NumberPath<Long> n_tasks = createNumber("n_tasks", Long.class);

    public final StringPath resource_pool = createString("resource_pool");

    public final StringPath task = createString("task");

    public final NumberPath<Double> total_seconds = createNumber("total_seconds", Double.class);

    public final StringPath unit = createString("unit");

    public final StringPath unit_type = createString("unit_type");

    public Qresource_unit_task_stats_log(String variable) {
        super(Qresource_unit_task_stats_log.class, forVariable(variable), "PUBLIC", "resource_unit_task_stats_log");
        addMetadata();
    }

    public Qresource_unit_task_stats_log(String variable, String schema, String table) {
        super(Qresource_unit_task_stats_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qresource_unit_task_stats_log(Path<? extends Qresource_unit_task_stats_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "resource_unit_task_stats_log");
        addMetadata();
    }

    public Qresource_unit_task_stats_log(PathMetadata<?> metadata) {
        super(Qresource_unit_task_stats_log.class, metadata, "PUBLIC", "resource_unit_task_stats_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(mean_seconds, ColumnMetadata.named("mean_seconds").withIndex(5).ofType(Types.DOUBLE).withSize(64));
        addMetadata(n_tasks, ColumnMetadata.named("n_tasks").withIndex(7).ofType(Types.BIGINT).withSize(64));
        addMetadata(resource_pool, ColumnMetadata.named("resource_pool").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(task, ColumnMetadata.named("task").withIndex(4).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(total_seconds, ColumnMetadata.named("total_seconds").withIndex(6).ofType(Types.DOUBLE).withSize(64));
        addMetadata(unit, ColumnMetadata.named("unit").withIndex(3).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(unit_type, ColumnMetadata.named("unit_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
    }

}

