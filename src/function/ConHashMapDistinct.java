package function;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConHashMapDistinct {
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> ExtractKey) {
        Set<Object> chm = ConcurrentHashMap.newKeySet();
        return k -> chm.add(ExtractKey.apply(k));
    }
}
