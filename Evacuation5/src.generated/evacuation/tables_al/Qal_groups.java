package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qal_groups is a Querydsl query type for Qal_groups
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qal_groups extends com.mysema.query.sql.RelationalPathBase<Qal_groups> {

    private static final long serialVersionUID = 390161819;

    public static final Qal_groups INSTANCE = new Qal_groups("al_groups");

    public final StringPath description = createString("description");

    public final StringPath group_name = createString("group_name");

    public final com.mysema.query.sql.PrimaryKey<Qal_groups> SYS_PK_10097 = createPrimaryKey(group_name);

    public Qal_groups(String variable) {
        super(Qal_groups.class, forVariable(variable), "PUBLIC", "al_groups");
        addMetadata();
    }

    public Qal_groups(String variable, String schema, String table) {
        super(Qal_groups.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qal_groups(Path<? extends Qal_groups> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "al_groups");
        addMetadata();
    }

    public Qal_groups(PathMetadata<?> metadata) {
        super(Qal_groups.class, metadata, "PUBLIC", "al_groups");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(description, ColumnMetadata.named("description").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(group_name, ColumnMetadata.named("group_name").withIndex(1).ofType(Types.VARCHAR).withSize(255).notNull());
    }

}

