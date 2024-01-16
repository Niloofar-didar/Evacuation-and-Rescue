package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qdatasets_log is a Querydsl query type for Qdatasets_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qdatasets_log extends com.mysema.query.sql.RelationalPathBase<Qdatasets_log> {

    private static final long serialVersionUID = -632506899;

    public static final Qdatasets_log INSTANCE = new Qdatasets_log("datasets_log");

    public final StringPath agent = createString("agent");

    public final StringPath agent_type = createString("agent_type");

    public final NumberPath<Integer> index = createNumber("index", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Double> x = createNumber("x", Double.class);

    public final NumberPath<Double> y = createNumber("y", Double.class);

    public Qdatasets_log(String variable) {
        super(Qdatasets_log.class, forVariable(variable), "PUBLIC", "datasets_log");
        addMetadata();
    }

    public Qdatasets_log(String variable, String schema, String table) {
        super(Qdatasets_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qdatasets_log(Path<? extends Qdatasets_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "datasets_log");
        addMetadata();
    }

    public Qdatasets_log(PathMetadata<?> metadata) {
        super(Qdatasets_log.class, metadata, "PUBLIC", "datasets_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent, ColumnMetadata.named("agent").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(agent_type, ColumnMetadata.named("agent_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(index, ColumnMetadata.named("index").withIndex(4).ofType(Types.INTEGER).withSize(32));
        addMetadata(name, ColumnMetadata.named("name").withIndex(3).ofType(Types.VARCHAR).withSize(255));
        addMetadata(x, ColumnMetadata.named("x").withIndex(5).ofType(Types.DOUBLE).withSize(64));
        addMetadata(y, ColumnMetadata.named("y").withIndex(6).ofType(Types.DOUBLE).withSize(64));
    }

}

