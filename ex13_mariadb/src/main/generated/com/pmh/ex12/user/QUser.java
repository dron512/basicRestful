package com.pmh.ex12.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1616186204L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final com.pmh.ex12.common.QBaseEntity _super = new com.pmh.ex12.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.pmh.ex12.freeboard.FreeBoard, com.pmh.ex12.freeboard.QFreeBoard> likedFreeBoards = this.<com.pmh.ex12.freeboard.FreeBoard, com.pmh.ex12.freeboard.QFreeBoard>createList("likedFreeBoards", com.pmh.ex12.freeboard.FreeBoard.class, com.pmh.ex12.freeboard.QFreeBoard.class, PathInits.DIRECT2);

    public final ListPath<com.pmh.ex12.freeboard.FreeBoard, com.pmh.ex12.freeboard.QFreeBoard> list = this.<com.pmh.ex12.freeboard.FreeBoard, com.pmh.ex12.freeboard.QFreeBoard>createList("list", com.pmh.ex12.freeboard.FreeBoard.class, com.pmh.ex12.freeboard.QFreeBoard.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    //inherited
    public final StringPath modName = _super.modName;

    public final StringPath name = createString("name");

    //inherited
    public final StringPath regName = _super.regName;

    public final com.pmh.ex12.user.userprofile.QUserProfile userProfile;

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userProfile = inits.isInitialized("userProfile") ? new com.pmh.ex12.user.userprofile.QUserProfile(forProperty("userProfile"), inits.get("userProfile")) : null;
    }

}

