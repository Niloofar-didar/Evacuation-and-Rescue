package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qfluid_utilization_raw_log is a Querydsl query type for Qfluid_utilization_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qfluid_utilization_raw_log extends com.mysema.query.sql.RelationalPathBase<Qfluid_utilization_raw_log> {

    private static final long serialVersionUID = 316445390;

    public static final Qfluid_utilization_raw_log INSTANCE = new Qfluid_utilization_raw_log("fluid_utilization_raw_log");

    public final NumberPath<Integer> block_id = createNumber("block_id", Integer.class);

    public final NumberPath<Double> utilization = createNumber("utilization", Double.class);

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> FLUID_UTILIZATION_BLOCK_AGENT_REF = createForeignKey(block_id, "id");

    public Qfluid_utilization_raw_log(String variable) {
        super(Qfluid_utilization_raw_log.class, forVariable(variable), "PUBLIC", "fluid_utilization_raw_log");
        addMetadata();
    }

    public Qfluid_utilization_raw_log(String variable, String schema, String table) {
        super(Qfluid_utilization_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qfluid_utilization_raw_log(Path<? extends Qfluid_utilization_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "fluid_utilization_raw_log");
        addMetadata();
    }

    public Qfluid_utilization_raw_log(PathMetadata<?> metadata) {
        super(Qfluid_utilization_raw_log.class, metadata, "PUBLIC", "fluid_utilization_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(block_id, ColumnMetadata.named("block_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(utilization, ColumnMetadata.named("utilization").withIndex(2).ofType(Types.DOUBLE).withSize(64));
    }

}

