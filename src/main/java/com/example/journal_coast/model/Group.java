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
@Document(collection = "Groups")
public class Group {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    @JsonSerialize(contentUsing = ListObjectIdJsonSerializer.class)
    private List<ObjectId> subjectIds;
    private String name;
    private String faculty;
}
