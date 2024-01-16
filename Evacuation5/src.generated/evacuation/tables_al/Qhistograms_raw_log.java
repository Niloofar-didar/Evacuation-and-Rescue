package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qhistograms_raw_log is a Querydsl query type for Qhistograms_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qhistograms_raw_log extends com.mysema.query.sql.RelationalPathBase<Qhistograms_raw_log> {

    private static final long serialVersionUID = -1079041494;

    public static final Qhistograms_raw_log INSTANCE = new Qhistograms_raw_log("histograms_raw_log");

    public final NumberPath<Double> cdf = createNumber("cdf", Double.class);

    public final NumberPath<Integer> element_id = createNumber("element_id", Integer.class);

    public final NumberPath<Double> end = createNumber("end", Double.class);

    public final NumberPath<Double> pdf = createNumber("pdf", Double.class);

    public final NumberPath<Double> start = createNumber("start", Double.class);

    public final com.mysema.query.sql.ForeignKey<Qagent_elements_raw_log> HISTOGRAMS_ELEMENT_REF = createForeignKey(element_id, "id");

    public Qhistograms_raw_log(String variable) {
        super(Qhistograms_raw_log.class, forVariable(variable), "PUBLIC", "histograms_raw_log");
        addMetadata();
    }

    public Qhistograms_raw_log(String variable, String schema, String table) {
        super(Qhistograms_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qhistograms_raw_log(Path<? extends Qhistograms_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "histograms_raw_log");
        addMetadata();
    }

    public Qhistograms_raw_log(PathMetadata<?> metadata) {
        super(Qhistograms_raw_log.class, metadata, "PUBLIC", "histograms_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(cdf, ColumnMetadata.named("cdf").withIndex(5).ofType(Types.DOUBLE).withSize(64));
        addMetadata(element_id, ColumnMetadata.named("element_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(end, ColumnMetadata.named("end").withIndex(3).ofType(Types.DOUBLE).withSize(64));
        addMetadata(pdf, ColumnMetadata.named("pdf").withIndex(4).ofType(Types.DOUBLE).withSize(64));
        addMetadata(start, ColumnMetadata.named("start").withIndex(2).ofType(Types.DOUBLE).withSize(64));
    }

}

