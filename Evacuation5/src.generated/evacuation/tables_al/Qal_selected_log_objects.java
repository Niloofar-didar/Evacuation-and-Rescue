package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qal_selected_log_objects is a Querydsl query type for Qal_selected_log_objects
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qal_selected_log_objects extends com.mysema.query.sql.RelationalPathBase<Qal_selected_log_objects> {

    private static final long serialVersionUID = 1903144700;

    public static final Qal_selected_log_objects INSTANCE = new Qal_selected_log_objects("al_selected_log_objects");

    public final StringPath name = createString("name");

    public final StringPath type = createString("type");

    public Qal_selected_log_objects(String variable) {
        super(Qal_selected_log_objects.class, forVariable(variable), "PUBLIC", "al_selected_log_objects");
        addMetadata();
    }

    public Qal_selected_log_objects(String variable, String schema, String table) {
        super(Qal_selected_log_objects.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qal_selected_log_objects(Path<? extends Qal_selected_log_objects> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "al_selected_log_objects");
        addMetadata();
    }

    public Qal_selected_log_objects(PathMetadata<?> metadata) {
        super(Qal_selected_log_objects.class, metadata, "PUBLIC", "al_selected_log_objects");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(name, ColumnMetadata.named("name").withIndex(1).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(type, ColumnMetadata.named("type").withIndex(2).ofType(Types.VARCHAR).withSize(255));
    }

}

