package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qlibrary_block_parameters_log is a Querydsl query type for Qlibrary_block_parameters_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qlibrary_block_parameters_log extends com.mysema.query.sql.RelationalPathBase<Qlibrary_block_parameters_log> {

    private static final long serialVersionUID = -1965737390;

    public static final Qlibrary_block_parameters_log INSTANCE = new Qlibrary_block_parameters_log("library_block_parameters_log");

    public final StringPath block = createString("block");

    public final StringPath block_type = createString("block_type");

    public final StringPath parameter_name = createString("parameter_name");

    public final StringPath parameter_value = createString("parameter_value");

    public Qlibrary_block_parameters_log(String variable) {
        super(Qlibrary_block_parameters_log.class, forVariable(variable), "PUBLIC", "library_block_parameters_log");
        addMetadata();
    }

    public Qlibrary_block_parameters_log(String variable, String schema, String table) {
        super(Qlibrary_block_parameters_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qlibrary_block_parameters_log(Path<? extends Qlibrary_block_parameters_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "library_block_parameters_log");
        addMetadata();
    }

    public Qlibrary_block_parameters_log(PathMetadata<?> metadata) {
        super(Qlibrary_block_parameters_log.class, metadata, "PUBLIC", "library_block_parameters_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(block, ColumnMetadata.named("block").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(block_type, ColumnMetadata.named("block_type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(parameter_name, ColumnMetadata.named("parameter_name").withIndex(3).ofType(Types.VARCHAR).withSize(255));
        addMetadata(parameter_value, ColumnMetadata.named("parameter_value").withIndex(4).ofType(Types.VARCHAR).withSize(16777216));
    }

}

