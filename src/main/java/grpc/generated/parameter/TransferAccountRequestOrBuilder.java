// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: transfer_account_message.proto

package grpc.generated.parameter;

public interface TransferAccountRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:transfer.account.TransferAccountRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 金额
   * </pre>
   *
   * <code>int64 amount = 1;</code>
   */
  long getAmount();

  /**
   * <pre>
   * 转账人id
   * </pre>
   *
   * <code>string from_user_id = 2;</code>
   */
  java.lang.String getFromUserId();
  /**
   * <pre>
   * 转账人id
   * </pre>
   *
   * <code>string from_user_id = 2;</code>
   */
  com.google.protobuf.ByteString
      getFromUserIdBytes();

  /**
   * <pre>
   * 被转账人id
   * </pre>
   *
   * <code>string to_user_id = 3;</code>
   */
  java.lang.String getToUserId();
  /**
   * <pre>
   * 被转账人id
   * </pre>
   *
   * <code>string to_user_id = 3;</code>
   */
  com.google.protobuf.ByteString
      getToUserIdBytes();

  /**
   * <pre>
   * 时间
   * </pre>
   *
   * <code>int64 timestamp = 4;</code>
   */
  long getTimestamp();
}