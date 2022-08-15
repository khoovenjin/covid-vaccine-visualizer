package datastructure;

import java.util.Optional;
import java.util.function.Function;

public class Nullable<T> {
    private Optional<T> data;

    public Nullable (T data) {
        this.data = Optional.ofNullable(data);
    }

    public T value() {
        return data.get();
    }

    public void setData (T data) { 
        this.data = Optional.ofNullable(data);
    }

    public Optional<T> getData () {
        return data;
    }

    public final Nullable<T> bind (Nullable<T> amplified, Function<T, Nullable<T>> func) {
        if (amplified.value() == null)
            return null;
        else
            return func.apply(amplified.value());
    }
}