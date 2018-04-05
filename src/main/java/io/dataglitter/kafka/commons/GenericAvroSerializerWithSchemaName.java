package io.dataglitter.kafka.commons;

import java.util.Map;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.common.serialization.Serializer;

import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;

public class GenericAvroSerializerWithSchemaName implements Serializer<GenericRecord> {

  KafkaAvroSerializerWithSchemaName inner;

  /**
   * Constructor used by Kafka Streams.
   */
  public GenericAvroSerializerWithSchemaName() {
    inner = new KafkaAvroSerializerWithSchemaName();
  }

  public GenericAvroSerializerWithSchemaName(SchemaRegistryClient client) {
    inner = new KafkaAvroSerializerWithSchemaName(client);
  }

  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {
    inner.configure(configs, isKey);
  }

  @Override
  public byte[] serialize(String topic, GenericRecord record) {
    return inner.serialize(topic, record);
  }

  @Override
  public void close() {
    inner.close();
  }
}
