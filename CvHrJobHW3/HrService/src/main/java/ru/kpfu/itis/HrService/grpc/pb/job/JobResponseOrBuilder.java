// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: src/main/protobuf/job.proto
// Protobuf Java Version: 4.27.0

public interface JobResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:JobResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int32 experience = 2;</code>
   * @return The experience.
   */
  int getExperience();

  /**
   * <code>repeated string stack = 3;</code>
   * @return A list containing the stack.
   */
  java.util.List<java.lang.String>
      getStackList();
  /**
   * <code>repeated string stack = 3;</code>
   * @return The count of stack.
   */
  int getStackCount();
  /**
   * <code>repeated string stack = 3;</code>
   * @param index The index of the element to return.
   * @return The stack at the given index.
   */
  java.lang.String getStack(int index);
  /**
   * <code>repeated string stack = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the stack at the given index.
   */
  com.google.protobuf.ByteString
      getStackBytes(int index);

  /**
   * <code>string description = 4;</code>
   * @return The description.
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 4;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>string company = 5;</code>
   * @return The company.
   */
  java.lang.String getCompany();
  /**
   * <code>string company = 5;</code>
   * @return The bytes for company.
   */
  com.google.protobuf.ByteString
      getCompanyBytes();

  /**
   * <code>int32 proposed_salary = 6;</code>
   * @return The proposedSalary.
   */
  int getProposedSalary();
}
