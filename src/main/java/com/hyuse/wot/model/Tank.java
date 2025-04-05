package com.hyuse.wot.model;

import com.hyuse.wot.enums.Nation;
import com.hyuse.wot.enums.Roles;
import com.hyuse.wot.enums.Tier;
import com.hyuse.wot.enums.Types;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Tank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Types type;

    @Column(nullable = false)
    private Tier tier;

    @Column(nullable = false)
    private Nation nation;

    @Column(name = "tanks_roles", nullable = false)
    private Roles roles;

    @Embedded
    private Images images;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Types getType() {
        return type;
    }

    public Tier getTier() {
        return tier;
    }

    public Nation getNation() {
        return nation;
    }

    public Roles getRoles() {
        return roles;
    }

    public Images getImages() {
        return images;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tank tank = (Tank) o;
        return Objects.equals(id, tank.id) && Objects.equals(name, tank.name) && type == tank.type && tier == tank.tier && nation == tank.nation && roles == tank.roles && Objects.equals(images, tank.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, tier, nation, roles, images);
    }

    @Override
    public String toString() {
        return "Tank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", tier=" + tier +
                ", nation=" + nation +
                ", roles=" + roles +
                ", images=" + images +
                '}';
    }
}
