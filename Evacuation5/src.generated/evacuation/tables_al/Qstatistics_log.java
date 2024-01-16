package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qstatistics_log is a Querydsl query type for Qstatistics_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qstatistics_log extends com.mysema.query.sql.RelationalPathBase<Qstatistics_log> {

    private static final long serialVersionUID = 1804169429;

    public static final Qstatistics_log INSTANCE = new Qstatistics_log("statistics_log");

    public final StringPath agent = createString("agent");

    public final StringPath agent_type = createString("agent_type");

    public final NumberPath<Double> deviation = createNumber("deviation", Double.class);

    public final NumberPath<Double> maximum = createNumber("maximum", Double.class);

    public final NumberPath<Double> mean = createNumber("mean", Double.class);

    public final NumberPath<Double> mean_confidence = createNumber("mean_confidence", Double.class);

    public final NumberPath<Double> minimum = createNumber("minimum", Double.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> number = createNumber("number", Integer.class);

    public Qstatistics_log(String variable) {
        super(Qstatistics_log.class, forVariable(variable), "PUBLIC", "statistics_log");
        addMetadata();
    }

    public Qstatistics_log(String variable, String schema, String table) {
        super(Qstatistics_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qstatistics_log(Path<? extends Qstatistics_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "statistics_log");
        addMetadata();
    }

    public Qstatistics_log(PathMetadata<?> metadata) {
        super(Qstatistics_log.class, metadata, "PUBLIC", "statistics_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent, ColumnMetadata.named("agent").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(agent_type, ColumnMetadata.named("agent_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(deviation, ColumnMetadata.named("deviation").withIndex(5).ofType(Types.DOUBLE).withSize(64));
        addMetadata(maximum, ColumnMetadata.named("maximum").withIndex(7).ofType(Types.DOUBLE).withSize(64));
        addMetadata(mean, ColumnMetadata.named("mean").withIndex(4).ofType(Types.DOUBLE).withSize(64));
        addMetadata(mean_confidence, ColumnMetadata.named("mean_confidence").withIndex(8).ofType(Types.DOUBLE).withSize(64));
        addMetadata(minimum, ColumnMetadata.named("minimum").withIndex(6).ofType(Types.DOUBLE).withSize(64));
        addMetadata(name, ColumnMetadata.named("name").withIndex(3).ofType(Types.VARCHAR).withSize(255));
        addMetadata(number, ColumnMetadata.named("number").withIndex(9).ofType(Types.INTEGER).withSize(32));
    }

}

