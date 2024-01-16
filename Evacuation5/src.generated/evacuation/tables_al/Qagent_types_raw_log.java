package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagent_types_raw_log is a Querydsl query type for Qagent_types_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagent_types_raw_log extends com.mysema.query.sql.RelationalPathBase<Qagent_types_raw_log> {

    private static final long serialVersionUID = 1142129312;

    public static final Qagent_types_raw_log INSTANCE = new Qagent_types_raw_log("agent_types_raw_log");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final com.mysema.query.sql.PrimaryKey<Qagent_types_raw_log> SYS_PK_10136 = createPrimaryKey(id);

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> _AGENT_TYPE_REF = createInvForeignKey(id, "agent_type_id");

    public final com.mysema.query.sql.ForeignKey<Qagent_type_elements_raw_log> _ELEMENT_TO_AGENT_TYPE_REF = createInvForeignKey(id, "agent_type_id");

    public Qagent_types_raw_log(String variable) {
        super(Qagent_types_raw_log.class, forVariable(variable), "PUBLIC", "agent_types_raw_log");
        addMetadata();
    }

    public Qagent_types_raw_log(String variable, String schema, String table) {
        super(Qagent_types_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagent_types_raw_log(Path<? extends Qagent_types_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agent_types_raw_log");
        addMetadata();
    }

    public Qagent_types_raw_log(PathMetadata<?> metadata) {
        super(Qagent_types_raw_log.class, metadata, "PUBLIC", "agent_types_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.INTEGER).withSize(32).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(255));
    }

}

