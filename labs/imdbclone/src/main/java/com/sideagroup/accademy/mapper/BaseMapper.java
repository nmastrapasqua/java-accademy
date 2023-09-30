package com.sideagroup.accademy.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public abstract class BaseMapper {

    protected String normalizeCharacters(String characters) {
        if (characters == null)
            return null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<String> characterList =
                    Arrays.asList(mapper.readValue(characters, String[].class));
            return characterList.toString()
                    .replace("[", "")
                    .replace("]", "");
        } catch (JsonProcessingException e) {
            return characters;
        }
    }
}
