package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagent_parameters_log is a Querydsl query type for Qagent_parameters_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagent_parameters_log extends com.mysema.query.sql.RelationalPathBase<Qagent_parameters_log> {

    private static final long serialVersionUID = 1916170454;

    public static final Qagent_parameters_log INSTANCE = new Qagent_parameters_log("agent_parameters_log");

    public final StringPath agent = createString("agent");

    public final StringPath agent_type = createString("agent_type");

    public final StringPath parameter_name = createString("parameter_name");

    public final StringPath parameter_value = createString("parameter_value");

    public Qagent_parameters_log(String variable) {
        super(Qagent_parameters_log.class, forVariable(variable), "PUBLIC", "agent_parameters_log");
        addMetadata();
    }

    public Qagent_parameters_log(String variable, String schema, String table) {
        super(Qagent_parameters_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagent_parameters_log(Path<? extends Qagent_parameters_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agent_parameters_log");
        addMetadata();
    }

    public Qagent_parameters_log(PathMetadata<?> metadata) {
        super(Qagent_parameters_log.class, metadata, "PUBLIC", "agent_parameters_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(agent, ColumnMetadata.named("agent").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(agent_type, ColumnMetadata.named("agent_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(parameter_name, ColumnMetadata.named("parameter_name").withIndex(3).ofType(Types.VARCHAR).withSize(255));
        addMetadata(parameter_value, ColumnMetadata.named("parameter_value").withIndex(4).ofType(Types.VARCHAR).withSize(16777216));
    }

}

