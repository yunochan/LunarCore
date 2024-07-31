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
import us.hebi.quickbuf.RepeatedInt;

public final class RelicAvatarRecommendScRspOuterClass {
  /**
   * Protobuf type {@code RelicAvatarRecommendScRsp}
   */
  public static final class RelicAvatarRecommendScRsp extends ProtoMessage<RelicAvatarRecommendScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 set_id = 8;</code>
     */
    private int setId;

    /**
     * <code>optional uint32 retcode = 12;</code>
     */
    private int retcode;

    /**
     * <code>optional bool is_fetch_avatar_list = 1;</code>
     */
    private boolean isFetchAvatarList;

    /**
     * <code>repeated uint32 avatar_id_list = 10;</code>
     */
    private final RepeatedInt avatarIdList = RepeatedInt.newEmptyInstance();

    private RelicAvatarRecommendScRsp() {
    }

    /**
     * @return a new empty instance of {@code RelicAvatarRecommendScRsp}
     */
    public static RelicAvatarRecommendScRsp newInstance() {
      return new RelicAvatarRecommendScRsp();
    }

    /**
     * <code>optional uint32 set_id = 8;</code>
     * @return whether the setId field is set
     */
    public boolean hasSetId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 set_id = 8;</code>
     * @return this
     */
    public RelicAvatarRecommendScRsp clearSetId() {
      bitField0_ &= ~0x00000001;
      setId = 0;
      return this;
    }

    /**
     * <code>optional uint32 set_id = 8;</code>
     * @return the setId
     */
    public int getSetId() {
      return setId;
    }

    /**
     * <code>optional uint32 set_id = 8;</code>
     * @param value the setId to set
     * @return this
     */
    public RelicAvatarRecommendScRsp setSetId(final int value) {
      bitField0_ |= 0x00000001;
      setId = value;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 12;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 retcode = 12;</code>
     * @return this
     */
    public RelicAvatarRecommendScRsp clearRetcode() {
      bitField0_ &= ~0x00000002;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 12;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 12;</code>
     * @param value the retcode to set
     * @return this
     */
    public RelicAvatarRecommendScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000002;
      retcode = value;
      return this;
    }

    /**
     * <code>optional bool is_fetch_avatar_list = 1;</code>
     * @return whether the isFetchAvatarList field is set
     */
    public boolean hasIsFetchAvatarList() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional bool is_fetch_avatar_list = 1;</code>
     * @return this
     */
    public RelicAvatarRecommendScRsp clearIsFetchAvatarList() {
      bitField0_ &= ~0x00000004;
      isFetchAvatarList = false;
      return this;
    }

    /**
     * <code>optional bool is_fetch_avatar_list = 1;</code>
     * @return the isFetchAvatarList
     */
    public boolean getIsFetchAvatarList() {
      return isFetchAvatarList;
    }

    /**
     * <code>optional bool is_fetch_avatar_list = 1;</code>
     * @param value the isFetchAvatarList to set
     * @return this
     */
    public RelicAvatarRecommendScRsp setIsFetchAvatarList(final boolean value) {
      bitField0_ |= 0x00000004;
      isFetchAvatarList = value;
      return this;
    }

    /**
     * <code>repeated uint32 avatar_id_list = 10;</code>
     * @return whether the avatarIdList field is set
     */
    public boolean hasAvatarIdList() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <code>repeated uint32 avatar_id_list = 10;</code>
     * @return this
     */
    public RelicAvatarRecommendScRsp clearAvatarIdList() {
      bitField0_ &= ~0x00000008;
      avatarIdList.clear();
      return this;
    }

    /**
     * <code>repeated uint32 avatar_id_list = 10;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableAvatarIdList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedInt getAvatarIdList() {
      return avatarIdList;
    }

    /**
     * <code>repeated uint32 avatar_id_list = 10;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedInt getMutableAvatarIdList() {
      bitField0_ |= 0x00000008;
      return avatarIdList;
    }

    /**
     * <code>repeated uint32 avatar_id_list = 10;</code>
     * @param value the avatarIdList to add
     * @return this
     */
    public RelicAvatarRecommendScRsp addAvatarIdList(final int value) {
      bitField0_ |= 0x00000008;
      avatarIdList.add(value);
      return this;
    }

    /**
     * <code>repeated uint32 avatar_id_list = 10;</code>
     * @param values the avatarIdList to add
     * @return this
     */
    public RelicAvatarRecommendScRsp addAllAvatarIdList(final int... values) {
      bitField0_ |= 0x00000008;
      avatarIdList.addAll(values);
      return this;
    }

    @Override
    public RelicAvatarRecommendScRsp copyFrom(final RelicAvatarRecommendScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        setId = other.setId;
        retcode = other.retcode;
        isFetchAvatarList = other.isFetchAvatarList;
        avatarIdList.copyFrom(other.avatarIdList);
      }
      return this;
    }

