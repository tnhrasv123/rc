package com.raceclicker.achievements;

public class Achievement {
    private final String id;
    private final String name;
    private final String description;
    private final String category;
    private final String level;
    private final int points;
    private final String rewardType;
    private final Object rewardValue; // Can be String (title) or Number (amount)
    private final int progressRequired;

    public Achievement(String id, String name, String description, String category, String level, int points, String rewardType, Object rewardValue, int progressRequired) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.level = level;
        this.points = points;
        this.rewardType = rewardType;
        this.rewardValue = rewardValue;
        this.progressRequired = progressRequired;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getLevel() {
        return level;
    }

    public int getPoints() {
        return points;
    }

    public String getRewardType() {
        return rewardType;
    }

    public Object getRewardValue() {
        return rewardValue;
    }

    public int getProgressRequired() {
        return progressRequired;
    }
}