package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qtrace_raw_log is a Querydsl query type for Qtrace_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qtrace_raw_log extends com.mysema.query.sql.RelationalPathBase<Qtrace_raw_log> {

    private static final long serialVersionUID = -1549567642;

    public static final Qtrace_raw_log INSTANCE = new Qtrace_raw_log("trace_raw_log");

    public final NumberPath<Integer> agent_id = createNumber("agent_id", Integer.class);

    public final NumberPath<Integer> counter = createNumber("counter", Integer.class);

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final StringPath message_text = createString("message_text");

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> TRACE_LOG_AGENT_REF = createForeignKey(agent_id, "id");

    public Qtrace_raw_log(String variable) {
        super(Qtrace_raw_log.class, forVariable(variable), "PUBLIC", "trace_raw_log");
        addMetadata();
    }

    public Qtrace_raw_log(String variable, String schema, String table) {
        super(Qtrace_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qtrace_raw_log(Path<? extends Qtrace_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "trace_raw_log");
        addMetadata();
    }

    public Qtrace_raw_log(PathMetadata<?> metadata) {
        super(Qtrace_raw_log.class, metadata, "PUBLIC", "trace_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent_id, ColumnMetadata.named("agent_id").withIndex(2).ofType(Types.INTEGER).withSize(32));
        addMetadata(counter, ColumnMetadata.named("counter").withIndex(1).ofType(Types.INTEGER).withSize(32).notNull());
        addMetadata(date, ColumnMetadata.named("date").withIndex(3).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(message_text, ColumnMetadata.named("message_text").withIndex(4).ofType(Types.VARCHAR).withSize(16777216));
    }

}

