package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qloc2 is a Querydsl query type for Qloc2
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qloc2 extends com.mysema.query.sql.RelationalPathBase<Qloc2> {

    private static final long serialVersionUID = 793575391;

    public static final Qloc2 INSTANCE = new Qloc2("loc2");

    public final NumberPath<Integer> al_id = createNumber("al_id", Integer.class);

    public final BooleanPath chk = createBoolean("chk");

    public final NumberPath<Integer> n1 = createNumber("n1", Integer.class);

    public final NumberPath<Integer> n2 = createNumber("n2", Integer.class);

    public final NumberPath<Integer> n3 = createNumber("n3", Integer.class);

    public final NumberPath<Integer> n4 = createNumber("n4", Integer.class);

    public final NumberPath<Double> x = createNumber("x", Double.class);

    public final NumberPath<Double> y = createNumber("y", Double.class);

    public final com.mysema.query.sql.PrimaryKey<Qloc2> SYS_PK_10129 = createPrimaryKey(al_id);

    public Qloc2(String variable) {
        super(Qloc2.class, forVariable(variable), "PUBLIC", "loc2");
        addMetadata();
    }

    public Qloc2(String variable, String schema, String table) {
        super(Qloc2.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qloc2(Path<? extends Qloc2> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "loc2");
        addMetadata();
    }

    public Qloc2(PathMetadata<?> metadata) {
        super(Qloc2.class, metadata, "PUBLIC", "loc2");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(al_id, ColumnMetadata.named("al_id").withIndex(1).ofType(Types.INTEGER).withSize(32).notNull());
        addMetadata(chk, ColumnMetadata.named("chk").withIndex(4).ofType(Types.BOOLEAN).withSize(0));
        addMetadata(n1, ColumnMetadata.named("n1").withIndex(5).ofType(Types.INTEGER).withSize(32));
        addMetadata(n2, ColumnMetadata.named("n2").withIndex(6).ofType(Types.INTEGER).withSize(32));
        addMetadata(n3, ColumnMetadata.named("n3").withIndex(7).ofType(Types.INTEGER).withSize(32));
        addMetadata(n4, ColumnMetadata.named("n4").withIndex(8).ofType(Types.INTEGER).withSize(32));
        addMetadata(x, ColumnMetadata.named("x").withIndex(2).ofType(Types.DOUBLE).withSize(64));
        addMetadata(y, ColumnMetadata.named("y").withIndex(3).ofType(Types.DOUBLE).withSize(64));
    }

}

