package io.dataglitter.kafka.commons.generics;

/**
 * Created by reddys on 10/03/2018.
 */
public interface SchemaAdaptor<T1, T2, T3> {
    T1 adapt() throws Exception;
    T3 populateRecord(T2 t2);
}
