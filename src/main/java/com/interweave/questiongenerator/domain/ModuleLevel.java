package com.interweave.questiongenerator.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ModuleLevel {
    public String module;
    public Map<String, Integer> percentPerLevel = new LinkedHashMap<>();

    public ModuleLevel(String module, Map<String, Integer> percentPerLevel) {
        this.module = module;
        this.percentPerLevel = percentPerLevel;
    }

    public ModuleLevel() {
    }

    public String getModule() {
        return module;
    }

    public ModuleLevel setModule(String module) {
        this.module = module;
        return this;
    }

    public Map<String, Integer> getPercentPerLevel() {
        return percentPerLevel;
    }

    public ModuleLevel setPercentPerLevel(Map<String, Integer> percentPerLevel) {
        this.percentPerLevel = percentPerLevel;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModuleLevel that = (ModuleLevel) o;
        return Objects.equals(module, that.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(module);
    }
}
