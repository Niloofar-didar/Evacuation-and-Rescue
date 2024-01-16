package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagent_messages_raw_log is a Querydsl query type for Qagent_messages_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagent_messages_raw_log extends com.mysema.query.sql.RelationalPathBase<Qagent_messages_raw_log> {

    private static final long serialVersionUID = -630131103;

    public static final Qagent_messages_raw_log INSTANCE = new Qagent_messages_raw_log("agent_messages_raw_log");

    public final NumberPath<Integer> agent_id = createNumber("agent_id", Integer.class);

    public final NumberPath<Integer> counter = createNumber("counter", Integer.class);

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final StringPath message = createString("message");

    public final NumberPath<Integer> sender_id = createNumber("sender_id", Integer.class);

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> MESSAGES_AGENT_REF = createForeignKey(agent_id, "id");

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> MESSAGES_SENDER_AGENT_REF = createForeignKey(sender_id, "id");

    public Qagent_messages_raw_log(String variable) {
        super(Qagent_messages_raw_log.class, forVariable(variable), "PUBLIC", "agent_messages_raw_log");
        addMetadata();
    }

    public Qagent_messages_raw_log(String variable, String schema, String table) {
        super(Qagent_messages_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagent_messages_raw_log(Path<? extends Qagent_messages_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agent_messages_raw_log");
        addMetadata();
    }

    public Qagent_messages_raw_log(PathMetadata<?> metadata) {
        super(Qagent_messages_raw_log.class, metadata, "PUBLIC", "agent_messages_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent_id, ColumnMetadata.named("agent_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(counter, ColumnMetadata.named("counter").withIndex(5).ofType(Types.INTEGER).withSize(32).notNull());
        addMetadata(date, ColumnMetadata.named("date").withIndex(4).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(message, ColumnMetadata.named("message").withIndex(3).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(sender_id, ColumnMetadata.named("sender_id").withIndex(2).ofType(Types.INTEGER).withSize(32));
    }

}