    @Override
    public RelicAvatarRecommendScRsp mergeFrom(final RelicAvatarRecommendScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasSetId()) {
        setSetId(other.setId);
      }
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasIsFetchAvatarList()) {
        setIsFetchAvatarList(other.isFetchAvatarList);
      }
      if (other.hasAvatarIdList()) {
        getMutableAvatarIdList().addAll(other.avatarIdList);
      }
      return this;
    }

    @Override
    public RelicAvatarRecommendScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      setId = 0;
      retcode = 0;
      isFetchAvatarList = false;
      avatarIdList.clear();
      return this;
    }

    @Override
    public RelicAvatarRecommendScRsp clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      avatarIdList.clear();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof RelicAvatarRecommendScRsp)) {
        return false;
      }
      RelicAvatarRecommendScRsp other = (RelicAvatarRecommendScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasSetId() || setId == other.setId)
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasIsFetchAvatarList() || isFetchAvatarList == other.isFetchAvatarList)
        && (!hasAvatarIdList() || avatarIdList.equals(other.avatarIdList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 64);
        output.writeUInt32NoTag(setId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 96);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 8);
        output.writeBoolNoTag(isFetchAvatarList);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        for (int i = 0; i < avatarIdList.length(); i++) {
          output.writeRawByte((byte) 80);
          output.writeUInt32NoTag(avatarIdList.array()[i]);
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(setId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 2;
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += (1 * avatarIdList.length()) + ProtoSink.computeRepeatedUInt32SizeNoTag(avatarIdList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public RelicAvatarRecommendScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 64: {
            // setId
            setId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 96) {
              break;
            }
          }
          case 96: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 8) {
              break;
            }
          }
          case 8: {
            // isFetchAvatarList
            isFetchAvatarList = input.readBool();
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 82) {
              break;
            }
          }
          case 82: {
            // avatarIdList [packed=true]
            input.readPackedUInt32(avatarIdList, tag);
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
          case 80: {
            // avatarIdList [packed=false]
            tag = input.readRepeatedUInt32(avatarIdList, tag);
            bitField0_ |= 0x00000008;
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
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.retcode, retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeBool(FieldNames.isFetchAvatarList, isFetchAvatarList);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRepeatedUInt32(FieldNames.avatarIdList, avatarIdList);
      }
      output.endObject();
    }

    @Override
    public RelicAvatarRecommendScRsp mergeFrom(final JsonSource input) throws IOException {
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
          case 24331623:
          case 1632335338: {
            if (input.isAtField(FieldNames.isFetchAvatarList)) {
              if (!input.trySkipNullValue()) {
                isFetchAvatarList = input.readBool();
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1214270702:
          case 1824281692: {
            if (input.isAtField(FieldNames.avatarIdList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedUInt32(avatarIdList);
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
    public RelicAvatarRecommendScRsp clone() {
      return new RelicAvatarRecommendScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static RelicAvatarRecommendScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new RelicAvatarRecommendScRsp(), data).checkInitialized();
    }

    public static RelicAvatarRecommendScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RelicAvatarRecommendScRsp(), input).checkInitialized();
    }

    public static RelicAvatarRecommendScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RelicAvatarRecommendScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating RelicAvatarRecommendScRsp messages
     */
    public static MessageFactory<RelicAvatarRecommendScRsp> getFactory() {
      return RelicAvatarRecommendScRspFactory.INSTANCE;
    }

    private enum RelicAvatarRecommendScRspFactory implements MessageFactory<RelicAvatarRecommendScRsp> {
      INSTANCE;

      @Override
      public RelicAvatarRecommendScRsp create() {
        return RelicAvatarRecommendScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName setId = FieldName.forField("setId", "set_id");

      static final FieldName retcode = FieldName.forField("retcode");

      static final FieldName isFetchAvatarList = FieldName.forField("isFetchAvatarList", "is_fetch_avatar_list");

      static final FieldName avatarIdList = FieldName.forField("avatarIdList", "avatar_id_list");
    }
  }
}