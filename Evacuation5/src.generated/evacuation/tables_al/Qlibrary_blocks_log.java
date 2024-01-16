package evacuation.tables_al;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Qlibrary_blocks_log is a Querydsl query type for Qlibrary_blocks_log
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class Qlibrary_blocks_log extends com.mysema.query.sql.RelationalPathBase<Qlibrary_blocks_log> {

    private static final long serialVersionUID = -41352388;

    public static final Qlibrary_blocks_log INSTANCE = new Qlibrary_blocks_log("library_blocks_log");

    public final DateTimePath<java.util.Date> birthdate = createDateTime("birthdate", java.util.Date.class);

    public final DateTimePath<java.util.Date> deathdate = createDateTime("deathdate", java.util.Date.class);

    public final StringPath name = createString("name");

    public final StringPath type = createString("type");

    public Qlibrary_blocks_log(String variable) {
        super(Qlibrary_blocks_log.class, forVariable(variable), "PUBLIC", "library_blocks_log");
        addMetadata();
    }

    public Qlibrary_blocks_log(String variable, String schema, String table) {
        super(Qlibrary_blocks_log.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Qlibrary_blocks_log(Path<? extends Qlibrary_blocks_log> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "library_blocks_log");
        addMetadata();
    }

    public Qlibrary_blocks_log(PathMetadata<?> metadata) {
        super(Qlibrary_blocks_log.class, metadata, "PUBLIC", "library_blocks_log");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(birthdate, ColumnMetadata.named("birthdate").withIndex(3).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(deathdate, ColumnMetadata.named("deathdate").withIndex(4).ofType(Types.TIMESTAMP).withSize(26));
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(16777216));
        addMetadata(type, ColumnMetadata.named("type").withIndex(1).ofType(Types.VARCHAR).withSize(16777216));
    }

}

