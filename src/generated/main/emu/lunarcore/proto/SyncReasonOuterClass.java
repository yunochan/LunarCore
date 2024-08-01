// Code generated by protocol buffer compiler. Do not edit!
package emu.lunarcore.proto;

import us.hebi.quickbuf.ProtoEnum;
import us.hebi.quickbuf.ProtoUtil;

public final class SyncReasonOuterClass {
  /**
   * Protobuf enum {@code SyncReason}
   */
  public enum SyncReason implements ProtoEnum<SyncReason> {
    /**
     * <code>SYNC_REASON_NONE = 0;</code>
     */
    SYNC_REASON_NONE("SYNC_REASON_NONE", 0),

    /**
     * <code>SYNC_REASON_MP_ADD = 1;</code>
     */
    SYNC_REASON_MP_ADD("SYNC_REASON_MP_ADD", 1),

    /**
     * <code>SYNC_REASON_MP_ADD_PROP_HIT = 2;</code>
     */
    SYNC_REASON_MP_ADD_PROP_HIT("SYNC_REASON_MP_ADD_PROP_HIT", 2),

    /**
     * <code>SYNC_REASON_HP_ADD = 3;</code>
     */
    SYNC_REASON_HP_ADD("SYNC_REASON_HP_ADD", 3),

    /**
     * <code>SYNC_REASON_HP_ADD_PROP_HIT = 4;</code>
     */
    SYNC_REASON_HP_ADD_PROP_HIT("SYNC_REASON_HP_ADD_PROP_HIT", 4);

    /**
     * <code>SYNC_REASON_NONE = 0;</code>
     */
    public static final int SYNC_REASON_NONE_VALUE = 0;

    /**
     * <code>SYNC_REASON_MP_ADD = 1;</code>
     */
    public static final int SYNC_REASON_MP_ADD_VALUE = 1;

    /**
     * <code>SYNC_REASON_MP_ADD_PROP_HIT = 2;</code>
     */
    public static final int SYNC_REASON_MP_ADD_PROP_HIT_VALUE = 2;

    /**
     * <code>SYNC_REASON_HP_ADD = 3;</code>
     */
    public static final int SYNC_REASON_HP_ADD_VALUE = 3;

    /**
     * <code>SYNC_REASON_HP_ADD_PROP_HIT = 4;</code>
     */
    public static final int SYNC_REASON_HP_ADD_PROP_HIT_VALUE = 4;

    private final String name;

    private final int number;

    private SyncReason(String name, int number) {
      this.name = name;
      this.number = number;
    }

    /**
     * @return the string representation of enum entry
     */
    @Override
    public String getName() {
      return name;
    }

    /**
     * @return the numeric wire value of this enum entry
     */
    @Override
    public int getNumber() {
      return number;
    }

    /**
     * @return a converter that maps between this enum's numeric and text representations
     */
    public static ProtoEnum.EnumConverter<SyncReason> converter() {
      return SyncReasonConverter.INSTANCE;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value, or null if unknown.
     */
    public static SyncReason forNumber(int value) {
      return SyncReasonConverter.INSTANCE.forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @param other Fallback value in case the value is not known.
     * @return The enum associated with the given numeric wire value, or the fallback value if unknown.
     */
    public static SyncReason forNumberOr(int number, SyncReason other) {
      SyncReason value = forNumber(number);
      return value == null ? other : value;
    }

    enum SyncReasonConverter implements ProtoEnum.EnumConverter<SyncReason> {
      INSTANCE;

      private static final SyncReason[] lookup = new SyncReason[5];

      static {
        lookup[0] = SYNC_REASON_NONE;
        lookup[1] = SYNC_REASON_MP_ADD;
        lookup[2] = SYNC_REASON_MP_ADD_PROP_HIT;
        lookup[3] = SYNC_REASON_HP_ADD;
        lookup[4] = SYNC_REASON_HP_ADD_PROP_HIT;
      }

      @Override
      public final SyncReason forNumber(final int value) {
        if (value >= 0 && value < lookup.length) {
          return lookup[value];
        }
        return null;
      }

      @Override
      public final SyncReason forName(final CharSequence value) {
        if (value.length() == 16) {
          if (ProtoUtil.isEqual("SYNC_REASON_NONE", value)) {
            return SYNC_REASON_NONE;
          }
        }
        if (value.length() == 18) {
          if (ProtoUtil.isEqual("SYNC_REASON_MP_ADD", value)) {
            return SYNC_REASON_MP_ADD;
          }
          if (ProtoUtil.isEqual("SYNC_REASON_HP_ADD", value)) {
            return SYNC_REASON_HP_ADD;
          }
        }
        if (value.length() == 27) {
          if (ProtoUtil.isEqual("SYNC_REASON_MP_ADD_PROP_HIT", value)) {
            return SYNC_REASON_MP_ADD_PROP_HIT;
          }
          if (ProtoUtil.isEqual("SYNC_REASON_HP_ADD_PROP_HIT", value)) {
            return SYNC_REASON_HP_ADD_PROP_HIT;
          }
        }
        return null;
      }
    }
  }
}
