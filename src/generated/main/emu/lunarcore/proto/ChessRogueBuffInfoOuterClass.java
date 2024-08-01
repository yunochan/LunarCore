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

public final class ChessRogueBuffInfoOuterClass {
  /**
   * Protobuf type {@code ChessRogueBuffInfo}
   */
  public static final class ChessRogueBuffInfo extends ProtoMessage<ChessRogueBuffInfo> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional .ChessRogueBuffData buff_data = 12;</code>
     */
    private final ChessRogueBuffDataOuterClass.ChessRogueBuffData buffData = ChessRogueBuffDataOuterClass.ChessRogueBuffData.newInstance();

    private ChessRogueBuffInfo() {
    }

    /**
     * @return a new empty instance of {@code ChessRogueBuffInfo}
     */
    public static ChessRogueBuffInfo newInstance() {
      return new ChessRogueBuffInfo();
    }

    /**
     * <code>optional .ChessRogueBuffData buff_data = 12;</code>
     * @return whether the buffData field is set
     */
    public boolean hasBuffData() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional .ChessRogueBuffData buff_data = 12;</code>
     * @return this
     */
    public ChessRogueBuffInfo clearBuffData() {
      bitField0_ &= ~0x00000001;
      buffData.clear();
      return this;
    }

    /**
     * <code>optional .ChessRogueBuffData buff_data = 12;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableBuffData()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public ChessRogueBuffDataOuterClass.ChessRogueBuffData getBuffData() {
      return buffData;
    }

    /**
     * <code>optional .ChessRogueBuffData buff_data = 12;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public ChessRogueBuffDataOuterClass.ChessRogueBuffData getMutableBuffData() {
      bitField0_ |= 0x00000001;
      return buffData;
    }

    /**
     * <code>optional .ChessRogueBuffData buff_data = 12;</code>
     * @param value the buffData to set
     * @return this
     */
    public ChessRogueBuffInfo setBuffData(
        final ChessRogueBuffDataOuterClass.ChessRogueBuffData value) {
      bitField0_ |= 0x00000001;
      buffData.copyFrom(value);
      return this;
    }

    @Override
    public ChessRogueBuffInfo copyFrom(final ChessRogueBuffInfo other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        buffData.copyFrom(other.buffData);
      }
      return this;
    }

    @Override
    public ChessRogueBuffInfo mergeFrom(final ChessRogueBuffInfo other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasBuffData()) {
        getMutableBuffData().mergeFrom(other.buffData);
      }
      return this;
    }

    @Override
    public ChessRogueBuffInfo clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      buffData.clear();
      return this;
    }

    @Override
    public ChessRogueBuffInfo clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      buffData.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof ChessRogueBuffInfo)) {
        return false;
      }
      ChessRogueBuffInfo other = (ChessRogueBuffInfo) o;
      return bitField0_ == other.bitField0_
        && (!hasBuffData() || buffData.equals(other.buffData));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 98);
        output.writeMessageNoTag(buffData);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(buffData);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public ChessRogueBuffInfo mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 98: {
            // buffData
            input.readMessage(buffData);
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
        output.writeMessage(FieldNames.buffData, buffData);
      }
      output.endObject();
    }

    @Override
    public ChessRogueBuffInfo mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -1523035491:
          case 55546902: {
            if (input.isAtField(FieldNames.buffData)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(buffData);
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
    public ChessRogueBuffInfo clone() {
      return new ChessRogueBuffInfo().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static ChessRogueBuffInfo parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new ChessRogueBuffInfo(), data).checkInitialized();
    }

    public static ChessRogueBuffInfo parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ChessRogueBuffInfo(), input).checkInitialized();
    }

    public static ChessRogueBuffInfo parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ChessRogueBuffInfo(), input).checkInitialized();
    }

    /**
     * @return factory for creating ChessRogueBuffInfo messages
     */
    public static MessageFactory<ChessRogueBuffInfo> getFactory() {
      return ChessRogueBuffInfoFactory.INSTANCE;
    }

    private enum ChessRogueBuffInfoFactory implements MessageFactory<ChessRogueBuffInfo> {
      INSTANCE;

      @Override
      public ChessRogueBuffInfo create() {
        return ChessRogueBuffInfo.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName buffData = FieldName.forField("buffData", "buff_data");
    }
  }
}
