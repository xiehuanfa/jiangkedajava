package com.nuesoft.redbag;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name="tb_user")
public class User {
    @Id
    @GenericGenerator(name="idGenerator",strategy="uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    @Column(name="username",unique = true,nullable =false,length = 64)
    private String username;
    private String password;
    private String email;
}
