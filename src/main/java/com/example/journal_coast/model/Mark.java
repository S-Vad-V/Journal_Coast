package com.example.journal_coast.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Marks")
public class Mark {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId subjectId;
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId studentId;
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId teacherId;
    private Integer mark;
}
