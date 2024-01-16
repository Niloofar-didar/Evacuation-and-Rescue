package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qstatistics_raw_log is a Querydsl query type for Qstatistics_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qstatistics_raw_log extends com.mysema.query.sql.RelationalPathBase<Qstatistics_raw_log> {

    private static final long serialVersionUID = -610610242;

    public static final Qstatistics_raw_log INSTANCE = new Qstatistics_raw_log("statistics_raw_log");

    public final NumberPath<Integer> agent_id = createNumber("agent_id", Integer.class);

    public final NumberPath<Double> deviation = createNumber("deviation", Double.class);

    public final NumberPath<Double> maximum = createNumber("maximum", Double.class);

    public final NumberPath<Double> mean = createNumber("mean", Double.class);

    public final NumberPath<Double> mean_confidence = createNumber("mean_confidence", Double.class);

    public final NumberPath<Double> minimum = createNumber("minimum", Double.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> number = createNumber("number", Integer.class);

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> STATISTICS_AGENT_REF = createForeignKey(agent_id, "id");

    public Qstatistics_raw_log(String variable) {
        super(Qstatistics_raw_log.class, forVariable(variable), "PUBLIC", "statistics_raw_log");
        addMetadata();
    }

    public Qstatistics_raw_log(String variable, String schema, String table) {
        super(Qstatistics_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qstatistics_raw_log(Path<? extends Qstatistics_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "statistics_raw_log");
        addMetadata();
    }

    public Qstatistics_raw_log(PathMetadata<?> metadata) {
        super(Qstatistics_raw_log.class, metadata, "PUBLIC", "statistics_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent_id, ColumnMetadata.named("agent_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(deviation, ColumnMetadata.named("deviation").withIndex(4).ofType(Types.DOUBLE).withSize(64));
        addMetadata(maximum, ColumnMetadata.named("maximum").withIndex(6).ofType(Types.DOUBLE).withSize(64));
        addMetadata(mean, ColumnMetadata.named("mean").withIndex(3).ofType(Types.DOUBLE).withSize(64));
        addMetadata(mean_confidence, ColumnMetadata.named("mean_confidence").withIndex(7).ofType(Types.DOUBLE).withSize(64));
        addMetadata(minimum, ColumnMetadata.named("minimum").withIndex(5).ofType(Types.DOUBLE).withSize(64));
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(255));
        addMetadata(number, ColumnMetadata.named("number").withIndex(8).ofType(Types.INTEGER).withSize(32));
    }

}

