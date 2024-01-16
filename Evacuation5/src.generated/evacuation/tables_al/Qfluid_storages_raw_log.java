package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qfluid_storages_raw_log is a Querydsl query type for Qfluid_storages_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qfluid_storages_raw_log extends com.mysema.query.sql.RelationalPathBase<Qfluid_storages_raw_log> {

    private static final long serialVersionUID = -33422776;

    public static final Qfluid_storages_raw_log INSTANCE = new Qfluid_storages_raw_log("fluid_storages_raw_log");

    public final NumberPath<Double> average = createNumber("average", Double.class);

    public final NumberPath<Integer> block_id = createNumber("block_id", Integer.class);

    public final NumberPath<Double> maximum = createNumber("maximum", Double.class);

    public final NumberPath<Double> minimum = createNumber("minimum", Double.class);

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> FLUID_STORAGES_BLOCK_AGENT_REF = createForeignKey(block_id, "id");

    public Qfluid_storages_raw_log(String variable) {
        super(Qfluid_storages_raw_log.class, forVariable(variable), "PUBLIC", "fluid_storages_raw_log");
        addMetadata();
    }

    public Qfluid_storages_raw_log(String variable, String schema, String table) {
        super(Qfluid_storages_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qfluid_storages_raw_log(Path<? extends Qfluid_storages_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "fluid_storages_raw_log");
        addMetadata();
    }

    public Qfluid_storages_raw_log(PathMetadata<?> metadata) {
        super(Qfluid_storages_raw_log.class, metadata, "PUBLIC", "fluid_storages_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(average, ColumnMetadata.named("average").withIndex(4).ofType(Types.DOUBLE).withSize(64));
        addMetadata(block_id, ColumnMetadata.named("block_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(maximum, ColumnMetadata.named("maximum").withIndex(3).ofType(Types.DOUBLE).withSize(64));
        addMetadata(minimum, ColumnMetadata.named("minimum").withIndex(2).ofType(Types.DOUBLE).withSize(64));
    }

}

