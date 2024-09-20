package dev.eribas.horizon.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateSpaceRequest {

    private @NonNull String id;
    private @NonNull String name;

}
