package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by lubuntu on 8/20/16.
 */
@Entity
public class User extends Model
{
    @Id                 /*Primary Key*/
    @GeneratedValue(strategy = GenerationType.AUTO)     /*Auto Increment*/
    public Long id;

    public String email;

    public String password;

    @OneToMany(mappedBy = "sender")

    @OneToMany(mappedBy = "receiver")
    public List<ConnectionRequest> connectionRequestsReceived;

    @OneToOne
    public Profile profile;

    @ManyToMany
    @JoinTable(name = "user_connections" ,
        joinColumns =  {
            @JoinColumn(name = "user_id")
        },
        inverseJoinColumns = {
                @JoinColumn(name = "connection_id")
        }
    )
    public Set<User> connections;
}
