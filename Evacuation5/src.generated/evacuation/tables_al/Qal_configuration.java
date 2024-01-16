package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qal_configuration is a Querydsl query type for Qal_configuration
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qal_configuration extends com.mysema.query.sql.RelationalPathBase<Qal_configuration> {

    private static final long serialVersionUID = 2084006735;

    public static final Qal_configuration INSTANCE = new Qal_configuration("al_configuration");

    public final StringPath property_name = createString("property_name");

    public final StringPath property_value = createString("property_value");

    public Qal_configuration(String variable) {
        super(Qal_configuration.class, forVariable(variable), "PUBLIC", "al_configuration");
        addMetadata();
    }

    public Qal_configuration(String variable, String schema, String table) {
        super(Qal_configuration.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qal_configuration(Path<? extends Qal_configuration> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "al_configuration");
        addMetadata();
    }

    public Qal_configuration(PathMetadata<?> metadata) {
        super(Qal_configuration.class, metadata, "PUBLIC", "al_configuration");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(property_name, ColumnMetadata.named("property_name").withIndex(1).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(property_value, ColumnMetadata.named("property_value").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
    }

}

