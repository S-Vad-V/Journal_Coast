package com.example.journal_coast.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.utair.sd.mongo.model.deserialiezer.ListObjectIdJsonSerializer;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Teachers")
public class Teacher {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String phone;
    private String address;
    private String job;
    private String scienceDegree;
    @JsonSerialize(contentUsing = ListObjectIdJsonSerializer.class)
    private List<ObjectId> groupIds;
    @JsonSerialize(contentUsing = ListObjectIdJsonSerializer.class)
    private List<ObjectId> subjectIds;
}
