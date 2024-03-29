/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package avro_pojos;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class CustomerTransactionsPair extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3247105332257000205L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CustomerTransactionsPair\",\"namespace\":\"com.sephora.dataplatform.avro\",\"fields\":[{\"name\":\"previous\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"CustomerTransactions\",\"fields\":[{\"name\":\"return_surrogate_key\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"dp_reference_number\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"return_reference_number\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"usa_id\",\"type\":[\"null\",\"long\"],\"doc\":\"bi_id\",\"default\":null},{\"name\":\"sephora_id\",\"type\":[\"null\",\"long\"],\"doc\":\"sephora_id field\",\"default\":null},{\"name\":\"online_atg_id\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"online_atg_id field\",\"default\":null},{\"name\":\"card_numbers\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":[]}],\"default\":null},{\"name\":\"return_auth_flag\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"return_auth_flag field\",\"default\":null},{\"name\":\"reason_text\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"the reason why the current return has such return_auth_flag\",\"default\":null},{\"name\":\"cust_sale_counter\",\"type\":\"int\",\"doc\":\"cust_sale_counter field\"},{\"name\":\"cust_return_counter\",\"type\":\"int\",\"doc\":\"cust_return_counter field\"},{\"name\":\"pct_sale_to_return\",\"type\":\"double\",\"doc\":\"pct_sale_to_return field\"},{\"name\":\"created_date\",\"type\":\"long\",\"doc\":\"created_date field\"},{\"name\":\"start_date\",\"type\":\"long\",\"doc\":\"start_date field\"},{\"name\":\"end_date\",\"type\":\"long\",\"doc\":\"end_date field\"},{\"name\":\"active_flag\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"active_flag field A or I\",\"default\":\"A\"},{\"name\":\"orders\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"OrderHeaderTender\",\"fields\":[{\"name\":\"order_header\",\"type\":[{\"type\":\"record\",\"name\":\"OrderHeaderConsolidated\",\"fields\":[{\"name\":\"org_id\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"atg_id\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"usa_id\",\"type\":[\"null\",\"long\"]},{\"name\":\"sephora_id\",\"type\":[\"null\",\"long\"]},{\"name\":\"order_number\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"original_order_number\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"channel_type\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"transaction_type\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"store_number\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"cancel_flag\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"order_cancel_flag\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"order_cancel_datetime\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"order_submit_datetime\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"order_submit_datetime_local\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"order_submit_date\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"is_declined\",\"type\":\"boolean\",\"default\":false},{\"name\":\"return_auth_flag\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"return_reason_text\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"return_reference_number\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"return_group_id\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"return_sale_counter\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"return_return_counter\",\"type\":[\"null\",\"int\"],\"default\":null}]},\"null\"]},{\"name\":\"order_tender\",\"type\":[{\"type\":\"record\",\"name\":\"OrderTenderDetailsEvents\",\"fields\":[{\"name\":\"order_number\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"card_number\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"channel_type\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"transaction_type\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"order_submit_date\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]},\"null\"]},{\"name\":\"batch_id\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"group_id\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"number_of_accounts\",\"type\":\"int\",\"default\":1},{\"name\":\"is_primary\",\"type\":\"boolean\",\"doc\":\"means that transaction is directly related to the aggregation key\",\"default\":false},{\"name\":\"is_merge\",\"type\":\"boolean\",\"doc\":\"means that need to change key to usa_id from order_header (only if is_primary = true)\",\"default\":false}]},\"default\":[]},\"default\":[]},{\"name\":\"record_update_flag\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"record_update_flag field U or D\",\"default\":\"U\"},{\"name\":\"number_of_accounts\",\"type\":\"int\",\"default\":1},{\"name\":\"group_id\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"is_primary\",\"type\":\"boolean\",\"default\":false}]}],\"default\":null},{\"name\":\"current\",\"type\":\"CustomerTransactions\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CustomerTransactionsPair> ENCODER =
      new BinaryMessageEncoder<CustomerTransactionsPair>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CustomerTransactionsPair> DECODER =
      new BinaryMessageDecoder<CustomerTransactionsPair>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CustomerTransactionsPair> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CustomerTransactionsPair> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CustomerTransactionsPair> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CustomerTransactionsPair>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CustomerTransactionsPair to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CustomerTransactionsPair from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CustomerTransactionsPair instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CustomerTransactionsPair fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public CustomerTransactions previous;
  @Deprecated public CustomerTransactions current;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CustomerTransactionsPair() {}

  /**
   * All-args constructor.
   * @param previous The new value for previous
   * @param current The new value for current
   */
  public CustomerTransactionsPair(CustomerTransactions previous, CustomerTransactions current) {
    this.previous = previous;
    this.current = current;
  }

  public SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return previous;
    case 1: return current;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: previous = (CustomerTransactions)value$; break;
    case 1: current = (CustomerTransactions)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'previous' field.
   * @return The value of the 'previous' field.
   */
  public CustomerTransactions getPrevious() {
    return previous;
  }


  /**
   * Sets the value of the 'previous' field.
   * @param value the value to set.
   */
  public void setPrevious(CustomerTransactions value) {
    this.previous = value;
  }

  /**
   * Gets the value of the 'current' field.
   * @return The value of the 'current' field.
   */
  public CustomerTransactions getCurrent() {
    return current;
  }


  /**
   * Sets the value of the 'current' field.
   * @param value the value to set.
   */
  public void setCurrent(CustomerTransactions value) {
    this.current = value;
  }

  /**
   * Creates a new CustomerTransactionsPair RecordBuilder.
   * @return A new CustomerTransactionsPair RecordBuilder
   */
  public static CustomerTransactionsPair.Builder newBuilder() {
    return new CustomerTransactionsPair.Builder();
  }

  /**
   * Creates a new CustomerTransactionsPair RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CustomerTransactionsPair RecordBuilder
   */
  public static CustomerTransactionsPair.Builder newBuilder(CustomerTransactionsPair.Builder other) {
    if (other == null) {
      return new CustomerTransactionsPair.Builder();
    } else {
      return new CustomerTransactionsPair.Builder(other);
    }
  }

  /**
   * Creates a new CustomerTransactionsPair RecordBuilder by copying an existing CustomerTransactionsPair instance.
   * @param other The existing instance to copy.
   * @return A new CustomerTransactionsPair RecordBuilder
   */
  public static CustomerTransactionsPair.Builder newBuilder(CustomerTransactionsPair other) {
    if (other == null) {
      return new CustomerTransactionsPair.Builder();
    } else {
      return new CustomerTransactionsPair.Builder(other);
    }
  }

  /**
   * RecordBuilder for CustomerTransactionsPair instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CustomerTransactionsPair>
    implements org.apache.avro.data.RecordBuilder<CustomerTransactionsPair> {

    private CustomerTransactions previous;
    private CustomerTransactions.Builder previousBuilder;
    private CustomerTransactions current;
    private CustomerTransactions.Builder currentBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(CustomerTransactionsPair.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.previous)) {
        this.previous = data().deepCopy(fields()[0].schema(), other.previous);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (other.hasPreviousBuilder()) {
        this.previousBuilder = CustomerTransactions.newBuilder(other.getPreviousBuilder());
      }
      if (isValidValue(fields()[1], other.current)) {
        this.current = data().deepCopy(fields()[1].schema(), other.current);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (other.hasCurrentBuilder()) {
        this.currentBuilder = CustomerTransactions.newBuilder(other.getCurrentBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing CustomerTransactionsPair instance
     * @param other The existing instance to copy.
     */
    private Builder(CustomerTransactionsPair other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.previous)) {
        this.previous = data().deepCopy(fields()[0].schema(), other.previous);
        fieldSetFlags()[0] = true;
      }
      this.previousBuilder = null;
      if (isValidValue(fields()[1], other.current)) {
        this.current = data().deepCopy(fields()[1].schema(), other.current);
        fieldSetFlags()[1] = true;
      }
      this.currentBuilder = null;
    }

    /**
      * Gets the value of the 'previous' field.
      * @return The value.
      */
    public CustomerTransactions getPrevious() {
      return previous;
    }


    /**
      * Sets the value of the 'previous' field.
      * @param value The value of 'previous'.
      * @return This builder.
      */
    public CustomerTransactionsPair.Builder setPrevious(CustomerTransactions value) {
      validate(fields()[0], value);
      this.previousBuilder = null;
      this.previous = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'previous' field has been set.
      * @return True if the 'previous' field has been set, false otherwise.
      */
    public boolean hasPrevious() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'previous' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public CustomerTransactions.Builder getPreviousBuilder() {
      if (previousBuilder == null) {
        if (hasPrevious()) {
          setPreviousBuilder(CustomerTransactions.newBuilder(previous));
        } else {
          setPreviousBuilder(CustomerTransactions.newBuilder());
        }
      }
      return previousBuilder;
    }

    /**
     * Sets the Builder instance for the 'previous' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public CustomerTransactionsPair.Builder setPreviousBuilder(CustomerTransactions.Builder value) {
      clearPrevious();
      previousBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'previous' field has an active Builder instance
     * @return True if the 'previous' field has an active Builder instance
     */
    public boolean hasPreviousBuilder() {
      return previousBuilder != null;
    }

    /**
      * Clears the value of the 'previous' field.
      * @return This builder.
      */
    public CustomerTransactionsPair.Builder clearPrevious() {
      previous = null;
      previousBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'current' field.
      * @return The value.
      */
    public CustomerTransactions getCurrent() {
      return current;
    }


    /**
      * Sets the value of the 'current' field.
      * @param value The value of 'current'.
      * @return This builder.
      */
    public CustomerTransactionsPair.Builder setCurrent(CustomerTransactions value) {
      validate(fields()[1], value);
      this.currentBuilder = null;
      this.current = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'current' field has been set.
      * @return True if the 'current' field has been set, false otherwise.
      */
    public boolean hasCurrent() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'current' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public CustomerTransactions.Builder getCurrentBuilder() {
      if (currentBuilder == null) {
        if (hasCurrent()) {
          setCurrentBuilder(CustomerTransactions.newBuilder(current));
        } else {
          setCurrentBuilder(CustomerTransactions.newBuilder());
        }
      }
      return currentBuilder;
    }

    /**
     * Sets the Builder instance for the 'current' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public CustomerTransactionsPair.Builder setCurrentBuilder(CustomerTransactions.Builder value) {
      clearCurrent();
      currentBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'current' field has an active Builder instance
     * @return True if the 'current' field has an active Builder instance
     */
    public boolean hasCurrentBuilder() {
      return currentBuilder != null;
    }

    /**
      * Clears the value of the 'current' field.
      * @return This builder.
      */
    public CustomerTransactionsPair.Builder clearCurrent() {
      current = null;
      currentBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CustomerTransactionsPair build() {
      try {
        CustomerTransactionsPair record = new CustomerTransactionsPair();
        if (previousBuilder != null) {
          try {
            record.previous = this.previousBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("previous"));
            throw e;
          }
        } else {
          record.previous = fieldSetFlags()[0] ? this.previous : (CustomerTransactions) defaultValue(fields()[0]);
        }
        if (currentBuilder != null) {
          try {
            record.current = this.currentBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("current"));
            throw e;
          }
        } else {
          record.current = fieldSetFlags()[1] ? this.current : (CustomerTransactions) defaultValue(fields()[1]);
        }
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CustomerTransactionsPair>
    WRITER$ = (org.apache.avro.io.DatumWriter<CustomerTransactionsPair>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CustomerTransactionsPair>
    READER$ = (org.apache.avro.io.DatumReader<CustomerTransactionsPair>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.previous == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      this.previous.customEncode(out);
    }

    this.current.customEncode(out);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.previous = null;
      } else {
        if (this.previous == null) {
          this.previous = new CustomerTransactions();
        }
        this.previous.customDecode(in);
      }

      if (this.current == null) {
        this.current = new CustomerTransactions();
      }
      this.current.customDecode(in);

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.previous = null;
          } else {
            if (this.previous == null) {
              this.previous = new CustomerTransactions();
            }
            this.previous.customDecode(in);
          }
          break;

        case 1:
          if (this.current == null) {
            this.current = new CustomerTransactions();
          }
          this.current.customDecode(in);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










