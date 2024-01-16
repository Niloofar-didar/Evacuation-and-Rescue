package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qflowchart_entries_raw_log is a Querydsl query type for Qflowchart_entries_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qflowchart_entries_raw_log extends com.mysema.query.sql.RelationalPathBase<Qflowchart_entries_raw_log> {

    private static final long serialVersionUID = 847672930;

    public static final Qflowchart_entries_raw_log INSTANCE = new Qflowchart_entries_raw_log("flowchart_entries_raw_log");

    public final NumberPath<Integer> agent_id = createNumber("agent_id", Integer.class);

    public final NumberPath<Integer> block_id = createNumber("block_id", Integer.class);

    public final NumberPath<Integer> counter = createNumber("counter", Integer.class);

    public final DateTimePath<java.util.Date> entry_date = createDateTime("entry_date", java.util.Date.class);

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> FLOWCHART_ENTRIES_ENTITY_AGENT_REF = createForeignKey(agent_id, "id");

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> FLOWCHART_ENTRIES_BLOCK_AGENT_REF = createForeignKey(block_id, "id");

    public Qflowchart_entries_raw_log(String variable) {
        super(Qflowchart_entries_raw_log.class, forVariable(variable), "PUBLIC", "flowchart_entries_raw_log");
        addMetadata();
    }

    public Qflowchart_entries_raw_log(String variable, String schema, String table) {
        super(Qflowchart_entries_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qflowchart_entries_raw_log(Path<? extends Qflowchart_entries_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "flowchart_entries_raw_log");
        addMetadata();
    }

    public Qflowchart_entries_raw_log(PathMetadata<?> metadata) {
        super(Qflowchart_entries_raw_log.class, metadata, "PUBLIC", "flowchart_entries_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent_id, ColumnMetadata.named("agent_id").withIndex(2).ofType(Types.INTEGER).withSize(32));
        addMetadata(block_id, ColumnMetadata.named("block_id").withIndex(3).ofType(Types.INTEGER).withSize(32));
        addMetadata(counter, ColumnMetadata.named("counter").withIndex(1).ofType(Types.INTEGER).withSize(32).notNull());
        addMetadata(entry_date, ColumnMetadata.named("entry_date").withIndex(4).ofType(Types.TIMESTAMP).withSize(26));
    }

}

