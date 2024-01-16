package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qdestroyed_agents_raw_log is a Querydsl query type for Qdestroyed_agents_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qdestroyed_agents_raw_log extends com.mysema.query.sql.RelationalPathBase<Qdestroyed_agents_raw_log> {

    private static final long serialVersionUID = -273919281;

    public static final Qdestroyed_agents_raw_log INSTANCE = new Qdestroyed_agents_raw_log("destroyed_agents_raw_log");

    public final NumberPath<Integer> agent_id = createNumber("agent_id", Integer.class);

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> DESTROYED_AGENT_REF = createForeignKey(agent_id, "id");

    public Qdestroyed_agents_raw_log(String variable) {
        super(Qdestroyed_agents_raw_log.class, forVariable(variable), "PUBLIC", "destroyed_agents_raw_log");
        addMetadata();
    }

    public Qdestroyed_agents_raw_log(String variable, String schema, String table) {
        super(Qdestroyed_agents_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qdestroyed_agents_raw_log(Path<? extends Qdestroyed_agents_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "destroyed_agents_raw_log");
        addMetadata();
    }

    public Qdestroyed_agents_raw_log(PathMetadata<?> metadata) {
        super(Qdestroyed_agents_raw_log.class, metadata, "PUBLIC", "destroyed_agents_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent_id, ColumnMetadata.named("agent_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(date, ColumnMetadata.named("date").withIndex(2).ofType(Types.TIMESTAMP).withSize(26));
    }

}

