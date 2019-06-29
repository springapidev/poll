package com.coderbd.dto;

public class OptionCount {
    private Long optionId;
    private Long count=0L;

    public OptionCount() {
    }

    public OptionCount(Long optionId, Long count) {
        this.optionId = optionId;
        this.count = count;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getOptionId() {
        return optionId;
    }

    public Long getCount() {
        return count;
    }
}
