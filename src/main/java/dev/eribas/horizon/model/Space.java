package dev.eribas.horizon.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Space")
public class Space {
    @Id
    public String id;

    @Field("name")
    public String name;
}