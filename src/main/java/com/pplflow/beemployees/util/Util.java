package com.pplflow.beemployees.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public final class Util {
    private Util() {
    }

    public static ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }
}
