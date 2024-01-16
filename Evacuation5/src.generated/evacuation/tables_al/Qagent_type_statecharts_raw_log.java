package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qagent_type_statecharts_raw_log is a Querydsl query type for Qagent_type_statecharts_raw_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qagent_type_statecharts_raw_log extends com.mysema.query.sql.RelationalPathBase<Qagent_type_statecharts_raw_log> {

    private static final long serialVersionUID = 1005819830;

    public static final Qagent_type_statecharts_raw_log INSTANCE = new Qagent_type_statecharts_raw_log("agent_type_statecharts_raw_log");

    public final NumberPath<Integer> element_id = createNumber("element_id", Integer.class);

    public final NumberPath<Integer> statechart_id = createNumber("statechart_id", Integer.class);

    public final com.mysema.query.sql.ForeignKey<Qagent_type_elements_raw_log> STATECHARTS_STATECHART_TO_ELEMENT_REF = createForeignKey(statechart_id, "id");

    public final com.mysema.query.sql.ForeignKey<Qagent_type_elements_raw_log> STATECHARTS_ELEMENT_TO_ELEMENT_REF = createForeignKey(element_id, "id");

    public Qagent_type_statecharts_raw_log(String variable) {
        super(Qagent_type_statecharts_raw_log.class, forVariable(variable), "PUBLIC", "agent_type_statecharts_raw_log");
        addMetadata();
    }

    public Qagent_type_statecharts_raw_log(String variable, String schema, String table) {
        super(Qagent_type_statecharts_raw_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qagent_type_statecharts_raw_log(Path<? extends Qagent_type_statecharts_raw_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "agent_type_statecharts_raw_log");
        addMetadata();
    }

    public Qagent_type_statecharts_raw_log(PathMetadata<?> metadata) {
        super(Qagent_type_statecharts_raw_log.class, metadata, "PUBLIC", "agent_type_statecharts_raw_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(element_id, ColumnMetadata.named("element_id").withIndex(2).ofType(Types.INTEGER).withSize(32));
        addMetadata(statechart_id, ColumnMetadata.named("statechart_id").withIndex(1).ofType(Types.INTEGER).withSize(32));
    }

}

