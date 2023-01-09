package demo.audit.listener;

import org.hibernate.envers.RevisionListener;

import demo.audit.entity.MyRevisionEntity;

public class MyRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        MyRevisionEntity rev = (MyRevisionEntity) revisionEntity;
        rev.setUsername("yakup");
    }
}
