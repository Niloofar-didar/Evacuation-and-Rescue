package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qfluid_storages_log is a Querydsl query type for Qfluid_storages_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qfluid_storages_log extends com.mysema.query.sql.RelationalPathBase<Qfluid_storages_log> {

    private static final long serialVersionUID = -535727009;

    public static final Qfluid_storages_log INSTANCE = new Qfluid_storages_log("fluid_storages_log");

    public final NumberPath<Double> average = createNumber("average", Double.class);

    public final StringPath block = createString("block");

    public final StringPath block_type = createString("block_type");

    public final NumberPath<Double> maximum = createNumber("maximum", Double.class);

    public final NumberPath<Double> minimum = createNumber("minimum", Double.class);

    public Qfluid_storages_log(String variable) {
        super(Qfluid_storages_log.class, forVariable(variable), "PUBLIC", "fluid_storages_log");
        addMetadata();
    }

    public Qfluid_storages_log(String variable, String schema, String table) {
        super(Qfluid_storages_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qfluid_storages_log(Path<? extends Qfluid_storages_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "fluid_storages_log");
        addMetadata();
    }

    public Qfluid_storages_log(PathMetadata<?> metadata) {
        super(Qfluid_storages_log.class, metadata, "PUBLIC", "fluid_storages_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(average, ColumnMetadata.named("average").withIndex(5).ofType(Types.DOUBLE).withSize(64));
        addMetadata(block, ColumnMetadata.named("block").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(block_type, ColumnMetadata.named("block_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(maximum, ColumnMetadata.named("maximum").withIndex(4).ofType(Types.DOUBLE).withSize(64));
        addMetadata(minimum, ColumnMetadata.named("minimum").withIndex(3).ofType(Types.DOUBLE).withSize(64));
    }

}

