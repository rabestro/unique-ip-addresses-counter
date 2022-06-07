package lv.id.jc.ipv4;

import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Stream;

/**
 * Unique IPv4 addresses counter
 */
public class UniqueAddressCounter implements ToLongFunction<Stream<String>> {

    private final IntSet container;
    private final ToIntFunction<CharSequence> converter;

    public UniqueAddressCounter(IntSet container, ToIntFunction<CharSequence> converter) {
        this.container = container;
        this.converter = converter;
    }

    @Override
    public long applyAsLong(Stream<String> addresses) {
        addresses.mapToInt(converter).forEach(container::add);
        return container.size();
    }
}
