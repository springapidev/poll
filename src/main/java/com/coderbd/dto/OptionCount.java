package com.coderbd.dto;

public class OptionCount {
    private Long optionId;
    private Long count;

    public OptionCount() {
    }

    public OptionCount(Long optionId, Long count) {
        this.optionId = optionId;
        this.count = count;
    }

    public Long getOptionId() {
        return optionId;
    }

    public Long getCount() {
        return count;
    }
}
