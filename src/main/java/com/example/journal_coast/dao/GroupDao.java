package com.example.journal_coast.dao;

import com.example.journal_coast.exception.SDException;
import com.example.journal_coast.model.Group;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class GroupDao {
    private final MongoTemplate mongoTemplate;

    public Group getGroup(ObjectId groupId) throws SDException {
        if (groupId == null) {
            throw new SDException("empty param");
        }
        return mongoTemplate.findOne(Query.query(Criteria.where("_id").is(groupId)), Group.class);
    }

    public void saveGroup(Group group) throws SDException {
        if (group == null) {
            throw new SDException("empty param");
        }
        mongoTemplate.save(group);
    }

    public void deleteGroup(ObjectId groupId) {
        if (groupId == null) {
            throw new SDException("empty param");
        }
        mongoTemplate.remove(Query.query(Criteria.where("_id").is(groupId)), Group.class);
    }
}
