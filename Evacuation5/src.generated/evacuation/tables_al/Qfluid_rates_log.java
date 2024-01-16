package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qfluid_rates_log is a Querydsl query type for Qfluid_rates_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qfluid_rates_log extends com.mysema.query.sql.RelationalPathBase<Qfluid_rates_log> {

    private static final long serialVersionUID = -1159741610;

    public static final Qfluid_rates_log INSTANCE = new Qfluid_rates_log("fluid_rates_log");

    public final NumberPath<Double> average_rate = createNumber("average_rate", Double.class);

    public final StringPath block = createString("block");

    public final StringPath block_type = createString("block_type");

    public final NumberPath<Double> maximum_rate = createNumber("maximum_rate", Double.class);

    public final NumberPath<Double> minimum_rate = createNumber("minimum_rate", Double.class);

    public final StringPath port = createString("port");

    public final NumberPath<Double> total_amount = createNumber("total_amount", Double.class);

    public Qfluid_rates_log(String variable) {
        super(Qfluid_rates_log.class, forVariable(variable), "PUBLIC", "fluid_rates_log");
        addMetadata();
    }

    public Qfluid_rates_log(String variable, String schema, String table) {
        super(Qfluid_rates_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qfluid_rates_log(Path<? extends Qfluid_rates_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "fluid_rates_log");
        addMetadata();
    }

    public Qfluid_rates_log(PathMetadata<?> metadata) {
        super(Qfluid_rates_log.class, metadata, "PUBLIC", "fluid_rates_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(average_rate, ColumnMetadata.named("average_rate").withIndex(7).ofType(Types.DOUBLE).withSize(64));
        addMetadata(block, ColumnMetadata.named("block").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(block_type, ColumnMetadata.named("block_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(maximum_rate, ColumnMetadata.named("maximum_rate").withIndex(6).ofType(Types.DOUBLE).withSize(64));
        addMetadata(minimum_rate, ColumnMetadata.named("minimum_rate").withIndex(5).ofType(Types.DOUBLE).withSize(64));
        addMetadata(port, ColumnMetadata.named("port").withIndex(3).ofType(Types.VARCHAR).withSize(20));
        addMetadata(total_amount, ColumnMetadata.named("total_amount").withIndex(4).ofType(Types.DOUBLE).withSize(64));
    }

}

