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

public final class ComposeItemScRspOuterClass {
  /**
   * Protobuf type {@code ComposeItemScRsp}
   */
  public static final class ComposeItemScRsp extends ProtoMessage<ComposeItemScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 count = 3;</code>
     */
    private int count;

    /**
     * <code>optional uint32 retcode = 10;</code>
     */
    private int retcode;

    /**
     * <code>optional uint32 compose_id = 15;</code>
     */
    private int composeId;

    /**
     * <code>optional .ItemList return_item_list = 14;</code>
     */
    private final ItemListOuterClass.ItemList returnItemList = ItemListOuterClass.ItemList.newInstance();

    private ComposeItemScRsp() {
    }

    /**
     * @return a new empty instance of {@code ComposeItemScRsp}
     */
    public static ComposeItemScRsp newInstance() {
      return new ComposeItemScRsp();
    }

    /**
     * <code>optional uint32 count = 3;</code>
     * @return whether the count field is set
     */
    public boolean hasCount() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 count = 3;</code>
     * @return this
     */
    public ComposeItemScRsp clearCount() {
      bitField0_ &= ~0x00000001;
      count = 0;
      return this;
    }

    /**
     * <code>optional uint32 count = 3;</code>
     * @return the count
     */
    public int getCount() {
      return count;
    }

    /**
     * <code>optional uint32 count = 3;</code>
     * @param value the count to set
     * @return this
     */
    public ComposeItemScRsp setCount(final int value) {
      bitField0_ |= 0x00000001;
      count = value;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 10;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 retcode = 10;</code>
     * @return this
     */
    public ComposeItemScRsp clearRetcode() {
      bitField0_ &= ~0x00000002;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 10;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 10;</code>
     * @param value the retcode to set
     * @return this
     */
    public ComposeItemScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000002;
      retcode = value;
      return this;
    }

    /**
     * <code>optional uint32 compose_id = 15;</code>
     * @return whether the composeId field is set
     */
    public boolean hasComposeId() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional uint32 compose_id = 15;</code>
     * @return this
     */
    public ComposeItemScRsp clearComposeId() {
      bitField0_ &= ~0x00000004;
      composeId = 0;
      return this;
    }

    /**
     * <code>optional uint32 compose_id = 15;</code>
     * @return the composeId
     */
    public int getComposeId() {
      return composeId;
    }

    /**
     * <code>optional uint32 compose_id = 15;</code>
     * @param value the composeId to set
     * @return this
     */
    public ComposeItemScRsp setComposeId(final int value) {
      bitField0_ |= 0x00000004;
      composeId = value;
      return this;
    }

    /**
     * <code>optional .ItemList return_item_list = 14;</code>
     * @return whether the returnItemList field is set
     */
    public boolean hasReturnItemList() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <code>optional .ItemList return_item_list = 14;</code>
     * @return this
     */
    public ComposeItemScRsp clearReturnItemList() {
      bitField0_ &= ~0x00000008;
      returnItemList.clear();
      return this;
    }

    /**
     * <code>optional .ItemList return_item_list = 14;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableReturnItemList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public ItemListOuterClass.ItemList getReturnItemList() {
      return returnItemList;
    }

    /**
     * <code>optional .ItemList return_item_list = 14;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public ItemListOuterClass.ItemList getMutableReturnItemList() {
      bitField0_ |= 0x00000008;
      return returnItemList;
    }

    /**
     * <code>optional .ItemList return_item_list = 14;</code>
     * @param value the returnItemList to set
     * @return this
     */
    public ComposeItemScRsp setReturnItemList(final ItemListOuterClass.ItemList value) {
      bitField0_ |= 0x00000008;
      returnItemList.copyFrom(value);
      return this;
    }

    @Override
    public ComposeItemScRsp copyFrom(final ComposeItemScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        count = other.count;
        retcode = other.retcode;
        composeId = other.composeId;
        returnItemList.copyFrom(other.returnItemList);
      }
      return this;
    }

    @Override
    public ComposeItemScRsp mergeFrom(final ComposeItemScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasCount()) {
        setCount(other.count);
      }
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasComposeId()) {
        setComposeId(other.composeId);
      }
      if (other.hasReturnItemList()) {
        getMutableReturnItemList().mergeFrom(other.returnItemList);
      }
      return this;
    }

    @Override
    public ComposeItemScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      count = 0;
      retcode = 0;
      composeId = 0;
      returnItemList.clear();
      return this;
    }

    @Override
    public ComposeItemScRsp clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      returnItemList.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof ComposeItemScRsp)) {
        return false;
      }
      ComposeItemScRsp other = (ComposeItemScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasCount() || count == other.count)
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasComposeId() || composeId == other.composeId)
        && (!hasReturnItemList() || returnItemList.equals(other.returnItemList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 24);
        output.writeUInt32NoTag(count);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 80);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 120);
        output.writeUInt32NoTag(composeId);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRawByte((byte) 114);
        output.writeMessageNoTag(returnItemList);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(count);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(composeId);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(returnItemList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public ComposeItemScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 24: {
            // count
            count = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 80) {
              break;
            }
          }
          case 80: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 120) {
              break;
            }
          }
          case 120: {
            // composeId
            composeId = input.readUInt32();
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 114) {
              break;
            }
          }
          case 114: {
            // returnItemList
            input.readMessage(returnItemList);
            bitField0_ |= 0x00000008;
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
        output.writeUInt32(FieldNames.count, count);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.retcode, retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeUInt32(FieldNames.composeId, composeId);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeMessage(FieldNames.returnItemList, returnItemList);
      }
      output.endObject();
    }

    @Override
    public ComposeItemScRsp mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 94851343: {
            if (input.isAtField(FieldNames.count)) {
              if (!input.trySkipNullValue()) {
                count = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1097936398: {
            if (input.isAtField(FieldNames.retcode)) {
              if (!input.trySkipNullValue()) {
                retcode = input.readUInt32();
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1399759283:
          case -442843416: {
            if (input.isAtField(FieldNames.composeId)) {
              if (!input.trySkipNullValue()) {
                composeId = input.readUInt32();
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -6533215:
          case -807051781: {
            if (input.isAtField(FieldNames.returnItemList)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(returnItemList);
                bitField0_ |= 0x00000008;
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
    public ComposeItemScRsp clone() {
      return new ComposeItemScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static ComposeItemScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new ComposeItemScRsp(), data).checkInitialized();
    }

    public static ComposeItemScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ComposeItemScRsp(), input).checkInitialized();
    }

    public static ComposeItemScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ComposeItemScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating ComposeItemScRsp messages
     */
    public static MessageFactory<ComposeItemScRsp> getFactory() {
      return ComposeItemScRspFactory.INSTANCE;
    }

    private enum ComposeItemScRspFactory implements MessageFactory<ComposeItemScRsp> {
      INSTANCE;

      @Override
      public ComposeItemScRsp create() {
        return ComposeItemScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName count = FieldName.forField("count");

      static final FieldName retcode = FieldName.forField("retcode");

      static final FieldName composeId = FieldName.forField("composeId", "compose_id");

      static final FieldName returnItemList = FieldName.forField("returnItemList", "return_item_list");
    }
  }
}
