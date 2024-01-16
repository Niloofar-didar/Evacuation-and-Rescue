package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagent_elements_raw_log is a Querydsl query type for Qagent_elements_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagent_elements_raw_log extends com.mysema.query.sql.RelationalPathBase<Qagent_elements_raw_log> {

    private static final long serialVersionUID = -754722036;

    public static final Qagent_elements_raw_log INSTANCE = new Qagent_elements_raw_log("agent_elements_raw_log");

    public final NumberPath<Integer> agent_id = createNumber("agent_id", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final com.mysema.query.sql.PrimaryKey<Qagent_elements_raw_log> SYS_PK_10157 = createPrimaryKey(id);

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> ELEMENT_TO_AGENT_REF = createForeignKey(agent_id, "id");

    public final com.mysema.query.sql.ForeignKey<Qdatasets_raw_log> _DATASETS_ELEMENT_REF = createInvForeignKey(id, "element_id");

    public final com.mysema.query.sql.ForeignKey<Qhistograms_raw_log> _HISTOGRAMS_ELEMENT_REF = createInvForeignKey(id, "element_id");

    public Qagent_elements_raw_log(String variable) {
        super(Qagent_elements_raw_log.class, forVariable(variable), "PUBLIC", "agent_elements_raw_log");
        addMetadata();
    }

    public Qagent_elements_raw_log(String variable, String schema, String table) {
        super(Qagent_elements_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagent_elements_raw_log(Path<? extends Qagent_elements_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agent_elements_raw_log");
        addMetadata();
    }

    public Qagent_elements_raw_log(PathMetadata<?> metadata) {
        super(Qagent_elements_raw_log.class, metadata, "PUBLIC", "agent_elements_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent_id, ColumnMetadata.named("agent_id").withIndex(2).ofType(Types.INTEGER).withSize(32));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.INTEGER).withSize(32).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(3).ofType(Types.VARCHAR).withSize(255));
    }

}

