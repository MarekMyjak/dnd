package dnd.character_information;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DefaultExperiencePoints implements ExperiencePoints {
    int experiencePoints;

    @Override
    public void increaseExperience(int amount) {
        experiencePoints += amount;
    }

    @Override
    public int getLevel() {
        return (experiencePoints / 1000) + 1;
    }
}
