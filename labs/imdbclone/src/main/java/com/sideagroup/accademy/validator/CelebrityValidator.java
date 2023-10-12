package com.sideagroup.accademy.validator;

import com.sideagroup.accademy.exception.GenericServiceException;
import org.springframework.stereotype.Component;

@Component
public class CelebrityValidator {

    public void validateQueryParams(String orderBy) {
        if (!"id".equals(orderBy) &&
                !"primaryName".equals(orderBy)) {
            throw new GenericServiceException("Invalid Sort field '" + orderBy + "'. Valid values are: [id, primaryName]");
        }
    }
}
