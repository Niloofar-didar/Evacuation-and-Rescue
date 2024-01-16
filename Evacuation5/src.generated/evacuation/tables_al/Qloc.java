package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qloc is a Querydsl query type for Qloc
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qloc extends com.mysema.query.sql.RelationalPathBase<Qloc> {

    private static final long serialVersionUID = -1636968781;

    public static final Qloc INSTANCE = new Qloc("loc");

    public final NumberPath<Integer> al_id = createNumber("al_id", Integer.class);

    public final NumberPath<Integer> sname = createNumber("sname", Integer.class);

    public final NumberPath<Double> x = createNumber("x", Double.class);

    public final NumberPath<Double> y = createNumber("y", Double.class);

    public final NumberPath<Double> z = createNumber("z", Double.class);

    public final com.mysema.query.sql.PrimaryKey<Qloc> SYS_PK_10125 = createPrimaryKey(al_id);

    public Qloc(String variable) {
        super(Qloc.class, forVariable(variable), "PUBLIC", "loc");
        addMetadata();
    }

    public Qloc(String variable, String schema, String table) {
        super(Qloc.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qloc(Path<? extends Qloc> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "loc");
        addMetadata();
    }

    public Qloc(PathMetadata<?> metadata) {
        super(Qloc.class, metadata, "PUBLIC", "loc");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(al_id, ColumnMetadata.named("al_id").withIndex(1).ofType(Types.INTEGER).withSize(32).notNull());
        addMetadata(sname, ColumnMetadata.named("sname").withIndex(5).ofType(Types.INTEGER).withSize(32));
        addMetadata(x, ColumnMetadata.named("x").withIndex(2).ofType(Types.DOUBLE).withSize(64));
        addMetadata(y, ColumnMetadata.named("y").withIndex(3).ofType(Types.DOUBLE).withSize(64));
        addMetadata(z, ColumnMetadata.named("z").withIndex(4).ofType(Types.DOUBLE).withSize(64));
    }

}

