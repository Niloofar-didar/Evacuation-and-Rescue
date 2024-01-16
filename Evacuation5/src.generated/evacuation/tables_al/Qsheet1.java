package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qsheet1 is a Querydsl query type for Qsheet1
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qsheet1 extends com.mysema.query.sql.RelationalPathBase<Qsheet1> {

    private static final long serialVersionUID = -1684176289;

    public static final Qsheet1 INSTANCE = new Qsheet1("sheet1");

    public final NumberPath<Integer> al_id = createNumber("al_id", Integer.class);

    public final StringPath db_12_3666666667 = createString("db_12_3666666667");

    public final StringPath db_50 = createString("db_50");

    public final com.mysema.query.sql.PrimaryKey<Qsheet1> SYS_PK_10121 = createPrimaryKey(al_id);

    public Qsheet1(String variable) {
        super(Qsheet1.class, forVariable(variable), "PUBLIC", "sheet1");
        addMetadata();
    }

    public Qsheet1(String variable, String schema, String table) {
        super(Qsheet1.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qsheet1(Path<? extends Qsheet1> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "sheet1");
        addMetadata();
    }

    public Qsheet1(PathMetadata<?> metadata) {
        super(Qsheet1.class, metadata, "PUBLIC", "sheet1");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(al_id, ColumnMetadata.named("al_id").withIndex(1).ofType(Types.INTEGER).withSize(32).notNull());
        addMetadata(db_12_3666666667, ColumnMetadata.named("db_12_3666666667").withIndex(3).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(db_50, ColumnMetadata.named("db_50").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
    }

}

