package com.example.journal_coast.dao;

import com.example.journal_coast.exception.SDException;
import com.example.journal_coast.model.Student;
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
public class StudentDao {
    private MongoTemplate mongoTemplate;

    public Student getStudents(ObjectId studentId) {
        if (studentId == null) {
            throw new SDException("empty param");
        }
        return mongoTemplate.findOne(Query.query(Criteria.where("_id").is(studentId)), Student.class);
    }

    public Student saveStudents(Student student) {
        if (student == null) {
            throw new SDException("empty param");
        }
        return mongoTemplate.save(student);
    }
}
