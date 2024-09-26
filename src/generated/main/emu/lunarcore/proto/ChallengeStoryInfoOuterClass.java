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

public final class ChallengeStoryInfoOuterClass {
  public static final class ChallengeStoryInfo extends ProtoMessage<ChallengeStoryInfo> implements Cloneable {
    private static final long serialVersionUID = 0L;
    
    private final ChallengeBossBuffInfoOuterClass.ChallengeBossBuffInfo curBossBuffs = ChallengeBossBuffInfoOuterClass.ChallengeBossBuffInfo.newInstance();
    
    private final ChallengeStoryBuffInfoOuterClass.ChallengeStoryBuffInfo curStoryBuffs = ChallengeStoryBuffInfoOuterClass.ChallengeStoryBuffInfo.newInstance();
    
    public static ChallengeStoryInfo newInstance() {
      return new ChallengeStoryInfo();
    }
    
    public boolean hasCurBossBuffs() {
      return ((this.bitField0_ & 0x1) != 0);
    }
    
    public ChallengeStoryInfo clearCurBossBuffs() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.curBossBuffs.clear();
      return this;
    }
    
    public ChallengeBossBuffInfoOuterClass.ChallengeBossBuffInfo getCurBossBuffs() {
      return this.curBossBuffs;
    }
    
    public ChallengeBossBuffInfoOuterClass.ChallengeBossBuffInfo getMutableCurBossBuffs() {
      this.bitField0_ |= 0x1;
      return this.curBossBuffs;
    }
    
    public ChallengeStoryInfo setCurBossBuffs(ChallengeBossBuffInfoOuterClass.ChallengeBossBuffInfo value) {
      this.bitField0_ |= 0x1;
      this.curBossBuffs.copyFrom(value);
      return this;
    }
    
    public boolean hasCurStoryBuffs() {
      return ((this.bitField0_ & 0x2) != 0);
    }
    
