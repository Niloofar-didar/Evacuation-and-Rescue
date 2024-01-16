package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qfluid_units_raw_log is a Querydsl query type for Qfluid_units_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qfluid_units_raw_log extends com.mysema.query.sql.RelationalPathBase<Qfluid_units_raw_log> {

    private static final long serialVersionUID = -63150693;

    public static final Qfluid_units_raw_log INSTANCE = new Qfluid_units_raw_log("fluid_units_raw_log");

    public final StringPath amount_units = createString("amount_units");

    public final NumberPath<Integer> block_id = createNumber("block_id", Integer.class);

    public final StringPath rate_units = createString("rate_units");

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> FLUID_UNITS_BLOCK_AGENT_REF = createForeignKey(block_id, "id");

    public Qfluid_units_raw_log(String variable) {
        super(Qfluid_units_raw_log.class, forVariable(variable), "PUBLIC", "fluid_units_raw_log");
        addMetadata();
    }

    public Qfluid_units_raw_log(String variable, String schema, String table) {
        super(Qfluid_units_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qfluid_units_raw_log(Path<? extends Qfluid_units_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "fluid_units_raw_log");
        addMetadata();
    }

    public Qfluid_units_raw_log(PathMetadata<?> metadata) {
        super(Qfluid_units_raw_log.class, metadata, "PUBLIC", "fluid_units_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(amount_units, ColumnMetadata.named("amount_units").withIndex(2).ofType(Types.VARCHAR).withSize(20));
        addMetadata(block_id, ColumnMetadata.named("block_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(rate_units, ColumnMetadata.named("rate_units").withIndex(3).ofType(Types.VARCHAR).withSize(20));
    }

}

