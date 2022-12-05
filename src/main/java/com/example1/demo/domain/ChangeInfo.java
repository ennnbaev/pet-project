package com.example1.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "change_info",schema = "public")
public class ChangeInfo implements Serializable
{
    @Id
    private int id;
    @Column(name = "contact_info")
    private String contactInfo;
    @Column(name = "old_game")
    private String oldGame;
    @Column(name = "new_game")
    private String newGame;

    @Override public int hashCode()
    {
        return Objects.hash(contactInfo, oldGame, newGame);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getContactInfo()
    {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo)
    {
        this.contactInfo = contactInfo;
    }

    public String getOldGame()
    {
        return oldGame;
    }

    public void setOldGame(String oldGame)
    {
        this.oldGame = oldGame;
    }

    public String getNewGame()
    {
        return newGame;
    }

    public void setNewGame(String newGame)
    {
        this.newGame = newGame;
    }
    @Override public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        ChangeInfo that = (ChangeInfo) o;
        return Objects.equals(contactInfo, that.contactInfo) && Objects.equals(oldGame, that.oldGame) && Objects
                .equals(newGame, that.newGame);
    }

    @Override public String toString()
    {
        return "ChangeInfo{" + "contactInfo='" + contactInfo + '\'' + ", oldGame='" + oldGame + '\'' + ", newGame='"
                + newGame + '\'' + '}';
    }
}
