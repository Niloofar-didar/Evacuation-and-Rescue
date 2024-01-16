package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qal_tables is a Querydsl query type for Qal_tables
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qal_tables extends com.mysema.query.sql.RelationalPathBase<Qal_tables> {

    private static final long serialVersionUID = 746244652;

    public static final Qal_tables INSTANCE = new Qal_tables("al_tables");

    public final StringPath description = createString("description");

    public final StringPath group_name = createString("group_name");

    public final StringPath table_name = createString("table_name");

    public final com.mysema.query.sql.PrimaryKey<Qal_tables> SYS_PK_10101 = createPrimaryKey(table_name);

    public Qal_tables(String variable) {
        super(Qal_tables.class, forVariable(variable), "PUBLIC", "al_tables");
        addMetadata();
    }

    public Qal_tables(String variable, String schema, String table) {
        super(Qal_tables.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qal_tables(Path<? extends Qal_tables> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "al_tables");
        addMetadata();
    }

    public Qal_tables(PathMetadata<?> metadata) {
        super(Qal_tables.class, metadata, "PUBLIC", "al_tables");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(description, ColumnMetadata.named("description").withIndex(3).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(group_name, ColumnMetadata.named("group_name").withIndex(2).ofType(Types.VARCHAR).withSize(255));
        addMetadata(table_name, ColumnMetadata.named("table_name").withIndex(1).ofType(Types.VARCHAR).withSize(255).notNull());
    }

}

