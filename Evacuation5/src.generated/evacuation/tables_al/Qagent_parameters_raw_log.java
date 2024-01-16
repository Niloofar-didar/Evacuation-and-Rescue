package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagent_parameters_raw_log is a Querydsl query type for Qagent_parameters_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagent_parameters_raw_log extends com.mysema.query.sql.RelationalPathBase<Qagent_parameters_raw_log> {

    private static final long serialVersionUID = -1009390785;

    public static final Qagent_parameters_raw_log INSTANCE = new Qagent_parameters_raw_log("agent_parameters_raw_log");

    public final NumberPath<Integer> agent_id = createNumber("agent_id", Integer.class);

    public final StringPath parameter_name = createString("parameter_name");

    public final StringPath parameter_value = createString("parameter_value");

    public final com.mysema.query.sql.ForeignKey<Qagents_raw_log> AGENT_PARAMETERS_AGENT_REF = createForeignKey(agent_id, "id");

    public Qagent_parameters_raw_log(String variable) {
        super(Qagent_parameters_raw_log.class, forVariable(variable), "PUBLIC", "agent_parameters_raw_log");
        addMetadata();
    }

    public Qagent_parameters_raw_log(String variable, String schema, String table) {
        super(Qagent_parameters_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagent_parameters_raw_log(Path<? extends Qagent_parameters_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agent_parameters_raw_log");
        addMetadata();
    }

    public Qagent_parameters_raw_log(PathMetadata<?> metadata) {
        super(Qagent_parameters_raw_log.class, metadata, "PUBLIC", "agent_parameters_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent_id, ColumnMetadata.named("agent_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
        addMetadata(parameter_name, ColumnMetadata.named("parameter_name").withIndex(2).ofType(Types.VARCHAR).withSize(255));
        addMetadata(parameter_value, ColumnMetadata.named("parameter_value").withIndex(3).ofType(Types.VARCHAR).withSize(16777216));
    }

}

