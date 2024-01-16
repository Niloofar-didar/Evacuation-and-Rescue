package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qhelperrr is a Querydsl query type for Qhelperrr
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qhelperrr extends com.mysema.query.sql.RelationalPathBase<Qhelperrr> {

    private static final long serialVersionUID = 560850651;

    public static final Qhelperrr INSTANCE = new Qhelperrr("helperrr");

    public final NumberPath<Integer> al_id = createNumber("al_id", Integer.class);

    public final NumberPath<Double> timee = createNumber("timee", Double.class);

    public final com.mysema.query.sql.PrimaryKey<Qhelperrr> SYS_PK_10133 = createPrimaryKey(al_id);

    public Qhelperrr(String variable) {
        super(Qhelperrr.class, forVariable(variable), "PUBLIC", "helperrr");
        addMetadata();
    }

    public Qhelperrr(String variable, String schema, String table) {
        super(Qhelperrr.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qhelperrr(Path<? extends Qhelperrr> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "helperrr");
        addMetadata();
    }

    public Qhelperrr(PathMetadata<?> metadata) {
        super(Qhelperrr.class, metadata, "PUBLIC", "helperrr");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(al_id, ColumnMetadata.named("al_id").withIndex(1).ofType(Types.INTEGER).withSize(32).notNull());
        addMetadata(timee, ColumnMetadata.named("timee").withIndex(2).ofType(Types.DOUBLE).withSize(64));
    }

}

