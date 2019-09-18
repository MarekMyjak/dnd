package dnd;

import lombok.Builder;

@Builder
class DefaultCharacterInformation implements CharacterInformation {
    @Builder.Default
    AbilityScore abilityScore;
    @Builder.Default
    int armorClass;
    @Builder.Default
    DefaultHitPoints defaultHitPoints;

    @Override
    public CharacterCondition getCharacterCondition() {
        return null;
    }

    @Override
    public DefaultHitPoints getHitPoints() {
        return defaultHitPoints;
    }

    @Override
    public boolean isHit(int roll) {
        return false;
    }

    @Override
    public int getExperiencePoints() {
        return 0;
    }

    @Override
    public void increaseExperience(int i) { }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getArmorClass() {
        return armorClass + abilityScore.getModifiers(abilityScore.getDexterity());
    }

    public static class DefaultCharacterInformationBuilder {
        private static final int DEFAULT_ARMOR_CLASS = 10;

        public DefaultCharacterInformationBuilder() {
            this.abilityScore = AbilityScore.builder().build();
            this.armorClass = DEFAULT_ARMOR_CLASS;
            this.defaultHitPoints = new DefaultHitPoints(abilityScore);
        }

        DefaultCharacterInformation build() {
            return new DefaultCharacterInformation(abilityScore,
                    armorClass,
                    new DefaultHitPoints(abilityScore));
        }
    }
}
