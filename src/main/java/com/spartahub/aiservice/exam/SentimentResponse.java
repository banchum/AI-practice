package com.spartahub.aiservice.exam;

public class SentimentResponse {
    public enum Sentiment {
        POSITIVE, NEUTRAL, NEGATIVE
    }

    private Sentiment sentiment;
    private String reason;

    public Sentiment getSentiment() {
        return sentiment;
    }

    public void setSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
