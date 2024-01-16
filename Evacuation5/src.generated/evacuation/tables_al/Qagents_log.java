package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagents_log is a Querydsl query type for Qagents_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagents_log extends com.mysema.query.sql.RelationalPathBase<Qagents_log> {

    private static final long serialVersionUID = -792736064;

    public static final Qagents_log INSTANCE = new Qagents_log("agents_log");

    public final DateTimePath<java.util.Date> birthdate = createDateTime("birthdate", java.util.Date.class);

    public final DateTimePath<java.util.Date> deathdate = createDateTime("deathdate", java.util.Date.class);

    public final StringPath name = createString("name");

    public final StringPath type = createString("type");

    public Qagents_log(String variable) {
        super(Qagents_log.class, forVariable(variable), "PUBLIC", "agents_log");
        addMetadata();
    }

    public Qagents_log(String variable, String schema, String table) {
        super(Qagents_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagents_log(Path<? extends Qagents_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agents_log");
        addMetadata();
    }

    public Qagents_log(PathMetadata<?> metadata) {
        super(Qagents_log.class, metadata, "PUBLIC", "agents_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(birthdate, ColumnMetadata.named("birthdate").withIndex(3).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(deathdate, ColumnMetadata.named("deathdate").withIndex(4).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(type, ColumnMetadata.named("type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
    }

}

