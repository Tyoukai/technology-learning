// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: transfer_account_message.proto

package grpc.generated.parameter;

public interface TransferAccountResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:transfer.account.TransferAccountResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 返回码
   * </pre>
   *
   * <code>int32 code = 1;</code>
   */
  int getCode();

  /**
   * <pre>
   * 返回信息
   * </pre>
   *
   * <code>string msg = 2;</code>
   */
  java.lang.String getMsg();
  /**
   * <pre>
   * 返回信息
   * </pre>
   *
   * <code>string msg = 2;</code>
   */
  com.google.protobuf.ByteString
      getMsgBytes();
}
