package com.codegeekgao.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体对象
 *
 * @author gaoxinpeng
 * @version Id: User.java, v 0.1 2018/4/11 上午11:38 gaoxinpeng Exp $$
 */
@Document(collection = "user")
@Data
public class User implements Serializable {
    /**
     * spring-data-mongodb中的实体映射是通过MongoMappingConverter这个类实现的。它可以通过注释把java类转换为mongodb的文档。
     * 它有以下几种注释：
     *
     * @Id - 文档的唯一标识，在mongodb中为ObjectId，它是唯一的，通过时间戳+机器标识+进程ID+自增计数器（确保同一秒内产生的Id不会冲突）构成。
     * @Document - 把一个java类声明为mongodb的文档，可以通过collection参数指定这个类对应的文档。
     * @DBRef - 声明类似于关系数据库的关联关系。ps：暂不支持级联的保存功能，当你在本实例中修改了DERef对象里面的值时，单独保存本实例并不能保存DERef引用的对象，它要另外保存，如下面例子的Person和Account。
     * @Indexed - 声明该字段需要索引，建索引可以大大的提高查询效率。
     * @CompoundIndex - 复合索引的声明，建复合索引可以有效地提高多字段的查询效率。
     * @GeoSpatialIndexed - 声明该字段为地理信息的索引。
     * @Transient - 映射忽略的字段，该字段不会保存到mongodb。
     * @PersistenceConstructor - 声明构造函数，作用是把从数据库取出的数据实例化为对象。该构造函数传入的值为从DBObject中取出的数据
     */
    private static final long serialVersionUID = 3510317929533003102L;
    @Id
    private String userId;
    @NotNull
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private Date registrationDate = new Date();
    private Set<String> roles = new HashSet<>();

    @PersistenceConstructor
    public User(String userId, String userName, String password, String name, String email,
                Date registrationDate, Set<String> roles) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
        this.roles = roles;
    }
}
