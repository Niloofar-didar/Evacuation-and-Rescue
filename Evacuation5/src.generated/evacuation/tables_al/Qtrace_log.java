package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qtrace_log is a Querydsl query type for Qtrace_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qtrace_log extends com.mysema.query.sql.RelationalPathBase<Qtrace_log> {

    private static final long serialVersionUID = -371774851;

    public static final Qtrace_log INSTANCE = new Qtrace_log("trace_log");

    public final StringPath agent = createString("agent");

    public final StringPath agent_type = createString("agent_type");

    public final NumberPath<Integer> counter = createNumber("counter", Integer.class);

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final StringPath message_text = createString("message_text");

    public Qtrace_log(String variable) {
        super(Qtrace_log.class, forVariable(variable), "PUBLIC", "trace_log");
        addMetadata();
    }

    public Qtrace_log(String variable, String schema, String table) {
        super(Qtrace_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qtrace_log(Path<? extends Qtrace_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "trace_log");
        addMetadata();
    }

    public Qtrace_log(PathMetadata<?> metadata) {
        super(Qtrace_log.class, metadata, "PUBLIC", "trace_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent, ColumnMetadata.named("agent").withIndex(5).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(agent_type, ColumnMetadata.named("agent_type").withIndex(4).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(counter, ColumnMetadata.named("counter").withIndex(3).ofType(Types.INTEGER).withSize(32));
        addMetadata(date, ColumnMetadata.named("date").withIndex(2).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(message_text, ColumnMetadata.named("message_text").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
    }

}

