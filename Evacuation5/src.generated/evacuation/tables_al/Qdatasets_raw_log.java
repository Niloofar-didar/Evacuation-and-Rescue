package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qdatasets_raw_log is a Querydsl query type for Qdatasets_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qdatasets_raw_log extends com.mysema.query.sql.RelationalPathBase<Qdatasets_raw_log> {

    private static final long serialVersionUID = -24785706;

    public static final Qdatasets_raw_log INSTANCE = new Qdatasets_raw_log("datasets_raw_log");

    public final NumberPath<Integer> element_id = createNumber("element_id", Integer.class);

    public final NumberPath<Integer> index = createNumber("index", Integer.class);

    public final NumberPath<Double> x = createNumber("x", Double.class);

    public final NumberPath<Double> y = createNumber("y", Double.class);

    public final com.mysema.query.sql.ForeignKey<Qagent_elements_raw_log> DATASETS_ELEMENT_REF = createForeignKey(element_id, "id");

    public Qdatasets_raw_log(String variable) {
        super(Qdatasets_raw_log.class, forVariable(variable), "PUBLIC", "datasets_raw_log");
        addMetadata();
    }

    public Qdatasets_raw_log(String variable, String schema, String table) {
        super(Qdatasets_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qdatasets_raw_log(Path<? extends Qdatasets_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "datasets_raw_log");
        addMetadata();
    }

    public Qdatasets_raw_log(PathMetadata<?> metadata) {
        super(Qdatasets_raw_log.class, metadata, "PUBLIC", "datasets_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(element_id, ColumnMetadata.named("element_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(index, ColumnMetadata.named("index").withIndex(2).ofType(Types.INTEGER).withSize(32));
        addMetadata(x, ColumnMetadata.named("x").withIndex(3).ofType(Types.DOUBLE).withSize(64));
        addMetadata(y, ColumnMetadata.named("y").withIndex(4).ofType(Types.DOUBLE).withSize(64));
    }

}

