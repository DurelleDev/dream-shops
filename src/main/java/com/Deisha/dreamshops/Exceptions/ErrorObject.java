package com.Deisha.dreamshops.Exceptions;

import jdk.jfr.MetadataDefinition;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class ErrorObject {
    private Integer statusCode;
    private String message;
    private Date timeStamp;
}


