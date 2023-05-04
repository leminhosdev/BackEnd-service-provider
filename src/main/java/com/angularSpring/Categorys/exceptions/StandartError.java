package com.angularSpring.Categorys.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandartError {

    private Long timestamp;
    private Integer status;
    private String error;


}