    public ChallengeStoryInfo clearCurStoryBuffs() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.curStoryBuffs.clear();
      return this;
    }
    
    public ChallengeStoryBuffInfoOuterClass.ChallengeStoryBuffInfo getCurStoryBuffs() {
      return this.curStoryBuffs;
    }
    
    public ChallengeStoryBuffInfoOuterClass.ChallengeStoryBuffInfo getMutableCurStoryBuffs() {
      this.bitField0_ |= 0x2;
      return this.curStoryBuffs;
    }
    
    public ChallengeStoryInfo setCurStoryBuffs(ChallengeStoryBuffInfoOuterClass.ChallengeStoryBuffInfo value) {
      this.bitField0_ |= 0x2;
      this.curStoryBuffs.copyFrom(value);
      return this;
    }
    
    public ChallengeStoryInfo copyFrom(ChallengeStoryInfo other) {
      this.cachedSize = other.cachedSize;
      if ((this.bitField0_ | other.bitField0_) != 0) {
        this.bitField0_ = other.bitField0_;
        this.curBossBuffs.copyFrom(other.curBossBuffs);
        this.curStoryBuffs.copyFrom(other.curStoryBuffs);
      } 
      return this;
    }
    
    public ChallengeStoryInfo mergeFrom(ChallengeStoryInfo other) {
      if (other.isEmpty())
        return this; 
      this.cachedSize = -1;
      if (other.hasCurBossBuffs())
        getMutableCurBossBuffs().mergeFrom(other.curBossBuffs); 
      if (other.hasCurStoryBuffs())
        getMutableCurStoryBuffs().mergeFrom(other.curStoryBuffs); 
      return this;
    }
    
    public ChallengeStoryInfo clear() {
      if (isEmpty())
        return this; 
      this.cachedSize = -1;
      this.bitField0_ = 0;
      this.curBossBuffs.clear();
      this.curStoryBuffs.clear();
      return this;
    }
    
    public ChallengeStoryInfo clearQuick() {
      if (isEmpty())
        return this; 
      this.cachedSize = -1;
      this.bitField0_ = 0;
      this.curBossBuffs.clearQuick();
      this.curStoryBuffs.clearQuick();
      return this;
    }
    
    public boolean equals(Object o) {
      if (o == this)
        return true; 
      if (!(o instanceof ChallengeStoryInfo))
        return false; 
      ChallengeStoryInfo other = (ChallengeStoryInfo)o;
      return (this.bitField0_ == other.bitField0_ && (
        !hasCurBossBuffs() || this.curBossBuffs.equals(other.curBossBuffs)) && (
        !hasCurStoryBuffs() || this.curStoryBuffs.equals(other.curStoryBuffs)));
    }
    
    public void writeTo(ProtoSink output) throws IOException {
      if ((this.bitField0_ & 0x1) != 0) {
        output.writeRawByte((byte)66);
        output.writeMessageNoTag(this.curBossBuffs);
      } 
      if ((this.bitField0_ & 0x2) != 0) {
        output.writeRawByte((byte)74);
        output.writeMessageNoTag(this.curStoryBuffs);
      } 
    }
    
    protected int computeSerializedSize() {
      int size = 0;
      if ((this.bitField0_ & 0x1) != 0)
        size += 1 + ProtoSink.computeMessageSizeNoTag(this.curBossBuffs); 
      if ((this.bitField0_ & 0x2) != 0)
        size += 1 + ProtoSink.computeMessageSizeNoTag(this.curStoryBuffs); 
      return size;
    }
    
    public ChallengeStoryInfo mergeFrom(ProtoSource input) throws IOException {
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 66:
            input.readMessage(this.curBossBuffs);
            this.bitField0_ |= 0x1;
            tag = input.readTag();
            if (tag != 74)
              continue; 
          case 74:
            input.readMessage(this.curStoryBuffs);
            this.bitField0_ |= 0x2;
            tag = input.readTag();
            if (tag != 0)
              continue; 
          case 0:
            return this;
        } 
        if (!input.skipField(tag))
          return this; 
        tag = input.readTag();
      } 
    }
    
    public void writeTo(JsonSink output) throws IOException {
      output.beginObject();
      if ((this.bitField0_ & 0x1) != 0)
        output.writeMessage(FieldNames.curBossBuffs, this.curBossBuffs); 
      if ((this.bitField0_ & 0x2) != 0)
        output.writeMessage(FieldNames.curStoryBuffs, this.curStoryBuffs); 
      output.endObject();
    }
    
    public ChallengeStoryInfo mergeFrom(JsonSource input) throws IOException {
      if (!input.beginObject())
        return this; 
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -1632186189:
          case -340377971:
            if (input.isAtField(FieldNames.curBossBuffs)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(this.curBossBuffs);
                this.bitField0_ |= 0x1;
              } 
              continue;
            } 
            input.skipUnknownField();
            continue;
          case -738440393:
          case -587091733:
            if (input.isAtField(FieldNames.curStoryBuffs)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(this.curStoryBuffs);
                this.bitField0_ |= 0x2;
              } 
              continue;
            } 
            input.skipUnknownField();
            continue;
        } 
        input.skipUnknownField();
      } 
      input.endObject();
      return this;
    }
    
    public ChallengeStoryInfo clone() {
      return (new ChallengeStoryInfo()).copyFrom(this);
    }
    
    public boolean isEmpty() {
      return (this.bitField0_ == 0);
    }
    
    public static ChallengeStoryInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
      return (ChallengeStoryInfo)((ChallengeStoryInfo)ProtoMessage.mergeFrom(new ChallengeStoryInfo(), data)).checkInitialized();
    }
    
    public static ChallengeStoryInfo parseFrom(ProtoSource input) throws IOException {
      return (ChallengeStoryInfo)((ChallengeStoryInfo)ProtoMessage.mergeFrom(new ChallengeStoryInfo(), input)).checkInitialized();
    }
    
    public static ChallengeStoryInfo parseFrom(JsonSource input) throws IOException {
      return (ChallengeStoryInfo)((ChallengeStoryInfo)ProtoMessage.mergeFrom(new ChallengeStoryInfo(), input)).checkInitialized();
    }
    
    public static MessageFactory<ChallengeStoryInfo> getFactory() {
      return ChallengeStoryInfoFactory.INSTANCE;
    }
    
    private enum ChallengeStoryInfoFactory implements MessageFactory<ChallengeStoryInfo> {
      INSTANCE;
      
      public ChallengeStoryInfoOuterClass.ChallengeStoryInfo create() {
        return ChallengeStoryInfoOuterClass.ChallengeStoryInfo.newInstance();
      }
    }
    
    static class FieldNames {
      static final FieldName curBossBuffs = FieldName.forField("curBossBuffs", "cur_boss_buffs");
      
      static final FieldName curStoryBuffs = FieldName.forField("curStoryBuffs", "cur_story_buffs");
    }
  }
  
  private enum ChallengeStoryInfoFactory implements MessageFactory<ChallengeStoryInfo> {
    INSTANCE;
    
    public ChallengeStoryInfoOuterClass.ChallengeStoryInfo create() {
      return ChallengeStoryInfoOuterClass.ChallengeStoryInfo.newInstance();
    }
  }
  
  static class FieldNames {
    static final FieldName curBossBuffs = FieldName.forField("curBossBuffs", "cur_boss_buffs");
    
    static final FieldName curStoryBuffs = FieldName.forField("curStoryBuffs", "cur_story_buffs");
  }
}
