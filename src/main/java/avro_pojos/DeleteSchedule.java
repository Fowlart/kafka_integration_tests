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
public class DeleteSchedule extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8526559199473065874L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DeleteSchedule\",\"namespace\":\"com.sephora.dataplatform.avro\",\"fields\":[{\"name\":\"return_reference_number\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"start_date\",\"type\":\"long\",\"doc\":\"start_date field\"},{\"name\":\"transactions_summary\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"CustomerTransactionsSummary\",\"fields\":[{\"name\":\"return_surrogate_key\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"return_reference_number\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"usa_id\",\"type\":[\"null\",\"long\"],\"doc\":\"bi_id\",\"default\":null},{\"name\":\"sephora_id\",\"type\":[\"null\",\"long\"],\"doc\":\"sephora_id field\",\"default\":null},{\"name\":\"online_atg_id\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"online_atg_id field\",\"default\":null},{\"name\":\"card_number\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"card_number token from order_tender_details_events table\",\"default\":null},{\"name\":\"return_auth_flag\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"return_auth_flag field\",\"default\":null},{\"name\":\"reason_text\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"the reason why the current return has such return_auth_flag\",\"default\":null},{\"name\":\"cust_sale_counter\",\"type\":\"int\",\"doc\":\"cust_sale_counter field\"},{\"name\":\"cust_return_counter\",\"type\":\"int\",\"doc\":\"cust_return_counter field\"},{\"name\":\"pct_sale_to_return\",\"type\":\"double\",\"doc\":\"pct_sale_to_return field\"},{\"name\":\"created_date\",\"type\":\"long\",\"doc\":\"created_date field\"},{\"name\":\"start_date\",\"type\":\"long\",\"doc\":\"start_date field\"},{\"name\":\"end_date\",\"type\":\"long\",\"doc\":\"end_date field\"},{\"name\":\"active_flag\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"active_flag field A or I\",\"default\":\"A\"},{\"name\":\"record_update_flag\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"record_update_flag field U or D\",\"default\":\"U\"}]},\"default\":[]},\"default\":[]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<DeleteSchedule> ENCODER =
      new BinaryMessageEncoder<DeleteSchedule>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<DeleteSchedule> DECODER =
      new BinaryMessageDecoder<DeleteSchedule>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<DeleteSchedule> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<DeleteSchedule> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<DeleteSchedule> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<DeleteSchedule>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this DeleteSchedule to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a DeleteSchedule from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a DeleteSchedule instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static DeleteSchedule fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public String return_reference_number;
  /** start_date field */
  @Deprecated public long start_date;
  @Deprecated public java.util.List<CustomerTransactionsSummary> transactions_summary;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public DeleteSchedule() {}

  /**
   * All-args constructor.
   * @param return_reference_number The new value for return_reference_number
   * @param start_date start_date field
   * @param transactions_summary The new value for transactions_summary
   */
  public DeleteSchedule(String return_reference_number, Long start_date, java.util.List<CustomerTransactionsSummary> transactions_summary) {
    this.return_reference_number = return_reference_number;
    this.start_date = start_date;
    this.transactions_summary = transactions_summary;
  }

  public SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return return_reference_number;
    case 1: return start_date;
    case 2: return transactions_summary;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: return_reference_number = value$ != null ? value$.toString() : null; break;
    case 1: start_date = (Long)value$; break;
    case 2: transactions_summary = (java.util.List<CustomerTransactionsSummary>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'return_reference_number' field.
   * @return The value of the 'return_reference_number' field.
   */
  public String getReturnReferenceNumber() {
    return return_reference_number;
  }


  /**
   * Sets the value of the 'return_reference_number' field.
   * @param value the value to set.
   */
  public void setReturnReferenceNumber(String value) {
    this.return_reference_number = value;
  }

  /**
   * Gets the value of the 'start_date' field.
   * @return start_date field
   */
  public long getStartDate() {
    return start_date;
  }


  /**
   * Sets the value of the 'start_date' field.
   * start_date field
   * @param value the value to set.
   */
  public void setStartDate(long value) {
    this.start_date = value;
  }

  /**
   * Gets the value of the 'transactions_summary' field.
   * @return The value of the 'transactions_summary' field.
   */
  public java.util.List<CustomerTransactionsSummary> getTransactionsSummary() {
    return transactions_summary;
  }


  /**
   * Sets the value of the 'transactions_summary' field.
   * @param value the value to set.
   */
  public void setTransactionsSummary(java.util.List<CustomerTransactionsSummary> value) {
    this.transactions_summary = value;
  }

  /**
   * Creates a new DeleteSchedule RecordBuilder.
   * @return A new DeleteSchedule RecordBuilder
   */
  public static DeleteSchedule.Builder newBuilder() {
    return new DeleteSchedule.Builder();
  }

  /**
   * Creates a new DeleteSchedule RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new DeleteSchedule RecordBuilder
   */
  public static DeleteSchedule.Builder newBuilder(DeleteSchedule.Builder other) {
    if (other == null) {
      return new DeleteSchedule.Builder();
    } else {
      return new DeleteSchedule.Builder(other);
    }
  }

  /**
   * Creates a new DeleteSchedule RecordBuilder by copying an existing DeleteSchedule instance.
   * @param other The existing instance to copy.
   * @return A new DeleteSchedule RecordBuilder
   */
  public static DeleteSchedule.Builder newBuilder(DeleteSchedule other) {
    if (other == null) {
      return new DeleteSchedule.Builder();
    } else {
      return new DeleteSchedule.Builder(other);
    }
  }

  /**
   * RecordBuilder for DeleteSchedule instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DeleteSchedule>
    implements org.apache.avro.data.RecordBuilder<DeleteSchedule> {

    private String return_reference_number;
    /** start_date field */
    private long start_date;
    private java.util.List<CustomerTransactionsSummary> transactions_summary;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(DeleteSchedule.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.return_reference_number)) {
        this.return_reference_number = data().deepCopy(fields()[0].schema(), other.return_reference_number);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.start_date)) {
        this.start_date = data().deepCopy(fields()[1].schema(), other.start_date);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.transactions_summary)) {
        this.transactions_summary = data().deepCopy(fields()[2].schema(), other.transactions_summary);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing DeleteSchedule instance
     * @param other The existing instance to copy.
     */
    private Builder(DeleteSchedule other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.return_reference_number)) {
        this.return_reference_number = data().deepCopy(fields()[0].schema(), other.return_reference_number);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.start_date)) {
        this.start_date = data().deepCopy(fields()[1].schema(), other.start_date);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.transactions_summary)) {
        this.transactions_summary = data().deepCopy(fields()[2].schema(), other.transactions_summary);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'return_reference_number' field.
      * @return The value.
      */
    public String getReturnReferenceNumber() {
      return return_reference_number;
    }


    /**
      * Sets the value of the 'return_reference_number' field.
      * @param value The value of 'return_reference_number'.
      * @return This builder.
      */
    public DeleteSchedule.Builder setReturnReferenceNumber(String value) {
      validate(fields()[0], value);
      this.return_reference_number = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'return_reference_number' field has been set.
      * @return True if the 'return_reference_number' field has been set, false otherwise.
      */
    public boolean hasReturnReferenceNumber() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'return_reference_number' field.
      * @return This builder.
      */
    public DeleteSchedule.Builder clearReturnReferenceNumber() {
      return_reference_number = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'start_date' field.
      * start_date field
      * @return The value.
      */
    public long getStartDate() {
      return start_date;
    }


    /**
      * Sets the value of the 'start_date' field.
      * start_date field
      * @param value The value of 'start_date'.
      * @return This builder.
      */
    public DeleteSchedule.Builder setStartDate(long value) {
      validate(fields()[1], value);
      this.start_date = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'start_date' field has been set.
      * start_date field
      * @return True if the 'start_date' field has been set, false otherwise.
      */
    public boolean hasStartDate() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'start_date' field.
      * start_date field
      * @return This builder.
      */
    public DeleteSchedule.Builder clearStartDate() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'transactions_summary' field.
      * @return The value.
      */
    public java.util.List<CustomerTransactionsSummary> getTransactionsSummary() {
      return transactions_summary;
    }


    /**
      * Sets the value of the 'transactions_summary' field.
      * @param value The value of 'transactions_summary'.
      * @return This builder.
      */
    public DeleteSchedule.Builder setTransactionsSummary(java.util.List<CustomerTransactionsSummary> value) {
      validate(fields()[2], value);
      this.transactions_summary = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'transactions_summary' field has been set.
      * @return True if the 'transactions_summary' field has been set, false otherwise.
      */
    public boolean hasTransactionsSummary() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'transactions_summary' field.
      * @return This builder.
      */
    public DeleteSchedule.Builder clearTransactionsSummary() {
      transactions_summary = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public DeleteSchedule build() {
      try {
        DeleteSchedule record = new DeleteSchedule();
        record.return_reference_number = fieldSetFlags()[0] ? this.return_reference_number : (String) defaultValue(fields()[0]);
        record.start_date = fieldSetFlags()[1] ? this.start_date : (Long) defaultValue(fields()[1]);
        record.transactions_summary = fieldSetFlags()[2] ? this.transactions_summary : (java.util.List<CustomerTransactionsSummary>) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<DeleteSchedule>
    WRITER$ = (org.apache.avro.io.DatumWriter<DeleteSchedule>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<DeleteSchedule>
    READER$ = (org.apache.avro.io.DatumReader<DeleteSchedule>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.return_reference_number == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.return_reference_number);
    }

    out.writeLong(this.start_date);

    long size0 = this.transactions_summary.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (CustomerTransactionsSummary e0: this.transactions_summary) {
      actualSize0++;
      out.startItem();
      e0.customEncode(out);
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.return_reference_number = null;
      } else {
        this.return_reference_number = in.readString();
      }

      this.start_date = in.readLong();

      long size0 = in.readArrayStart();
      java.util.List<CustomerTransactionsSummary> a0 = this.transactions_summary;
      if (a0 == null) {
        a0 = new SpecificData.Array<CustomerTransactionsSummary>((int)size0, SCHEMA$.getField("transactions_summary").schema());
        this.transactions_summary = a0;
      } else a0.clear();
      SpecificData.Array<CustomerTransactionsSummary> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<CustomerTransactionsSummary>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          CustomerTransactionsSummary e0 = (ga0 != null ? ga0.peek() : null);
          if (e0 == null) {
            e0 = new CustomerTransactionsSummary();
          }
          e0.customDecode(in);
          a0.add(e0);
        }
      }

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.return_reference_number = null;
          } else {
            this.return_reference_number = in.readString();
          }
          break;

        case 1:
          this.start_date = in.readLong();
          break;

        case 2:
          long size0 = in.readArrayStart();
          java.util.List<CustomerTransactionsSummary> a0 = this.transactions_summary;
          if (a0 == null) {
            a0 = new SpecificData.Array<CustomerTransactionsSummary>((int)size0, SCHEMA$.getField("transactions_summary").schema());
            this.transactions_summary = a0;
          } else a0.clear();
          SpecificData.Array<CustomerTransactionsSummary> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<CustomerTransactionsSummary>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              CustomerTransactionsSummary e0 = (ga0 != null ? ga0.peek() : null);
              if (e0 == null) {
                e0 = new CustomerTransactionsSummary();
              }
              e0.customDecode(in);
              a0.add(e0);
            }
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









