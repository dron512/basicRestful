package com.pmh.ex11.freeboard;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFreeBoard is a Querydsl query type for FreeBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFreeBoard extends EntityPathBase<FreeBoard> {

    private static final long serialVersionUID = -1978246597L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFreeBoard freeBoard = new QFreeBoard("freeBoard");

    public final com.pmh.ex11.common.QBaseEntity _super = new com.pmh.ex11.common.QBaseEntity(this);

    public final StringPath author = createString("author");

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.pmh.ex11.user.User, com.pmh.ex11.user.QUser> likedByUsers = this.<com.pmh.ex11.user.User, com.pmh.ex11.user.QUser>createList("likedByUsers", com.pmh.ex11.user.User.class, com.pmh.ex11.user.QUser.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    //inherited
    public final StringPath modName = _super.modName;

    //inherited
    public final StringPath regName = _super.regName;

    public final StringPath title = createString("title");

    public final com.pmh.ex11.user.QUser user;

    public QFreeBoard(String variable) {
        this(FreeBoard.class, forVariable(variable), INITS);
    }

    public QFreeBoard(Path<? extends FreeBoard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFreeBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFreeBoard(PathMetadata metadata, PathInits inits) {
        this(FreeBoard.class, metadata, inits);
    }

    public QFreeBoard(Class<? extends FreeBoard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.pmh.ex11.user.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

