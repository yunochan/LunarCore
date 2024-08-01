// Code generated by protocol buffer compiler. Do not edit!
package emu.lunarcore.proto;

import java.io.IOException;
import us.hebi.quickbuf.FieldName;
import us.hebi.quickbuf.InvalidProtocolBufferException;
import us.hebi.quickbuf.JsonSink;
import us.hebi.quickbuf.JsonSource;
import us.hebi.quickbuf.MessageFactory;
import us.hebi.quickbuf.ProtoMessage;
import us.hebi.quickbuf.ProtoSink;
import us.hebi.quickbuf.ProtoSource;

public final class RelicAvatarRecommendCsReqOuterClass {
  /**
   * Protobuf type {@code RelicAvatarRecommendCsReq}
   */
  public static final class RelicAvatarRecommendCsReq extends ProtoMessage<RelicAvatarRecommendCsReq> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 set_id = 13;</code>
     */
    private int setId;

    private RelicAvatarRecommendCsReq() {
    }

    /**
     * @return a new empty instance of {@code RelicAvatarRecommendCsReq}
     */
    public static RelicAvatarRecommendCsReq newInstance() {
      return new RelicAvatarRecommendCsReq();
    }

    /**
     * <code>optional uint32 set_id = 13;</code>
     * @return whether the setId field is set
     */
    public boolean hasSetId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 set_id = 13;</code>
     * @return this
     */
    public RelicAvatarRecommendCsReq clearSetId() {
      bitField0_ &= ~0x00000001;
      setId = 0;
      return this;
    }

    /**
     * <code>optional uint32 set_id = 13;</code>
     * @return the setId
     */
    public int getSetId() {
      return setId;
    }

    /**
     * <code>optional uint32 set_id = 13;</code>
     * @param value the setId to set
     * @return this
     */
    public RelicAvatarRecommendCsReq setSetId(final int value) {
      bitField0_ |= 0x00000001;
      setId = value;
      return this;
    }

    @Override
    public RelicAvatarRecommendCsReq copyFrom(final RelicAvatarRecommendCsReq other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        setId = other.setId;
      }
      return this;
    }

    @Override
    public RelicAvatarRecommendCsReq mergeFrom(final RelicAvatarRecommendCsReq other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasSetId()) {
        setSetId(other.setId);
      }
      return this;
    }

    @Override
    public RelicAvatarRecommendCsReq clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      setId = 0;
      return this;
    }

    @Override
    public RelicAvatarRecommendCsReq clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof RelicAvatarRecommendCsReq)) {
        return false;
      }
      RelicAvatarRecommendCsReq other = (RelicAvatarRecommendCsReq) o;
      return bitField0_ == other.bitField0_
        && (!hasSetId() || setId == other.setId);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 104);
        output.writeUInt32NoTag(setId);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(setId);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public RelicAvatarRecommendCsReq mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 104: {
            // setId
            setId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 0) {
              break;
            }
          }
          case 0: {
            return this;
          }
          default: {
            if (!input.skipField(tag)) {
              return this;
            }
            tag = input.readTag();
            break;
          }
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeUInt32(FieldNames.setId, setId);
      }
      output.endObject();
    }

    @Override
    public RelicAvatarRecommendCsReq mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 109327645:
          case -905788904: {
            if (input.isAtField(FieldNames.setId)) {
              if (!input.trySkipNullValue()) {
                setId = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          default: {
            input.skipUnknownField();
            break;
          }
        }
      }
      input.endObject();
      return this;
    }

    @Override
    public RelicAvatarRecommendCsReq clone() {
      return new RelicAvatarRecommendCsReq().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static RelicAvatarRecommendCsReq parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new RelicAvatarRecommendCsReq(), data).checkInitialized();
    }

    public static RelicAvatarRecommendCsReq parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RelicAvatarRecommendCsReq(), input).checkInitialized();
    }

    public static RelicAvatarRecommendCsReq parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RelicAvatarRecommendCsReq(), input).checkInitialized();
    }

    /**
     * @return factory for creating RelicAvatarRecommendCsReq messages
     */
    public static MessageFactory<RelicAvatarRecommendCsReq> getFactory() {
      return RelicAvatarRecommendCsReqFactory.INSTANCE;
    }

    private enum RelicAvatarRecommendCsReqFactory implements MessageFactory<RelicAvatarRecommendCsReq> {
      INSTANCE;

      @Override
      public RelicAvatarRecommendCsReq create() {
        return RelicAvatarRecommendCsReq.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName setId = FieldName.forField("setId", "set_id");
    }
  }
}
