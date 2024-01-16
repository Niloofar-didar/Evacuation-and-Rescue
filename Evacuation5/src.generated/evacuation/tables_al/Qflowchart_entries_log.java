package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qflowchart_entries_log is a Querydsl query type for Qflowchart_entries_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qflowchart_entries_log extends com.mysema.query.sql.RelationalPathBase<Qflowchart_entries_log> {

    private static final long serialVersionUID = -354941575;

    public static final Qflowchart_entries_log INSTANCE = new Qflowchart_entries_log("flowchart_entries_log");

    public final StringPath agent = createString("agent");

    public final StringPath agent_type = createString("agent_type");

    public final StringPath block = createString("block");

    public final StringPath block_type = createString("block_type");

    public final NumberPath<Integer> counter = createNumber("counter", Integer.class);

    public final DateTimePath<java.util.Date> entry_date = createDateTime("entry_date", java.util.Date.class);

    public Qflowchart_entries_log(String variable) {
        super(Qflowchart_entries_log.class, forVariable(variable), "PUBLIC", "flowchart_entries_log");
        addMetadata();
    }

    public Qflowchart_entries_log(String variable, String schema, String table) {
        super(Qflowchart_entries_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qflowchart_entries_log(Path<? extends Qflowchart_entries_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "flowchart_entries_log");
        addMetadata();
    }

    public Qflowchart_entries_log(PathMetadata<?> metadata) {
        super(Qflowchart_entries_log.class, metadata, "PUBLIC", "flowchart_entries_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent, ColumnMetadata.named("agent").withIndex(3).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(agent_type, ColumnMetadata.named("agent_type").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(block, ColumnMetadata.named("block").withIndex(5).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(block_type, ColumnMetadata.named("block_type").withIndex(4).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(counter, ColumnMetadata.named("counter").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(entry_date, ColumnMetadata.named("entry_date").withIndex(6).ofType(Types.TIMESTAMP).withSize(26));
    }

}

