package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qhistograms_log is a Querydsl query type for Qhistograms_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qhistograms_log extends com.mysema.query.sql.RelationalPathBase<Qhistograms_log> {

    private static final long serialVersionUID = 1652413761;

    public static final Qhistograms_log INSTANCE = new Qhistograms_log("histograms_log");

    public final StringPath agent = createString("agent");

    public final StringPath agent_type = createString("agent_type");

    public final NumberPath<Double> cdf = createNumber("cdf", Double.class);

    public final NumberPath<Double> end = createNumber("end", Double.class);

    public final StringPath name = createString("name");

    public final NumberPath<Double> pdf = createNumber("pdf", Double.class);

    public final NumberPath<Double> start = createNumber("start", Double.class);

    public Qhistograms_log(String variable) {
        super(Qhistograms_log.class, forVariable(variable), "PUBLIC", "histograms_log");
        addMetadata();
    }

    public Qhistograms_log(String variable, String schema, String table) {
        super(Qhistograms_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qhistograms_log(Path<? extends Qhistograms_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "histograms_log");
        addMetadata();
    }

    public Qhistograms_log(PathMetadata<?> metadata) {
        super(Qhistograms_log.class, metadata, "PUBLIC", "histograms_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent, ColumnMetadata.named("agent").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(agent_type, ColumnMetadata.named("agent_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(cdf, ColumnMetadata.named("cdf").withIndex(7).ofType(Types.DOUBLE).withSize(64));
        addMetadata(end, ColumnMetadata.named("end").withIndex(5).ofType(Types.DOUBLE).withSize(64));
        addMetadata(name, ColumnMetadata.named("name").withIndex(3).ofType(Types.VARCHAR).withSize(255));
        addMetadata(pdf, ColumnMetadata.named("pdf").withIndex(6).ofType(Types.DOUBLE).withSize(64));
        addMetadata(start, ColumnMetadata.named("start").withIndex(4).ofType(Types.DOUBLE).withSize(64));
    }

}

