package dev.eribas.horizon.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Space")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Space {

    @Id
    private String id;
    private String name;

}
