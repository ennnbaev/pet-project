package com.example1.demo.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_generator")
    @SequenceGenerator(name="player_generator", sequenceName = "public.usr_id_seq", allocationSize = 1, initialValue = 1)

    Integer id;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "active")
    boolean active;
    @Column(name = "email")
    String email;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Set<Role> getRoles()
    {
        return roles;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }

    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)

    private Set<Role> roles;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
