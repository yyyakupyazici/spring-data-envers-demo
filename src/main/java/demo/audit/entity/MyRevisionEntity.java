package demo.audit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import demo.audit.listener.MyRevisionListener;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "revinfo")
@RevisionEntity(MyRevisionListener.class)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class MyRevisionEntity extends DefaultRevisionEntity {

    @Column(name = "username")
    private String username;
}