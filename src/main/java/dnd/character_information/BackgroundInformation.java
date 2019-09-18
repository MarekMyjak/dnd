package dnd.character_information;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Builder
class BackgroundInformation implements Named {
    String name;
    Alignment alignment;
}
