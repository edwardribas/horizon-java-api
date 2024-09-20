package dev.eribas.horizon.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NonNull
@NoArgsConstructor
public class UpdateSpaceRequest {

    private String id;
    private String name;

}
