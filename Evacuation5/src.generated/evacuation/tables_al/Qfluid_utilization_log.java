package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qfluid_utilization_log is a Querydsl query type for Qfluid_utilization_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qfluid_utilization_log extends com.mysema.query.sql.RelationalPathBase<Qfluid_utilization_log> {

    private static final long serialVersionUID = -215664667;

    public static final Qfluid_utilization_log INSTANCE = new Qfluid_utilization_log("fluid_utilization_log");

    public final StringPath block = createString("block");

    public final StringPath block_type = createString("block_type");

    public final NumberPath<Double> utilization = createNumber("utilization", Double.class);

    public Qfluid_utilization_log(String variable) {
        super(Qfluid_utilization_log.class, forVariable(variable), "PUBLIC", "fluid_utilization_log");
        addMetadata();
    }

    public Qfluid_utilization_log(String variable, String schema, String table) {
        super(Qfluid_utilization_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qfluid_utilization_log(Path<? extends Qfluid_utilization_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "fluid_utilization_log");
        addMetadata();
    }

    public Qfluid_utilization_log(PathMetadata<?> metadata) {
        super(Qfluid_utilization_log.class, metadata, "PUBLIC", "fluid_utilization_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(block, ColumnMetadata.named("block").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(block_type, ColumnMetadata.named("block_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(utilization, ColumnMetadata.named("utilization").withIndex(3).ofType(Types.DOUBLE).withSize(64));
    }

}

