package com.example.fitpal.mappers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public interface EntityMapper<From, To> {

    To map(From from);

    From unmap(To to);

    default List<To> map(List<From> from) {
        return from.stream().map(this::map).collect(Collectors.toList());
    }

    default List<From> unmap(List<To> to) { return to.stream().map(this::unmap).collect(Collectors.toList()); }
}
