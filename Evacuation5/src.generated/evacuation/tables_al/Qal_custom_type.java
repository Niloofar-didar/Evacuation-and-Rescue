package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qal_custom_type is a Querydsl query type for Qal_custom_type
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qal_custom_type extends com.mysema.query.sql.RelationalPathBase<Qal_custom_type> {

    private static final long serialVersionUID = -467864607;

    public static final Qal_custom_type INSTANCE = new Qal_custom_type("al_custom_type");

    public final StringPath column_name = createString("column_name");

    public final StringPath name = createString("name");

    public final StringPath table_name = createString("table_name");

    public final StringPath type = createString("type");

    public Qal_custom_type(String variable) {
        super(Qal_custom_type.class, forVariable(variable), "PUBLIC", "al_custom_type");
        addMetadata();
    }

    public Qal_custom_type(String variable, String schema, String table) {
        super(Qal_custom_type.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qal_custom_type(Path<? extends Qal_custom_type> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "al_custom_type");
        addMetadata();
    }

    public Qal_custom_type(PathMetadata<?> metadata) {
        super(Qal_custom_type.class, metadata, "PUBLIC", "al_custom_type");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(column_name, ColumnMetadata.named("column_name").withIndex(2).ofType(Types.VARCHAR).withSize(255));
        addMetadata(name, ColumnMetadata.named("name").withIndex(4).ofType(Types.VARCHAR).withSize(255));
        addMetadata(table_name, ColumnMetadata.named("table_name").withIndex(1).ofType(Types.VARCHAR).withSize(255));
        addMetadata(type, ColumnMetadata.named("type").withIndex(3).ofType(Types.VARCHAR).withSize(255));
    }

}

