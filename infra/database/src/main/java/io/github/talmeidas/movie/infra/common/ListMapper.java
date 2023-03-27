package io.github.talmeidas.movie.infra.common;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public interface ListMapper<T, K> {

    default List<T> of(final List<K> elements, final Function<K, T> mapper) {
        final List<T> result = new ArrayList<>(elements.size());
        elements.forEach(element -> result.add(mapper.apply(element)));
        return result;
    }
}