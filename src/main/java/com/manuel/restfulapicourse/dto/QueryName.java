package com.manuel.restfulapicourse.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class QueryName implements Serializable {
    List<String> firstnames = new ArrayList<>();
    public QueryName(){}

    public List<String> getFirstnames() {
        return firstnames;
    }
}
