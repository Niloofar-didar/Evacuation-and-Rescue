package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qal_views is a Querydsl query type for Qal_views
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qal_views extends com.mysema.query.sql.RelationalPathBase<Qal_views> {

    private static final long serialVersionUID = -1497859641;

    public static final Qal_views INSTANCE = new Qal_views("al_views");

    public final BooleanPath is_valid = createBoolean("is_valid");

    public final StringPath view_definition = createString("view_definition");

    public final StringPath view_name = createString("view_name");

    public Qal_views(String variable) {
        super(Qal_views.class, forVariable(variable), "PUBLIC", "al_views");
        addMetadata();
    }

    public Qal_views(String variable, String schema, String table) {
        super(Qal_views.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qal_views(Path<? extends Qal_views> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "al_views");
        addMetadata();
    }

    public Qal_views(PathMetadata<?> metadata) {
        super(Qal_views.class, metadata, "PUBLIC", "al_views");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(is_valid, ColumnMetadata.named("is_valid").withIndex(3).ofType(Types.BOOLEAN).withSize(0));
        addMetadata(view_definition, ColumnMetadata.named("view_definition").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(view_name, ColumnMetadata.named("view_name").withIndex(1).ofType(Types.VARCHAR).withSize(255).notNull());
    }

}

