package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qal_db_objects is a Querydsl query type for Qal_db_objects
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qal_db_objects extends com.mysema.query.sql.RelationalPathBase<Qal_db_objects> {

    private static final long serialVersionUID = 834693786;

    public static final Qal_db_objects INSTANCE = new Qal_db_objects("al_db_objects");

    public final StringPath name = createString("name");

    public final StringPath type = createString("type");

    public final StringPath usage = createString("usage");

    public Qal_db_objects(String variable) {
        super(Qal_db_objects.class, forVariable(variable), "PUBLIC", "al_db_objects");
        addMetadata();
    }

    public Qal_db_objects(String variable, String schema, String table) {
        super(Qal_db_objects.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qal_db_objects(Path<? extends Qal_db_objects> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "al_db_objects");
        addMetadata();
    }

    public Qal_db_objects(PathMetadata<?> metadata) {
        super(Qal_db_objects.class, metadata, "PUBLIC", "al_db_objects");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(name, ColumnMetadata.named("name").withIndex(1).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(type, ColumnMetadata.named("type").withIndex(2).ofType(Types.VARCHAR).withSize(255));
        addMetadata(usage, ColumnMetadata.named("usage").withIndex(3).ofType(Types.VARCHAR).withSize(255));
    }

}

