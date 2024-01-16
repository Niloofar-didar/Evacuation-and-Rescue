package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qfluid_units_log is a Querydsl query type for Qfluid_units_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qfluid_units_log extends com.mysema.query.sql.RelationalPathBase<Qfluid_units_log> {

    private static final long serialVersionUID = -1848608462;

    public static final Qfluid_units_log INSTANCE = new Qfluid_units_log("fluid_units_log");

    public final StringPath amount_units = createString("amount_units");

    public final StringPath block = createString("block");

    public final StringPath block_type = createString("block_type");

    public final StringPath rate_units = createString("rate_units");

    public Qfluid_units_log(String variable) {
        super(Qfluid_units_log.class, forVariable(variable), "PUBLIC", "fluid_units_log");
        addMetadata();
    }

    public Qfluid_units_log(String variable, String schema, String table) {
        super(Qfluid_units_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qfluid_units_log(Path<? extends Qfluid_units_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "fluid_units_log");
        addMetadata();
    }

    public Qfluid_units_log(PathMetadata<?> metadata) {
        super(Qfluid_units_log.class, metadata, "PUBLIC", "fluid_units_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(amount_units, ColumnMetadata.named("amount_units").withIndex(3).ofType(Types.VARCHAR).withSize(20));
        addMetadata(block, ColumnMetadata.named("block").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(block_type, ColumnMetadata.named("block_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(rate_units, ColumnMetadata.named("rate_units").withIndex(4).ofType(Types.VARCHAR).withSize(20));
    }

}

