package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagent_messages_log is a Querydsl query type for Qagent_messages_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagent_messages_log extends com.mysema.query.sql.RelationalPathBase<Qagent_messages_log> {

    private static final long serialVersionUID = -1178051336;

    public static final Qagent_messages_log INSTANCE = new Qagent_messages_log("agent_messages_log");

    public final NumberPath<Integer> counter = createNumber("counter", Integer.class);

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final StringPath message = createString("message");

    public final StringPath recipient = createString("recipient");

    public final StringPath recipient_type = createString("recipient_type");

    public final StringPath sender = createString("sender");

    public final StringPath sender_type = createString("sender_type");

    public Qagent_messages_log(String variable) {
        super(Qagent_messages_log.class, forVariable(variable), "PUBLIC", "agent_messages_log");
        addMetadata();
    }

    public Qagent_messages_log(String variable, String schema, String table) {
        super(Qagent_messages_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagent_messages_log(Path<? extends Qagent_messages_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agent_messages_log");
        addMetadata();
    }

    public Qagent_messages_log(PathMetadata<?> metadata) {
        super(Qagent_messages_log.class, metadata, "PUBLIC", "agent_messages_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(counter, ColumnMetadata.named("counter").withIndex(7).ofType(Types.INTEGER).withSize(32));
        addMetadata(date, ColumnMetadata.named("date").withIndex(6).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(message, ColumnMetadata.named("message").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(recipient, ColumnMetadata.named("recipient").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(recipient_type, ColumnMetadata.named("recipient_type").withIndex(3).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(sender, ColumnMetadata.named("sender").withIndex(4).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(sender_type, ColumnMetadata.named("sender_type").withIndex(5).ofType(Types.VARCHAR).withSize(16777216));
    }

}

