package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qfluid_rates_raw_log is a Querydsl query type for Qfluid_rates_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qfluid_rates_raw_log extends com.mysema.query.sql.RelationalPathBase<Qfluid_rates_raw_log> {

    private static final long serialVersionUID = -499910209;

    public static final Qfluid_rates_raw_log INSTANCE = new Qfluid_rates_raw_log("fluid_rates_raw_log");

    public final NumberPath<Double> average = createNumber("average", Double.class);

    public final NumberPath<Integer> block_id = createNumber("block_id", Integer.class);

    public final NumberPath<Double> maximum = createNumber("maximum", Double.class);

    public final NumberPath<Double> minimum = createNumber("minimum", Double.class);

    public final StringPath port = createString("port");

    public final NumberPath<Double> total = createNumber("total", Double.class);

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> FLUID_RATES_BLOCK_AGENT_REF = createForeignKey(block_id, "id");

    public Qfluid_rates_raw_log(String variable) {
        super(Qfluid_rates_raw_log.class, forVariable(variable), "PUBLIC", "fluid_rates_raw_log");
        addMetadata();
    }

    public Qfluid_rates_raw_log(String variable, String schema, String table) {
        super(Qfluid_rates_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qfluid_rates_raw_log(Path<? extends Qfluid_rates_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "fluid_rates_raw_log");
        addMetadata();
    }

    public Qfluid_rates_raw_log(PathMetadata<?> metadata) {
        super(Qfluid_rates_raw_log.class, metadata, "PUBLIC", "fluid_rates_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(average, ColumnMetadata.named("average").withIndex(6).ofType(Types.DOUBLE).withSize(64));
        addMetadata(block_id, ColumnMetadata.named("block_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(maximum, ColumnMetadata.named("maximum").withIndex(5).ofType(Types.DOUBLE).withSize(64));
        addMetadata(minimum, ColumnMetadata.named("minimum").withIndex(4).ofType(Types.DOUBLE).withSize(64));
        addMetadata(port, ColumnMetadata.named("port").withIndex(2).ofType(Types.VARCHAR).withSize(20));
        addMetadata(total, ColumnMetadata.named("total").withIndex(3).ofType(Types.DOUBLE).withSize(64));
    }

}

