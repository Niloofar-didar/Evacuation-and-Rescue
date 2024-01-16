package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qresource_unit_utilization_log is a Querydsl query type for Qresource_unit_utilization_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qresource_unit_utilization_log extends com.mysema.query.sql.RelationalPathBase<Qresource_unit_utilization_log> {

    private static final long serialVersionUID = -356463568;

    public static final Qresource_unit_utilization_log INSTANCE = new Qresource_unit_utilization_log("resource_unit_utilization_log");

    public final StringPath resource_pool = createString("resource_pool");

    public final StringPath unit = createString("unit");

    public final StringPath unit_type = createString("unit_type");

    public final NumberPath<Double> utilization = createNumber("utilization", Double.class);

    public Qresource_unit_utilization_log(String variable) {
        super(Qresource_unit_utilization_log.class, forVariable(variable), "PUBLIC", "resource_unit_utilization_log");
        addMetadata();
    }

    public Qresource_unit_utilization_log(String variable, String schema, String table) {
        super(Qresource_unit_utilization_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qresource_unit_utilization_log(Path<? extends Qresource_unit_utilization_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "resource_unit_utilization_log");
        addMetadata();
    }

    public Qresource_unit_utilization_log(PathMetadata<?> metadata) {
        super(Qresource_unit_utilization_log.class, metadata, "PUBLIC", "resource_unit_utilization_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(resource_pool, ColumnMetadata.named("resource_pool").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(unit, ColumnMetadata.named("unit").withIndex(3).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(unit_type, ColumnMetadata.named("unit_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(utilization, ColumnMetadata.named("utilization").withIndex(4).ofType(Types.DOUBLE).withSize(64));
    }

}

