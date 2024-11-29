package com.example.pocJop.Dto;

public interface UnidirectionalMapper<I, O> {
    I from(O input);
}
