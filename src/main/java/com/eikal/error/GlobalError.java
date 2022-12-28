package com.eikal.error;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author David Kinyanjui
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GlobalError {
    private short status;
    private String message;
}
